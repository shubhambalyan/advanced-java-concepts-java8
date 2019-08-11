package in.conceptarchitect.collections;

public class StackOverFlowException extends RuntimeException {

	Object value;

	public StackOverFlowException(Object value) {
		super();
		this.value = value;
	}

	public Object getValue() {
		return value;
	}
	
	
	
}
