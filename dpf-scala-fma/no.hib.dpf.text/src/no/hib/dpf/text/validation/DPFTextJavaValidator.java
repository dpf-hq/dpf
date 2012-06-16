package no.hib.dpf.text.validation;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.DpfId;
import no.hib.dpf.text.tdpf.Element;
import no.hib.dpf.text.tdpf.TGraph;
import no.hib.dpf.text.tdpf.TdpfFactory;
import no.hib.dpf.text.wrapper.JavaScalaBridge;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;

 

public class DPFTextJavaValidator extends AbstractDPFTextJavaValidator {

	JavaScalaBridge bridge = new JavaScalaBridge();
	
//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
//		}
//	}

	//TODO: Add code here:
	
	@Check
	public void checkGreetingStartsWithCapital(TGraph graph) {
//		for(Element e:graph.getElements()){
//			System.out.println(e);
//		}
		System.out.println("Test Start");
//		bridge.read(graph);
		System.out.println("Test End");
	}

	@Check
	public void checkGreetingStartsWithCapital(Arrows arrows) {
	}

	@Check
	public void checkGreetingStartsWithCapital(Arrow arrow) {
	}
	

}
