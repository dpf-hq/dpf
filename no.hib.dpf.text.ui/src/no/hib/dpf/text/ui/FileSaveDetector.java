package no.hib.dpf.text.ui;

import java.beans.PropertyChangeSupport;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;

public class FileSaveDetector implements IResourceDeltaVisitor{
	
	public static FileSaveDetector INSTANCE = new FileSaveDetector(); 
	
	private PropertyChangeSupport support = new PropertyChangeSupport(this);

	private FileSaveDetector(){}	
	
	public final PropertyChangeSupport getSupport() {
		return support;
	}

	public boolean visit(IResourceDelta delta) {
       IResource res = delta.getResource();
       switch (delta.getKind()) {
//          case IResourceDelta.ADDED:
//             break;
//          case IResourceDelta.REMOVED:
//              break;
          case IResourceDelta.CHANGED:
             if(res.getFullPath().toString().endsWith(Normalizer.SPECIFICATION_FILE_EXTENSION)){
            	 support.firePropertyChange(res.getName(), true, false);
             }
             break;
       }
       return true; // visit the children
    }

//	private static IFile getIFileIResource(IResource r) {
//		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
//		return root.getFile(r.getFullPath());
//	}
	
	
	
}
