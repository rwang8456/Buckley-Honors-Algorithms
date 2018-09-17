import java.io.*;

public class HW4 
{
	public static void main(String[] args) throws IOException 
	{
		File file1 = new File("count.dat");
		DataInputStream input = new DataInputStream(new FileInputStream(file1));
        DataOutputStream output = new DataOutputStream(new FileOutputStream(file1));
		int timesCount = input.readInt();
		timesCount++;
		output.writeInt(timesCount);
		input.close();
		output.close();
	}
}
