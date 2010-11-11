package no.hib.dpf.editor.model;

public class SingleNodeConnection extends Connection {

	private static final long serialVersionUID = 764028909094201787L;

	public SingleNodeConnection(Shape source) {
		super(source, source);
	}

}
