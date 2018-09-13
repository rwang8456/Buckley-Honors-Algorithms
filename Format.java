import java.io.*;
import java.util.*;

public class Format {
	public static void main(String args[]) throws FileNotFoundException {
		File fromFile = new File("src/Format.java");
		File toFile = new File("src/Formatted.java");
		
		Scanner input = new Scanner(fromFile);
		PrintWriter output = new PrintWriter(toFile);
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			int tabCount = 0;
			if(line.contains("{")) {
				int x = 1;
				while(line.charAt(line.length() - x) == ' ') {
					x++;
				}
				if(line.charAt(line.length() - x) == '{') {
					for(int i = 0; i < line.length(); i++) {
						if(line.charAt(i) == '\t') tabCount++;
					}
					output.println(line.substring(0, line.length() - x));
					for(int i = 0; i < tabCount; i++)
						output.print("\t");
					output.println("{");
				}
				else output.println(line);
			}
			else output.println();
		}
		
		input.close();
		output.close();
	}
}
