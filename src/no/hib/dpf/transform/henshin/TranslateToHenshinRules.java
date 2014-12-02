package no.hib.dpf.transform.henshin;

import java.io.File;

import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.rules.TransformModule;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class TranslateToHenshinRules {

	public static final String PATH = "C:/Users/Petter/workspace/Henshin_Test/model/";
	public static final String HENSHIN = "generateHenshinRules.henshin";
	public static final String HENSHINNEW = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateHenshinRules.henshin";
	public static final String HENSHINUNITS = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateLoopHenshin.henshin";
	
	public static void generateHenshinModule(boolean save){
		
		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformUtils.activeWorkingDirectory());

		Transform transform = TransformUtils.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(TransformUtils.activeWindowFileLocation()));
		TransformModule translateHenshinRules = new TransformModule(transform, resourceSet);
		
		Module result = (Module) translateHenshinRules.createModule();
		
		if(save){
			String henshinModelName = TransformUtils.trimActiveTransformModel()+"toHenshin.henshin";
			File file = new File(TransformUtils.activeWorkingDirectory()+"/"+henshinModelName);
			if(file.exists()){
				file.delete();
			}
			resourceSet.saveEObject(result, henshinModelName);
		}
		System.out.println("Module" + result.getName());
	}
}
