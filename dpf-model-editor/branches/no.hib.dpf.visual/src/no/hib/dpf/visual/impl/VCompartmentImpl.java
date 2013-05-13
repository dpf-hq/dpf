package no.hib.dpf.visual.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import no.hib.dpf.diagram.DNode;
import no.hib.dpf.visual.VCompartment;
import no.hib.dpf.visual.VisualPackage;

public class VCompartmentImpl extends VElementImpl implements VCompartment {
	
	protected DNode childrenType;
	
	protected DNode parent;
	
	protected EList<DNode> children;

	
	protected VCompartmentImpl() {
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
	public EList<DNode> getChildren() {
		return children;
	}

	@Override
	public void addChild(DNode child) {
		children.add(child);
	}

}
