package workflow;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;

import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.hib.dpf.codegen.xpand.ui.wizards.WorkflowParser;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

public class WorkflowSetup {
	
	public void generate(Map<String, String> properties) {
		try {
			Bundle bb = Platform.getBundle("no.hib.dpf.codegen.examples.dpfplay");
			Enumeration<URL> ce = bb.findEntries("/", "workflow.mwe", true);
			
			URL typeFileURL = null;
			
			if(ce.hasMoreElements()) {
				typeFileURL = ce.nextElement();
			}
			
			WorkflowParser workflowSetup = new WorkflowParser(
					typeFileURL.toString());
			
			workflowSetup.setProperty("dpf_model", properties.get("xmiLocation"));
			
			//"Hack": When testing with different eclipse instances, we have different classloaders
			//This will probably be unecessary when installed in single instance? TODO: test
			URL mmURL = null;
			ce = bb.findEntries("models", "metamodel.xmi", false);
			if(ce.hasMoreElements()) {
				mmURL = ce.nextElement();
			}
			
			workflowSetup.setProperty("dpf_metamodel", mmURL.toString());
			
			workflowSetup.setProperty("src-gen", properties.get("outputPath"));
			
//			URL outputPath = null;
			
			File f = File.createTempFile("workflow", null);
			
			System.out.println(workflowSetup.getXml());
			workflowSetup.writeXml(f.getAbsolutePath());
			
			WorkflowEngine we = new WorkflowEngine();
			we.prepare(f.getAbsolutePath(), null, new HashMap<String, String>());
			Issues problems = new IssuesImpl();
			we.executeWorkflow(new HashMap<String, String>(), problems);
			logIssues(System.out, problems);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
	private void logIssues(final PrintStream ps, final Issues issues) {
		// log any configuration warning messages
		final Diagnostic[] issueArray = issues.getIssues();
		for (final Diagnostic issue : issueArray) {
			if (issue.getSeverity() == Diagnostic.ERROR) {
				ps.append(issue.toString() + "\n");
			}
			if (issue.getSeverity() == Diagnostic.WARNING) {
				ps.append(issue.toString() + "\n");
			}
			if (issue.getSeverity() == Diagnostic.INFO) {
				ps.append(issue.toString() + "\n");
			}
		}
	}

//	private Map<String, Variable> getGlobalVars(Map<String, String> map) {
//		HashMap<String, Variable> res = new HashMap<String, Variable>();
//		for(String k : map.keySet()) {
//			Variable v = new Variable(k, map.get(k));
//			res.put(k, v);
//		}
//		return res;
//	}
}
