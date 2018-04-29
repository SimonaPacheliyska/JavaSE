
public class ExpiredProjectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "The projection has already expired.\n";
	}
	

}
