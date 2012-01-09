package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.util.HashSet;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.core.Specification;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.TypeHelper;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

public class SpecificationType extends AbstractTypeImpl {
	DpfMetamodel model;
	Specification spec;
	public SpecificationType(DpfMetamodel model, String name, Specification spec) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.spec = spec;
	}

	@Override
	public boolean isInstance(Object o) {
		return o instanceof Specification;
	}

	@Override
	public Object newInstance() {
		return null;
	}

	@Override
	public Feature[] getContributedFeatures() {
		final Set<FeatureImpl> res = new HashSet<FeatureImpl>();
		
		res.addAll(TypeHelper.getEClassFeatures(model, spec.eClass(), this));
		
		return res.toArray(new Feature[res.size()]);
	}

}
