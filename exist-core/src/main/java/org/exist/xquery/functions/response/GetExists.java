/*
 * eXist-db Open Source Native XML Database
 * Copyright (C) 2001 The eXist-db Authors
 *
 * info@exist-db.org
 * http://www.exist-db.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.exist.xquery.functions.response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.exist.dom.QName;
import org.exist.http.servlets.ResponseWrapper;
import org.exist.xquery.Cardinality;
import org.exist.xquery.FunctionSignature;
import org.exist.xquery.XPathException;
import org.exist.xquery.XQueryContext;
import org.exist.xquery.value.BooleanValue;
import org.exist.xquery.value.FunctionParameterSequenceType;
import org.exist.xquery.value.Sequence;
import org.exist.xquery.value.Type;

import java.util.Optional;


/**
 * Determines if the HTTP Response is set in the XQuery Context.
 *
 * @author <a href="mailto:andrzej@chaeron.com">Andrzej Taramina</a>
 */
public class GetExists extends ResponseFunction {
    private static final Logger logger = LogManager.getLogger(GetExists.class);

	public final static FunctionSignature signature =
		new FunctionSignature(
			new QName( "exists", ResponseModule.NAMESPACE_URI, ResponseModule.PREFIX ),
			"Returns whether a response object exists.",
			null,
			new FunctionParameterSequenceType( "result", Type.BOOLEAN, Cardinality.EXACTLY_ONE, "true if the response object exists" ) );

    public GetExists(final XQueryContext context)
    {
        super( context, signature );
    }

    @Override
    public Sequence eval(final Sequence[] args, final Optional<ResponseWrapper> response) throws XPathException {
        return BooleanValue.valueOf(response.isPresent());
    }

}
