package no.hib.dpf.text.validation;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.Element;
import no.hib.dpf.text.tdpf.TGraph;
import no.hib.dpf.text.tdpf.TdpfFactory;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;

 

public class DPFTextJavaValidator extends AbstractDPFTextJavaValidator {

	private Arrows lastArrows = null;
	
//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
//		}
//	}

	//TODO: Add code here:
	
	@Check
	public void checkGreetingStartsWithCapital(TGraph graph) {
		for(Element e:graph.getElements()){
			System.out.println(e);
		}
	}

	@Check
	public void checkGreetingStartsWithCapital(Arrows arrows) {
		this.lastArrows = arrows;
	}

	@Check
	public void checkGreetingStartsWithCapital(Arrow arrow) {
		if(null != this.lastArrows){
			Arrow a = TdpfFactory.eINSTANCE.createArrow();
			a.setSr(this.lastArrows.getSr());
			a.setId(this.lastArrows.getId());
			a.setTgNode(EcoreUtil2.clone(arrow.getSr()));
			System.out.println("Consume" + a);
			this.lastArrows=null;
		}
		System.out.println("3:>" + arrow);
	}
	
}
