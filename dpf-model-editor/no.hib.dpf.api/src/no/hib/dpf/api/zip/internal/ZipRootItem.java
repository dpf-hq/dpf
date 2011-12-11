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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import no.hib.dpf.api.zip.ZipFileStore;
import no.hib.dpf.api.zip.internal.ZipResourceChangedListener;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

public class ZipRootItem extends ZipDirectoryItem {
	private ZipFile file;
	private File tempfile;
	private ZipOutputStream zos;

	public ZipRootItem(File file) throws ZipException, IOException {
		this(new ZipFile(file));
		
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new ZipResourceChangedListener());
		
		tempfile = File.createTempFile("tmp", "zip");
	}

	public ZipRootItem(ZipFile file) {
		super(new Path(file.getName()).lastSegment(), null);
		this.file = file;
		parseEntries(file);
	}

	public String getFullName() {
		return file.getName();
	}

	protected InputStream getInputStream(ZipEntry entry) throws IOException {
		return file.getInputStream(entry);
	}

	protected OutputStream getOutputStream(ZipFileStore store) {
		try {
			// Skriv innhold frå FS til tempfil
			FileOutputStream fos = new FileOutputStream(tempfile);
			zos = new ZipOutputStream(new BufferedOutputStream(fos)) {
				@Override
				public void close() {
					try {
						super.close();
						file = ZipFileUtils.replaceTempfile(new File(file.getName()), tempfile);
						parseEntries(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
		
			ZipFileUtils.writeEntries(zos, this, store);

			// Lag ny entry til fil som skal skrivast via EFS-> EFS tek hand om
			// lukking av stream
			
			zos.putNextEntry(new ZipEntry(store.getName()));

			System.out.println("getOutputStream: " + this.getName());
			return zos;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	public void writeToZip() {
		try {
			FileOutputStream fos = new FileOutputStream(tempfile);
			ZipOutputStream zo = new ZipOutputStream(new BufferedOutputStream(fos));
			ZipFileUtils.writeEntries(zo, this, null);
			zo.close();
			ZipFileUtils.replaceTempfile(new File(file.getName()), tempfile);
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public File getTempFile() {
		return tempfile;
	}
	/**
	 * Given a ZipFile, return a SortedMap of Maps and FileInfos
	 * 
	 * @param zipFile
	 * @return
	 */
	//TODO: Kanskje refactora heilt vekk?
	private void parseEntries(ZipFile zipFile) {
		ZipFileUtils.parseEntries(this, file);
	}
	
}
