/**
 * 
 */
package com.raj.leetcode.google;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */
public class SudokuSolver {

	//https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board);
	}

	private boolean solve(char[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == '.') {
					for (char val = '1'; val <= '9'; val++) {
						if (isValid(a, i, j, val)) {
							a[i][j] = val;
							if (solve(a)) {
								return true;
							} else {
								a[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] a, int i, int j, char val) {
		int blockStartX = i - i % 3;
		int blockStartY = j - j % 3;
		for (int k = 0; k < 9; k++) {
			int x = blockStartX + (k / 3), y = blockStartY + (k % 3);
			if (a[k][j] == val || a[i][k] == val || a[x][y] == val)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		SudokuSolver obj = new SudokuSolver();
		char a[][]= {
				  {'5','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
		};

		obj.solveSudoku(a);
		CommonUtil.print2DArray(a, 9,9);

	}

}
