import java.util.HashMap;

import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;

public class Test {
	public static void main(String[] a) {
		WorkflowEngine r = new WorkflowEngine();
		r.run("workflow/workflow.mwe", new NullProgressMonitor(), new HashMap<String, String>(), new HashMap<String, String>());
	}
}
