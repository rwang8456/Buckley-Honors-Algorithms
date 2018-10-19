public class HW13 
{
	static int[][] a = {{0, 0, 0, 0, 7, 0, 0, 0, 0},
						{0, 0, 5, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 6, 0},
						{0, 0, 0, 0, 0, 9, 0, 0, 0},
						{0, 0, 0, 3, 0, 0, 0, 0, 0},
						{0, 4, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 8, 0, 0},
						{2, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 1}};
					   
	static boolean[][] b;

	public static void main(String[] args) 
	{
		b = new boolean[a.length][a[0].length];
		for (int i = 0; i < b.length; i++) 
		{
			for (int j = 0; j < b[0].length; j++) 
			{
				if (a[i][j] != 0) b[i][j] = true;
			}
		}
		backtrack(0, 0, true);
		printBoard();
		
	}
	
	static boolean backtrack(int r, int c, boolean f)
	{
		if (c == a.length) 
		{
			c = 0;
			r++;
		}
		
		if (r == a.length) 
			return true;
		
		if (c == -1) 
		{
			c = a.length - 1;
			r--;
		}
		
		if (b[r][c]) 
			return f ? backtrack(r, c + 1, f) : backtrack(r, c - 1, f);
			
		int x = a[r][c];
		for (int i = x + 1; i <= 9; i++) 
		{
			if (isOk(r, c, i)) 
			{
				a[r][c] = i;
				return backtrack (r, c + 1, true);
			}
		}
		a[r][c] = 0;
		return backtrack(r, c - 1, false);
	}
	
	static boolean isOk(int r, int c, int num) 
	{
		for (int row = 0; row < a.length; row++) 
		{
			if (a[row][c] == num)
				return false;
		}
		
		for (int col = 0; col < a[0].length; col++) 
		{
			if (a[r][col] == num) 
				return false;
		}
		
		int rBox = (r / 3) * 3;
		int cBox = (c / 3) * 3;
		
		for (int row = rBox; row < rBox + 3; row++) 
		{
			for (int col = cBox; col < cBox + 3; col++) 
			{
				if(a[row][col] == num)
					return false;
			}
		}
		return true;
	}
	
	
	static void printBoard() 
	{
		for (int[] row : a) 
		{
			for (int col: row)
				System.out.print(col + " ");
			
			System.out.println();
		} 
		System.out.println();
	}

}