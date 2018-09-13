import java.io.*;
import java.util.*;

public class Lab 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		File f = new File("hello world.txt");
		countOccurance(f);
	}
	
	public static void countOccurance(File f) throws FileNotFoundException
	{
		int[] count = new int[26];
		
		File toFile = new File("Occurance.txt");
		
		Scanner input = new Scanner(f);
		PrintWriter output = new PrintWriter(toFile);
		
		while(input.hasNext())
		{
			String w = input.next().toLowerCase();
			for(int i = 0; i < w.length(); i++)
				count[(int)(w.charAt(i)) - 97]++;
		}
		
		for(int i = 0; i < count.length; i++)
			output.println((char)(i + 65) + ": " + count[i]);
		
		input.close();
		output.close();	
	}
}
