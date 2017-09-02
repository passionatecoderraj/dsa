/**
 *
 */
package com.raj.backtracking;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *         // @formatter:off
 * 
 * 
 *         You are given a 2D char matrix representing the game board. 'M'
 *         represents an unrevealed mine, 'E' represents an unrevealed empty
 *         square, 'B' represents a revealed blank square that has no adjacent
 *         (above, below, left, right, and all 4 diagonals) mines, digit ('1' to
 *         '8') represents how many mines are adjacent to this revealed square,
 *         and finally 'X' represents a revealed mine.
 * 
 *         Now given the next click position (row and column indices) among all
 *         the unrevealed squares ('M' or 'E'), return the board after revealing
 *         this position according to the following rules:
 * 
 *         If a mine ('M') is revealed, then the game is over - change it to
 *         'X'. If an empty square ('E') with no adjacent mines is revealed,
 *         then change it to revealed blank ('B') and all of its adjacent
 *         unrevealed squares should be revealed recursively. If an empty square
 *         ('E') with at least one adjacent mine is revealed, then change it to
 *         a digit ('1' to '8') representing the number of adjacent mines.
 *         Return the board when no more squares will be revealed
 * 
 *         //@formatter:on
 */
public class Minesweeper {

	public void updateBoard(char[][] a, int[] click) {
		int x = click[0];
		int y = click[1];
		// if it's Mine, put 'X' and stop
		if (a[x][y] == 'M') {
			a[x][y] = 'X';
		} else {

			int count = countMines(a, x, y);
			if (count > 0) {
				// if surrounded by 'mines' put count and stop
				a[x][y] = (char) (count + '0');
			} else {
				// if it's not surrounded by mines put blank 'B' and do dfs
				a[x][y] = 'B';
				dfs(a, x, y);
			}
		}
	}

	private void dfs(char[][] a, int x, int y) {
		for (int[] move : moves) {
			int _x = x + move[0];
			int _y = y + move[1];
			if (isSafe(a, _x, _y) && a[_x][_y] == 'E') {
				int count = countMines(a, _x, _y);
				if (count > 0) {
					a[_x][_y] = (char) (count + '0');
				} else {
					a[_x][_y] = 'B';
					dfs(a, _x, _y);
				}
			}
		}
	}

	private int countMines(char a[][], int x, int y) {
		int count = 0;
		for (int[] move : moves) {
			int _x = x + move[0];
			int _y = y + move[1];
			if (isSafe(a, _x, _y) && a[_x][_y] == 'M') {
				count++;
			}
		}
		return count;
	}

	private boolean isSafe(char[][] a, int x, int y) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
	}

	int moves[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

	public static void main(String[] args) {
		Minesweeper obj = new Minesweeper();
		// @formatter:off
		char[][] a = new char[][] { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' } };
		int click1[] = { 3, 0 };
		char[][] b = new char[][] { { 'B', '1', 'E', '1', 'B' }, { 'B', '1', 'M', '1', 'B' },
				{ 'B', '1', '1', '1', 'B' }, { 'B', 'B', 'B', 'B', 'B' } };
		int click2[] = { 1, 2 };
		// @formatter:on
		int m = a.length, n = a[0].length;
		CommonUtil.print2DArray(a, m, n);
		obj.updateBoard(a, click1);
		CommonUtil.print2DArray(a, m, n);
		CommonUtil.print2DArray(b, m, n);
		obj.updateBoard(b, click2);
		CommonUtil.print2DArray(b, m, n);

	}

}
