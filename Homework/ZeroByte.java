package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ZeroByte {
	public static void main(String args[]) {
		File folder = new File("C:\\Users\\Bobby Wang\\Desktop\\zero byte");
		File[] fileList = folder.listFiles();
		String[] fullArray = new String[fileList.length];

		for (int i = 0; i < fileList.length; i++) {
			System.out.println(format(fileList[i].getName()));
			fullArray[i] = format(fileList[i].getName());
		}

		File file = new File("C:\\Users\\Bobby Wang\\eclipse-workspace\\Zero Byte\\src\\test\\Test.java");
		try (FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(file);
			PrintWriter out = new PrintWriter(bw)) {
			for (String line : fullArray)
				out.println(line);
		} catch (IOException e) {
			System.out.println("Failed");
		}

		try {
			runProcess("javac -cp src src/test/Test.java");
			runProcess("java -cp src test.Test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		file.delete();
	}

	static String format(String str) {
		str = str.substring(1, str.length() - 4);
		str = str.replace("QUO", "\"");
		return str;
	}

	private static void printLines(String cmd, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(cmd + " " + line);
		}
	}

	private static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " stdout:", pro.getInputStream());
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
	}
}
