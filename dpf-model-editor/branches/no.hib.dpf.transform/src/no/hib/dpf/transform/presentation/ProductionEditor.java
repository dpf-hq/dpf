/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.transform.presentation;

import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_TYPE_DGRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFEditorPaletteFactory;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;
import no.hib.dpf.editor.displaymodel.factories.DPFConnectionCreationToolEntry;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.parts.DPFEditPartFactory;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.transform.util.TransformUtils;
import no.hib.dpf.transform.util.TransformConstants;
import no.hib.dpf.transform.parts.TransformArrowLabelEditPart;
import no.hib.dpf.transform.parts.TransformDArrowEditPart;
import no.hib.dpf.transform.parts.TransformDNodeEditPart;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A graphical editor with flyout palette that can edit .dpf files. The
 * binding between the .dpf file extension and this editor is done in
 * plugin.xml
 * 
 * @author Elias Volanakis
 */
public abstract class ProductionEditor extends GraphicalEditorWithFlyoutPalette{

	/** This is the root of the editor's model. */

	protected Production production;

	//	/** Palette component, holding the tools and shapes. */
	protected Transform transform = null;
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
	protected PaletteRoot paletteRoot;

	private DPFEditPartFactory shapesEditPartFactory;
	protected DPFTransformPaletteFactory paletteFactory;

	protected DSpecification dspec = null;
	
	protected PropertySheetPage propertySheetPage;


	public void setProduction(Production prod){
		production = prod;
	}
	
