import java.util.*;

public class factorial {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			String temp = "";
			for (int j = 0; j <= i; j++)
				temp += (char)(i + 64);
			map.put(Character.toString((char)(i + 65)), temp);
		}
		
		String newAlphabet = "(A|";
		for (int i = 1; i < 25; i += 2)
			newAlphabet += "" + map.keySet().toArray()[i + 1] + "|" + map.keySet().toArray()[i] + "|";
		newAlphabet += "Z)";

		System.out.print(f((map), n));
		input.close();
	}

	public static int f(Map<String, String> map, int n) {
		String[] str = new String[n];
		for (int i = 0; i < n; i++)
			str[i] = map.get(map.keySet().toArray()[i]);

		while (n > 1) {
			String temp = str[n - 2];
			str[n - 2] = "";
			for (int i = 0; i < str[n - 1].length(); i++)
				str[n - 2] += temp;

			System.out.println(Arrays.toString(str));
			n--;
		}	
		return str[0].length();
	}
}
