package uni.sofia.fmi.mjt.lambdas;

public class Peak {
	
	private byte position;
	private String name;
	private double height;
	private double prominence;
	private String mountChain;
	private int year;
	private int climbs;
	
	private Peak(String line) {
		String[] data = line.split(",");
		this.position = (byte) Integer.parseInt(data[0]);
		this.name = data[1];
		this.height = Double.parseDouble(data[2]);
		this.prominence = Double.parseDouble(data[3]);
		this.mountChain = data[4];
		this.year =  Integer.parseInt(data[5]);
		this.climbs = Integer.parseInt(data[6]);
	}
	
	public byte getPosition() {
		return this.position;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getProminence(){
		return this.prominence;
	}
	
	public String getMountChain() {
		return this.mountChain;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getClimbs() {
		return this.climbs;
	}
	
	public static Peak createPeak(String line) {
		return new Peak(line);
	}
	
	
	@Override
	public String toString() {
		return "Peak [" + position + "," + name + ", " + height + ", " + prominence
				+ ", " + mountChain + ", " + year + ", " + climbs + "]";
	}
}
