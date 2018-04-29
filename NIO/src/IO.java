
// File file = new File ("fileName.txt"); // creates a filename
// file.createNewFile() - if the given file doesn't exist, it creates a new file
// file.exists() - checks weather the file already exist
// eof == null

import java.io.*;

public class IO {

	public static void main(String[] args) {
		File fileName = new File("test.txt");
		BufferedReader buff = new BufferedReader(new FileReader(fileName));
	}
}
