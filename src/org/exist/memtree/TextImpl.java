/*
 *  eXist Open Source Native XML Database
 *  Copyright (C) 2001-03 Wolfgang M. Meier
 *  wolfgang@exist-db.org
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
package org.exist.memtree;

import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class TextImpl extends NodeImpl implements Text {

	public TextImpl(DocumentImpl doc, int nodeNumber) {
		super(doc, nodeNumber);
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.Text#splitText(int)
	 */
	public Text splitText(int arg0) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.CharacterData#getData()
	 */
	public String getData() throws DOMException {
		return new String(document.characters, document.alpha[nodeNumber],
			document.alphaLen[nodeNumber]);
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.CharacterData#setData(java.lang.String)
	 */
	public void setData(String arg0) throws DOMException {
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.CharacterData#getLength()
	 */
	public int getLength() {
		return document.alphaLen[nodeNumber];
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.Node#getNodeValue()
	 */
	public String getNodeValue() throws DOMException {
		return getData();
	}
	
	/* (non-Javadoc)
	 * @see org.w3c.dom.CharacterData#substringData(int, int)
	 */
	public String substringData(int arg0, int arg1) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.CharacterData#appendData(java.lang.String)
	 */
	public void appendData(String arg0) throws DOMException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.CharacterData#insertData(int, java.lang.String)
	 */
	public void insertData(int arg0, String arg1) throws DOMException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.CharacterData#deleteData(int, int)
	 */
	public void deleteData(int arg0, int arg1) throws DOMException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.CharacterData#replaceData(int, int, java.lang.String)
	 */
	public void replaceData(int arg0, int arg1, String arg2)
		throws DOMException {
		// TODO Auto-generated method stub

	}

}
