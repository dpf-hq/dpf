package no.hib.mums.partmaker;

import static no.hib.mums.shared.MumsConstants.ATTRIBUTE;
import static no.hib.mums.shared.MumsConstants.PART;
import static no.hib.mums.shared.MumsConstants.TYPE;

import java.util.HashMap;

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

public class PartHelper extends DPFHelper {
	
	private Specification modelInstance = null;
	
	protected static HashMap<String, Node> parts = new HashMap<String, Node>();
	
	private HashMap<String, Integer> counters = new HashMap<String, Integer>();
	
	static {
	}

	public PartHelper(Specification modelInstance) {
		this.modelInstance = modelInstance;
		initMaps();
	}
	
	private void initMaps() {
		for(Node n : modelInstance.getGraph().getNodes()) {
			if(n.getTypeName().equals(PART)) {
				parts.put(n.getId(), n);
			}
		}
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
	
	//M0 types
	public boolean isAttributeInstance(Arrow a) {
		return a.getName().startsWith(ATTRIBUTE) 
				&& Character.isDigit(a.getName().charAt(a.getName().length()-1));
	}
	
	public Specification getModel() {
		return modelInstance;
	}
	
	public Node getNodeByName(String name) {
		return modelInstance.getGraph().getType().getNodeByName(name);
	}
	
	public Node createPartNode(String partName) {
		Integer count = counters.get(partName);
		if(count == null) {
			counters.put(partName, 0);
			count = 0;
		}
		Node n = modelInstance.getGraph().createNode(partName + count, getNodeByName(partName));
		counters.put(partName, ++count);
		return n;
	}
	
	public Arrow createAttributeArrow(Node node, Arrow parentArrow) {
		Integer count = counters.get(ATTRIBUTE);
		if(count == null) {
			counters.put(ATTRIBUTE, 0);
			count = 0;
		}
		Arrow a = modelInstance.getGraph().createArrow(ATTRIBUTE+count, node, createTypeInstance(parentArrow), parentArrow);
		counters.put(ATTRIBUTE, ++count);
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
}
