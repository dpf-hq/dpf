package no.hib.mums.shared;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;

import static no.hib.mums.shared.MumsConstants.*;
/**
 * DSML-specific helper class
 * 
 * @author anders
 *
 */

public class DPFHelper {
	
	public List<Arrow> getAttributesFromNode(Node n) {
		List<Arrow> ret = new ArrayList<Arrow>();
		for(Arrow a : n.getOutgoings()) {
			if(a.getTypeName().equals(ATTRIBUTE)) 
				ret.add(a);
		}
		return ret;
	}

	//M3 types
	public boolean isNode(Node n) {
		if(n.getName().equals(n.getName())) {
			return true;
		} return false;
	}
	
	public boolean isArrow(Arrow a) {
		if(a.getName().equals(a.getName())) {
			return true;
		} return false;	
	}
	
	//M1/M0 types -> business object is M0
	public boolean isHull(Node n) {
//		System.out.println("ishull" + n.getTypeNode());
		//FIXME: When an editor has saved its resources and is closed/put away, the resource containing m1 is not resolved.
		boolean ret = n.getTypeName().equals(HULL) || n.getName().equals(HULL);
		return ret;
	}
	
	public boolean isProp(Node n) {
		boolean ret = n.getTypeName().equals(PROPULSOR) || n.getName().equals(PROPULSOR);
		return ret;
	}
	
	public boolean isController(Node n) {
		return n.getTypeName().equals(CONTROLLER);
	}
	
	public boolean isThrusterControl(Node n) {
		return n.getTypeName().equals(THRUSTER_CONTROL);
	}
	
	public boolean isActuator(Node n) {
		return n.getTypeName().equals(ACTUATOR);
	}
	
	//M0 types
	public boolean isAttributeInstance(Arrow a) {
		return a.getName().startsWith(ATTRIBUTE) 
				&& Character.isDigit(a.getName().charAt(a.getName().length()-1));
	}
	
	public boolean descendantOf(Node n, String dpfConstant) {
		Node tmp = n.getTypeNode();
		while(tmp != null && !tmp.eIsProxy()) {
			if(tmp.getTypeName().equals(dpfConstant)) {
				return true;
			}
			tmp = tmp.getTypeNode();
		}
		
		return false;
	}
	
	public boolean descendantOf(Arrow a, String dpfConstant) {
		Arrow tmp = a.getTypeArrow();
		while(tmp != null && !tmp.eIsProxy()) {
			if(tmp.getTypeName().equals(dpfConstant)) {
				return true;
			}
			tmp = tmp.getTypeArrow();
		}
		
		return false;
	}
}
