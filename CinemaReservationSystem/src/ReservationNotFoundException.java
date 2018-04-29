
public class ReservationNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "The reservation doesn`t exist.\n";
	}

}
