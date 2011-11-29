package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.OperationImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.PropertyImpl;
import no.hib.dpf.core.Constraint;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

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

		//We want all the operations and attributes that is inside the DPF metamodel
		for(final EStructuralFeature ef : constraint.eClass().getEStructuralFeatures()) {
			Type t = model.getTypeForETypedElement(ef); 
			System.out.println("----------->ConstraintType#getContributedFeatures Type resolve name: " + ef.getName());
			if(t == null) {
				System.out.println("----------->ConstraintType#getContributedFeatures Type resolve failed for: " + ef.getName());
			} else {
				res.add(new PropertyImpl(this, ef.getName(), t) {
					//Creates getters and setters for a specified property. This means you can access ie. the graph 
					//object like so: spec.graph
					public Object get(final Object target) {
						return ((EObject) target).eGet(ef);
					}

					@Override
					public void set(final Object target, Object newValue) {
						if (ef.isChangeable() && !ef.isUnsettable() && !ef.isDerived()) {
							if (ef.getEType() instanceof EDataType && !(ef.getEType() instanceof EEnum)) {
								final EDataType dt = (EDataType) ef.getEType();
								newValue = getReturnType().convert(newValue, dt.getInstanceClass());
							}
							((EObject) target).eSet(ef, newValue);
						}
						else
							throw new UnsupportedOperationException("setting property '" + ef.getName()
									+ "' is not allowed!");
					}
				});
				// setter
				if (ef.isChangeable() && !ef.isMany()){ //  && !feature.isDerived()  { !feature.isUnsettable()
					// &&
					res.add(new OperationImpl(this, "set" + ef.getName(), this,
							new Type[] { t }) {

						@Override
						protected Object evaluateInternal(final Object target, final Object[] params) {
							Object newValue = params[0];
							if (newValue != null && ef.getEType() instanceof EDataType
									&& !(ef.getEType() instanceof EEnum)) {
								final EDataType dt = (EDataType) ef.getEType();
								newValue = getParameterTypes().get(0).convert(newValue, dt.getInstanceClass());
							}
							((EObject) target).eSet(ef, newValue);
							return target;
						}

					});
				}
				else if (ef.isMany()) {
					res.add(new OperationImpl(this, "set" + ef.getName(), this, new Type[] { t }) {
						@SuppressWarnings("unchecked")
						@Override
						protected Object evaluateInternal(Object target, Object[] params) {
							if (params != null) {
								Object newValue = params[0];

								if (newValue != null && ef.getEType() instanceof EDataType
										&& !(ef.getEType() instanceof EEnum)) {
									final EDataType dt = (EDataType) ef.getEType();
									newValue = getParameterTypes().get(0).convert(newValue, dt.getInstanceClass());
								}

								EList<Object> newColl = new BasicEList<Object>((List<?>)newValue);

								EObject targetObject = ((EObject) target);
								EClass targetClass = targetObject.eClass();
								EStructuralFeature eStructuralFeature = targetClass.getEStructuralFeature(ef.getName());

								EList<Object> coll = (EList<Object>) targetObject.eGet(eStructuralFeature);

								ECollections.setEList(coll, newColl);
								return target;
							}
							return null;
						}
					});
				}
				
			}
		}
		// Operations
		final EList<EOperation> eOperations = constraint.eClass().getEOperations();
		for (EOperation op : eOperations) {
			final EList<EParameter> emfParams = op.getEParameters();
			final Type[] paramTypes = new Type[emfParams.size()];
			boolean errors = false;
			for (int i = 0, x = emfParams.size(); i < x; i++) {
				final EParameter param = emfParams.get(i);
				paramTypes[i] = model.getTypeForETypedElement(param);
				if (paramTypes[i] == null) {
					System.out.println("Couldn't resolve type for " + param.getEType().getName()); //might fail if name is null
					errors = true;
				}
			}
			final Type t = model.getTypeForETypedElement(op);
			if (t == null) {
				System.out.println("Couldn't resolve type for " + op.getEType().getName());
				errors = true;
			}
			if (!errors) {

				res.add(new OperationImpl(this, op.getName(), t, paramTypes) {

					@Override
					protected Object evaluateInternal(final Object target, final Object[] params) {
						final Class<?>[] paramClasses = new Class<?>[emfParams.size()];
						for (int i = 0, x = emfParams.size(); i < x; i++) {
							final EParameter param = emfParams.get(i);
							if (param.isMany()) {
								paramClasses[i] = EList.class;
							}
							else {
								paramClasses[i] = param.getEType().getInstanceClass();
							}
							params[i] = getParameterTypes().get(i).convert(params[i], paramClasses[i]);
						}
						try {
							final Method m = target.getClass().getMethod(getName(), paramClasses);
							return m.invoke(target, params);
						}
						catch (final Exception e) {
							throw new RuntimeException(e);
						}
					}
				});
			}
		}
		return res.toArray(new Feature[res.size()]);
	}
}
