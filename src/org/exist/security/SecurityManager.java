/*
 *  eXist Open Source Native XML Database
 *  Copyright (C) 2001 Wolfgang M. Meier
 *  meier@ifs.tu-darmstadt.de
 *  http://exist.sourceforge.net
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 * 
 *  $Id$
 */
package org.exist.security;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.exist.EXistException;
import org.exist.collections.Collection;
import org.exist.collections.triggers.TriggerException;
import org.exist.dom.DocumentImpl;
import org.exist.storage.BrokerPool;
import org.exist.storage.DBBroker;
import org.exist.util.LockException;
import org.exist.util.hashtable.Int2ObjectHashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * SecurityManager is responsible for managing users and groups.
 * 
 * There's only one SecurityManager for each database instance, which
 * may be obtained by {@link BrokerPool#getSecurityManager()}.
 * 
 * Users and groups are stored to collection /db/system in document
 * users.xml. While it is possible to edit this file by hand, it
 * may lead to unexpected results, since SecurityManager reads 
 * users.xml only during database startup and shutdown.
 */
public class SecurityManager {

	public final static String ACL_FILE = "users.xml";
	public final static String DBA_GROUP = "dba";
	public final static String DBA_USER = "admin";
	public final static String GUEST_GROUP = "guest";
	public final static String GUEST_USER = "guest";
	public final static String SYSTEM = "/db/system";
	
	private final static Logger LOG =
		Logger.getLogger(SecurityManager.class);

	private BrokerPool pool;
	private Int2ObjectHashMap groups = new Int2ObjectHashMap(65);
	private Int2ObjectHashMap users = new Int2ObjectHashMap(65);
	private int nextUserId = 0;
	private int nextGroupId = 0;
	
	private BrokerPool brokerPool;

	/**
	 * Initialize the security manager.
	 * 
	 * Checks if the file /db/system/users.xml exists in the database.
	 * If not, it is created with two default users: admin and guest.
	 *  
	 * @param pool
	 * @param sysBroker
	 */
	public SecurityManager(BrokerPool pool, DBBroker sysBroker) {
		this.pool = pool;
		
		DBBroker broker = sysBroker;
		try {
			Collection sysCollection = broker.getCollection(SYSTEM);
			if (sysCollection == null) {
				sysCollection = broker.getOrCreateCollection(SYSTEM);
				broker.saveCollection(sysCollection);
				sysCollection.setPermissions(0770);
			}
			Document acl = sysCollection.getDocument(SYSTEM + '/' + ACL_FILE);
			Element docElement = null;
			if (acl != null)
				docElement = acl.getDocumentElement();
			if (docElement == null) {
				LOG.debug("creating system users");
				User user = new User(DBA_USER, null);
				user.addGroup(DBA_GROUP);
				user.setUID(++nextUserId);
				users.put(user.getUID(), user);
				user = new User(GUEST_USER, GUEST_USER, GUEST_GROUP);
				user.setUID(++nextUserId);
				users.put(user.getUID(), user);
				addGroup(DBA_GROUP);
				addGroup(GUEST_GROUP);
				save(broker);
			} else {
				LOG.debug("loading acl");
				Element root = acl.getDocumentElement();
				NodeList nl = root.getChildNodes();
				Node node;
				Element next;
				User user;
				NodeList ul;
				String lastId;
				Group group;
				for (int i = 0; i < nl.getLength(); i++) {
					if(nl.item(i).getNodeType() != Node.ELEMENT_NODE)
						continue;
					next = (Element) nl.item(i);
					if (next.getTagName().equals("users")) {
						lastId = next.getAttribute("last-id");
						try {
							nextUserId = Integer.parseInt(lastId);
						} catch (NumberFormatException e) {
						}
						ul = next.getChildNodes();
						for (int j = 0; j < ul.getLength(); j++) {
							node = ul.item(j);
							if(node.getNodeType() == Node.ELEMENT_NODE &&
								node.getLocalName().equals("user")) {
								user = new User((Element)node);
								users.put(user.getUID(), user);
							}
						}
					} else if (next.getTagName().equals("groups")) {
						lastId = next.getAttribute("last-id");
						try {
							nextGroupId = Integer.parseInt(lastId);
						} catch (NumberFormatException e) {
						}
						ul = next.getChildNodes();
						for (int j = 0; j < ul.getLength(); j++) {
							node = ul.item(j);
							if(node.getNodeType() == Node.ELEMENT_NODE &&
								node.getLocalName().equals("group")) {
								group = new Group((Element)node);
								groups.put(group.getId(), group);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug("loading acl failed: " + e.getMessage());
		}
	}

	public synchronized void deleteUser(String name) throws PermissionDeniedException {
		deleteUser(getUser(name));
	}
	
	public synchronized void deleteUser(User user) throws PermissionDeniedException {
		if(user == null)
			return;
		if(user.getName().equals("admin") || user.getName().equals("guest"))
			throw new PermissionDeniedException("user " + user.getName() +
				" is required by the system. It cannot be removed.");
		user = (User)users.remove(user.getUID());
		if(user != null)
			LOG.debug("user " + user.getName() + " removed");
		else
			LOG.debug("user not found");
		DBBroker broker = null;
		try {
			broker = pool.get();
			save(broker);
		} catch (EXistException e) {
			e.printStackTrace();
		} finally {
			pool.release(broker);
		}
	}

	public synchronized User getUser(String name) {
		User user;
		for (Iterator i = users.valueIterator(); i.hasNext();) {
			user = (User) i.next();
			if (user.getName().equals(name))
				return user;
		}
		LOG.debug("user " + name + " not found");
		return null;
	}

	public synchronized User getUser(int uid) {
		final User user = (User)users.get(uid);
		if(user == null)
			LOG.debug("user with uid " + uid + " not found");
		return user;
	}
	
	public synchronized User[] getUsers() {
		User u[] = new User[users.size()];
		int j = 0;
		for (Iterator i = users.valueIterator(); i.hasNext(); j++)
			u[j] = (User) i.next();
		return u;
	}

	public synchronized void addGroup(String name) {
		Group group = new Group(name, ++nextGroupId);
		groups.put(group.getId(), group);
	}

	public synchronized boolean hasGroup(String name) {
		Group group;
		for (Iterator i = groups.valueIterator(); i.hasNext();) {
			group = (Group) i.next();
			if (group.getName().equals(name))
				return true;
		}
		return false;
	}

	public synchronized Group getGroup(String name) {
		Group group;
		for (Iterator i = groups.valueIterator(); i.hasNext();) {
			group = (Group) i.next();
			if (group.getName().equals(name))
				return group;
		}
		return null;
	}

	public synchronized Group getGroup(int gid) {
		return (Group)groups.get(gid);
	}
	
	public synchronized String[] getGroups() {
		ArrayList list = new ArrayList(groups.size());
		Group group;
		for(Iterator i = groups.valueIterator(); i.hasNext(); ) {
			group = (Group) i.next();
			list.add(group.getName());
		}
		String[] gl = new String[list.size()];
		list.toArray(gl);
		return gl;
	}
	
	public synchronized boolean hasAdminPrivileges(User user) {
		return user.hasGroup(DBA_GROUP);
	}

	public synchronized boolean hasUser(String name) {
		User user;
		for (Iterator i = users.valueIterator(); i.hasNext();) {
			user = (User) i.next();
			if (user.getName().equals(name))
				return true;
		}
		return false;
	}

	public synchronized void save(DBBroker broker) throws EXistException {
		LOG.debug("storing acl file");
		StringBuffer buf = new StringBuffer();
		buf.append("<auth>");
		// save groups
		buf.append("<groups last-id=\"");
		buf.append(Integer.toString(nextGroupId));
		buf.append("\">");
		for (Iterator i = groups.valueIterator(); i.hasNext();)
			buf.append(((Group) i.next()).toString());
		buf.append("</groups>");
		//save users
		buf.append("<users last-id=\"");
		buf.append(Integer.toString(nextUserId));
		buf.append("\">");
		for (Iterator i = users.valueIterator(); i.hasNext();)
			buf.append(((User) i.next()).toString());
		buf.append("</users>");
		buf.append("</auth>");
		// store users.xml
		broker.flush();
		broker.sync();
		try {
			broker.setUser(getUser(DBA_USER));
			Collection sysCollection = broker.getCollection(SYSTEM);
			DocumentImpl doc =
				sysCollection.addDocument(broker, ACL_FILE, buf.toString(), true);
			doc.setPermissions(0770);
			broker.saveCollection(doc.getCollection());
		} catch (SAXException e) {
			throw new EXistException(e.getMessage());
		} catch (PermissionDeniedException e) {
			throw new EXistException(e.getMessage());
		} catch (TriggerException e) {
			throw new EXistException(e.getMessage());
		} catch (LockException e) {
			throw new EXistException(e.getMessage());
		}
		broker.flush();
		broker.sync();
	}

	public synchronized void setUser(User user) {
		if (user.getUID() < 0)
			user.setUID(++nextUserId);
		users.put(user.getUID(), user);
		String group;
		for (Iterator i = user.getGroups(); i.hasNext();) {
			group = (String) i.next();
			if (!hasGroup(group))
				addGroup(group);
		}
		DBBroker broker = null;
		try {
			broker = pool.get();
			save(broker);
			createUserHome(broker, user);
		} catch (EXistException e) {
			LOG.debug("error while creating user", e);
		} catch (PermissionDeniedException e) {
			LOG.debug("error while create home collection", e);
		} finally {
			pool.release(broker);
		}
	}
	
	private void createUserHome(DBBroker broker, User user) 
	throws EXistException, PermissionDeniedException {
		if(user.getHome() == null)
			return;
		broker.setUser(getUser(DBA_USER));
		Collection home = broker.getOrCreateCollection(user.getHome());
		home.getPermissions().setOwner(user.getName());
		home.getPermissions().setGroup(user.getPrimaryGroup());
		broker.saveCollection(home);
	}
	public BrokerPool getBrokerPool() {
		return brokerPool;
	}

	public void setBrokerPool(BrokerPool brokerPool) {
		this.brokerPool = brokerPool;
	}

}