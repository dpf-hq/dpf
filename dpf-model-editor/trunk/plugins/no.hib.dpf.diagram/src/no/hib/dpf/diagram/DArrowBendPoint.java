/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DArrow Bend Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DArrowBendPoint#getD1 <em>D1</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowBendPoint#getD2 <em>D2</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowBendPoint#getWeight <em>Weight</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowBendPoint#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowBendPoint()
 * @model
 * @generated NOT
 */
public interface DArrowBendPoint extends EObject, Bendpoint{
	/**
	 * Returns the value of the '<em><b>D1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D1</em>' attribute.
	 * @see #setD1(Dimension)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowBendPoint_D1()
	 * @model dataType="no.hib.dpf.diagram.Dimension"
	 * @generated
	 */
	Dimension getD1();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowBendPoint#getD1 <em>D1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D1</em>' attribute.
	 * @see #getD1()
	 * @generated
	 */
	void setD1(Dimension value);

	/**
	 * Returns the value of the '<em><b>D2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D2</em>' attribute.
	 * @see #setD2(Dimension)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowBendPoint_D2()
	 * @model dataType="no.hib.dpf.diagram.Dimension"
	 * @generated
	 */
	Dimension getD2();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowBendPoint#getD2 <em>D2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D2</em>' attribute.
	 * @see #getD2()
	 * @generated
	 */
	void setD2(Dimension value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowBendPoint_Weight()
	 * @model
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowBendPoint#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(Point)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowBendPoint_Location()
	 * @model dataType="no.hib.dpf.diagram.Location"
	 * @generated
	 */
	Point getLocation();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowBendPoint#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Point value);

} // DArrowBendPoint
