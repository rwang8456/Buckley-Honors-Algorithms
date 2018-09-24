import java.util.*;

class GenericStack<E> 
{
	private E[] arr;
	private int last;
	
	public GenericStack() 
	{
		last = -1;
		arr = (E[]) new Object[10];
	}
	
	public int getSize() 
	{
		return last + 1;
	}
	
	public E peek() 
	{
		if (last == -1) 
			return null;
		return arr[last];
	}
	
	public E pop() 
	{
		if (last == -1) 
			return null;
		E e = arr[last--];
		return e;
	}
	
	public void push(E e) 
	{
		if (last + 1 ==  arr.length)
			arr = Arrays.copyOf(arr, arr.length * 2);
		arr[++last] = e; 
	}
	
	public boolean isEmpty() 
	{
		return last == -1;
	}
	
	public String toString() 
	{
		if (last == -1) 
			return "Stack: []";
		String str = "Stack: [";
		for (int i = 0; i < last; i++) 
		{
			str += arr[i] + ", ";
		}
		str += arr[last] + "]";
		return str;
	}
}
