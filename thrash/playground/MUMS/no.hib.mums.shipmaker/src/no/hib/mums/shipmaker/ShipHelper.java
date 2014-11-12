package no.hib.mums.shipmaker;

import static no.hib.mums.shared.MumsConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.mums.shared.DPFHelper;

/**
 * DSML-specific helper class
 * 
 * @author anders
 *
 */

public class ShipHelper extends DPFHelper {
	
	private Specification modelInstance = null;
	
	private HashMap<String, Node> parts = new HashMap<String, Node>();
	
	public ShipHelper(Specification model) {
		init(model);
	}
	
	public void init(Specification m) {
		modelInstance = m;
		for(Node n : getAllPartChildren()) {
			parts.put(n.getName(), n);
		}
	}
	
	//FIXME: Hardcoded
	public List<Node> getAllPartChildren() {
		ArrayList<Node> res = new ArrayList<Node>();
		//we need m2 level
		for(Node n : modelInstance.getGraph().getNodes()) {
			if(descendantOf(n,PART)) {
				res.add(n);
			}
		}
//		ModelUtil.printSpecification(modelInstance);
		return res;
	}
	
	public HashMap<String, Node> getPartMap() {
		for(Node n : getAllPartChildren()) {
			parts.put(n.getName(), n);
		}
		return parts;
	}
	
	//M2 types
	public boolean isPart(Node n) {
		return n.getTypeName().equals(PART) ? false : parts.get(n.getTypeNode().getId()) != null;
	}

	public boolean isAttribute(Arrow a) {
		return a.getTypeName().equals(ATTRIBUTE);
	}

	private boolean isType(Node n) {
		return n.getTypeName().equals(TYPE);
	}

	public Specification getModel() {
		return modelInstance;
	}
	
	public Node getNodeByName(String name) {
		return modelInstance.getGraph().getType().getNodeByName(name);
	}
	
	static int hcount = 0;
	public Node createPartNode(String partName) {
		Node n = modelInstance.getGraph().createNode(partName + hcount, getNodeByName(partName));
		++hcount;
		return n;
	}
	
	static int acount = 0;
	public Arrow createAttributeArrow(Node node, Arrow parentArrow) {
		Arrow a = modelInstance.getGraph().createArrow(ATTRIBUTE+acount, node, createTypeInstance(parentArrow), parentArrow);
		++acount;
		return a;
	}

	private Node createTypeInstance(Arrow a) {
		Node n = a.getTarget();
		if(isType(n)) {
			Node ret = modelInstance.getGraph().createNode(n.getName()+"Instance", n);
			return ret;
		}
		return null;
	}
	
	public boolean isPartInstance(Node n) {
		return parts.get(n.getName()) != null ? true : false;
	}
}
