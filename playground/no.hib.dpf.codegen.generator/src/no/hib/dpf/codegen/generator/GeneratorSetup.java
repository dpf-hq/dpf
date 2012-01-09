package no.hib.dpf.codegen.generator;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

//import org.eclipse.core.resources.IResource;
//import org.eclipse.core.resources.ResourcesPlugin;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.Platform;
//import java.util.Iterator;
//import org.eclipse.emf.ecore.EAttribute;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EClassifier;
//import org.eclipse.emf.ecore.EDataType;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EEnumLiteral;
//
//import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Specification;
//FIXME: Nytt namn
public class GeneratorSetup {
	
	public void generate(Map<String, String> properties) {
		// configure outlets
		//TODO: More error prone code
		OutputImpl output = new OutputImpl();
		Outlet outlet = new Outlet(properties.get("outputPath"));
		outlet.setOverwrite(true);
		outlet.addPostprocessor(new JavaBeautifier());
		output.addOutlet(outlet);
		
		Map<String, Variable> globalVarsMap = getGlobalVars(properties);
	    XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVarsMap, null, null);
	    
	    //Register the DPF metamodel
	    EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
	        @Override
	        protected EPackage[] allPackages() {
	            return new EPackage[] {CoreFactory.eINSTANCE.getEPackage()};
	        }
	    };
	    execCtx.registerMetaModel(metamodel);
	    Specification spec;
	    
		try {
			spec = CoreFactory.eINSTANCE.loadSpecification(URI.createURI(properties.get("xmiLocation")));
			
			XpandFacade facade = XpandFacade.create(execCtx);
		    facade.evaluate(properties.get("templateEntryPoint"), spec);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private Map<String, Variable> getGlobalVars(Map<String, String> map) {
		HashMap<String, Variable> res = new HashMap<String, Variable>();
		for(String k : map.keySet()) {
			Variable v = new Variable(k, map.get(k));
			res.put(k, v);
		}
		return res;
	}
//	//For debug purposes
//	@SuppressWarnings({"unused","rawtypes"})
//	private void printPackage(EPackage pack) {
//		for (Iterator iter = pack.getEClassifiers().iterator(); iter
//				.hasNext();) {
//			EClassifier classifier = (EClassifier) iter.next();
//			System.out.println(classifier.getName());
//			System.out.print(" ");
//			if (classifier instanceof EClass) {
//				EClass eClass = (EClass) classifier;
//				for (Iterator ai = eClass.getEAttributes().iterator(); ai
//						.hasNext();) {
//					EAttribute attribute = (EAttribute) ai.next();
//					System.out.print(attribute.getName() + " ");
//				}
//				if (!eClass.getEAttributes().isEmpty()
//						&& !eClass.getEReferences().isEmpty()) {
//					System.out.println();
//					System.out.print(" ");
//				}
//				for (Iterator ri = eClass.getEReferences().iterator(); ri
//						.hasNext();) {
//					EReference reference = (EReference) ri.next();
//					System.out.print(reference.getName() + " ");
//				}
//			} else if (classifier instanceof EEnum) {
//				EEnum eEnum = (EEnum) classifier;
//				for (Iterator ei = eEnum.getELiterals().iterator(); ei
//						.hasNext();) {
//					EEnumLiteral literal = (EEnumLiteral) ei.next();
//					System.out.print(literal.getName() + " ");
//				}
//			} else if (classifier instanceof EDataType) {
//				EDataType eDataType = (EDataType) classifier;
//				System.out.print(eDataType.getInstanceClassName());
//			}
//			System.out.println();
//		}
//	}		
}
