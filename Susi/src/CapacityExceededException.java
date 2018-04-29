
public class CapacityExceededException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CapacityExceededException() {
		super();
		this.message = new String("The student already took the maximum number of courses!");
	}
	
	public CapacityExceededException(int limit) {
		this.message = new String("Limit reached! You are not able to register more students.");
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
