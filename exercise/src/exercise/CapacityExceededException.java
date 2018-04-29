package exercise;

public class CapacityExceededException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7563317187410443733L;

	public String getMessage(int code) {
		return "The university capacity is exceeded.\n";
	}
	
	@Override
	public String getMessage() {
		return "The student already took the maximum number of courses.\n";
	}

}
