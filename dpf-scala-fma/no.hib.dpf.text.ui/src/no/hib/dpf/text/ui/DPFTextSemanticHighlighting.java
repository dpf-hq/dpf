package no.hib.dpf.text.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class DPFTextSemanticHighlighting implements
		ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		
		if (resource == null || resource.getParseResult() == null)
			return;
		
		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			final EObject eo = NodeModelUtils.findActualSemanticObjectFor(node);
			try {
				if (eo.getClass().getName().contains("Choosen")) {
					acceptor.addPosition(node.getOffset(), node.getLength(),DPFTextHighlighting.ARROW);
				}				
			} catch (Exception e) {
				//do nothing
			}
		}
	}
}
