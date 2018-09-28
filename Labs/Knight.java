import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Knight {
	public static void main(String args[]) {
		int[][] board = new int[8][8];

		int startI = 0, startJ = 0, endI = 7, endJ = 7;

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the start position of the knight: ");
		String startPos = input.nextLine().toUpperCase();
		if (ifSquareValid(startPos)) {
			startJ = startPos.charAt(0) - 65;
			startI = 56 - startPos.charAt(1);
		} else {
			System.out.println("Start Position is not valid.");
			input.close();
			return;

		}

		System.out.println("Please enter the end position of the knight: ");
		String endPos = input.nextLine().toUpperCase();
		if (ifSquareValid(endPos)) {
			endJ = endPos.charAt(0) - 65;
			endI = 56 - endPos.charAt(1);
		} else {
			System.out.println("End Position is not valid.");
			input.close();
			return;
		}

		input.close();

		Queue<Integer> q = new LinkedList<>();
		q.offer(startI);
		q.offer(startJ);
		int[] di = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] dj = { 2, 1, -1, -2, -2, -1, 1, 2 };
		board[startI][startJ] = 1;
		boolean found = false;

		while (!q.isEmpty() && !found) {
			int fromI = q.poll();
			int fromJ = q.poll();

			for (int i = 0; i < 8; i++) {
				int toI = fromI + di[i];
				int toJ = fromJ + dj[i];

				if (toI == endI && toJ == endJ)
					found = true;

				if (toI >= 0 && toI < 8 && toJ >= 0 && toJ < 8 && board[toI][toJ] == 0) {
					board[toI][toJ] = board[fromI][fromJ] + 1;
					q.offer(toI);
					q.offer(toJ);
				}
			}
		}

		System.out.println();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				System.out.printf("%3d", board[i][j]);
			System.out.println();
		}

		System.out.println();

		System.out.println(
				"It takes the knight " + (board[endI][endJ] - 1) + " step(s) to move from the start to the end.");

	}

	static boolean ifSquareValid(String str) {
		return (str.charAt(0) <= 72 && str.charAt(0) >= 65 && str.charAt(1) <= 56 && str.charAt(1) >= 48);

	}

}
