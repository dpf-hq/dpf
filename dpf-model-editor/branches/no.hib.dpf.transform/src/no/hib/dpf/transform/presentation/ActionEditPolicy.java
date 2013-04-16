package no.hib.dpf.transform.presentation;

import java.io.IOException;
import java.util.List;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.commands.EmptyExecutableCommand;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.TransformPackage;
import no.hib.dpf.transform.command.AddTransformCommand;
import no.hib.dpf.transform.command.DeleteTransformCommand;
import no.hib.dpf.transform.impl.ProductionImpl;
import no.hib.dpf.transform.impl.TransformFactoryImpl;
import no.hib.dpf.transform.impl.TransformImpl;
import no.hib.dpf.transform.util.TransformActivePage;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class ActionEditPolicy extends AbstractEditPolicy {

	private Object object;
	
	public Command getCommand(Request request) {
		if (AddTool.REQ_MAKE_ADD.equals(request.getType()))
			return MakeAddCommand(getHost());
		if (DeleteTool.REQ_MAKE_DELETE.equals(request.getType()))
			return MakeDeleteCommand(getHost());
		return null;
	}

	private Command MakeDeleteCommand(EditPart editPart) {
		Object editObject = editPart.getModel();
		
		if(editPart != null){
			return new DeleteTransformCommand(editObject, (DGraph)getHost().getParent().getModel());
		}
		return EmptyExecutableCommand.INSTANCE;
	}

	private Command MakeAddCommand(EditPart editPart) {
		Object editObject = editPart.getModel();
		
		if(editPart != null){
			return new AddTransformCommand((DNode) editObject, (DGraph)getHost().getParent().getModel());
		}
		return EmptyExecutableCommand.INSTANCE;
	}
	
	public EditPart getTargetEditPart(Request request) {
		if (AddTool.REQ_MAKE_ADD.equals(request.getType()) || DeleteTool.REQ_MAKE_DELETE.equals(request.getType()))
			return getHost();
		return null;
	}
}
;