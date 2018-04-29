
public class StudentAlreadyRegisteredException extends Exception {

	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "The student is already registered!";
	}
	
}
