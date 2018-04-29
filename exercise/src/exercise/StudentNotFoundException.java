package exercise;

public class StudentNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1088788512974051616L;

	@Override
	public String getMessage() {
		return "The student is not registered in the system.\n";
	}

	
}
