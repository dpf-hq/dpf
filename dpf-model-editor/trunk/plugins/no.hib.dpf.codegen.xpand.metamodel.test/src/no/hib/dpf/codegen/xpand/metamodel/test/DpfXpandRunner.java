package no.hib.dpf.codegen.xpand.metamodel.test;

import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;

public class DpfXpandRunner {
	
//	private String metaModelPath, modelPath;
	
	public DpfXpandRunner() {
//		this.metaModelPath = metaModelPath;
//		this.modelPath = modelPath;
	}
	
	public void runWorkflowEngine() {
		WorkflowEngine we = new WorkflowEngine();
		we.run("src/workflow/workflow.mwe", new NullProgressMonitor(), 
				new HashMap<String, String>(), new HashMap<String, Object>());
	}

	public void run(String outletPath, String metaModelPath, String modelPath, String evalEntry) {
		OutputImpl output = new OutputImpl();
		Outlet outlet = new Outlet(outletPath);
		outlet.setOverwrite(true);
		outlet.addPostprocessor(new JavaBeautifier());
		output.addOutlet(outlet);



		Map<String, Variable> globalVarsMap = new HashMap<String, Variable>();
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVarsMap, new DpfExceptionHandler(), null);

		Specification model = null;

		DpfMetamodel dpfMetaModel = 
				new DpfMetamodel();

		Specification metaModel = DPFCoreUtil.loadSpecification(
				URI.createURI(metaModelPath));

		dpfMetaModel.addDpfMetaModel(metaModel);

		execCtx.registerMetaModel(dpfMetaModel);

		model = DPFCoreUtil.loadSpecification(
				URI.createURI(modelPath));
		dpfMetaModel.setDpfModel(model);

		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate(evalEntry, model);
		//"template::test::main"
	}
}
