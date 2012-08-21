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

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.FeatureImpl;
import no.hib.dpf.codegen.xpand.metamodel.typesystem.TypeHelper;
import no.hib.dpf.core.Predicate;

import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

public class PredicateType extends AbstractTypeImpl {
	DpfMetamodel model;
	Predicate predicate;
	
	public PredicateType(DpfMetamodel model, String name, Predicate predicate) {
		super(model.getTypeSystem(), name);
		this.model = model;
		this.predicate = predicate;
	}

	@Override
	public boolean isInstance(Object o) {
		return o instanceof Predicate;
	}

	@Override
	public Object newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feature[] getContributedFeatures() {
		final Set<FeatureImpl> res = new HashSet<FeatureImpl>();

		res.addAll(TypeHelper.getEClassFeatures(model, predicate.eClass(), this));
		
		return res.toArray(new Feature[res.size()]);
	}

	public Predicate getPredicate() {
		return predicate;
	}
}
