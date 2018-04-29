
import java.util.Random;

public class Minesweeper {
 private char[][] board;
 private int width;
 private int height;
 
Minesweeper() {
	init(11,11);
}
Minesweeper(int width, int height){
	init(width,height);
}
private void init(int x, int y) {
	this.board = new char[x][y];
	this.width=x;
	this.height=y;
	for(int i =0;i<this.width;i++) {
		for(int j =0;j<this.height;j++) {
			this.board[i][j]='#';
		}
	}
}
public void dropBombs(int bombs) {
	Random randm= new Random();
	while(bombs>0) {
		int randX = randm.nextInt(this.width);
		int randY = randm.nextInt(this.height);
		if(this.board[randX][randY]!='B') {
			this.board[randX][randY]  = 'B';
			bombs--;
		}
	}
}
public void printBoard() {
	//StringBuilder strBoard  = new StringBuilder();
	for(int i=0;i< this.width;i++) {
		for(int j =0;j<this.height;j++) {
			//strBoard.append(this.board[j]);
			System.out.print(this.board[j]);
		}
		System.out.println();
	}
}

}