package no.hib.dpf.editor.model;

public class ModelSerializationException extends RuntimeException {

	private static final long serialVersionUID = 5914117460788053419L;
	
	public ModelSerializationException() {
		super();
	}

	public ModelSerializationException(String message) {
		super(message);
	}

	public ModelSerializationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModelSerializationException(Throwable cause) {
		super(cause);
	}

}
