package no.hib.dpf.transform.henshin;

import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.transform.TransformPackage;
import no.hib.dpf.transform.util.TransformActivePage;

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

	public TranslateToEcore(String modelPath){
		
		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformActivePage.activeWorkingDirectory());
			
		//Register file extension for resoure set
		resourceSet.registerXMIResourceFactories("xform");
		TransformPackage.eINSTANCE.getName();
			
		//Load the model and the Henshin module into resource set
		Resource model = resourceSet.getResource(TransformActivePage.activeTransformModel());
			
	}
}
