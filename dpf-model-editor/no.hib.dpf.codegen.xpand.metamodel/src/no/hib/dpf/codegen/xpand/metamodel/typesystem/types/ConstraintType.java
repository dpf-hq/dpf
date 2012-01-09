package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.util.HashSet;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.TypeHelper;
import no.hib.dpf.core.Constraint;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

public class ConstraintType extends AbstractTypeImpl {
	DpfMetamodel model;
	Constraint constraint;
	public ConstraintType(DpfMetamodel model, String name, Constraint constraint) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.constraint = constraint;
	}
	@Override
	public boolean isInstance(Object o) {
		return o instanceof Constraint;
	}
	@Override
	public Object newInstance() {
		return null;
	}
	@Override
	public Feature[] getContributedFeatures() {
		final Set<FeatureImpl> res = new HashSet<FeatureImpl>();
		
		res.addAll(TypeHelper.getEClassFeatures(model, constraint.eClass(), this));
		
		return res.toArray(new Feature[res.size()]);
	}
}
