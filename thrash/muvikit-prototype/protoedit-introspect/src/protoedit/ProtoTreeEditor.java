package protoedit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import muvitorkit.ui.ContextMenuProviderWithActionRegistry;
import muvitorkit.ui.MuvitorTreeEditor;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.ui.parts.TreeViewer;

import protoedit.actions.CreateClassAction;
import protoedit.actions.CreateReferenceAction;
import protoedit.actions.ProtoTreeContextMenuProvider;
import protoedit.editparts.tree.ProtoTreeEditPartFactory;
import protomodel.ProtomodelPackage;

public class ProtoTreeEditor extends MuvitorTreeEditor {
	public static final String GRAPH_VIEW_ID = "protoedit.ui.graphs.GraphView";
	static {
		registerViewID(ProtomodelPackage.Literals.DIAGRAM, GRAPH_VIEW_ID);
	}

	@Override
	protected ContextMenuProviderWithActionRegistry createContextMenuProvider(
			TreeViewer viewer) {
		return new ProtoTreeContextMenuProvider(viewer);
	}

	@Override
	protected void createCustomActions() {
		registerAction(new CreateReferenceAction(this));
		registerAction(new CreateClassAction(this));
	}

	@Override
	protected EObject createDefaultModel() {
		/*
		 * Clazz clazz = ProtomodelFactory.eINSTANCE.createClazz();
		 * clazz.setName("theclazz"); Reference ref =
		 * ProtomodelFactory.eINSTANCE.createReference(); ref.setName("theref");
		 * ref.setSource(clazz); ref.setDest(clazz);
		 * clazz.getReferences().add(ref);
		 * 
		 * Clazz clazz2 = ProtomodelFactory.eINSTANCE.createClazz();
		 * clazz2.setName("name2"); Reference ref2 =
		 * ProtomodelFactory.eINSTANCE.createReference();
		 * ref2.setName("theConnection"); ref2.setSource(clazz);
		 * ref2.setDest(clazz2); clazz.getReferences().add(ref2);
		 * 
		 * Diagram diagram = ProtomodelFactory.eINSTANCE.createDiagram();
		 * diagram.setName("default"); diagram.getClasses().add(clazz);
		 */

		/*URI modelUri = URI.createFileURI("/Users/dagvl/Documents/muvikit-prototype/protoedit/models/Proto.ecore");
	
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource ecoreResource = resourceSet.getResource(modelUri, true);
		EPackage protomodelPackage = (EPackage) ecoreResource.getContents().get(0);
		System.out.println("ePackage: " + protomodelPackage);
		EClass clazzClass = (EClass) protomodelPackage.getEClassifier("Clazz");
		EClass diagramClass = (EClass) protomodelPackage.getEClassifier("Diagram");
		//EClassifier nameClassifier = protomodelPackage.getEClassifier("name");
		EStructuralFeature clazzNameFeature = clazzClass.getEStructuralFeature("name");
		System.out.println("clazz:" + clazzClass);
		System.out.println("nameClassifier: " + clazzNameFeature);
		EFactory protoFactory = protomodelPackage.getEFactoryInstance();
		EObject clazz = protoFactory.create(clazzClass);
		clazz.eSet(clazzNameFeature, "TheKlass");
		System.out.println("clazz: " + clazz);
		System.out.println(clazz.eContents());
		

		EObject diagram = protoFactory.create(diagramClass);
		EStructuralFeature diagramNameFeature = diagramClass.getEStructuralFeature("name");
		EStructuralFeature diagramClassesFeature = diagramClass.getEStructuralFeature("classes");
		diagram.eSet(diagramNameFeature, "The Diagram");
		EList<EObject> classes = new BasicEList<EObject>();
		classes.add(clazz);

		return diagram;*/
		// Initialize the model
		//URI modelUri = URI.createFileURI("/Users/dagvl/Documents/runtime-EclipseApplication/testing/models/PROTO1.proto");
		URI modelUri = URI.createFileURI("/home/dagvl/workspaces/runtime-EclipseApplication/ProtoEMFTest/models/PROTO3.proto");
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource ecoreResource = resourceSet.getResource(modelUri, true);
		//EPackage protomodelPackage = (EPackage) ecoreResource.getContents().get(0);
		// Register the XMI resource factory for the .website extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("proto", new XMIResourceFactoryImpl());

		EObject root = ecoreResource.getContents().get(0);
		return root;

	}
	

	@Override
	protected EditPartFactory createTreeEditPartFactory() {
		return new ProtoTreeEditPartFactory();
	}

	@Override
	protected void setupKeyHandler(KeyHandler arg0) {
		// TODO Auto-generated method stub

	}

}
