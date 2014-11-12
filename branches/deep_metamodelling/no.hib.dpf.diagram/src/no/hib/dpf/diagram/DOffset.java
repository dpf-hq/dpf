/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DOffset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DOffset#getOffset <em>Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DOffset#getLen <em>Len</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DOffset#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDOffset()
 * @model
 * @generated
 */
public interface DOffset extends EObject {
	public final static Point DEFAULT = new Point(0, 0);
	/**
	 * Returns the value of the '<em><b>Len</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Len</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Len</em>' attribute.
	 * @see #setLen(int)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDOffset_Len()
	 * @model
	 * @generated
	 */
	int getLen();

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(Point)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDOffset_Offset()
	 * @model dataType="no.hib.dpf.diagram.ELocation"
	 * @generated
	 */
	Point getOffset();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DOffset#getLen <em>Len</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Len</em>' attribute.
	 * @see #getLen()
	 * @generated
	 */
	void setLen(int value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDOffset_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DOffset#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DOffset#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(Point value);

	void setDOffset(DOffset value);

} // DOffset
