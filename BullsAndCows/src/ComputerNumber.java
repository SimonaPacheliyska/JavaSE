
public class ComputerNumber {
	private static int cNumber;
	
	public static void initCompNumber(int number) {
		cNumber = (int)(Math.random() * Math.pow(10,5));
	}
	public static int getCNumber() {
		return cNumber;
	}
}
