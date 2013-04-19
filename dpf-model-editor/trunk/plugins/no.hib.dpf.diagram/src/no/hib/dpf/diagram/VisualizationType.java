/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Visualization Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.diagram.DiagramPackage#getVisualizationType()
 * @model
 * @generated
 */
public enum VisualizationType implements Enumerator {
	/**
	 * The '<em><b>Arrow Label</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARROW_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	ARROW_LABEL(0, "ArrowLabel", "ArrowLabel"),

	/**
	 * The '<em><b>Node To Node</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_TO_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_TO_NODE(1, "NodeToNode", "NodeToNode"),

	/**
	 * The '<em><b>Node To Arrow</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NODE_TO_ARROW_VALUE
	 * @generated
	 * @ordered
	 */
	NODE_TO_ARROW(2, "NodeToArrow", "NodeToArrow"),

	/**
	 * The '<em><b>Arrow To Node</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARROW_TO_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	ARROW_TO_NODE(3, "ArrowToNode", "ArrowToNode"),

	/**
	 * The '<em><b>Arrow To Arrow</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARROW_TO_ARROW_VALUE
	 * @generated
	 * @ordered
	 */
	ARROW_TO_ARROW(4, "ArrowToArrow", "ArrowToArrow"), /**
	 * The '<em><b>Composed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPOSED_VALUE
	 * @generated
	 * @ordered
	 */
	COMPOSED(5, "Composed", "Composed"), /**
	 * The '<em><b>On Node</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	ON_NODE(6, "OnNode", "OnNode");

	/**
	 * The '<em><b>Arrow Label</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Arrow Label</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARROW_LABEL
	 * @model name="ArrowLabel"
	 * @generated
	 * @ordered
	 */
	public static final int ARROW_LABEL_VALUE = 0;

	/**
	 * The '<em><b>Node To Node</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Node To Node</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_TO_NODE
	 * @model name="NodeToNode"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_TO_NODE_VALUE = 1;

	/**
	 * The '<em><b>Node To Arrow</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Node To Arrow</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NODE_TO_ARROW
	 * @model name="NodeToArrow"
	 * @generated
	 * @ordered
	 */
	public static final int NODE_TO_ARROW_VALUE = 2;

	/**
	 * The '<em><b>Arrow To Node</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Arrow To Node</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARROW_TO_NODE
	 * @model name="ArrowToNode"
	 * @generated
	 * @ordered
	 */
	public static final int ARROW_TO_NODE_VALUE = 3;

	/**
	 * The '<em><b>Arrow To Arrow</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Arrow To Arrow</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARROW_TO_ARROW
	 * @model name="ArrowToArrow"
	 * @generated
	 * @ordered
	 */
	public static final int ARROW_TO_ARROW_VALUE = 4;

	/**
	 * The '<em><b>Composed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Composed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPOSED
	 * @model name="Composed"
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSED_VALUE = 5;

	/**
	 * The '<em><b>On Node</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Node</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_NODE
	 * @model name="OnNode"
	 * @generated
	 * @ordered
	 */
	public static final int ON_NODE_VALUE = 6;

	/**
	 * An array of all the '<em><b>Visualization Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VisualizationType[] VALUES_ARRAY =
		new VisualizationType[] {
			ARROW_LABEL,
			NODE_TO_NODE,
			NODE_TO_ARROW,
			ARROW_TO_NODE,
			ARROW_TO_ARROW,
			COMPOSED,
			ON_NODE,
		};

	/**
	 * A public read-only list of all the '<em><b>Visualization Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VisualizationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Visualization Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisualizationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VisualizationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Visualization Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisualizationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VisualizationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Visualization Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisualizationType get(int value) {
		switch (value) {
			case ARROW_LABEL_VALUE: return ARROW_LABEL;
			case NODE_TO_NODE_VALUE: return NODE_TO_NODE;
			case NODE_TO_ARROW_VALUE: return NODE_TO_ARROW;
			case ARROW_TO_NODE_VALUE: return ARROW_TO_NODE;
			case ARROW_TO_ARROW_VALUE: return ARROW_TO_ARROW;
			case COMPOSED_VALUE: return COMPOSED;
			case ON_NODE_VALUE: return ON_NODE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VisualizationType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //VisualizationType
