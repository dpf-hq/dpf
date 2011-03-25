package no.hib.dpf.editor.model;

import no.hib.dpf.metamodel.Constraint;


public class SingleArrowConstraintElement extends VConstraint {

	private static final long serialVersionUID = -8335094106642818540L;

	public static final String MULTIPLICITY_1_PROP = "Multiplicity1";
	public static final String MULTIPLICITY_2_PROP = "Multiplicity2";
	
	private ArrowLabel constraintLabel;
	
	private int val_1 = 1;
	private int val_2 = -1;

	public SingleArrowConstraintElement(VArrow source, ConstraintType constraintType, Constraint IDObject) {
		this.setConstraintType(constraintType);
		// The dpf Constraint object must be initialized before the connection of the shapes.
		setIDObject(IDObject);
		constraintLabel = new ArrowLabel(toString(), true);
		reconnect(source, targets);
	}
		
	@Override
	public String toString() {
		if (constraintType == ConstraintType.COMPOSITION) {
			return "[comp]";
		} else if (constraintType == ConstraintType.IRREFLEXIVE) {
			return "[irr]";
		} else {
			return String.format("[%s..%s]", valToString(val_1), valToString(val_2));
		}
	}
	
	private String valToString(int val) {
		if (val == -1) return "*";
		return Integer.toString(val);
	}
	
	/**
	 * Reconnect this connection. The connection will reconnect with the shape
	 * it was previously attached to.
	 */
	@Override	
	public void reconnect() {
		if (!isConnected) {
			source.addSingleConstraint(this);
			isConnected = true;
		}
	}
	
	public void refreshSource() {
		if (isConnected) {
			source.refreshSingleConstraints();
		}
	}
	
	/**
	 * Disconnect this connection from the shape it is attached to.
	 */
	@Override
	public void disconnect() {
		if (isConnected) {
			source.removeSingleConstraint(this);
			isConnected = false;
		}
	}

	/**
	 * Sets the lineStyle based on the String provided by the PropertySheet
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public void setPropertyValue(Object id, Object value) {
		if (id.equals(MULTIPLICITY_1_PROP)) {
			setVal_1((Integer) value);
			getConstraintLabel().setLabelText(toString());
		} else if (id.equals(MULTIPLICITY_2_PROP)) {
			setVal_2((Integer) value);
			getConstraintLabel().setLabelText(toString());
		} else {
			super.setPropertyValue(id, value);
		}
	}

	private void setVal_1(Integer val_1) {
		this.val_1 = val_1.intValue();
	}

	public int getVal_1() {
		return val_1;
	}

	private void setVal_2(Integer val_2) {
		this.val_2 = val_2.intValue();
	}

	public int getVal_2() {
		return val_2;
	}

	public ArrowLabel getConstraintLabel() {
		return constraintLabel;
	}
	
}
