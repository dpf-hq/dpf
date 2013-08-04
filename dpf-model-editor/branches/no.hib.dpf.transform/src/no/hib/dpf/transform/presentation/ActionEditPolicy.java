package no.hib.dpf.transform.presentation;

import java.io.IOException;
import java.util.List;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.commands.EmptyExecutableCommand;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.TransformPackage;
import no.hib.dpf.transform.command.AddTransformCommand;
import no.hib.dpf.transform.command.PreserveTransformCommand;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.ScalableRootEditPart;
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
		if(PreserveTool.REQ_MAKE_COMMON.equals(request.getType()))
			return MakeCommonCommand(getHost());
		return null;
	}

	private Command MakeCommonCommand(EditPart editPart) {
		Object editObject = editPart.getModel();
		Production production = null;
		
		if(editObject instanceof DArrow){
			DArrow dArrow = (DArrow) editObject;
			production = (Production) dArrow.eContainer().eContainer().eContainer();
		}
		if(editObject instanceof DNode){
			DNode dNode = ((DNode) editObject);
			production = (Production) (dNode).eContainer().eContainer().eContainer();
		}
		if(editPart != null && production != null){
			return new PreserveTransformCommand(editObject, production);
			//
		}
		return EmptyExecutableCommand.INSTANCE;
	}

	private Command MakeDeleteCommand(EditPart editPart) {
		Object editObject = editPart.getModel();
		Production production = null;
		
		if(editObject instanceof DArrow){
			DArrow dArrow = (DArrow) editObject;
			production = (Production) dArrow.eContainer().eContainer().eContainer();
		}
		if(editObject instanceof DNode){
			DNode dNode = ((DNode) editObject);
			production = (Production) (dNode).eContainer().eContainer().eContainer();
		}
		if(editPart != null && production != null){
			return new DeleteTransformCommand(editObject, production);
		}
		return EmptyExecutableCommand.INSTANCE;
	}

	private Command MakeAddCommand(EditPart editPart) {
		Object editObject = editPart.getModel();
		Production production = null;
		
		if(editObject instanceof DArrow){
			DArrow dArrow = (DArrow) editObject;
			production = (Production) dArrow.eContainer().eContainer().eContainer();
			System.out.println("Ger " + (dArrow).eContainer().eContainer().eContainer());
		}
		if(editObject instanceof DNode){
			DNode dNode = ((DNode) editObject);
			production = (Production) (dNode).eContainer().eContainer().eContainer();
		}
		if(editPart != null && production != null){
			return new AddTransformCommand(editObject, production);
		}
		return EmptyExecutableCommand.INSTANCE;
	}
	
	public EditPart getTargetEditPart(Request request) {
		if (AddTool.REQ_MAKE_ADD.equals(request.getType()) || 
			DeleteTool.REQ_MAKE_DELETE.equals(request.getType()) || 
			PreserveTool.REQ_MAKE_COMMON.equals(request.getType()))
			return getHost();
		return null;
	}
}
;