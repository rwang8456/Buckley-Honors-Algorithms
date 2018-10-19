import java.util.Stack;

public class HW8 {

	public static void main(String[] args) {
		assert match("()");
		assert match("([]{}())");
		assert match("(((((((((())))))))))");
		assert !match("(((((");
		assert !match("({)}");
		assert match("[{[]()}[]]");
		assert !match("(((((((((()))))))))");
	}
	
	static boolean match (String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++ ) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{')
				st.push(ch);
			else if ((ch == ')' && st.peek() != '(') || (ch == ']' && st.peek() != '[') || (ch == '}' && st.peek() != '{'))
				return false;
			else st.pop();
		}
		return st.isEmpty();
	}

}