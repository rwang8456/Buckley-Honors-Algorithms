public class NQueens 
{
	static final int N = 6;
	static boolean[][] board = new boolean[N][N];

	public static void main(String[] args) 
	{
		backtrack(0);
		printBoard();
		
	}
	
	static boolean backtrack(int row) 
	{
		if (row == N) 
		{
			return true;
		}
		for (int col = 0; col < N; col++) 
		{
			if (isOk(row, col)) 
			{
				board[row][col] = true;
				
				if (backtrack(row + 1)) 
					return true;
				
				board[row][col] = false;
			}
		}
		return false;
	}
	
	static boolean isOk(int row, int col) 
	{
		for (int r = 0; r < row; r++)
		{
			if (board[r][col])
				return false;
		}
		
		int r = row - 1, c = col + 1;
		
		while (r >= 0 && c < N) 
		{
			if (board[r][c]) return false;
			r--;
			c++;
		}
		
		r = row - 1; c = col - 1;
		while (r >= 0 && c >= 0) 
		{
			if (board[r][c]) return false;
			r--;
			c--;
		}
		
		return true;
	}
	
	static void printBoard() 
	{
		for (boolean[] row : board) 
		{
			for (boolean col: row) 
			{
				System.out.print(col ? " ♕ " : " _ ");
			}
			System.out.println();
		}
		System.out.println();
	}

}