	public ProductionEditor(){
		paletteFactory = new DPFTransformPaletteFactory();
	}
	/**
	 * Configure the graphical viewer before it receives contents.
	 * <p>
	 * This is the place to choose an appropriate RootEditPart and
	 * EditPartFactory for your editor. The RootEditPart determines the behavior
	 * of the editor's "work-area". For example, GEF includes zoomable and
	 * scrollable root edit parts. The EditPartFactory maps model elements to
	 * edit parts (controllers).
	 * </p>
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	 public void createPartControl(Composite parent) {
		 super.createPartControl(parent);
		
		 
	 }
	 
	 public DPFTransformPaletteFactory getpaletteFactory(){
		 return paletteFactory;
	 }
	
	 protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		String transformFile = TransformUtils.activeWindowFileLocation();
		transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(transformFile), resourceToDiagnosticMap);
		DSpecification defaultDSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		defaultDSpecification.setDType(DiagramFactory.eINSTANCE.createDefaultDSpecification());
		
		DGraph newGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		


		DSpecification sourceDSpecification = transform.getSourceMetaModel();
		DSpecification targetDSpecification = transform.getTargetMetaModel();
		
		if(sourceDSpecification!=targetDSpecification && !targetDSpecification.getDGraph().getDNodes().isEmpty()){
			//commonGraph.setGraph(DiagramFactory.eINSTANCE.createDefaultDSpecification());

			System.out.println("Like");
			
			newGraph = setDGraphForExogenousTransformation(sourceDSpecification, targetDSpecification, transformFile);
//			EditPartGraph cGraph = new EditPartGraph();
//			dspec = cGraph.getCommonGraph();
//			dspec.setDSignature(DPFConstants.DEFAULT_DSIGNATURE);
//			dspec.setDType(DPFConstants.REFLEXIVE_DSPECIFICATION);
			
			String uri = "C:/Users/Petter/runtime-EclipseApplication/model/CorrespondanceModel.dpf";
			
			dspec = DPFUtils.loadDSpecification(DPFUtils.getResourceSet(), URI.createFileURI(uri), resourceToDiagnosticMap);
			
			for(int i = 0;i<dspec.getDGraph().getDNodes().size();i++){
				System.out.println(i+ " Name: " + dspec.getDGraph().getDNodes().get(i).getName() + " " + dspec.getDGraph().getDNodes().get(i).getTypeName());
			}
			newGraph = dspec.getDType().getDGraph();
		}
		else{
			System.out.println("Ulike");
			newGraph = sourceDSpecification.getDGraph();
		}
		for(int i = 0;i<newGraph.getDNodes().size();i++){
			System.out.println(newGraph.getDNodes().get(i).getName());
		}
		
		GraphicalViewer viewer = getGraphicalViewer();
		//paletteFactory.updatePalette(getPaletteRoot(), dSpecification.getDType().getDGraph());
		//paletteFactory.updatePalette(getPaletteRoot(), dSpecification.getDGraph());
		paletteFactory.updatePalette(getPaletteRoot(), newGraph);
		shapesEditPartFactory = new DPFEditPartFactory(){
			protected EditPart getPartForElement(Object modelElement) {
//				System.out.println("Her " + modelElement.toString());
//				EObject object = (EObject) modelElement;
//				Production prod = (Production) object.eContainer().eContainer();
//				if(prod.getName().contains(TransformConstants.CORRESPONDACE_GRAPH)){
//					System.out.println("her");
//				}
//				System.out.println(object.eContainer().eContainer());
//				if (modelElement instanceof DGraph) {
//					return new DGraphEditPart(){
//						protected void createEditPolicies() {
//							super.createEditPolicies();
//							installEditPolicy("action", new ActionEditPolicy());
//						}
//					};
//				}
				if (modelElement instanceof DNode) {
					return new TransformDNodeEditPart(modelElement){
						protected void createEditPolicies() {
							super.createEditPolicies();
							installEditPolicy("action", new ActionEditPolicy());
						}
					};
				}
				if (modelElement instanceof DArrow) {
					return new TransformDArrowEditPart(modelElement){
						protected void createEditPolicies() {
							super.createEditPolicies();
							installEditPolicy("action", new ActionEditPolicy());
						}
					};
				}
				if (modelElement instanceof DOffset) {
					DOffset offset = (DOffset) modelElement;
					if(offset.eContainer() instanceof DArrow)
						return new TransformArrowLabelEditPart(offset);
				}
				return super.getPartForElement(modelElement);
			}
		};
		viewer.setEditPartFactory(shapesEditPartFactory);
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		ContextMenuProvider cmProvider = new TranformEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
	}

	@Override
	protected FlyoutPreferences getPalettePreferences() {
		FlyoutPreferences retval = super.getPalettePreferences();
		retval.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
		retval.setPaletteWidth(200);
		return retval;
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		if (paletteRoot == null) {
			paletteRoot = paletteFactory.createPalette();
		}
		return paletteRoot;
	}
		
	private DGraph setDGraphForExogenousTransformation(DSpecification sourceDSpecification, 
			DSpecification targetDSpecification, String transformFile){
		
		DGraph tempGraph = null;
		
		DGraph defaultDGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		DNode defaultNode = DPFConstants.REFLEXIVE_TYPE_DNODE;
		DArrow defaultDArrow = DPFConstants.REFLEXIVE_TYPE_DARROW;
		
		EcoreUtil.resolveAll(targetDSpecification);
		EcoreUtil.resolveAll(targetDSpecification.getSpecification());
		
		Assert.isTrue(targetDSpecification != null);
		setPartName(transformFile);
		tempGraph = targetDSpecification.getDGraph();
		defaultDGraph = targetDSpecification.getDGraph();

		
//		tempGraph.getDNodes().addAll(targetDSpecification.getDGraph().getDNodes());
//		tempGraph.getDArrows().addAll(targetDSpecification.getDGraph().getDArrows());
		
		for(int i = 0;i<sourceDSpecification.getDGraph().getDNodes().size();i++){
			tempGraph.createDNode(sourceDSpecification.getDGraph().getDNodes().get(i).getName(), defaultNode);
		}
		
		for(int i = 0;i<sourceDSpecification.getDGraph().getDArrows().size();i++){
			DArrow dArrow = sourceDSpecification.getDGraph().getDArrows().get(i);
			DNode dSource = null;
			DNode dTarget = null;
			for(int j = 0;j<tempGraph.getDNodes().size();j++){
				if(tempGraph.getDNodes().get(j).getName().contains(dArrow.getDSource().getName())){
					dSource = tempGraph.getDNodes().get(j);
				}
			}
			for(int j = 0;j<tempGraph.getDNodes().size();j++){
				if(tempGraph.getDNodes().get(j).getName().contains(dArrow.getDTarget().getName())){
					dTarget = tempGraph.getDNodes().get(j);
				}
			}
			tempGraph.createDArrow(dArrow.getName(), dSource, dTarget, defaultDArrow);
		}
		//return tempGraph;
		return defaultDGraph;
	}

	/*private DGraph setDGraphForExogenousTransformation(DSpecification sourceDSpecification, 
			DSpecification targetDSpecification, String transformFile){
		
		DGraph tempGraph = null;
		
		EcoreUtil.resolveAll(sourceDSpecification);
		EcoreUtil.resolveAll(sourceDSpecification.getSpecification());
		
		Assert.isTrue(sourceDSpecification != null);
		setPartName(transformFile);
		tempGraph = sourceDSpecification.getDGraph();
		
		EcoreUtil.resolveAll(targetDSpecification);
		EcoreUtil.resolveAll(targetDSpecification.getSpecification());
		
		tempGraph.getDNodes().addAll(targetDSpecification.getDGraph().getDNodes());
		tempGraph.getDArrows().addAll(targetDSpecification.getDGraph().getDArrows());
		
		for(int i = 0;i<tempGraph.getDNodes().size();i++){
			for(int j = 0;j<targetDSpecification.getDGraph().getDNodes().size();j++){
				if(targetDSpecification.getDGraph().getDNodes().get(j).getName() == tempGraph.getDNodes().get(i).getName()){
					System.out.println(targetDSpecification.getDGraph().getDNodes().get(j).getName());
				}
			}
		}
		
		
		return tempGraph;
	}*/

	
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();	
	}
};