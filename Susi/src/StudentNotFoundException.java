
public class StudentNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Student with the given name does not exist!";
	}
	
	
}
