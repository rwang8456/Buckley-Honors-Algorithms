import java.util.*;

public class evaluatePostfix 
{
	static int evaluatePostfix(String ex) 
	{
		int ans = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < ex.length(); i++) 
		{
			char ch = ex.charAt(i);
			if ('1' <= ch && '9' >= ch) 
			{
				st.push(Integer.parseInt("" + ch));
			} 
			else if (ch == '+') 
			{
				int b = s.pop();
				int a = s.pop();
				st.push(a + b);
			} 
			else if (ch == '-') 
			{
				int b = s.pop();
				int a = s.pop();
				st.push(a - b);
			} 
			else if (ch == '*') 
			{
				int b = s.pop();
				int a = s.pop();
				st.push(a * b);
			} 
			else if (ch == '/') 
			{
				int b = s.pop();
				int a = s.pop();
				st.push(a / b);
			}
			
		}

		return st.pop();
	}

}
