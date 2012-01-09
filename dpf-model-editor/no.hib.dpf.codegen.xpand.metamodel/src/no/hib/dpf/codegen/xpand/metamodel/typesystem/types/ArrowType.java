package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.util.HashSet;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.TypeHelper;
import no.hib.dpf.core.Arrow;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

public class ArrowType extends AbstractTypeImpl{
	DpfMetamodel model;
	Arrow arrow;
	
	public ArrowType(DpfMetamodel model, String name, Arrow arrow) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.arrow = arrow;
	}

	@Override
	public boolean isInstance(Object o) {
		return o instanceof Arrow;
	}

	@Override
	public Object newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feature[] getContributedFeatures() {
		final Set<FeatureImpl> res = new HashSet<FeatureImpl>();

		res.addAll(TypeHelper.getEClassFeatures(model, arrow.eClass(), this));
		
		return res.toArray(new Feature[res.size()]);
	}
}
