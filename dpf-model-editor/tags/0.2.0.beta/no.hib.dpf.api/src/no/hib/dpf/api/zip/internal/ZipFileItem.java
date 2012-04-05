/*******************************************************************************
 * Copyright (c) 2006 Alex Blewitt and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alex Blewitt - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.api.zip.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;

import no.hib.dpf.api.zip.ZipFileStore;

public class ZipFileItem extends ZipItem {
	private ZipEntry entry;

	public ZipFileItem(String name, ZipDirectoryItem parent, ZipEntry entry) {
		super(name, parent);
		this.entry = entry;
	}

	public ZipEntry getEntry() {
		return entry;
	}

	public String getFullName() {
		return entry.getName();
	}

	public long getLastModified() {
		return entry.getTime();
	}

	public InputStream openInputStream() throws IOException {
		return getRoot().getInputStream(entry);
	}

	public OutputStream openOutputStream(ZipFileStore store) throws IOException {
		return this.getRoot().getOutputStream(store);
	}
}
