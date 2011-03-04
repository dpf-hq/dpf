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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import no.hib.dpf.api.zip.ZipFileStore;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class ZipRootItem extends ZipDirectoryItem {
	private ZipFile file;
	private File tempfile;
	private ZipOutputStream zos;
	private final static int BUFFER_SIZE = 8192;

	public ZipRootItem(File file) throws ZipException, IOException {
		this(new ZipFile(file));

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
						// Vi må ha ein måte som kopierer tmp fil vanleg fil,
						// for så å oppdatere lenka ressurs/workspace
						super.close();
						// Handle til fil
						File tmp = new File(file.getName());
						// Slettar fil
						if (!tmp.delete())
							System.out.println("Deletion error");
						// Kopierer tempfile
						if (!tempfile.renameTo(tmp))
							System.out.println("Rename error");
						file = new ZipFile(tmp);
						parseEntries(file);
						// FIXME:
						// " Attempted to beginRule: R/, does not match outer scope rule: P/TestFFs"
						// Dette får vi fordi ein ikkje returnerer rett
						// prosjekt.
						// Hack: Vi bør berre refreshe aktuelt prosjekt, men
						// korleis skal ein finne prosjektet op ein skapeleg
						// måte?
						// IProject[] rt =
						// ResourcesPlugin.getWorkspace().getRoot().getProjects();
						// Dette fungerar ikkje
						//
						// IProject lol =
						// ResourcesPlugin.getWorkspace().getRoot().getProject("TestFFs");
						// Meh
						// lol.refreshLocal(IProject.DEPTH_INFINITE, null);
						// //Vi må refreshe editor og
						// IWorkbench wb = PlatformUI.getWorkbench();
						// IWorkbenchWindow wbw = wb.getActiveWorkbenchWindow();
						// Wat is dis i dont even
						// IWorkbenchPage wbp = wbw.getActivePage();
						// IEditorPart ep = wbp.getActiveEditor();
						// ep.
						System.out.println();
					} catch (IOException e) {
						e.printStackTrace();
					} /*
					 * catch (CoreException e) { e.printStackTrace(); }
					 */
				}
			};

			writeEntries();

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
		System.out.println("getOutputStream:feil");
		return null;
	}

	public void writeEntries() {
		Collection<ZipItem> entries = getChildren();
		Iterator<ZipItem> it = entries.iterator();

		while (it.hasNext()) {
			ZipItem itm = it.next();
			String path = "";
			if (itm instanceof ZipFileItem) {
				writeFileToZip(path, (ZipFileItem) itm);
			} else if (itm instanceof ZipDirectoryItem) {
				writeDirToZip((ZipDirectoryItem) itm);
			}
		}
	}

	private void writeFileToZip(String path, ZipFileItem item) {
		final byte[] buf = new byte[BUFFER_SIZE];
		try {

			ZipEntry tmp = new ZipEntry(item.getEntry());

			// FIXME: Ein får streamclosed når "tullefiler" vert prøvd skrivne

			InputStream fis = getInputStream(tmp);

			BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE); // <---
																					// STREAM
																					// CLOSED
																					// HER
			// Dersom inputfil er tom (ikkje finst) bryt, eller vi ikkje får
			// stream på filnamn.
			if (bis.available() == 0 || fis == null)
				return; // <---Sikkert ikkje naudsynt når ein alltid skriv
						// oppretta filer

			System.out.println("putNext: " + tmp.getName());
			zos.putNextEntry(tmp);

			int i = 0;
			while ((i = bis.read(buf, 0, BUFFER_SIZE)) != -1) {
				zos.write(buf, 0, i);
			}
			zos.closeEntry();
			bis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
			// IOE dersom getInputStream feilar -> entry finst ikkje i file
			// (kvar node i FS har ZipEntry, så det skal ikkje skje)
		} finally {

		}
	}

	private void writeDirToZip(ZipDirectoryItem item) {
		Collection<ZipItem> items = item.getChildren();
		Iterator<ZipItem> it = items.iterator();
		while (it.hasNext()) {
			ZipItem itm = it.next();
			if (itm instanceof ZipFileItem) {
				writeFileToZip(item.getName(), (ZipFileItem) itm);
			} else if (itm instanceof ZipDirectoryItem) {
				writeDirToZip((ZipDirectoryItem) itm);
			}
		}
	}

	/**
	 * Given a ZipFile, return a SortedMap of Maps and FileInfos
	 * 
	 * @param zipFile
	 * @return
	 */
	private void parseEntries(ZipFile zipFile) {

		ZipDirectoryItem root = this;
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipDirectoryItem parent = root;
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String fullName = entry.getName();
			Path path = new Path(fullName);
			for (int i = 0; i < path.segmentCount() - 1; i++) {
				String dirName = path.segment(i);
				ZipDirectoryItem newParent = (ZipDirectoryItem) parent
						.getItem(dirName);
				if (newParent == null) {
					newParent = new ZipDirectoryItem(dirName, parent);
				}
				parent = newParent;
			}
			String name = path.lastSegment();
			if (entry.isDirectory()) {
				new ZipDirectoryItem(name, parent);
			} else {
				new ZipFileItem(name, parent, entry);
			}
		}
		new ZipDirectoryItem("models", this); // FIXME: For teh test
	}
}
