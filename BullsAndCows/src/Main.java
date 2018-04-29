import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("I wanna play a little game. I thought a number that you have to guess.");
		System.out.println("If your guessed number is at right position, you get a bull. Otherwise you get a cow!");
		System.out.println();
		System.out.println("Enter length of play number:");
		ComputerNumber.initCompNumber(scanner.nextInt());
		boolean win = false;
		while(!win) {
			System.out.println("Your number is ");
			int currNum = scanner.nextInt();
			System.out.println(getHits(getComputerNumber(), currNum));
			if(getHits(getComputerNumber(), currNum).contains("Finished")) {
				win= true;
			}
		}
		}
			

		

	private static int[] splitAtArray(int number) {
		int[] arr = new int[getDigitCounter(number)];
		for(int i =0;i<arr.length;number/=10,i++) {
			arr[i] = number%10;
		}
		return arr;
	}
	
	public static String getHits(int computer, int player) {
		int[] computers  = splitAtArray(computer);
		int[] players = splitAtArray(player);
		int bulls = 0;
		int cows = 0;
		for(int i = 0;i<computers.length;i++) {
			for(int j =0;j<players.length;j++) {
				if(computers[i]==players[j] && i==j) {
					bulls++;
				}
				if(computers[i]==players[j] && i!=j && players[j]!=computers[j] && players[i]!=computers[i]) {
					cows++;
				}
			}
			}
		return (bulls!=computers.length?bulls+" bulls and "+cows+" cows":bulls+" bulls and "+cows+" cows."+"\n"+"Finished");
	}
	private static int getDigitCounter(int computer) {
		int counter = 0;
		for(;computer>0;counter++,computer/=10);
		return counter;
	}

	public static int getComputerNumber() {
		return ComputerNumber.getCNumber();
	}
	
}