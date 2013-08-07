package no.hib.dpf.transform.henshin;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformPackage;
import no.hib.dpf.transform.presentation.TransformEditor;
import no.hib.dpf.transform.util.TransformActivePage;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class TranslateToEcore {

	public static final String SPEC_TO_ECORE = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateEcoreFromDSpec.henshin";
	
	public static void translateToEcore(DSpecification specification, boolean save){
		
		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformActivePage.activeWorkingDirectory());
		String metaModelName = specification.getSpecification().eResource().getURI().lastSegment().replace(".xmi", "");
		
		//Register file extension for resoure set
//		resourceSet.registerXMIResourceFactories("xmi");
//		TransformPackage.eINSTANCE.getName();
		
		//Load the model and the Henshin module into resource set
		Resource model = resourceSet.getResource(specification.getSpecification().eResource().getURI(), true);
		Module module = resourceSet.getModule(SPEC_TO_ECORE, true);
	
		Specification spec1 = (Specification) model.getContents().get(0);
		System.out.println("Spec " + spec1.getGraph().getNodes());
//		Specification spec2 = (Specification) model.getContents().get(1);
//		System.out.println("LOL " + spec1.getGraph().getNodes() + " " + spec2.getGraph().getNodes());
		
		EGraph graph = new EGraphImpl(model.getContents().get(0));
		Engine engine = new EngineImpl();
		
		Unit unit = module.getUnit("generateSpecToEcore");
		
		UnitApplication unitApp = new UnitApplicationImpl(engine, graph, unit, null);
		unitApp.setParameterValue("ecoreName", metaModelName);
		
		try{
			InterpreterUtil.executeOrDie(unitApp);
			ChangeImpl.PRINT_WARNINGS = false;
		} catch (AssertionError e){
			System.out.println("Errer " + e);
		}
		
		EPackage result = (EPackage) unitApp.getResultParameterValue("package");
		
		if(save){
			String henshinModelName = metaModelName+".ecore";
			File file = new File(TransformActivePage.activeWorkingDirectory()+"/"+henshinModelName);
			if(file.exists()){
				file.delete();
			}
			resourceSet.saveEObject(result, henshinModelName);
		}
		System.out.println("EPackage" + result.getEClassifiers().size());
	}
}
