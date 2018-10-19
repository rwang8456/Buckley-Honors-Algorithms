import java.util.*;
import java.io.*;

public class BFS 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("maze.txt"));
		int row = in.nextInt();
		int col = in.nextInt();
		in.nextLine();
		
		int[][] maze = new int[row][col];
		for(int i = 0; i < row; i++)
		{
			String line = in.nextLine();
			for(int j = 0; j < col; j++)
				maze[i][j] = (line.charAt(j) == 'X') ? -1 : 0;
			
		}
		in.close();
		
		int startI = 0, startJ = 3;
		int endI = 0, endJ = 5;
		Queue<Integer> q = new LinkedList<>();
		q.offer(startI);
		q.offer(startJ);
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, 1, 0, -1};
		
		maze[startI][startJ] = 1;
		boolean found = false;
		
		while(!q.isEmpty() && !found)
		{
			int fromI = q.poll();
			int fromJ = q.poll();
			for(int k = 0; k < 4; k++)
			{
				int toI = fromI + di[k];
				int toJ = fromJ + dj[k];
				if(toI == endI && toJ == endJ)
					found = true;
				if(toI >= 0 && toI < row && toJ >= 0 && toJ < col && maze[toI][toJ] == 0)
				{
					maze[toI][toJ] = maze[fromI][fromJ] + 1;
					q.offer(toI);
					q.offer(toJ);
				}
			}
		}
		
	
		q = new LinkedList<>();
		q.offer(endI);
		q.offer(endJ);
		found = false;
		
		while(!found) 
		{
			int fromI = q.poll();
			int fromJ = q.poll();
			boolean nextFound = false;
			for (int k = 0; k < 4 && !nextFound; k++) 
			{
				int toI = fromI + di[k];
				int toJ = fromJ + dj[k];
				if (toI == startI && toJ == startJ) 
				{
					found = true;
					q.offer(toI);
					q.offer(toJ);
					System.out.print("(" + fromI + ", " + fromJ + ") -> ");
					break;
				}
				if (toI >= 0 && toI < row && toJ >= 0 && toJ < col && maze[toI][toJ] != -1) 
				{
					if (maze[toI][toJ] == maze[fromI][fromJ] - 1) 
					{
						q.offer(toI);
						q.offer(toJ);
						nextFound = true;
						System.out.print("(" + fromI + ", " + fromJ + ") -> ");
					}
				}
			}
		}
		System.out.println("(" + q.poll() + ", " + q.poll() + ")");
		
		System.out.println();
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
				System.out.printf("%3d", maze[i][j]);
			System.out.println();
		}
		
	}
}
