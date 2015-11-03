/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import java.util.Collection;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.diagram.util.DPFConstants;

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
 * An implementation of the model object '<em><b>DSpecification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#getDGraph <em>DGraph</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#isGrid <em>Grid</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#isSnap <em>Snap</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#getZoom <em>Zoom</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#isGridVisible <em>Grid Visible</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#getDSignature <em>DSignature</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#getMetaFile <em>Meta File</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DSpecificationImpl#getSignatureFile <em>Signature File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DSpecificationImpl extends EObjectImpl implements DSpecification {

	/**
	 * The cached value of the '{@link #getDType() <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDType()
	 * @generated
	 * @ordered
	 */
	protected DSpecification dType;

	/**
	 * The cached value of the '{@link #getDGraph() <em>DGraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDGraph()
	 * @generated
	 * @ordered
	 */
	protected DGraph dGraph;

	/**
	 * The cached value of the '{@link #getDConstraints() <em>DConstraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<DConstraint> dConstraints;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected Specification specification;

	/**
	 * The default value of the '{@link #isGrid() <em>Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GRID_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGrid() <em>Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrid()
	 * @generated
	 * @ordered
	 */
	protected boolean grid = GRID_EDEFAULT;

	/**
	 * The default value of the '{@link #isSnap() <em>Snap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSnap()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SNAP_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSnap() <em>Snap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSnap()
	 * @generated
	 * @ordered
	 */
	protected boolean snap = SNAP_EDEFAULT;

	/**
	 * The default value of the '{@link #getZoom() <em>Zoom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoom()
	 * @generated
	 * @ordered
	 */
	protected static final double ZOOM_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getZoom() <em>Zoom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoom()
	 * @generated
	 * @ordered
	 */
	protected double zoom = ZOOM_EDEFAULT;

	/**
	 * The default value of the '{@link #isGridVisible() <em>Grid Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGridVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GRID_VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGridVisible() <em>Grid Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGridVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean gridVisible = GRID_VISIBLE_EDEFAULT;

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
	 * The default value of the '{@link #getMetaFile() <em>Meta File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaFile()
	 * @generated
	 * @ordered
	 */
	protected static final String META_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaFile() <em>Meta File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaFile()
	 * @generated
	 * @ordered
	 */
	protected String metaFile = META_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignatureFile() <em>Signature File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatureFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSignatureFile() <em>Signature File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatureFile()
	 * @generated
	 * @ordered
	 */
	protected String signatureFile = SIGNATURE_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSpecificationImpl() {
		super();
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
	public DSpecification basicGetDType() {
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification basicGetSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDGraph(DGraph newDGraph, NotificationChain msgs) {
		DGraph oldDGraph = dGraph;
		dGraph = newDGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__DGRAPH, oldDGraph, newDGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DConstraint createDConstraint(Constraint constraint) {
		DConstraint dConstraint = DiagramFactory.eINSTANCE.createDConstraint();
		dConstraint.setConstraint(constraint);
		this.getDConstraints().add(dConstraint);
		return dConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification getTemplateDSpecification() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DGraph createDGraph(Graph graph, DGraph dType) {
		DGraph dGraph = DiagramFactory.eINSTANCE.createDGraph();
		dGraph.setGraph(graph);
		if(dType != null)
			dGraph.setDType(dType);
		setDGraph(dGraph);
		return dGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.DSPECIFICATION__DTYPE:
				if (resolve) return getDType();
				return basicGetDType();
			case DiagramPackage.DSPECIFICATION__DGRAPH:
				return getDGraph();
			case DiagramPackage.DSPECIFICATION__DCONSTRAINTS:
				return getDConstraints();
			case DiagramPackage.DSPECIFICATION__SPECIFICATION:
				if (resolve) return getSpecification();
				return basicGetSpecification();
			case DiagramPackage.DSPECIFICATION__GRID:
				return isGrid();
			case DiagramPackage.DSPECIFICATION__SNAP:
				return isSnap();
			case DiagramPackage.DSPECIFICATION__ZOOM:
				return getZoom();
			case DiagramPackage.DSPECIFICATION__GRID_VISIBLE:
				return isGridVisible();
			case DiagramPackage.DSPECIFICATION__DSIGNATURE:
				if (resolve) return getDSignature();
				return basicGetDSignature();
			case DiagramPackage.DSPECIFICATION__META_FILE:
				return getMetaFile();
			case DiagramPackage.DSPECIFICATION__SIGNATURE_FILE:
				return getSignatureFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DSPECIFICATION__DGRAPH:
				return basicSetDGraph(null, msgs);
			case DiagramPackage.DSPECIFICATION__DCONSTRAINTS:
				return ((InternalEList<?>)getDConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagramPackage.DSPECIFICATION__DTYPE:
				return dType != null && dType != DPFConstants.REFLEXIVE_DSPECIFICATION;
			case DiagramPackage.DSPECIFICATION__DGRAPH:
				return dGraph != null;
			case DiagramPackage.DSPECIFICATION__DCONSTRAINTS:
				return dConstraints != null && !dConstraints.isEmpty();
			case DiagramPackage.DSPECIFICATION__SPECIFICATION:
				return specification != null;
			case DiagramPackage.DSPECIFICATION__GRID:
				return grid != GRID_EDEFAULT;
			case DiagramPackage.DSPECIFICATION__SNAP:
				return snap != SNAP_EDEFAULT;
			case DiagramPackage.DSPECIFICATION__ZOOM:
				return zoom != ZOOM_EDEFAULT;
			case DiagramPackage.DSPECIFICATION__GRID_VISIBLE:
				return gridVisible != GRID_VISIBLE_EDEFAULT;
			case DiagramPackage.DSPECIFICATION__DSIGNATURE:
				return dSignature != null && dSignature != DPFConstants.DEFAULT_DSIGNATURE;
			case DiagramPackage.DSPECIFICATION__META_FILE:
				return META_FILE_EDEFAULT == null ? metaFile != null : !META_FILE_EDEFAULT.equals(metaFile);
			case DiagramPackage.DSPECIFICATION__SIGNATURE_FILE:
				return SIGNATURE_FILE_EDEFAULT == null ? signatureFile != null : !SIGNATURE_FILE_EDEFAULT.equals(signatureFile);
		}
		return super.eIsSet(featureID);
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
			case DiagramPackage.DSPECIFICATION__DTYPE:
				setDType((DSpecification)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__DGRAPH:
				setDGraph((DGraph)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__DCONSTRAINTS:
				getDConstraints().clear();
				getDConstraints().addAll((Collection<? extends DConstraint>)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__SPECIFICATION:
				setSpecification((Specification)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__GRID:
				setGrid((Boolean)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__SNAP:
				setSnap((Boolean)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__ZOOM:
				setZoom((Double)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__GRID_VISIBLE:
				setGridVisible((Boolean)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__DSIGNATURE:
				setDSignature((DSignature)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__META_FILE:
				setMetaFile((String)newValue);
				return;
			case DiagramPackage.DSPECIFICATION__SIGNATURE_FILE:
				setSignatureFile((String)newValue);
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
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DSPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramPackage.DSPECIFICATION__DTYPE:
				setDType(DPFConstants.REFLEXIVE_DSPECIFICATION);
				return;
			case DiagramPackage.DSPECIFICATION__DGRAPH:
				setDGraph((DGraph)null);
				return;
			case DiagramPackage.DSPECIFICATION__DCONSTRAINTS:
				getDConstraints().clear();
				return;
			case DiagramPackage.DSPECIFICATION__SPECIFICATION:
				setSpecification((Specification)null);
				return;
			case DiagramPackage.DSPECIFICATION__GRID:
				setGrid(GRID_EDEFAULT);
				return;
			case DiagramPackage.DSPECIFICATION__SNAP:
				setSnap(SNAP_EDEFAULT);
				return;
			case DiagramPackage.DSPECIFICATION__ZOOM:
				setZoom(ZOOM_EDEFAULT);
				return;
			case DiagramPackage.DSPECIFICATION__GRID_VISIBLE:
				setGridVisible(GRID_VISIBLE_EDEFAULT);
				return;
			case DiagramPackage.DSPECIFICATION__DSIGNATURE:
				setDSignature(DPFConstants.DEFAULT_DSIGNATURE);
				return;
			case DiagramPackage.DSPECIFICATION__META_FILE:
				setMetaFile(META_FILE_EDEFAULT);
				return;
			case DiagramPackage.DSPECIFICATION__SIGNATURE_FILE:
				setSignatureFile(SIGNATURE_FILE_EDEFAULT);
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
	public EList<DConstraint> getDConstraints() {
		if (dConstraints == null) {
			dConstraints = new EObjectContainmentEList<DConstraint>(DConstraint.class, this, DiagramPackage.DSPECIFICATION__DCONSTRAINTS);
		}
		return dConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DGraph getDGraph() {
		return dGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DSignature getDSignature() {
		if (dSignature != null && dSignature.eIsProxy()) {
			InternalEObject oldDSignature = (InternalEObject)dSignature;
			dSignature = (DSignature)eResolveProxy(oldDSignature);
			if (dSignature != oldDSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DSPECIFICATION__DSIGNATURE, oldDSignature, dSignature));
			}
		}
		return dSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DSpecification getDType() {
		if (dType != null && dType.eIsProxy()) {
			InternalEObject oldDType = (InternalEObject)dType;
			dType = (DSpecification)eResolveProxy(oldDType);
			if (dType != oldDType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DSPECIFICATION__DTYPE, oldDType, dType));
			}
		}
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMetaFile() {
		return metaFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSignatureFile() {
		return signatureFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Specification getSpecification() {
		if (specification != null && specification.eIsProxy()) {
			InternalEObject oldSpecification = (InternalEObject)specification;
			specification = (Specification)eResolveProxy(oldSpecification);
			if (specification != oldSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DSPECIFICATION__SPECIFICATION, oldSpecification, specification));
			}
		}
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getZoom() {
		return zoom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isGrid() {
		return grid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isGridVisible() {
		return gridVisible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSnap() {
		return snap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setDGraph(DGraph newDGraph) {
		if (newDGraph != dGraph) {
			NotificationChain msgs = null;
			if (dGraph != null)
				msgs = ((InternalEObject)dGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DSPECIFICATION__DGRAPH, null, msgs);
			if (newDGraph != null)
				msgs = ((InternalEObject)newDGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DSPECIFICATION__DGRAPH, null, msgs);
			msgs = basicSetDGraph(newDGraph, msgs);
			if(specification != null && !specification.eIsProxy())
				specification.setGraph(dGraph != null ? dGraph.getGraph() : null);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__DGRAPH, newDGraph, newDGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setDSignature(DSignature newDSignature) {
		if(newDSignature == dSignature) return;
		DSignature oldDSignature = dSignature;
		dSignature = newDSignature;
		if(getSpecification() != null)
			getSpecification().setSignature(newDSignature.getSignature());
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__DSIGNATURE, oldDSignature, dSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setDType(DSpecification newDType) {
		if(newDType == dType) return;
		DSpecification oldDType = dType;
		dType = newDType;
		
		DSpecification type = getDType();
		Specification spec = getSpecification();
		DGraph graph = getDGraph();
		if(spec != null && !spec.eIsProxy())
			spec.setType(type == null ? null : type.getSpecification());
		if(graph != null && !graph.eIsProxy())
			graph.setDType(type == null ? null : type.getDGraph());
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__DTYPE, oldDType, dType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
//	public void save(URI uri) throws IOException {
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("dpf", new XMLResourceFactoryImpl());
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMLResourceFactoryImpl());
//		Resource diagram = resourceSet.createResource(uri);
//		Resource model = resourceSet.createResource(uri.appendFileExtension("xmi"));
//		Resource model_type = resourceSet.createResource(uri.appendFileExtension("type").appendFileExtension("xmi"));
//		Resource diagram_type = resourceSet.createResource(uri.appendFileExtension("xmi").appendFileExtension("type").appendFileExtension("xmi"));
//		model.getContents().add(getSpecification());
//		if(getSpecification().getGraph().getType() == Graph.REFLEXIVE_TYPE_GRAPH)
//			model_type.getContents().add(getSpecification().getGraph().getType());
//		diagram.getContents().add(this);
//		if(getDType() == DSpecification.REFLEXIVE_DSPECIFICATION)
//			diagram_type.getContents().add(getDType());
//		model_type.save(null);
//		model.save(null);
//		diagram_type.save(null);
//		diagram.save(null);
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGrid(boolean newGrid) {
		boolean oldGrid = grid;
		grid = newGrid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__GRID, oldGrid, grid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGridVisible(boolean newGridVisible) {
		boolean oldGridVisible = gridVisible;
		gridVisible = newGridVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__GRID_VISIBLE, oldGridVisible, gridVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetaFile(String newMetaFile) {
		String oldMetaFile = metaFile;
		metaFile = newMetaFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__META_FILE, oldMetaFile, metaFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSignatureFile(String newSignatureFile) {
		String oldSignatureFile = signatureFile;
		signatureFile = newSignatureFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__SIGNATURE_FILE, oldSignatureFile, signatureFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSnap(boolean newSnap) {
		boolean oldSnap = snap;
		snap = newSnap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__SNAP, oldSnap, snap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecification(Specification newSpecification) {
		Specification oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__SPECIFICATION, oldSpecification, specification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZoom(double newZoom) {
		double oldZoom = zoom;
		zoom = newZoom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DSPECIFICATION__ZOOM, oldZoom, zoom));
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
		result.append(" (grid: ");
		result.append(grid);
		result.append(", snap: ");
		result.append(snap);
		result.append(", zoom: ");
		result.append(zoom);
		result.append(", gridVisible: ");
		result.append(gridVisible);
		result.append(", metaFile: ");
		result.append(metaFile);
		result.append(", signatureFile: ");
		result.append(signatureFile);
		result.append(')');
		return result.toString();
	}

} //DSpecificationImpl
