
public class Position {
	private int x;
	private int y;
	
	Position(){
		this. x = 0;
		this.y = 0;
	}
	Position(int x , int y){
		this.x = x;
		this.y = y;
	}
	
	public int getXpos() {
		return this.x;
	}
	public void setXpos(int x) {
		this.x = x;
	}
	public int getYpos() {
		return this.y;
	}
	public void setYpos(int y) {
		this.y = y;
	}

}
