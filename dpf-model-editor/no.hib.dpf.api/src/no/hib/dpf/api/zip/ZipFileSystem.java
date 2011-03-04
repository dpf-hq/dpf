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
package no.hib.dpf.api.zip;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;

import no.hib.dpf.api.zip.internal.ZipItem;
import no.hib.dpf.api.zip.internal.ZipRootItem;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileSystem;
import org.eclipse.core.runtime.CoreException;


public class ZipFileSystem extends FileSystem {
	private static Map<URI, ZipItem> zipFileCache = new HashMap<URI, ZipItem>();
	private static Map<URI, ZipFileStore> zipFileStoreCache = new HashMap<URI, ZipFileStore>();

	public int attributes() {
//		return EFS.ATTRIBUTE_READ_ONLY; // | EFS.ATTRIBUTE_HIDDEN | EFS.ATTRIBUTE_EXECUTABLE etc.
//		return EFS.ATTRIBUTE_OWNER_READ | 
//			  	EFS.ATTRIBUTE_OWNER_WRITE | 
//			  	EFS.ATTRIBUTE_OWNER_EXECUTE |
//			  	EFS.ATTRIBUTE_ARCHIVE;
		return EFS.getLocalFileSystem().attributes();
//		return EFS.OVERWRITE;
	}
	public static ZipItem getItem(URI uri) throws ZipException, IOException,
			CoreException {
		if (zipFileCache.containsKey(uri)) {
			return (ZipItem) zipFileCache.get(uri);
		} else {
			File file = EFS.getStore(uri).toLocalFile(0, null);
			ZipItem item = new ZipRootItem(file);
			zipFileCache.put(uri, item);
			return item;
		}
	}

	public IFileStore getStore(URI uri) {
		try {
			if (zipFileStoreCache.containsKey(uri)) {
				return (IFileStore) zipFileStoreCache.get(uri);
			} else {
				ZipFileStore fileStore = new ZipFileStore("root", null,uri);
				zipFileStoreCache.put(uri, fileStore);
				return fileStore;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
