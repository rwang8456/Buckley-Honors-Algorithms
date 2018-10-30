public class factorial 
{
	public static void main(String args[]) 
  	{
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < 26; i++) 
        {
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
    }
}
