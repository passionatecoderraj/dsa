package com.raj.leetcode;

/**
 * @author Raj
 *
 */
// Validity of a given Tic-Tac-Toe board configuration

/*
 * A Tic-Tac-Toe board is given after some moves are played. Find out if the
 * given board is valid, i.e., is it possible to reach this board position after
 * some moves or not.
 */
public class IsValidTicTacToe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsValidTicTacToe obj = new IsValidTicTacToe();
		char a[] = { 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X' };

		boolean result = false;
		result = obj.isValidTicTacToe(a);
		System.out.println(result);

		char a2[] = { 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'X' };
		// (Both X and O cannot win)
		result = obj.isValidTicTacToe(a2);
		System.out.println(result);

		char a3[] = { 'O', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
		// (Valid board with only two moves played)
		result = obj.isValidTicTacToe(a3);
		System.out.println(result);
	}

	public boolean isValidTicTacToe(char a[]) {
		int[][] possibleWinningArrangements = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 },
				{ 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };
		// count X and Y
		int countX = 0, countO = 0;
		for (char ch : a) {
			if (ch == 'X')
				countX++;
			else if (ch == 'O')
				countO++;
		}

		if (countX == countO || countX == countO + 1) {
			boolean isOWon = isWin(possibleWinningArrangements, a, 'O');
			boolean isXWon = isWin(possibleWinningArrangements, a, 'X');
			if (isOWon && isXWon)
				return false;
			if (!isOWon && !isXWon)
				return true;

			if (isOWon && countX == countO) {
				return true;
			}
			if (isXWon && countX == countO + 1) {
				return true;
			}
		}
		return false;

	}

	public boolean isWin(int[][] possibleWinningArrangements, char[] a, char ch) {
		for (int i = 0; i < possibleWinningArrangements.length; i++) {
			if (a[possibleWinningArrangements[i][0]] == ch && a[possibleWinningArrangements[i][1]] == ch
					&& a[possibleWinningArrangements[i][2]] == ch) {
				return true;
			}
		}
		return false;
	}

}
