package no.hib.dpf.api.zip.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class ZipResourceChangedListener implements IResourceChangeListener {

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		System.out.println("Resource changed!");
		IResourceDelta delta = event.getDelta();
		final IResourceDelta[] children = delta.getAffectedChildren();

		WorkspaceJob job = new WorkspaceJob("Update project") {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor)
			throws CoreException {
				for(IResourceDelta d : children) {
					d.getResource().refreshLocal(IProject.DEPTH_INFINITE, null);
				}
				return Status.OK_STATUS;
			}
		};

		job.schedule();
	}
}
