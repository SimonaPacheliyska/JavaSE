package bg.uni.sofia.fmi.mjt.shopping;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "The item is not found!";
	}
}
