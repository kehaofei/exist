/*
 *  eXist Open Source Native XML Database
 *  Copyright (C) 2001-04 The eXist Project
 *  http://exist-db.org
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
package org.exist.storage.test;

import java.io.File;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.exist.collections.Collection;
import org.exist.collections.IndexInfo;
import org.exist.dom.DocumentImpl;
import org.exist.security.SecurityManager;
import org.exist.storage.BrokerPool;
import org.exist.storage.DBBroker;
import org.exist.storage.lock.Lock;
import org.exist.storage.serializers.Serializer;
import org.exist.storage.txn.TransactionManager;
import org.exist.storage.txn.Txn;
import org.exist.util.Configuration;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * TestCase: add a larger number of documents into a collection,
 * crash the database, restart, remove the collection and add some
 * more documents.
 * 
 * This test needs quite a few documents to be in the collection. Change
 * the directory path below to point to a directory with at least 1000 docs.
 * 
 * @author wolf
 *
 */
public class RecoveryTest3 extends TestCase {

    public static void main(String[] args) {
        TestRunner.run(RecoveryTest3.class);
    }
    
    private static String directory = "/home/wolf/xml/movies";
    
    private static File dir = new File(directory);
    
    public void testStore() {
        BrokerPool.FORCE_CORRUPTION = true;
        BrokerPool pool = null;        
        DBBroker broker = null;
        try {
        	pool = startDB();
        	assertNotNull(pool);
            broker = pool.get(SecurityManager.SYSTEM_USER);
            assertNotNull(broker);            
            TransactionManager transact = pool.getTransactionManager();
            assertNotNull(transact);
            Txn transaction = transact.beginTransaction();
            assertNotNull(transaction);            
            System.out.println("Transaction started ...");
            
            Collection root = broker.getOrCreateCollection(transaction, DBBroker.ROOT_COLLECTION + "/test");
            assertNotNull(root);
            broker.saveCollection(transaction, root);
            
            Collection test2 = broker.getOrCreateCollection(transaction, DBBroker.ROOT_COLLECTION + "/test/test2");
            assertNotNull(test2);
            broker.saveCollection(transaction, test2);            
            
            File files[] = dir.listFiles();
            assertNotNull(files);
            
            File f;
            IndexInfo info;
            
            // store some documents.
            for (int i = 0; i < files.length && i < 5000; i++) {
                f = files[i];
                assertNotNull(f);
                try {
                    info = test2.validateXMLResource(transaction, broker, f.getName(), new InputSource(f.toURI().toASCIIString()));
                    assertNotNull(info);
                    test2.store(transaction, broker, info, new InputSource(f.toURI().toASCIIString()), false);
                } catch (SAXException e) {
                	//TODO : why store invalid documents ?
                    System.err.println("Error found while parsing document: " + f.getName() + ": " + e.getMessage());
                }
            }
            
            transact.commit(transaction);
            System.out.println("Transaction commited ...");
	    } catch (Exception e) {            
	        fail(e.getMessage());             
        } finally {
            pool.release(broker);
        }
    }
    
    public void testRead() {
    	BrokerPool.FORCE_CORRUPTION = true;
        BrokerPool pool = null;
        DBBroker broker = null;
        try {
        	System.out.println("testRead() ...\n");
        	pool = startDB();
        	assertNotNull(pool);
            broker = pool.get(SecurityManager.SYSTEM_USER);
            assertNotNull(broker);
            TransactionManager transact = pool.getTransactionManager();
            assertNotNull(transact);
            Txn transaction = transact.beginTransaction();
            assertNotNull(transaction);
            System.out.println("Transaction started ...");
            
            Collection root = broker.openCollection(DBBroker.ROOT_COLLECTION + "/test", Lock.WRITE_LOCK);
            assertNotNull(root);
            transaction.registerLock(root.getLock(), Lock.WRITE_LOCK);            
            broker.removeCollection(transaction, root);   
            
            transact.commit(transaction);
            System.out.println("Transaction commited ...");
            
            transaction = transact.beginTransaction();
            System.out.println("Transaction started ...");
            
            root = broker.getOrCreateCollection(transaction, DBBroker.ROOT_COLLECTION + "/test");
            assertNotNull(root);
            broker.saveCollection(transaction, root);
            
            Collection test2 = broker.getOrCreateCollection(transaction, DBBroker.ROOT_COLLECTION + "/test/test2");
            assertNotNull(test2);
            broker.saveCollection(transaction, test2);
            
            File files[] = dir.listFiles();
            assertNotNull(files);
            
            File f;
            IndexInfo info;
            
            // store some documents.
            for (int i = 0; i < files.length && i < 5000; i++) {
                f = files[i];
                assertNotNull(f);
                try {
                    info = test2.validateXMLResource(transaction, broker, f.getName(), new InputSource(f.toURI().toASCIIString()));
                    assertNotNull(info);
                    test2.store(transaction, broker, info, new InputSource(f.toURI().toASCIIString()), false);
                } catch (SAXException e) {
                    System.err.println("Error found while parsing document: " + f.getName() + ": " + e.getMessage());
                }
            }
            
            transact.commit(transaction);
            System.out.println("Transaction commited ...");
	    } catch (Exception e) {            
	        fail(e.getMessage());              
        } finally {
            pool.release(broker);
        }
    }
    
    public void testRead2() {
        BrokerPool.FORCE_CORRUPTION = false;
        BrokerPool pool = null;
        DBBroker broker = null;
        try {
        	System.out.println("testRead2() ...\n");
        	pool = startDB();
        	assertNotNull(pool);        
            broker = pool.get(SecurityManager.SYSTEM_USER);
            assertNotNull(broker);
            
            //TODO : do something ?
            
	    } catch (Exception e) {            
	        fail(e.getMessage());              
        } finally {
            pool.release(broker);
        }
    }
    
    protected BrokerPool startDB() {
        String home, file = "conf.xml";
        home = System.getProperty("exist.home");
        if (home == null)
            home = System.getProperty("user.dir");
        try {
            Configuration config = new Configuration(file, home);
            BrokerPool.configure(1, 5, config);
            return BrokerPool.getInstance();
        } catch (Exception e) {            
            fail(e.getMessage());
        }
        return null;
    }

    protected void tearDown() {
        BrokerPool.stopAll(false);
    }

}
