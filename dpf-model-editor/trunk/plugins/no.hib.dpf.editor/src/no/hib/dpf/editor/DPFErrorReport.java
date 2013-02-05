package no.hib.dpf.editor;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Node;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;

public class DPFErrorReport {

	public static void logInfo(String message) {
		log(IStatus.INFO, IStatus.OK, message, null);
	}
	public static void logError(Throwable exception) {
		logError("Unexpected Exception", exception);
	}
	public static void logError(String message, Throwable exception) {
		log(IStatus.ERROR, IStatus.OK, message, exception);
	}

	public static void log(int severity, int code, String message,
			Throwable exception) {
		log(createStatus(severity, code, message, exception));
	}
	public static IStatus createStatus(int severity, int code,
			String message, Throwable exception) {
		return new Status(severity, DPFPlugin.PLUGIN_ID, code,
				message, exception);
	}
	public static void log(IStatus status) {
		DPFPlugin.getDefault().getLog().log(status);
	}
	public static String printConstraint(Constraint constraint) {
		String result = "";
		EList<Node> nodes = constraint.getNodes();
		for (int i = 0; i < nodes.size(); i++) {
			result += nodes.get(i).getName();
			if(i != nodes.size() - 1)
				result += ",";
		}
		result += ";";
		EList<Arrow> edges = constraint.getArrows();
		for (int i = 0; i < edges.size(); i++) {
			Arrow edge = edges.get(i);
			result += edge.getName() + "|" + edge.getSource().getName() + "->" + edge.getTarget().getName();
			if(i != edges.size() - 1)
				result += ",";
		}
		return result;
	}
}
