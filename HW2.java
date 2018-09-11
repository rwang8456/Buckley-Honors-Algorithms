import java.util.*;

public class HW2 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the values of three sides: ");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		try {
			Triangle t1 = new Triangle(a, b, c);
		} catch (IllegalTriangleException e) {
			System.out.println(e.getMessage());
		}
		
		input.close();
	}
}

class IllegalTriangleException extends Exception
{
	IllegalTriangleException()
	{
		super("The sum of any two sides must be greater than the other side.");
	}
}

class Triangle
{
	int a, b, c;
	Triangle(int a, int b, int c) throws IllegalTriangleException
	{
		if(a + b <= c || b + c <= a || a + c <= b)
			throw new IllegalTriangleException();
		
		this.a = a;
		this.b = b;
		this.c = c;
	}
}