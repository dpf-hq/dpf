package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.util.HashSet;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class DummyType extends AbstractTypeImpl{
	private DpfMetamodel model;
	
	public DummyType(DpfMetamodel model, String name) {
		super(model.getTypeSystem(), name);
		this.model = model;
	}

	@Override
	public boolean isInstance(Object o) {
		return o instanceof DummyType;
	}

	@Override
	public Object newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feature[] getContributedFeatures() {
		final Set<FeatureImpl> res = new HashSet<FeatureImpl>();
		return res.toArray(new Feature[res.size()]);
	}
	
	@Override
	public Set<? extends Type> getSuperTypes() {
		HashSet<Type> res = new HashSet<Type>();
		res.add(model.getTypeSystem().getObjectType());
		return res;
	}
}
