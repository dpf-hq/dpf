package no.hib.dpf.uconstraint.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.uconstraint.Constraints;
import no.hib.dpf.uconstraint.UConstraintPlugin;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class ConstraintsUtils extends DPFUtils {

	static List<EObject> getPersistentList(Constraints constraints){
		List<EObject> persistent = new ArrayList<EObject>();
		/*
		 * constraints itself (containing all the diagrams of universal constraints)
		 */
		persistent.add(constraints);
		if(constraints.getDSignature() != DPFConstants.DEFAULT_DSIGNATURE){
			persistent.add(constraints.getDSignature());
			persistent.add(constraints.getDSignature().getSignature());
		}
		/*
		 * type diagram (model diagram)
		 */
		DSpecification dModel = constraints.getElementTypeGraph();
		addDiagram(persistent, dModel);
		return persistent;

	}
	static void addDiagram(List<EObject> persistent, DSpecification diagram){
		if(diagram == DPFConstants.REFLEXIVE_DSPECIFICATION) 
			return;
		persistent.add(diagram);
		persistent.add(diagram.getSpecification());
		DSignature dSig = diagram.getDSignature();
		if(dSig != DPFConstants.DEFAULT_DSIGNATURE){
			if(!persistent.contains(dSig))
				persistent.add(dSig);
			if(!persistent.contains(dSig.getSignature()))
				persistent.add(dSig.getSignature());
		}
		addDiagram(persistent, diagram.getDType());
	}

	public static ResourceSetImpl getResourceSet(){
		ResourceSetImpl resourceSet = DPFUtils.getResourceSet();
		if(resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().containsKey("uc")) return resourceSet;
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sig", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("uc", new XMIResourceFactoryImpl());
		return resourceSet;
	}

	public static void saveConstraints(ResourceSetImpl resourceSet, URI osString, Constraints constraints, boolean initial) {
		Assert.isNotNull(resourceSet);
		Resource resource = createResource(resourceSet, osString);
		if(resource == null){
			return;
		}
		if(initial) resource.getContents().addAll(getPersistentList(constraints));
		try {
			resource.save(null);
		} catch (IOException e) {
			logError("Unable to save resource: " + osString, e);
			MessageDialog.openError(Display.getCurrent().getActiveShell(), 
					"Error", "Cannot save file " + osString.toFileString());
		}
	}

	public static Constraints loadConstraints(ResourceSetImpl resourceSet, URI diagramURI) {
		Assert.isNotNull(resourceSet);
		Resource constraints = createResource(resourceSet, diagramURI);
		try {
			constraints.load(null);
		} catch (IOException e) {
			logError("Unable to load resource: " + diagramURI, e);
			MessageDialog.openError(Display.getCurrent().getActiveShell(), 
					"Error", "Cannot load file " + diagramURI.toFileString());
		}
		if(constraints.getContents().isEmpty()) return null; 
		return (Constraints) constraints.getContents().get(0);
	}
	public static Plugin getPlugin(){return (UConstraintPlugin.Implementation)UConstraintPlugin.getPlugin(); };
}
