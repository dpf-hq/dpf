/*
* generated by Xtext
*/
package no.hib.dpf.text.ui.labeling;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Model;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.TGraph;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class DPFTextLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public DPFTextLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
		
	String text(Model m) {
		  return "Model";
	}

	String text(TGraph n) {
	  return "Graph<" + n.getTypeGraph().getId()+">";
	}
	
	
	String text(Node n) {
		  return "";
	}
	
	String text(Arrow arrow) {
		final String id = arrow.getId().getId() + "@" + arrow.getId().getName() + ":" 
						 + arrow.getType().getName() + "@" + arrow.getType().getId();
		final String sr = arrow.getSr().getId().getId() + "@" + arrow.getSr().getId().getName() + ":" 
					     + arrow.getSr().getType().getName() + "@" + arrow.getSr().getType().getId();
		String tg = "";
		
		//Target:
		if(null != arrow.getTgNode()){
			tg = arrow.getTgNode().getId().getId() + "@" + arrow.getTgNode().getId().getName() + ":"
			   + arrow.getTgNode().getType().getName() + "@" + arrow.getTgNode().getType().getId();
		}
		else if(null != arrow.getTgValue()){
			tg = arrow.getTgValue().getValue();
		}
		else if(null != arrow.getTgDataType()){
			tg = arrow.getTgDataType().getName() + ":Datatype";
		}		
		return sr + " --- " + id + " ---> " + tg;
	}

	String image(Node n) {
		  return "node.png";
	}

	String image(Arrow a) {
		  return "arrow.png";
	}	

	String image(TGraph g) {
		  return "graph.png";
	}

}
