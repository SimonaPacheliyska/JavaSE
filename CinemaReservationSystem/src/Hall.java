import java.util.Map;


public class Hall {

	private int number;
	private Map<Seat,Boolean> rowSeats;
	
	
	public Hall(int number, Map<Seat,Boolean> rowSeats) {
		this.number = number;
		this.rowSeats = rowSeats;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public Map<Seat,Boolean> getRowSeats() {
		return rowSeats;
	}
	
	public void setRowSeats(Map<Seat,Boolean> rowSeats) {
		this.rowSeats = rowSeats;
	}
}