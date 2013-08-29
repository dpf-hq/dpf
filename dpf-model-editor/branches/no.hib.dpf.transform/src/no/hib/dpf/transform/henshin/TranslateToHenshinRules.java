package no.hib.dpf.transform.henshin;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformPackage;
import no.hib.dpf.transform.presentation.TransformEditor;
import no.hib.dpf.transform.rules.TransformModule;
import no.hib.dpf.transform.util.TransformUtils;

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

public class TranslateToHenshinRules {

	public static final String PATH = "C:/Users/Petter/workspace/Henshin_Test/model/";
	public static final String HENSHIN = "generateHenshinRules.henshin";
	public static final String HENSHINNEW = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateHenshinRules.henshin";
	public static final String HENSHINUNITS = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateLoopHenshin.henshin";
	
	public static void generateHenshinModule(boolean save){
		
		//TranslateToEcore.translateToEcore(TransformActivePage.activeTransformModel(), true);

		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformUtils.activeWorkingDirectory());
		Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
		//Transform the metamodels
		//Engine engine = new EngineImpl();

		Transform transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(TransformUtils.activeWindowFileLocation()), resourceToDiagnosticMap);
		TransformModule translateHenshinRules = new TransformModule(transform, resourceSet);
		
		Module result = (Module) translateHenshinRules.createModule();
		
		if(save){
			String henshinModelName = TransformUtils.trimActiveTransformModel()+"toHenshin.henshin";
			File file = new File(TransformUtils.activeWorkingDirectory()+"/"+henshinModelName);
			if(file.exists()){
				file.delete();
			}
			//resourceSet.createResource(null, TransformActivePage.trimActiveTransformModel()+"toHenshin.henshin");
			resourceSet.saveEObject(result, henshinModelName);
		}
		System.out.println("Module" + result.getRules());
	}
	/*
	 * 		//TranslateToEcore.translateToEcore(path, save, engine, resourceSet);
		
		/*EPackage metamodel = (EPackage) loadMetaModelObject(resourceSet);
		System.out.println("/testing.ecore");
		//Create the resource set
		

		
		//Register file extension for resoure set
 		resourceSet.registerXMIResourceFactories("xform");
 		TransformPackage.eINSTANCE.getName();
 		
 		//Load the model and the Henshin module into resource set
 		Resource model = resourceSet.getResource(TransformActivePage.activeTransformModel());	
		Module module = resourceSet.getModule(HENSHINNEW, true);
		
		module.getImports().add(metamodel);
		
		//Load the model in a EGraph and define a Engine for the transformation
		EGraph graph = new EGraphImpl(model);
		
		//Unit unit = module.getUnit("createHenshinRules");
		Unit unit = module.getUnit("generateHenshinRules");
		
		UnitApplication unitApp = new UnitApplicationImpl(engine, graph, unit, null);
		
		//unitApp.setParameterValue("fileName", TransformActivePage.trimActiveTransformModel());
		
		try{
			InterpreterUtil.executeOrDie(unitApp);
			ChangeImpl.PRINT_WARNINGS = false;
		} catch (AssertionError e){
			System.out.println("Errer " + e);
		}
//		*/
//		Module result = (Module) unitApp.getResultParameterValue("module");
	/*
	 * private static EObject loadMetaModelObject(HenshinResourceSet resourceSet){
		URI instanceUri = URI.createFileURI(new File("C:/Users/Petter/runtime-EclipseApplication/transformtest/testing.ecore").getAbsolutePath());
		Resource resourceInstance = resourceSet.getResource(instanceUri, true);
		
		if (resourceInstance.isLoaded()) {
			resourceInstance.unload();
			try {
				resourceInstance.load(null);
			} catch (IOException e) {
				e.printStackTrace();
			}// try catch
		}// if

		return resourceInstance.getContents().get(0);
	}*/
}
