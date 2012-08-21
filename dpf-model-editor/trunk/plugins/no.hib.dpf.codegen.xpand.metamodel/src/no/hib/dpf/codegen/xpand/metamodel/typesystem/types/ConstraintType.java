/**
 * <copyright>
 * Copyright (c) 2012 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * @author Anders Sandven <anders.sandven@gmail.com>
 * </copyright>
 *
 * $Id$
 */

package no.hib.dpf.codegen.xpand.metamodel.typesystem.types;

import java.util.HashSet;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMMConstants;
import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.PropertyImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.TypeHelper;
import no.hib.dpf.core.Constraint;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class ConstraintType extends AbstractTypeImpl {
	private DpfMetamodel model;
	private Constraint constraint = null;
	
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
		
		//For debug
		res.add(new PropertyImpl(ConstraintType.this, "id", model.getTypeSystem().getStringType()) {

			@Override
			public Object get(Object target) {
				return ((Constraint)target).getId(); 
			}
			
		});
		
//		res.add(new PropertyImpl(ConstraintType.this, "getConstrainedNodes", 
//				new ListTypeImpl(model.getTypeForName("WUBWUB"), model.getTypeSystem(), "List")) {
//
//			@Override
//			public Object get(Object target) {
//				return ((Constraint)target).getNodes(); 
//			}
//			
//		});
//		
//		res.add(new PropertyImpl(ConstraintType.this, "getConstrainedArrows", model.getTypeSystem().getStringType()) {
//
//			@Override
//			public Object get(Object target) {
//				return ((Constraint)target).getArrows(); 
//			}
//			
//		});
//		
//		res.add(new PropertyImpl(ConstraintType.this, "getPredicate", model.getTypeSystem().getStringType()) {
//
//			@Override
//			public Object get(Object target) {
//				return ((Constraint)target).getPredicate(); 
//			}
//			
//		});
//		
//		res.add(new PropertyImpl(ConstraintType.this, "getParameters", model.getTypeSystem().getStringType()) {
//
//			@Override
//			public Object get(Object target) {
//				return ((Constraint)target).getParameters(); 
//			}
//			
//		});
		
		return res.toArray(new Feature[res.size()]);
	}
	
	@Override
	public Set<? extends Type> getSuperTypes() {
		HashSet<Type> res = new HashSet<Type>();
		if(!this.getName().equals(DpfMMConstants.NS_PREFIX + "::" + DpfMMConstants.CONSTRAINT)) {
			res.add(model.getTypeForName(DpfMMConstants.CONSTRAINT));
//			log.debug("Constraint " + this.getName() + " added as subtype of Constraint");
		}
		res.add(model.getTypeSystem().getObjectType());
		return res;
	}
	
	public Constraint getConstraint() {
		return constraint;
	}
}
