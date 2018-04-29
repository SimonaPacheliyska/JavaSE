package exercise;

public class StudentAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4797533547304758062L;

	@Override
	public String getMessage() {
		return "The student with the given faculty number already exist.\n";
	}

	
}
