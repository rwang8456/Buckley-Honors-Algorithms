
public class StringBuilderHW 
{
	public static void main(String args[])
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 1111; i++)
		{
			sb.append((char)(Math.random() * 94 + 33));
		}

		for(int i = 0; i < 1100; i += 100)
		{
			System.out.println(sb.substring(i, i + 100));
		}
		System.out.println(sb.substring(1100));
	}
}
