/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import java.util.Collection;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getSourceMetaModel <em>Source Meta Model</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getTargetMetaModel <em>Target Meta Model</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getDSignature <em>DSignature</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#isGenerate <em>Generate</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getSourceLocation <em>Source Location</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getTargetLocation <em>Target Location</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getElementTypeGraph <em>Element Type Graph</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getCorrespondanceGraph <em>Correspondance Graph</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getCorrespondanceLocation <em>Correspondance Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformImpl extends EObjectImpl implements Transform {
	/**
	 * The cached value of the '{@link #getSourceMetaModel() <em>Source Meta Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMetaModel()
	 * @generated
	 * @ordered
	 */
	protected DSpecification sourceMetaModel;

	/**
	 * The cached value of the '{@link #getTargetMetaModel() <em>Target Meta Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMetaModel()
	 * @generated
	 * @ordered
	 */
	protected DSpecification targetMetaModel;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Production> rules;

	/**
	 * The cached value of the '{@link #getDSignature() <em>DSignature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDSignature()
	 * @generated
	 * @ordered
	 */
	protected DSignature dSignature;

	/**
	 * The default value of the '{@link #isGenerate() <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerate() <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerate()
	 * @generated
	 * @ordered
	 */
	protected boolean generate = GENERATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceLocation() <em>Source Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceLocation() <em>Source Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLocation()
	 * @generated
	 * @ordered
	 */
	protected String sourceLocation = SOURCE_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetLocation() <em>Target Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetLocation() <em>Target Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLocation()
	 * @generated
	 * @ordered
	 */
	protected String targetLocation = TARGET_LOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElementTypeGraph() <em>Element Type Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeGraph()
	 * @generated
	 * @ordered
	 */
	protected DSpecification elementTypeGraph;

	/**
	 * The cached value of the '{@link #getCorrespondanceGraph() <em>Correspondance Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrespondanceGraph()
	 * @generated
	 * @ordered
	 */
	protected DSpecification correspondanceGraph;

	/**
	 * The default value of the '{@link #getCorrespondanceLocation() <em>Correspondance Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrespondanceLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String CORRESPONDANCE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCorrespondanceLocation() <em>Correspondance Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrespondanceLocation()
	 * @generated
	 * @ordered
	 */
	protected String correspondanceLocation = CORRESPONDANCE_LOCATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformPackage.Literals.TRANSFORM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification getSourceMetaModel() {
		if (sourceMetaModel != null && sourceMetaModel.eIsProxy()) {
			InternalEObject oldSourceMetaModel = (InternalEObject)sourceMetaModel;
			sourceMetaModel = (DSpecification)eResolveProxy(oldSourceMetaModel);
			if (sourceMetaModel != oldSourceMetaModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformPackage.TRANSFORM__SOURCE_META_MODEL, oldSourceMetaModel, sourceMetaModel));
			}
		}
		return sourceMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification basicGetSourceMetaModel() {
		return sourceMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMetaModel(DSpecification newSourceMetaModel) {
		DSpecification oldSourceMetaModel = sourceMetaModel;
		sourceMetaModel = newSourceMetaModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__SOURCE_META_MODEL, oldSourceMetaModel, sourceMetaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification getTargetMetaModel() {
		if (targetMetaModel != null && targetMetaModel.eIsProxy()) {
			InternalEObject oldTargetMetaModel = (InternalEObject)targetMetaModel;
			targetMetaModel = (DSpecification)eResolveProxy(oldTargetMetaModel);
			if (targetMetaModel != oldTargetMetaModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformPackage.TRANSFORM__TARGET_META_MODEL, oldTargetMetaModel, targetMetaModel));
			}
		}
		return targetMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification basicGetTargetMetaModel() {
		return targetMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMetaModel(DSpecification newTargetMetaModel) {
		DSpecification oldTargetMetaModel = targetMetaModel;
		targetMetaModel = newTargetMetaModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__TARGET_META_MODEL, oldTargetMetaModel, targetMetaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Production> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Production>(Production.class, this, TransformPackage.TRANSFORM__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSignature getDSignature() {
		if (dSignature != null && dSignature.eIsProxy()) {
			InternalEObject oldDSignature = (InternalEObject)dSignature;
			dSignature = (DSignature)eResolveProxy(oldDSignature);
			if (dSignature != oldDSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformPackage.TRANSFORM__DSIGNATURE, oldDSignature, dSignature));
			}
		}
		return dSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSignature basicGetDSignature() {
		return dSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDSignature(DSignature newDSignature) {
		DSignature oldDSignature = dSignature;
		dSignature = newDSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__DSIGNATURE, oldDSignature, dSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerate() {
		return generate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerate(boolean newGenerate) {
		boolean oldGenerate = generate;
		generate = newGenerate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__GENERATE, oldGenerate, generate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceLocation() {
		return sourceLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceLocation(String newSourceLocation) {
		String oldSourceLocation = sourceLocation;
		sourceLocation = newSourceLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__SOURCE_LOCATION, oldSourceLocation, sourceLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetLocation() {
		return targetLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetLocation(String newTargetLocation) {
		String oldTargetLocation = targetLocation;
		targetLocation = newTargetLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__TARGET_LOCATION, oldTargetLocation, targetLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification getElementTypeGraph() {
		if (elementTypeGraph != null && elementTypeGraph.eIsProxy()) {
			InternalEObject oldElementTypeGraph = (InternalEObject)elementTypeGraph;
			elementTypeGraph = (DSpecification)eResolveProxy(oldElementTypeGraph);
			if (elementTypeGraph != oldElementTypeGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformPackage.TRANSFORM__ELEMENT_TYPE_GRAPH, oldElementTypeGraph, elementTypeGraph));
			}
		}
		return elementTypeGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification basicGetElementTypeGraph() {
		return elementTypeGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeGraph(DSpecification newElementTypeGraph) {
		DSpecification oldElementTypeGraph = elementTypeGraph;
		elementTypeGraph = newElementTypeGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__ELEMENT_TYPE_GRAPH, oldElementTypeGraph, elementTypeGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification getCorrespondanceGraph() {
		if (correspondanceGraph != null && correspondanceGraph.eIsProxy()) {
			InternalEObject oldCorrespondanceGraph = (InternalEObject)correspondanceGraph;
			correspondanceGraph = (DSpecification)eResolveProxy(oldCorrespondanceGraph);
			if (correspondanceGraph != oldCorrespondanceGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformPackage.TRANSFORM__CORRESPONDANCE_GRAPH, oldCorrespondanceGraph, correspondanceGraph));
			}
		}
		return correspondanceGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification basicGetCorrespondanceGraph() {
		return correspondanceGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrespondanceGraph(DSpecification newCorrespondanceGraph) {
		DSpecification oldCorrespondanceGraph = correspondanceGraph;
		correspondanceGraph = newCorrespondanceGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__CORRESPONDANCE_GRAPH, oldCorrespondanceGraph, correspondanceGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCorrespondanceLocation() {
		return correspondanceLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrespondanceLocation(String newCorrespondanceLocation) {
		String oldCorrespondanceLocation = correspondanceLocation;
		correspondanceLocation = newCorrespondanceLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__CORRESPONDANCE_LOCATION, oldCorrespondanceLocation, correspondanceLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformPackage.TRANSFORM__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
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
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				if (resolve) return getSourceMetaModel();
				return basicGetSourceMetaModel();
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				if (resolve) return getTargetMetaModel();
				return basicGetTargetMetaModel();
			case TransformPackage.TRANSFORM__RULES:
				return getRules();
			case TransformPackage.TRANSFORM__DSIGNATURE:
				if (resolve) return getDSignature();
				return basicGetDSignature();
			case TransformPackage.TRANSFORM__GENERATE:
				return isGenerate();
			case TransformPackage.TRANSFORM__SOURCE_LOCATION:
				return getSourceLocation();
			case TransformPackage.TRANSFORM__TARGET_LOCATION:
				return getTargetLocation();
			case TransformPackage.TRANSFORM__ELEMENT_TYPE_GRAPH:
				if (resolve) return getElementTypeGraph();
				return basicGetElementTypeGraph();
			case TransformPackage.TRANSFORM__CORRESPONDANCE_GRAPH:
				if (resolve) return getCorrespondanceGraph();
				return basicGetCorrespondanceGraph();
			case TransformPackage.TRANSFORM__CORRESPONDANCE_LOCATION:
				return getCorrespondanceLocation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				setSourceMetaModel((DSpecification)newValue);
				return;
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				setTargetMetaModel((DSpecification)newValue);
				return;
			case TransformPackage.TRANSFORM__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Production>)newValue);
				return;
			case TransformPackage.TRANSFORM__DSIGNATURE:
				setDSignature((DSignature)newValue);
				return;
			case TransformPackage.TRANSFORM__GENERATE:
				setGenerate((Boolean)newValue);
				return;
			case TransformPackage.TRANSFORM__SOURCE_LOCATION:
				setSourceLocation((String)newValue);
				return;
			case TransformPackage.TRANSFORM__TARGET_LOCATION:
				setTargetLocation((String)newValue);
				return;
			case TransformPackage.TRANSFORM__ELEMENT_TYPE_GRAPH:
				setElementTypeGraph((DSpecification)newValue);
				return;
			case TransformPackage.TRANSFORM__CORRESPONDANCE_GRAPH:
				setCorrespondanceGraph((DSpecification)newValue);
				return;
			case TransformPackage.TRANSFORM__CORRESPONDANCE_LOCATION:
				setCorrespondanceLocation((String)newValue);
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
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				setSourceMetaModel((DSpecification)null);
				return;
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				setTargetMetaModel((DSpecification)null);
				return;
			case TransformPackage.TRANSFORM__RULES:
				getRules().clear();
				return;
			case TransformPackage.TRANSFORM__DSIGNATURE:
				setDSignature((DSignature)null);
				return;
			case TransformPackage.TRANSFORM__GENERATE:
				setGenerate(GENERATE_EDEFAULT);
				return;
			case TransformPackage.TRANSFORM__SOURCE_LOCATION:
				setSourceLocation(SOURCE_LOCATION_EDEFAULT);
				return;
			case TransformPackage.TRANSFORM__TARGET_LOCATION:
				setTargetLocation(TARGET_LOCATION_EDEFAULT);
				return;
			case TransformPackage.TRANSFORM__ELEMENT_TYPE_GRAPH:
				setElementTypeGraph((DSpecification)null);
				return;
			case TransformPackage.TRANSFORM__CORRESPONDANCE_GRAPH:
				setCorrespondanceGraph((DSpecification)null);
				return;
			case TransformPackage.TRANSFORM__CORRESPONDANCE_LOCATION:
				setCorrespondanceLocation(CORRESPONDANCE_LOCATION_EDEFAULT);
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
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				return sourceMetaModel != null;
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				return targetMetaModel != null;
			case TransformPackage.TRANSFORM__RULES:
				return rules != null && !rules.isEmpty();
			case TransformPackage.TRANSFORM__DSIGNATURE:
				return dSignature != null;
			case TransformPackage.TRANSFORM__GENERATE:
				return generate != GENERATE_EDEFAULT;
			case TransformPackage.TRANSFORM__SOURCE_LOCATION:
				return SOURCE_LOCATION_EDEFAULT == null ? sourceLocation != null : !SOURCE_LOCATION_EDEFAULT.equals(sourceLocation);
			case TransformPackage.TRANSFORM__TARGET_LOCATION:
				return TARGET_LOCATION_EDEFAULT == null ? targetLocation != null : !TARGET_LOCATION_EDEFAULT.equals(targetLocation);
			case TransformPackage.TRANSFORM__ELEMENT_TYPE_GRAPH:
				return elementTypeGraph != null;
			case TransformPackage.TRANSFORM__CORRESPONDANCE_GRAPH:
				return correspondanceGraph != null;
			case TransformPackage.TRANSFORM__CORRESPONDANCE_LOCATION:
				return CORRESPONDANCE_LOCATION_EDEFAULT == null ? correspondanceLocation != null : !CORRESPONDANCE_LOCATION_EDEFAULT.equals(correspondanceLocation);
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
		result.append(" (generate: ");
		result.append(generate);
		result.append(", sourceLocation: ");
		result.append(sourceLocation);
		result.append(", targetLocation: ");
		result.append(targetLocation);
		result.append(", correspondanceLocation: ");
		result.append(correspondanceLocation);
		result.append(')');
		return result.toString();
	}

} //TransformImpl