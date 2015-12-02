package no.hib.dpf.editor.commands;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.editor.DPFEditor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

public class GenerateServiceHandler extends AbstractHandler {

	class Service {
		public String name, required, provide;
		public List<String> exception = new ArrayList<String>();
		private int indent;

		public void setIndent(int indent) {
			this.indent = indent;
		}

		public String toString() {
			StringBuffer buffer = new StringBuffer();
			buffer.append(repeatTab(indent) + "{" + "\n");
			buffer.append(repeatTab(indent + 1) + "name : " + name + ",\n");
			buffer.append(repeatTab(indent + 1) + "required : " + required
					+ ",\n");
			buffer.append(repeatTab(indent + 1) + "provided : "
					+ (provide != null ? provide : "") + ",\n");
			buffer.append(repeatTab(indent + 1) + "exception : ");
			if (!exception.isEmpty())
				buffer.append("\n" + repeatTab(indent + 1));
			buffer.append("[");
			if (!exception.isEmpty()) {
				buffer.append("\n" + repeatTab(indent + 2) + exception.get(0));
				for (int index = 1; index < exception.size(); ++index) {
					buffer.append(",\n" + repeatTab(indent + 2)
							+ exception.get(index));

				}
			}
			if (!exception.isEmpty())
				buffer.append("\n" + repeatTab(indent + 1));
			buffer.append("]\n");
			buffer.append(repeatTab(indent) + "}");
			return buffer.toString();
		}
	}

	public static String repeatTab(int size) {
		return repeat(' ', size * 2);
	}

	public static String repeat(char a, int size) {
		char[] result = new char[size];
		Arrays.fill(result, a);
		return new String(result);
	}


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor instanceof DPFEditor) {

			Map<String, List<Service>> ServiceRegistry = new HashMap<String, List<Service>>();
			Specification model = ((DPFEditor) editor).getDSpecification()
					.getSpecification();
			// Find type service
			Graph instances = model.getGraph();

			Graph types = model.getType().getGraph();
			Node serviceType = types.getNodeByName("Service");
			Arrow request = types.getArrowByName("request"), provide = types
					.getArrowByName("return"), service_exception = types
					.getArrowByName("exception");
			for (Node node : instances.getNodes()) {
				if (node.getTypeNode() == serviceType) {
					
					//Get component
					String component = null;
					for (Constraint c : node.getConstraints()) {
						String predicate = c.getPredicate().getSymbol();
						if (predicate.startsWith("@")) {
							component = predicate.substring(1);
							break;
						}
					}
					
					//Get service name
					Service service = new Service();
					service.name = node.getName();
					
					//Get the required information of the service
					for (Arrow arrow : node.getIncomings()) {
						if (arrow.getTypeArrow() == request) {
							service.required = arrow.getName(); // only one
																// request
																// is allowed
						}
					}
					
					//Get the provision and the exception of the service
					for (Arrow arrow : node.getOutgoings()) {
						if (arrow.getTypeArrow() == provide) {
							service.provide = arrow.getName(); // only one
																// return is
																// allowed
						} else if (arrow.getTypeArrow() == service_exception) {
							service.exception.add(arrow.getName());
						}
					}
					List<Service> services = ServiceRegistry.get(component);
					if (services == null) {
						services = new ArrayList<Service>();
					}
					if(!services.contains(service))
						services.add(service);
					ServiceRegistry.put(component, services);
				}
			}
			StringBuffer buffer = new StringBuffer();
			for (Entry<String, List<Service>> iter : ServiceRegistry.entrySet()) {
				buffer.append(iter.getKey() + "\n{\n" + repeatTab(1)
						+ "Service : \n" + repeatTab(1) + "[\n");
				Service s = iter.getValue().get(0);
				s.setIndent(2);
				buffer.append(s);
				for (int index = 1; index < iter.getValue().size(); ++index) {
					s = iter.getValue().get(index);
					buffer.append(",\n");
					s.setIndent(2);
					buffer.append(s);
				}
				buffer.append("\n" + repeatTab(1) + "]\n}\n");
			}
			
			IFile file = ((IFileEditorInput)editor.getEditorInput()).getFile();
			String fileName = file.getLocation().toOSString() + ".service";
			
			try {
				FileWriter writer = new FileWriter(fileName);
				writer.write(buffer.toString());
				writer.close();
				file.getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
