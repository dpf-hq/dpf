package no.hib.dpf.visual.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import no.hib.dpf.core.Node;
import no.hib.dpf.visual.VCompositeElement;
import no.hib.dpf.visual.VisualPackage;

public class VCompositeElementImpl extends VElementImpl implements VCompositeElement {
	
	protected Node childrenType;
	
	protected Node parent;
	
	protected EList<Node> children;

	
	protected VCompositeElementImpl() {
		super();
	}

	@Override
	public EClass eClass() {
		return VisualPackage.Literals.VNODE;
	}
	
	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<Node> getChildren() {
		return children;
	}

	@Override
	public Node getParent() {
		return parent;
	}

	@Override
	public Node getChildrenType() {
		return childrenType;
	}

	@Override
	public void setParent(Node node) {
		parent = node;
	}

	@Override
	public void setChildrenType(Node node) {
		childrenType = node;
	}

	@Override
	public void addChild(Node child) {
		children.add(child);
	}

}
