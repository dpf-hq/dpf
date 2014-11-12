package no.hib.dpf.text.validation;

import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.ChoosenSpecification;
import no.hib.dpf.text.tdpf.ConstraintSignature;
import no.hib.dpf.text.tdpf.Element;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.SequenceNumber;
import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.util.Tuple;
import no.hib.dpf.text.wrapper.JavaScalaBridge;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.validation.Check;

/**
 *  Validate the specifications for the editor
 */
public class DPFTextJavaValidator extends AbstractDPFTextJavaValidator {

	private static final boolean debug = false;
	
	private static Map<String,Map<Long,String>> validationErrors = new HashMap<String,Map<Long,String>>();	
	
	public static final void setValidationErrMsg(final Map<Long,String> errs, final IFile owner){

		DPFTextJavaValidator.validationErrors.put(owner.getFullPath().toString(), errs);
		
	}

	private void setValidationErrMsg(Element e){
		try {
			final URI eUri = e.eResource().getURI();
			final String platformString = eUri.toPlatformString(true);
			final String key = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString).getFullPath().toString();
			if(null != key){
				final Map<Long,String> err = DPFTextJavaValidator.validationErrors.get(key);
				if(null != err){
					final String msg =	err.get(Long.valueOf(e.getId().getId()));
					if(debug)System.out.println("ErrorMsg=" + msg);
					if(null != msg && !msg.equals("")){
						//System.out.println("Set error " + msg);
						error(msg,e,null,null);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Vars:
	private JavaScalaBridge bridge = null;
	private ChoosenSpecification type = null;
	private Arrows arrows = null;
	private boolean isSpecification = false;
	private boolean isConstraints = false;
	
	@Check
	public synchronized void whichType(ChoosenSpecification s) {
		//System.out.println("whichType");
		type = s;
		isSpecification=true;
	}

	@Check
	public void createBridge(SequenceNumber s) {
		System.out.println("Create JavaScalaBridge");
		if(null == type) throw new RuntimeException("Type for Validation not set!");
		bridge = new JavaScalaBridge(s.getNextNumber(),type.getId());
	}
	
	@Check
	public void exitSpecification(Specification s) {
		isSpecification=false;
		isConstraints=false;
	}
	
	@Check
	public void isConstraints(ConstraintSignature s) {
		System.out.println("Constraint-Signature");
		isConstraints=true;
	}

	
	@Check
	public void checkNode(Node node) {
		if(isSpecification && !isConstraints)
		try {
			Tuple<Node,String> t = bridge.addNode(node);
			if(!t.y.equals("")){
				error(t.y, null);
			}
			setValidationErrMsg(node);
		} catch (Exception e) {
			if(debug)e.printStackTrace();
		}
	}
	
	@Check
	public void checkArrow(Arrow arrow) {
		if(isSpecification && !isConstraints)
		try {
			checkDelatedArrow(arrows);
			Tuple<Arrow,String> t = bridge.addArrow(arrow);
			if(!t.y.equals("")){
				error(t.y, null);
			}
			setValidationErrMsg(arrow);
		} catch (Exception e) {
			if(debug)e.printStackTrace();
		}
		else if(isSpecification && isConstraints)
		try {
			checkDelatedArrowOfConstraint(arrows);
			Tuple<Arrow,String> t = bridge.checkArrowForConstraint(arrow);
			if(!t.y.equals("")){
				error(t.y, null);
			}
		} catch (Exception e) {
			if(debug)e.printStackTrace();
		}
	}
	
	@Check
	public void checkArrows(Arrows arrows) {
		if(isSpecification && !isConstraints){
			checkDelatedArrow(arrows);
			setValidationErrMsg(arrows);
		}
		else if(isSpecification && isConstraints){
			checkDelatedArrowOfConstraint(arrows);
		}
		if(!(arrows instanceof Arrow)){
			this.arrows = arrows;
		}
	}

	private void checkDelatedArrow(Arrows arrows) {
		try {
			if(null !=this.arrows){
				Tuple<Tuple<Arrows,Arrows>,String> t = bridge.addArrows(this.arrows,arrows);
				this.arrows = null;
				if(!t.y.equals("")){
					error(t.y,this.arrows,null,null);
				}
			}
		} catch (Exception e) {
			if(debug)e.printStackTrace();
		}
	}

	private void checkDelatedArrowOfConstraint(Arrows arrows) {
		try {
			if(null !=this.arrows){
				Tuple<Tuple<Arrows,Arrows>,String> t = bridge.checkArrowsForConstraint(this.arrows,arrows);
				this.arrows = null;
				if(!t.y.equals("")){
					error(t.y,this.arrows,null,null);
				}
			}
		} catch (Exception e) {
			if(debug)e.printStackTrace();
		}
	}
	
}
