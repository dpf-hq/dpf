package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.util.HashSet;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.OperationImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.PropertyImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.TypeHelper;
import no.hib.dpf.core.Arrow;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class ArrowType extends AbstractTypeImpl{
	private DpfMetamodel model;
	private Arrow arrow;
	private Type metaType = null;
	
	public ArrowType(DpfMetamodel model, String name, Arrow arrow) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.arrow = arrow;
	}
	
	public ArrowType(DpfMetamodel model, String name, Arrow arrow, Type metaType) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.arrow = arrow;
		this.metaType = metaType;
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

		if(metaType == null) {
			res.add(new PropertyImpl(this, "target", model.getType(arrow.getTarget())) {
				//Creates getters and setters for a specified property. This means you can access ie. the graph 
				//object like so: spec.graph
				public Object get(final Object target) {
					return ((Arrow)target).getTarget();
				}
			});
			res.add(new PropertyImpl(this, "source", model.getType(arrow.getSource())) {
				public Object get(final Object target) {
					return ((Arrow)target).getSource();
				}
			});
		}
		if(arrow.getConstraints().size() != 0) {
			//The reason for using the first constraint is to give xpand the required features for the constraint type.
			res.add(new OperationImpl(this, "getConstraints", new ListTypeImpl(model.getTypeForName(arrow.getConstraints().get(0).getId()), model.getTypeSystem(), "List")) {
				
				@Override
				protected Object evaluateInternal(Object target, Object[] params) {
					return arrow.getConstraints();
				}
			});
		}
		return res.toArray(new Feature[res.size()]);
	}
	@Override
	public Set<? extends Type> getSuperTypes() {
		HashSet<Type> res = new HashSet<Type>();
		if(metaType != null) res.add(metaType);
		res.add(model.getTypeForName("dpf::Arrow"));
		res.add(model.getTypeSystem().getObjectType());
		return res;
	}
	
	public Arrow getDpfArrow() {
		return arrow;
	}
}
