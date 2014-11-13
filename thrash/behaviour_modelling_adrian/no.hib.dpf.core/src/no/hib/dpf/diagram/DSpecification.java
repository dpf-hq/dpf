/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Specification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSpecification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#getDGraph <em>DGraph</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#getSpecification <em>Specification</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#isGrid <em>Grid</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#isSnap <em>Snap</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#getZoom <em>Zoom</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#isGridVisible <em>Grid Visible</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#getDSignature <em>DSignature</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#getMetaFile <em>Meta File</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSpecification#getSignatureFile <em>Signature File</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification()
 * @model
 * @generated
 */
public interface DSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DType</em>' reference.
	 * @see #setDType(DSpecification)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_DType()
	 * @model
	 * @generated
	 */
	DSpecification getDType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#getDType <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DType</em>' reference.
	 * @see #getDType()
	 * @generated
	 */
	void setDType(DSpecification value);

	/**
	 * Returns the value of the '<em><b>DGraph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DGraph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DGraph</em>' containment reference.
	 * @see #setDGraph(DGraph)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_DGraph()
	 * @model containment="true"
	 * @generated
	 */
	DGraph getDGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#getDGraph <em>DGraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DGraph</em>' containment reference.
	 * @see #getDGraph()
	 * @generated
	 */
	void setDGraph(DGraph value);

	/**
	 * Returns the value of the '<em><b>DConstraints</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DConstraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DConstraints</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_DConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<DConstraint> getDConstraints();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' reference.
	 * @see #setSpecification(Specification)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_Specification()
	 * @model required="true"
	 * @generated
	 */
	Specification getSpecification();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#getSpecification <em>Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(Specification value);

	/**
	 * Returns the value of the '<em><b>Grid</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grid</em>' attribute.
	 * @see #setGrid(boolean)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_Grid()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isGrid();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#isGrid <em>Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid</em>' attribute.
	 * @see #isGrid()
	 * @generated
	 */
	void setGrid(boolean value);

	/**
	 * Returns the value of the '<em><b>Snap</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snap</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snap</em>' attribute.
	 * @see #setSnap(boolean)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_Snap()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isSnap();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#isSnap <em>Snap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snap</em>' attribute.
	 * @see #isSnap()
	 * @generated
	 */
	void setSnap(boolean value);

	/**
	 * Returns the value of the '<em><b>Zoom</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zoom</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zoom</em>' attribute.
	 * @see #setZoom(double)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_Zoom()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	double getZoom();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#getZoom <em>Zoom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zoom</em>' attribute.
	 * @see #getZoom()
	 * @generated
	 */
	void setZoom(double value);

	/**
	 * Returns the value of the '<em><b>Grid Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grid Visible</em>' attribute.
	 * @see #setGridVisible(boolean)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_GridVisible()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isGridVisible();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#isGridVisible <em>Grid Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid Visible</em>' attribute.
	 * @see #isGridVisible()
	 * @generated
	 */
	void setGridVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>DSignature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSignature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSignature</em>' reference.
	 * @see #setDSignature(DSignature)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_DSignature()
	 * @model
	 * @generated
	 */
	DSignature getDSignature();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#getDSignature <em>DSignature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DSignature</em>' reference.
	 * @see #getDSignature()
	 * @generated
	 */
	void setDSignature(DSignature value);

	/**
	 * Returns the value of the '<em><b>Meta File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta File</em>' attribute.
	 * @see #setMetaFile(String)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_MetaFile()
	 * @model
	 * @generated
	 */
	String getMetaFile();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#getMetaFile <em>Meta File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta File</em>' attribute.
	 * @see #getMetaFile()
	 * @generated
	 */
	void setMetaFile(String value);

	/**
	 * Returns the value of the '<em><b>Signature File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature File</em>' attribute.
	 * @see #setSignatureFile(String)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSpecification_SignatureFile()
	 * @model
	 * @generated
	 */
	String getSignatureFile();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSpecification#getSignatureFile <em>Signature File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature File</em>' attribute.
	 * @see #getSignatureFile()
	 * @generated
	 */
	void setSignatureFile(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="no.hib.dpf.core.EIOException" uriDataType="no.hib.dpf.core.EURI"
	 * @generated
	 */
//	void save(URI uri) throws IOException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DGraph createDGraph(Graph graph, DGraph dType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DConstraint createDConstraint(Constraint constraint);

} // DSpecification
