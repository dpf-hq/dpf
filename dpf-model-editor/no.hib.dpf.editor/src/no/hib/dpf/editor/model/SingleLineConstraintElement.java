package no.hib.dpf.editor.model;


// TODO: TO-BIG-DO: make one more flexible constraint class.
public class SingleLineConstraintElement extends VConstraint {

	private static final long serialVersionUID = -8335094106642818540L;

	public static final String MULTIPLICITY_1_PROP = "Multiplicity1";
	public static final String MULTIPLICITY_2_PROP = "Multiplicity2";
	
	private int val_1 = 1;
	private int val_2 = -1;

	public SingleLineConstraintElement(VEdge source, ConstraintType constraintType) {
		super(source, null, constraintType);
	}
		
	@Override
	public String toString() {
		return String.format("[%s..%s]", valToString(val_1), valToString(val_2));
	}
	
	private String valToString(int val) {
		if (val == -1) return "*";
		return Integer.toString(val);
	}
	
	/**
	 * Reconnect this connection. The connection will reconnect with the shapes
	 * it was previously attached to.
	 */
	@Override	
	public void reconnect() {
		if (!isConnected) {
			source.addSingleConstraint(this);
			isConnected = true;
		}
	}

	/**
	 * Reconnect to a different source and/or target shape. The connection will
	 * disconnect from its current attachments and reconnect to the new source
	 * and target.
	 * 
	 * @param newSource
	 *            a new source endpoint for this connection (non null)
	 * @param newTarget
	 *            a new target endpoint for this connection (non null)
	 * @throws IllegalArgumentException
	 *             if any of the paramers are null or newSource == newTarget
	 */
	@Override
	public void reconnect(VEdge newSource, VEdge newTarget) {
		if (newSource == null) {
			throw new IllegalArgumentException();
		}
		disconnect();
		this.source = newSource;
		reconnect();
	}
	
	/**
	 * Disconnect this connection from the shapes it is attached to.
	 */
	@Override
	public void disconnect() {
		if (isConnected) {
			source.removeSingleConstraint(this);
			isConnected = false;
		}
	}

	/**
	 * Returns the lineStyle as String for the Property Sheet
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(MULTIPLICITY_1_PROP)) {
			return "0";
		}
		if (id.equals(MULTIPLICITY_2_PROP)) {
			return "1";
		}
		return super.getPropertyValue(id);
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
//			return "0";
		} else if (id.equals(MULTIPLICITY_2_PROP)) {
//			return "1";
		} else {
			super.setPropertyValue(id, value);
		}
	}

	public void setVal_1(int val_1) {
		this.val_1 = val_1;
	}

	public int getVal_1() {
		return val_1;
	}

	public void setVal_2(int val_2) {
		this.val_2 = val_2;
	}

	public int getVal_2() {
		return val_2;
	}
	
}
