/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel;

public class ModelSerializationException extends RuntimeException {

	private static final long serialVersionUID = 5914117460788053419L;
	
	public ModelSerializationException() {
		super();
	}

	public ModelSerializationException(String message) {
		super(message);
	}

	public ModelSerializationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModelSerializationException(Throwable cause) {
		super(cause);
	}

}
