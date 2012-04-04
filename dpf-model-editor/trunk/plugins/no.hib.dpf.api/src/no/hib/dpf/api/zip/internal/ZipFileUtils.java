package no.hib.dpf.api.zip.internal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import no.hib.dpf.api.zip.ZipFileStore;

import org.eclipse.core.runtime.Path;

/**
 * @author Anders Sandven
 *
 */
public class ZipFileUtils {
	private final static int BUFFER_SIZE = 8192;
	
	public static void writeEntries(ZipOutputStream out, ZipRootItem root, ZipFileStore store) {
		Collection<ZipItem> entries;
		if(store != null) 
			entries = findAndRemoveEntry(root, store.getName());
		else
			entries = root.getChildren();
		
		Iterator<ZipItem> it = entries.iterator();

		while (it.hasNext()) {
			ZipItem itm = it.next();
			String path = "";
			if (itm instanceof ZipFileItem) {
				writeFileToZip(out, path, (ZipFileItem) itm, root);
			} else if (itm instanceof ZipDirectoryItem) {
				writeDirToZip(out, (ZipDirectoryItem) itm, root);
			}
		}
	}
	
	private static Collection<ZipItem> findAndRemoveEntry(ZipRootItem root, String entryname) {
		//FIXME: We need to ignore the VFS zip entry for the file to be written (if it already exists)
		//Betre måte å gjera dette på?
		Collection<ZipItem> entries = root.getChildren();
		Iterator<ZipItem> it = entries.iterator();
		while (it.hasNext()) {
			ZipItem tmp = it.next();
			if(tmp.getName().equals(entryname))
				it.remove();
		}
		return entries;
	}

	private static void writeFileToZip(ZipOutputStream out, String path, ZipFileItem item, ZipRootItem root) {
		final byte[] buf = new byte[BUFFER_SIZE];
		try {

			ZipEntry tmp = new ZipEntry(item.getEntry());

			// Ein får streamclosed når "tullefiler" vert prøvd skrivne

			InputStream in = root.getInputStream(tmp);

			BufferedInputStream bis = new BufferedInputStream(in, BUFFER_SIZE); 
			// Dersom inputfil er tom (ikkje finst) bryt, eller vi ikkje får
			// stream på filnamn.
			if (bis.available() == 0 || in == null)
				return; // <---Sikkert ikkje naudsynt når ein alltid skriv
						// oppretta filer

			System.out.println("putNext: " + tmp.getName());
			out.putNextEntry(tmp);

			int i = 0;
			while ((i = bis.read(buf, 0, BUFFER_SIZE)) != -1) {
				out.write(buf, 0, i);
			}
			out.closeEntry();
			bis.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	private static void writeDirToZip(ZipOutputStream out, ZipDirectoryItem item, ZipRootItem root) {
		Collection<ZipItem> items = item.getChildren();
		Iterator<ZipItem> it = items.iterator();
		while (it.hasNext()) {
			ZipItem itm = it.next();
			if (itm instanceof ZipFileItem) {
				writeFileToZip(out, item.getName(), (ZipFileItem) itm, root);
			} else if (itm instanceof ZipDirectoryItem) {
				writeDirToZip(out, (ZipDirectoryItem) itm, root);
			}
		}
	}
	public static ZipFile replaceTempfile(File file, File tempfile) throws ZipException, IOException {
		//FIXME: Rename method
		// Slettar fil
		if (!file.delete())
			System.out.println("Deletion error");
		// Kopierer tempfile
		if (!tempfile.renameTo(file))
			System.out.println("Rename error");
		return new ZipFile(file);	
	}
	public static void parseEntries(ZipRootItem rt, ZipFile zipFile) {
		ZipDirectoryItem root = rt;
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
	}
	
}
