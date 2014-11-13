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

		//We ensure that we are not creating target and source properties for either the arrow base type, or the metatypes,
		//as this should happen on a specific type.
		if(!this.getName().equals(DpfMMConstants.NS_PREFIX + "::" + DpfMMConstants.ARROW) && metaType == null) {
			res.add(new PropertyImpl(this, "target", model.getType(arrow.getTarget())) {
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
		res.add(new OperationImpl(this, "getConstraints", new ListTypeImpl(
				model.getTypeForName(DpfMMConstants.CONSTRAINT), model.getTypeSystem(), "List")) {
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				return arrow.getConstraints();
			}
		});
		return res.toArray(new Feature[res.size()]);
	}
	
	@Override
	public Set<? extends Type> getSuperTypes() {
		HashSet<Type> res = new HashSet<Type>();
		if(!this.getName().equals(DpfMMConstants.NS_PREFIX + "::" + DpfMMConstants.ARROW)) {
			res.add(model.getTypeForName(DpfMMConstants.ARROW));
		}
		if(metaType != null) res.add(metaType);
		res.add(model.getTypeSystem().getObjectType());
		return res;
	}
	
	public Arrow getArrow() {
		return arrow;
	}
}
