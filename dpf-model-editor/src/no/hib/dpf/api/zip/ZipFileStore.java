package no.hib.dpf.api.zip;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

import no.hib.dpf.api.zip.internal.ZipDirectoryItem;
import no.hib.dpf.api.zip.internal.ZipFileItem;
import no.hib.dpf.api.zip.internal.ZipItem;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileInfo;
import org.eclipse.core.filesystem.provider.FileStore;
import org.eclipse.core.internal.filesystem.Messages;
import org.eclipse.core.internal.filesystem.Policy;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.Util;
import org.eclipse.osgi.util.NLS;

public class ZipFileStore extends FileStore {
	static ZipItem getRoot(URI uri) throws URISyntaxException, ZipException,
			IOException, CoreException {
		URI zipFile = new URI(uri.getQuery());
		return ZipFileSystem.getItem(zipFile);
	}

	private String name;
	private ZipFileStore parent;
	private URI uri;
	private ZipItem item;

	// Slik det er no, er FileStores ei reversert lenka liste med peikar til
	// forelder og element
	// Kanskje laga ei liste med barn?
	// Korleis skrive til zip fil utan at ein får traversert lista?

	private ZipFileStore(String name, ZipFileStore parent) {
		this.name = name;
		this.parent = parent;
	}

	public ZipFileStore(String name, ZipFileStore parent, ZipItem item) {
		this(name, parent);
		this.item = item;
	}

	public ZipFileStore(String name, ZipFileStore parent, URI uri)
			throws ZipException, URISyntaxException, IOException, CoreException {
		this(name, parent, getRoot(uri).getItem(new Path(uri.getPath()), 0));
		this.uri = uri;
	}

	@Override
	public IFileStore mkdir(int options, IProgressMonitor monitor) {
		// TODO: MÅ IMPLEMENTERAST FOR AT FILOPERASJONAR SKAL FUNGERA
		System.out.println("ZipFileStore#mkdir");

		if (this.item instanceof ZipDirectoryItem) {
			return this;
		} // Ein må kanskje ha kode for å oppretta nye directories -> pr no
			// unødvendig?
		System.out.println("ZipFileStore#mkdir returns null");
		return null;
	}

	@Override
	public void delete(int options, IProgressMonitor monitor)
			throws CoreException {
		// FIXME: MÅ IMPLEMENTERAST FOR AT FILOPERASJONAR SKAL FUNGERA
		System.out.println("ZipFileStore#delete");
		if (this.item instanceof ZipFileItem) {
			// Removes ZipFileItem from Directory tree
			((ZipDirectoryItem) this.parent.item).removeChild(this.item);
			// Sets the ZipFileItems parent to null
			this.item.setParent(null);
			this.parent = null;
			// Skriv zip fil på nytt og oppdater

			// TODO: implementer delete i ZipFileUtils
		} else if (this.item instanceof ZipDirectoryItem) {
			// TODO: Dersom directory må vi traversere barn og sette parent til
			// dir høgare opp i hierarkiet
			// Eller slette alle?
		}
	}

	@Override
	public String[] childNames(int options, IProgressMonitor monitor)
			throws CoreException {
		if (isDirectory()) {
			Collection collection = ((ZipDirectoryItem) item).getChildren();
			String[] children = new String[collection.size()];
			Iterator it = collection.iterator();
			int i = 0;
			while (it.hasNext()) {
				ZipItem zip = (ZipItem) it.next();
				children[i++] = zip.getName();
			}
			return children;
		} else
			return new String[0];
	}

	private boolean isDirectory() {
		return item instanceof ZipDirectoryItem;
	}

	@Override
	public IFileInfo fetchInfo(int options, IProgressMonitor monitor)
			throws CoreException {
		FileInfo fileInfo = new FileInfo(getName());
		if (isDirectory()) {
			fileInfo.setDirectory(true);
		} else if (item == null) {
			return fileInfo; // WTF
			// this.item = new ZipFileItem(name,
			// (ZipDirectoryItem)this.getParent(), new ZipEntry(this.name));
		} else {

			fileInfo.setDirectory(false);
			fileInfo.setLastModified(((ZipFileItem) item).getLastModified());
		}

		fileInfo.setExists(true);
		fileInfo.setAttribute(EFS.getLocalFileSystem().attributes(), true); // Ingen
																			// ide
																			// om
		// dette er rett
		// flag
		return fileInfo;
	}

	@Override
	public IFileStore getChild(String name) {
		if (isDirectory()) {
			ZipItem child = ((ZipDirectoryItem) item).getItem(name);
			return new ZipFileStore(name, this, child);
		} else {
			return null;
		}
	}

	protected IPath getPath() {
		if (parent == null) {
			return new Path("/");
		} else {
			return parent.getPath().append(getName());
		}
	}

	protected URI getBase() {
		if (parent == null) {
			return uri;
		} else {
			return ((ZipFileStore) getParent()).getBase();
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IFileStore getParent() {
		return parent;
	}

	@Override
	public InputStream openInputStream(int options, IProgressMonitor monitor)
			throws CoreException {
		if (!isDirectory()) {
			try {
				return ((ZipFileItem) item).openInputStream();
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR,
						"org.example.efs.zip", "Failed to open file", e));
			}
		} else {
			return null;
		}
	}

	@Override
	public OutputStream openOutputStream(int options, IProgressMonitor monitor) {
		System.out.println("ZipFileStore#openOutputStream");
		// FileStore peikar ikkje på noko ZipItem-> bør kunna handtera
		// directories(ZipDirectoryItem) i tillegg til filer (ZipFileItem)

		System.out.println(parent.getBase().toString());
		System.out.println(parent.getPath().toString());
		ZipItem root = null;
		try {
			if (item == null) {
				// Dersom item er null opprettar vi eit nytt ZipFileItem, med
				// "models" som parent
				root = getRoot(getBase());

				ZipItem dir = ((ZipDirectoryItem) root).getItem("models");
				// if (dir instanceof ZipDirectoryItem) {
				// System.out.println("YAY!");
				// }
				item = new ZipFileItem(name, (ZipDirectoryItem) dir,
						new ZipEntry(name));
			}
			return ((ZipFileItem) item).openOutputStream(this);
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public URI toURI() {
		try {
			URI base = getBase();
			return new URI(base.getScheme(), null, null, 0, getPath()
					.toString(), base.getQuery(), null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
