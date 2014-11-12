package generator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;

public class test {
	private static void workflowEngineExecution() {
		WorkflowEngine we = new WorkflowEngine();
		we.run("src/workflow/workflow.mwe", new NullProgressMonitor(), 
				new HashMap<String, String>(), new HashMap<String, Object>());
	}
}
