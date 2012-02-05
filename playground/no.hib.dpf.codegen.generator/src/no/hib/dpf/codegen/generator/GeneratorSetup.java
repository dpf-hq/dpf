package no.hib.dpf.codegen.generator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;

import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import no.hib.dpf.codegen.xpand.ui.wizards.*;
//import org.eclipse.xtend.expression.Variable;

public class GeneratorSetup {
	
	public void generate(Map<String, String> properties) {
		try {
			Bundle bb = Platform.getBundle("no.hib.dpf.codegen.generator");
			Enumeration<URL> ce = bb.findEntries("/", "play_workflow.mwe", true);
			
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
			ce = bb.findEntries("metamodel", "m3.dpf.xmi", false);
			if(ce.hasMoreElements()) {
				mmURL = ce.nextElement();
			}
			
			workflowSetup.setProperty("dpf_metamodel", mmURL.toString());
			
			URL outputPath = null;
			
			File f = File.createTempFile("workflow", null);
			
			workflowSetup.writeXml(f.getAbsolutePath());
			
			WorkflowEngine we = new WorkflowEngine();
			we.run(f.getAbsolutePath(), null, new HashMap<String, String>(), new HashMap<String, String>());
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
	
//	private Map<String, Variable> getGlobalVars(Map<String, String> map) {
//		HashMap<String, Variable> res = new HashMap<String, Variable>();
//		for(String k : map.keySet()) {
//			Variable v = new Variable(k, map.get(k));
//			res.put(k, v);
//		}
//		return res;
//	}
}
