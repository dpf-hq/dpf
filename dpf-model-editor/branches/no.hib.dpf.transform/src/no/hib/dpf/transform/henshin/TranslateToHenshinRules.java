package no.hib.dpf.transform.henshin;

import java.io.File;

import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.transform.TransformPackage;
import no.hib.dpf.transform.util.TransformActivePage;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
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
	
	
	public static void generateHenshinModule(String path, boolean save){
		
		//Create the resource set
		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformActivePage.activeWorkingDirectory());
 		
		//Register file extension for resoure set
 		resourceSet.registerXMIResourceFactories("xform");
 		TransformPackage.eINSTANCE.getName();
 		
 		//Load the model and the Henshin module into resource set
 		Resource model = resourceSet.getResource(TransformActivePage.activeTransformModel());	
		Module module = resourceSet.getModule(HENSHINNEW, true);
		
		//Load the model in a EGraph and define a Engine for the transformation
		EGraph graph = new EGraphImpl(model);
		Engine engine = new EngineImpl();
		
		Unit unit = module.getUnit("createHenshinRules");
		UnitApplication unitApp = new UnitApplicationImpl(engine, graph, unit, null);
		
		try{
			InterpreterUtil.executeOrDie(unitApp);
		} catch (AssertionError e){
			System.out.println("Errer " + e);
		}
		
		Module result = (Module) unitApp.getResultParameterValue("module");
		
		if(save){
			String henshinModelName = TransformActivePage.trimActiveTransformModel()+"toHenshin.henshin";
			File file = new File(TransformActivePage.activeWorkingDirectory()+"/"+henshinModelName);
			if(file.exists()){
				file.delete();
			}
			resourceSet.saveEObject(result, henshinModelName);
		}
		
		System.out.println("Module" + result.getRules().toString());
	}
}
