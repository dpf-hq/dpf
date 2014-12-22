/**
 */
package no.hib.dpf.uconstraint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>UC Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUCType()
 * @model
 * @generated
 */
public enum UCType implements Enumerator {
	/**
	 * The '<em><b>ALL LEFT EXIST RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_LEFT_EXIST_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_LEFT_EXIST_RIGHT(0, "ALL_LEFT_EXIST_RIGHT", "ALL_LEFT_EXIST_RIGHT"), /**
	 * The '<em><b>ALL LEFT NOT EXIST RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_LEFT_NOT_EXIST_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_LEFT_NOT_EXIST_RIGHT(1, "ALL_LEFT_NOT_EXIST_RIGHT", "ALL_LEFT_NOT_EXIST_RIGHT"), /**
	 * The '<em><b>ALL LEFT IFF RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_LEFT_IFF_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_LEFT_IFF_RIGHT(2, "ALL_LEFT_IFF_RIGHT", "ALL_LEFT_IFF_RIGHT"), /**
	 * The '<em><b>ALL LEFT IFF NOT RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_LEFT_IFF_NOT_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_LEFT_IFF_NOT_RIGHT(3, "ALL_LEFT_IFF_NOT_RIGHT", "ALL_LEFT_IFF_NOT_RIGHT");

	/**
	 * The '<em><b>ALL LEFT EXIST RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALL LEFT EXIST RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL_LEFT_EXIST_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_LEFT_EXIST_RIGHT_VALUE = 0;

	/**
	 * The '<em><b>ALL LEFT NOT EXIST RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALL LEFT NOT EXIST RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL_LEFT_NOT_EXIST_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_LEFT_NOT_EXIST_RIGHT_VALUE = 1;

	/**
	 * The '<em><b>ALL LEFT IFF RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALL LEFT IFF RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL_LEFT_IFF_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_LEFT_IFF_RIGHT_VALUE = 2;

	/**
	 * The '<em><b>ALL LEFT IFF NOT RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALL LEFT IFF NOT RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL_LEFT_IFF_NOT_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_LEFT_IFF_NOT_RIGHT_VALUE = 3;

	/**
	 * An array of all the '<em><b>UC Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UCType[] VALUES_ARRAY =
		new UCType[] {
			ALL_LEFT_EXIST_RIGHT,
			ALL_LEFT_NOT_EXIST_RIGHT,
			ALL_LEFT_IFF_RIGHT,
			ALL_LEFT_IFF_NOT_RIGHT,
		};

	/**
	 * A public read-only list of all the '<em><b>UC Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UCType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>UC Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UCType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UCType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>UC Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UCType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UCType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>UC Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UCType get(int value) {
		switch (value) {
			case ALL_LEFT_EXIST_RIGHT_VALUE: return ALL_LEFT_EXIST_RIGHT;
			case ALL_LEFT_NOT_EXIST_RIGHT_VALUE: return ALL_LEFT_NOT_EXIST_RIGHT;
			case ALL_LEFT_IFF_RIGHT_VALUE: return ALL_LEFT_IFF_RIGHT;
			case ALL_LEFT_IFF_NOT_RIGHT_VALUE: return ALL_LEFT_IFF_NOT_RIGHT;
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
	private UCType(int value, String name, String literal) {
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
	
} //UCType
