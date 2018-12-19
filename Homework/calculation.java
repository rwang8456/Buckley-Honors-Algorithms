
public class calculation 
{
	public static void main(String args[])
	{
		System.out.println("8 + 5 = " + add(8, 5));
		System.out.println("8 - 5 = " + sub(8, 5));
		System.out.println("8 * 5 = " + mult(8, 5));
		System.out.println("41 / 8 = " + div(41, 8));
		System.out.println("41 % 8 = " + mod(41, 8));
	}
	
	public static int add(int a, int b)
	{
		while(b != 0)
		{
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}
	
	public static int sub(int a, int b)
	{
		b = add(~b, 1);
		return add(a, b);
	}
	
	public static int mult(int a, int b)
	{
		int sum = 0;
		for(int i = 0; i < b; i++)
			sum = add(sum, a);
		return sum;
	}
	
	public static int div(int a, int b)
	{
		int result = 0;
		while(a >= b)
		{
			a = sub(a, b);
			result++;
		}
		return result;
	}
	
	public static int mod(int a, int b)
	{
		while(a >= b)
		{
			a = sub(a, b);
		}
		return a;
	}
}
