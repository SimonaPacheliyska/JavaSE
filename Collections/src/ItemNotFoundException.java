
public class ItemNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2163904297258112749L;

	@Override
	public String getMessage() {
		return "The item is not found.\n";
	}

}
