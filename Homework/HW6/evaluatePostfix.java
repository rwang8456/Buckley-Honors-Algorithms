import java.util.*;

public class evaluatePostfix 
{
	static int evaluatePostfix(String ex) 
	{
		int ans = 0;
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < ex.length(); i++) 
		{
			char ch = ex.charAt(i);
			if ('1' <= ch && '9' >= ch) 
			{
				s.push(Integer.parseInt("" + ch));
			} 
			else if (ch == '+') 
			{
				int b = s.pop();
				int a = s.pop();
				s.push(a + b);
			} 
			else if (ch == '-') 
			{
				int b = s.pop();
				int a = s.pop();
				s.push(a - b);
			} 
			else if (ch == '*') 
			{
				int b = s.pop();
				int a = s.pop();
				s.push(a * b);
			} 
			else if (ch == '/') 
			{
				int b = s.pop();
				int a = s.pop();
				s.push(a / b);
			}
			
		}

		return s.pop();
	}

}
