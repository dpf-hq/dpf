package no.hib.dpf.codegen.testproject.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Specification;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;

public class Test {
	/**
	 * This method demonstrates how to programatically invoke the workflow engine
	 */
	private static void workflowEngineExecution() {
		WorkflowEngine we = new WorkflowEngine();
		we.run("src/workflow/workflow.mwe", new NullProgressMonitor(), 
				new HashMap<String, String>(), new HashMap<String, Object>());
	}
	
	/**
	 * This method demonstrates how to programatically use Xpand without the workflow engine.
	 */
	private static void programmaticExecution(String outletPath, String metaModelPath, String modelPath) {
		OutputImpl output = new OutputImpl();
		Outlet outlet = new Outlet(outletPath);
		outlet.setOverwrite(true);
		outlet.addPostprocessor(new JavaBeautifier());
		output.addOutlet(outlet);
		
		Map<String, Variable> globalVarsMap = new HashMap<String, Variable>();
	    XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVarsMap, null, null);
	    
	    Specification model = null;
	    
	    try {
	    	DpfMetamodel dpfMetaModel = 
	  	    	new DpfMetamodel();
	    	
	    	Specification metaModel = CoreFactory.eINSTANCE.loadSpecification(
	    			URI.createURI(metaModelPath));
	  	    
	    	dpfMetaModel.addDpfMetaModel(metaModel);
	    	
	  	    execCtx.registerMetaModel(dpfMetaModel);
	  	    
			model = CoreFactory.eINSTANCE.loadSpecification(
					URI.createURI(modelPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate("template::test::main", model);
	}
	
	public static void main(String[] args) {
		workflowEngineExecution();
//		programmaticExecution(
//				"/home/anders/Master/Code/main/generator-branch/no.hib.dpf.codegen.testproject/src-gen",
//				"/home/anders/Master/Code/main/generator-branch/no.hib.dpf.codegen.testproject/metamodel/test.dpf.xmi", 
//				"/home/anders/Master/Code/main/generator-branch/no.hib.dpf.codegen.testproject/model/model.dpf.xmi");
	}
}
