package no.hib.dpf.editor.actions;

import no.hib.dpf.editor.DPFEditor;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public class ExportImageAction implements IEditorActionDelegate {

	DPFEditor editor = null;
 
	@Override
	public void run(IAction action) {
		if(editor != null){
			final GraphicalViewer graphicalViewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class); // get it from your editor
			if(graphicalViewer == null) return;

			final String saveLocation = ((IFileEditorInput)editor.getEditorInput()).getFile().getLocation().toOSString() + ".jpeg"; // get it thru a FileDialog 
			RootEditPart rootEditPart = graphicalViewer.getRootEditPart();
			if(rootEditPart instanceof LayerManager){
				final IFigure printFigure = ((LayerManager)rootEditPart).getLayer(LayerConstants.PRINTABLE_LAYERS);
				if(printFigure != null){
					Rectangle bounds = printFigure.getBounds();
					final Image img = new Image(Display.getDefault(), bounds.width, bounds.height); 
					SWTGraphics graphic = new SWTGraphics(new GC(img));
					printFigure.paint(graphic);
					saveImage(img, saveLocation, SWT.IMAGE_JPEG);
					graphic.dispose();
					img.dispose();
					try {
						((IFileEditorInput)editor.getEditorInput()).getFile().getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

	private void saveImage(Image image, String location, int type){
		ImageLoader imgLoader = new ImageLoader(); 
		imgLoader.data = new ImageData[] { image.getImageData() }; 
		imgLoader.save(location, type);
	}
	
	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if(targetEditor == editor)
			return;
		if(targetEditor instanceof DPFEditor){
			editor = (DPFEditor) targetEditor;
			action.setEnabled(true);
		}else{
			editor = null;
			action.setEnabled(false);
		}
	}

}
