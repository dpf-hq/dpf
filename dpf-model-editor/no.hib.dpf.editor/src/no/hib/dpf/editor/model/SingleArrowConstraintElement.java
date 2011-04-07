package no.hib.dpf.editor.model;

import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.IDObject;


public class SingleArrowConstraintElement extends DConstraint {

	private static final long serialVersionUID = -8335094106642818540L;

	public static final String MULTIPLICITY_1_PROP = "Multiplicity1";
	public static final String MULTIPLICITY_2_PROP = "Multiplicity2";
	
	private ArrowLabel constraintLabel;
	
	public SingleArrowConstraintElement(DArrow source, ConstraintType constraintType, Constraint IDObject) {
		this.setConstraintType(constraintType);
		// The dpf Constraint object must be initialized before the connection of the shapes.
		setIDObject(IDObject);
		reconnect(source, targets);
	}
		
	@Override
	public String toString() {
		if (constraintType == ConstraintType.COMPOSITION) {
			return "[comp]";
		} else if (constraintType == ConstraintType.IRREFLEXIVE) {
			return "[irr]";
		} else if (constraintType == ConstraintType.TRANSITIVE_IRREFLEXIVE) {
			return "[t-irr]";
		} else {
			return String.format("[%s..%s]", valToString(getVal_1()), valToString(getVal_2()));
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
	
	@Override
	public void setIDObject(IDObject idObject) {
		super.setIDObject(idObject);
		if (getConstraintLabel() != null) {
			getConstraintLabel().setLabelText(toString());
		} else {
			constraintLabel = new ArrowLabel(toString(), true);
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
	
	private int [] getValuesFromParameter() {
		try {
			int [] retval =  new int[2];
			retval[0] = Integer.parseInt(getParameters().split(",")[0]);
			retval[1] = Integer.parseInt(getParameters().split(",")[1]);
			return retval;
		} catch (Exception e) {
			return new int[]{1, -1};
		}
	}

	private void setVal_1(Integer val_1) {
		String params = val_1.toString() + "," + new Integer(getVal_2()).toString();
		setParameters(params);
	}

	public int getVal_1() {
		return getValuesFromParameter()[0];
	}

	private void setVal_2(Integer val_2) {
		String params = new Integer(getVal_1()).toString() + "," + val_2.toString();
		setParameters(params);
	}

	public int getVal_2() {
		return getValuesFromParameter()[1];
	}

	public ArrowLabel getConstraintLabel() {
		return constraintLabel;
	}
	
}
