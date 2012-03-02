/**
 * <copyright>
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, �yvind Bech and Dag Viggo Lok�en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;


import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.JarFile;

import no.hib.dpf.api.ui.*;
import no.hib.dpf.constant.DPFConstants;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticsValidator;
import no.hib.dpf.core.Visualization;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getShape <em>Shape</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getSemanticsValidator <em>Semantics Validator</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getVisualization <em>Visualization</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredicateImpl extends EObjectImpl implements Predicate {
	/**
	 * The cached value of the '{@link #getShape() <em>Shape</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShape()
	 * @generated
	 * @ordered
	 */
	protected Graph shape;

	/**
	 * The cached value of the '{@link #getSemanticsValidator() <em>Semantics Validator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticsValidator()
	 * @generated
	 * @ordered
	 */
	protected SemanticsValidator semanticsValidator;

	/**
	 * The default value of the '{@link #getParameters() <em>Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected String parameters = PARAMETERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVisualization() <em>Visualization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualization()
	 * @generated
	 * @ordered
	 */
	protected Visualization visualization;

	/**
	 * The default value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected String symbol = SYMBOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	private Checker checker;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getShape() {
		return shape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShape(Graph newShape, NotificationChain msgs) {
		Graph oldShape = shape;
		shape = newShape;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SHAPE, oldShape, newShape);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShape(Graph newShape) {
		if (newShape != shape) {
			NotificationChain msgs = null;
			if (shape != null)
				msgs = ((InternalEObject)shape).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__SHAPE, null, msgs);
			if (newShape != null)
				msgs = ((InternalEObject)newShape).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__SHAPE, null, msgs);
			msgs = basicSetShape(newShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SHAPE, newShape, newShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SemanticsValidator getSemanticsValidator() {
		if(semanticsValidator == null)
			semanticsValidator = CoreFactory.eINSTANCE.createSemanticsValidator();
		return semanticsValidator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSemanticsValidator(SemanticsValidator newSemanticsValidator, NotificationChain msgs) {
		SemanticsValidator oldSemanticsValidator = semanticsValidator;
		semanticsValidator = newSemanticsValidator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SEMANTICS_VALIDATOR, oldSemanticsValidator, newSemanticsValidator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticsValidator(SemanticsValidator newSemanticsValidator) {
		if (newSemanticsValidator != semanticsValidator) {
			NotificationChain msgs = null;
			if (semanticsValidator != null)
				msgs = ((InternalEObject)semanticsValidator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__SEMANTICS_VALIDATOR, null, msgs);
			if (newSemanticsValidator != null)
				msgs = ((InternalEObject)newSemanticsValidator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__SEMANTICS_VALIDATOR, null, msgs);
			msgs = basicSetSemanticsValidator(newSemanticsValidator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SEMANTICS_VALIDATOR, newSemanticsValidator, newSemanticsValidator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameters(String newParameters) {
		String oldParameters = parameters;
		parameters = newParameters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__PARAMETERS, oldParameters, parameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visualization getVisualization() {
		return visualization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisualization(Visualization newVisualization, NotificationChain msgs) {
		Visualization oldVisualization = visualization;
		visualization = newVisualization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__VISUALIZATION, oldVisualization, newVisualization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualization(Visualization newVisualization) {
		if (newVisualization != visualization) {
			NotificationChain msgs = null;
			if (visualization != null)
				msgs = ((InternalEObject)visualization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__VISUALIZATION, null, msgs);
			if (newVisualization != null)
				msgs = ((InternalEObject)newVisualization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__VISUALIZATION, null, msgs);
			msgs = basicSetVisualization(newVisualization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__VISUALIZATION, newVisualization, newVisualization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbol(String newSymbol) {
		String oldSymbol = symbol;
		symbol = newSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SYMBOL, oldSymbol, symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns a newly created constraint. If the nodes and/or arrows provided don't match the shape
	 * of this predicate, null is returned.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Constraint createConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained) {
		GraphHomomorphism graphHomomorphism = CoreFactory.eINSTANCE.createGraphHomomorphism();
		if (graphHomomorphism.tryToCreateGraphHomomorphism(getShape(), nodes, arrows)) {
			return constructConstraint(modelToBeConstrained, graphHomomorphism);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCreateConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained) {
		GraphHomomorphism graphHomomorphism = CoreFactory.eINSTANCE.createGraphHomomorphism();
		return graphHomomorphism.tryToCreateGraphHomomorphism(getShape(), nodes, arrows);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		if (getSemanticsValidator() != null) {
			return getSemanticsValidator().validateSemantics(oStar, constraintParameters, typeNodes, typeArrows);
		}
		return true;
	}

	private Map<String, String> getParameterMap(String parString){
		Map<String, String> result = new HashMap<String, String>();
		if(parString == null || parString.isEmpty())
			return null;
		String[] paras = parString.split(";");
		for (int i = 0; i < paras.length; i++) {
			String string = paras[i];
			String[] keyValue = string.split(":");
			if(keyValue.length != 2)
				return null;
			result.put(keyValue[0], keyValue[1]);
		}
		return result;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateSemantics(String parameters, GraphHomomorphism mapping, Graph graph) {
		if(graph.getNodes().size() == 0)
			return true;
		Map<Node, List<Node>> nodeMap = new LinkedHashMap<Node, List<Node>>();
		Map<Arrow, List<Arrow>> arrowMap = new LinkedHashMap<Arrow, List<Arrow>>();
		intialize(mapping, graph, nodeMap, arrowMap);
		Map<String, String> paraMap = getParameterMap(parameters);
		Checker checker = getChecker();
		if(checker != null)
			return checker.check(paraMap, getShape(), nodeMap, arrowMap);
		return true;
	}

	private URL getClassLocation (final Class<?> clazz)
	{
		Bundle bundle = FrameworkUtil.getBundle(clazz);
		URL url = bundle.getResource("");
		try {
			url = FileLocator.resolve(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

	private String getFileLocation(final URL url){
		if(url.getProtocol().equals("jar")){
			JarURLConnection conn;
			try {
				conn = (JarURLConnection)url.openConnection();
				JarFile jarfile = conn.getJarFile();
				return jarfile.getName();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(url.getProtocol().equals("file")){
			try {
				File file = new File(url.toURI());
				return file.getAbsolutePath();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

		}
		return url.getPath();
	}
	public static final String PATH_SEPARATOR = System.getProperty("path.separator");
	private Checker getChecker(){
		if(checker == null){
			String[] opts = new String[]{"-cp", getFileLocation(getClassLocation(Node.class)) + PATH_SEPARATOR + getFileLocation(getClassLocation(EObject.class))+ PATH_SEPARATOR + getFileLocation(getClassLocation(Notifier.class))};
			CharSequenceCompiler<Checker> compiler = new CharSequenceCompiler<Checker>(Thread.currentThread().getContextClassLoader(),  Arrays.asList(opts));
			try {
				Class<Checker> clazz = compiler.compile(DPFConstants.DefaultCheckerClass, getSemanticsValidator().getValidator(), null, Checker.class);
				checker = clazz.newInstance();
			} catch (ClassCastException e) {
				DPFErrorReport.logError(e);
			} catch (CharSequenceCompilerException e) {
				DPFErrorReport.logError(e);
			} catch (InstantiationException e) {
				DPFErrorReport.logError(e);
			} catch (IllegalAccessException e) {
				DPFErrorReport.logError(e);
			} 
		}
		return checker;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private EMap changeKeyAndValue(EMap map){
		//map must be bijective
		EMap result = new BasicEMap();
		Iterator iter = map.iterator();
		while(iter.hasNext()){
			Entry entry = (Entry) iter.next();
			result.put(entry.getValue(), entry.getKey());
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	private void intialize(GraphHomomorphism mapping, Graph graph,
			Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) {
		EMap<Node, Node> typeNodeToNode = changeKeyAndValue(mapping.getNodeMapping());
		EMap<Arrow, Arrow> tyepArrowToArrow = changeKeyAndValue(mapping.getArrowMapping());
		for(Node node : graph.getNodes()){
			Node type = node.getTypeNode();
			Node untypeNode = typeNodeToNode.get(type);
			if(untypeNode != null){
				List<Node> nodes = nodeMap.get(untypeNode);
				if(nodes == null)
					nodes = new ArrayList<Node>();
				nodes.add(node);
				nodeMap.put(untypeNode, nodes);
			}
		}
		for(Arrow arrow : graph.getArrows()){
			Arrow type = arrow.getTypeArrow();
			Arrow untypeArrow = tyepArrowToArrow.get(type);
			if(untypeArrow != null){
				List<Arrow> arrows = arrowMap.get(untypeArrow);
				if(arrows == null)
					arrows = new ArrayList<Arrow>();
				arrows.add(arrow);
				arrowMap.put(untypeArrow, arrows);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	private Constraint constructConstraint(Graph modelToBeConstrained, GraphHomomorphism graphHomomorphism) {
		Constraint retval = CoreFactory.eINSTANCE.createConstraint();
		retval.setMappings(graphHomomorphism);
		retval.setPredicate(this);
		retval.setParameters(getParameters());
		retval.setGraph(modelToBeConstrained);
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.PREDICATE__SHAPE:
				return basicSetShape(null, msgs);
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				return basicSetSemanticsValidator(null, msgs);
			case CorePackage.PREDICATE__VISUALIZATION:
				return basicSetVisualization(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.PREDICATE__SHAPE:
				return getShape();
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				return getSemanticsValidator();
			case CorePackage.PREDICATE__PARAMETERS:
				return getParameters();
			case CorePackage.PREDICATE__VISUALIZATION:
				return getVisualization();
			case CorePackage.PREDICATE__SYMBOL:
				return getSymbol();
			case CorePackage.PREDICATE__ICON:
				return getIcon();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.PREDICATE__SHAPE:
				setShape((Graph)newValue);
				return;
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				setSemanticsValidator((SemanticsValidator)newValue);
				return;
			case CorePackage.PREDICATE__PARAMETERS:
				setParameters((String)newValue);
				return;
			case CorePackage.PREDICATE__VISUALIZATION:
				setVisualization((Visualization)newValue);
				return;
			case CorePackage.PREDICATE__SYMBOL:
				setSymbol((String)newValue);
				return;
			case CorePackage.PREDICATE__ICON:
				setIcon((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.PREDICATE__SHAPE:
				setShape((Graph)null);
				return;
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				setSemanticsValidator((SemanticsValidator)null);
				return;
			case CorePackage.PREDICATE__PARAMETERS:
				setParameters(PARAMETERS_EDEFAULT);
				return;
			case CorePackage.PREDICATE__VISUALIZATION:
				setVisualization((Visualization)null);
				return;
			case CorePackage.PREDICATE__SYMBOL:
				setSymbol(SYMBOL_EDEFAULT);
				return;
			case CorePackage.PREDICATE__ICON:
				setIcon(ICON_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.PREDICATE__SHAPE:
				return shape != null;
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				return semanticsValidator != null;
			case CorePackage.PREDICATE__PARAMETERS:
				return PARAMETERS_EDEFAULT == null ? parameters != null : !PARAMETERS_EDEFAULT.equals(parameters);
			case CorePackage.PREDICATE__VISUALIZATION:
				return visualization != null;
			case CorePackage.PREDICATE__SYMBOL:
				return SYMBOL_EDEFAULT == null ? symbol != null : !SYMBOL_EDEFAULT.equals(symbol);
			case CorePackage.PREDICATE__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (parameters: ");
		result.append(parameters);
		result.append(", symbol: ");
		result.append(symbol);
		result.append(", icon: ");
		result.append(icon);
		result.append(')');
		return result.toString();
	}

} //PredicateImpl
