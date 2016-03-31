package com.interivew.practice;

import com.interivew.graph.CommonUtil;

public class PracticeBacktracking {

	public void permutationsOfString(char[] a, int n) {
		permutationsOfStringUtil(a, 0, n - 1);
	}

	public void permutationsOfStringUtil(char[] a, int l, int r) {
		if (l == r) {
			CommonUtil.printArray(a);
		}
		for (int i = l; i <= r; i++) {
			CommonUtil.swap(a, i, l);
			permutationsOfStringUtil(a, l + 1, r);
			CommonUtil.swap(a, i, l);
		}
	}

	// combinations of string
	public void combinationsOfString(char[] a, int n) {
		StringBuilder op = new StringBuilder(n);
		combinationsOfStringUtil(a, 0, n, op);
	}

	public void combinationsOfStringUtil(char[] a, int start, int n, StringBuilder op) {
		if (start == n)
			return;
		for (int i = start; i < n; i++) {
			op.append(a[i]);
			System.out.println(op.toString());
			combinationsOfStringUtil(a, start + 1, n, op);
			// deleting last character or just added character
			op.deleteCharAt(op.length() - 1);
		}
	}

	// combinations of size r
	public void combinationsOfSizeR(char[] a, int n, int r) {
		char[] t = new char[r];
		combinationsOfSizeRUtil(a, 0, n, t, 0, r);
	}

	public void combinationsOfSizeRUtil(char[] a, int start, int n, char[] t, int index, int r) {
		if (index == r) {
			CommonUtil.printArray(t);
			return;
		}

		for (int i = start; i < n; i++) {
			t[index] = a[i];
			combinationsOfSizeRUtil(a, start + 1, n, t, index + 1, r);
		}
	}

	// knights tour
	public void knightsTourForChessBoard(int n) {
		int a[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = -1;
			}
		}

		int moves[][] = { { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 }, { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 } };
		int move_no = 0;
		a[0][0] = move_no;
		if (solveKT(a, n, 0, 0, move_no + 1, moves)) {
			CommonUtil.print2DArray(a, n, n);
		} else {
			System.out.println("No Solution");
		}

	}

	public boolean solveKT(int[][] a, int n, int x, int y, int move_no, int[][] moves) {
		if (move_no == n * n)
			return true;
		int nxt_x, nxt_y;
		for (int i = 0; i < n; i++) {
			nxt_x = x + moves[i][0];
			nxt_y = y + moves[i][0];
			if (isSafeToMoveForKT(a, n, nxt_x, nxt_y)) {
				a[nxt_x][nxt_y] = move_no;
				if (solveKT(a, n, nxt_x, nxt_y, move_no + 1, moves)) {
					return true;
				} else {
					a[nxt_x][nxt_y] = -1;
				}
			}
		}
		return false;
	}

	public boolean isSafeToMoveForKT(int a[][], int n, int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < n && a[x][y] == -1)
			return true;
		return false;
	}

	// rat maze
	/*
	 * method 1;
	 */
	public void ratMazeMethod1(int[][] a, int m, int n) {

		boolean result = false;
		int sol[][] = new int[n][n];
		int[][] moves = { { 0, 1 }, { 1, 0 } };

		result = ratMazeUtilMethod1(a, sol, m, n, 0, 0, moves);
		if (result) {
			CommonUtil.print2DArray(sol, m, n);
		} else {
			System.out.println("No solution");
		}
	}

	public boolean ratMazeUtilMethod1(int[][] a, int[][] sol, int m, int n, int x, int y, int[][] moves) {
		if (x == m - 1 && y == n - 1) {
			sol[x][y] = 9;
			return true;
		}

		int next_x, next_y;
		for (int i = 0; i < moves.length; i++) {
			next_x = x + moves[i][0];
			next_y = y + moves[i][1];
			if (isSafeForRatToMove(a, m, n, next_x, next_y)) {
				sol[x][y] = 9;
				if (ratMazeUtilMethod1(a, sol, m, n, next_x, next_y, moves))
					return true;
				else
					sol[x][y] = 0;
			}

		}
		return false;
	}

	public boolean isSafeForRatToMove(int[][] a, int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n && a[x][y] == 1;
	}

	// method 2
	public void ratMazeMethod2(int[][] a, int m, int n) {

		boolean result = false;
		int sol[][] = new int[n][n];

		result = ratMazeUtilMethod2(a, sol, m, n, 0, 0);
		if (result) {
			CommonUtil.print2DArray(sol, m, n);
		} else {
			System.out.println("No solution");
		}
	}

	public boolean ratMazeUtilMethod2(int[][] a, int[][] sol, int m, int n, int x, int y) {
		if (x == m - 1 && y == n - 1) {
			sol[x][y] = 9;
			return true;
		}

		if (isSafeForRatToMove(a, m, n, x, y)) {
			sol[x][y] = 9;
			if (ratMazeUtilMethod2(a, sol, m, n, x + 1, y)) {
				return true;
			}
			if (ratMazeUtilMethod2(a, sol, m, n, x, y + 1)) {
				return true;
			}
			sol[x][y] = 0;
		}

		return false;
	}

	// N Queen

	public void solveNQueen(int n) {
		int a[][] = new int[n][n];
		int row = 0;
		if (solveNQueenUtil(a, n, row)) {
			CommonUtil.print2DArray(a, n, n);
		} else {
			System.out.println("No solution exist");
		}

	}

	public boolean solveNQueenUtil(int[][] a, int n, int row) {
		if (row == n)
			return true;
		for (int col = 0; col < n; col++) {
			if (isSafeToPlaceQueen(a, n, row, col)) {
				a[row][col] = 1;
				if (solveNQueenUtil(a, n, row + 1))
					return true;
				else
					a[row][col] = 0;
			}
		}
		return false;
	}

	public boolean isSafeToPlaceQueen(int[][] a, int n, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (a[i][col] == 1)
				return false;
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (a[i][j] == 1)
				return false;
		}

		for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
			if (a[i][j] == 1)
				return false;
		}
		return true;
	}

	// m coloring
	public void solveMColoring(int[][] a, int m) {
		int n = a.length;
		int sol[] = new int[n];
		int ver = 0;
		if (solveMColoringUtil(a, n, ver, sol, m)) {
			CommonUtil.printArray(sol);
		} else {
			System.out.println("no solution");
		}
	}

	public boolean solveMColoringUtil(int[][] a, int n, int ver, int[] sol, int m) {
		if (ver == n)
			return true;
		for (int color = 1; color <= m; color++) {
			if (isSafeForMColoring(a, n, ver, color, sol)) {
				sol[ver] = color;
				if (solveMColoringUtil(a, n, ver + 1, sol, m))
					return true;
				else
					sol[ver] = 0;
			}
		}
		return false;
	}

	public boolean isSafeForMColoring(int[][] a, int n, int ver, int color, int[] sol) {
		for (int i = 0; i < ver; i++) {
			if (a[ver][i] == 1 && sol[i] == color)
				return false;
		}
		return true;
	}

	public int countIslands(int a[][], int m, int n) {

		int moves[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 } };
		int count = 0;

		boolean t[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && !t[i][j]) {
					dfs(a, m, n, t, i, j, moves);
					count++;
				}
			}
		}
		return count;
	}

	public void dfs(int[][] a, int m, int n, boolean[][] t, int x, int y, int[][] moves) {

		t[x][y] = true;
		int _x, _y;
		for (int i = 0; i < moves.length; i++) {
			_x = x + moves[i][0];
			_y = y + moves[i][1];
			if (isSafeToMoveInIsland(a, m, n, _x, _y)) {
				t[_x][_y] = true;
			}
		}
	}

	public boolean isSafeToMoveInIsland(int[][] a, int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n && a[x][y] == 1;
	}

	public boolean searchWordInDictionary(char a[][], int m, int n, String word) {

		int moves[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == word.charAt(0)) {
					if (searchWordUtil(a, m, n, i, j, word, 1, moves)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean searchWordUtil(char[][] a, int m, int n, int x, int y, String word, int index, int[][] moves) {
		if (index == word.length())
			return true;

		for (int i = 0; i < moves.length; i++) {
			int next_x = x + moves[i][0];
			int next_y = y + moves[i][1];
			if (isSafeForSearchWordInDictionary(a, m, n, next_x, next_y, word, index)) {
				if (searchWordUtil(a, m, n, next_x, next_y, word, index + 1, moves))
					return true;
			}
		}
		return false;
	}

	private boolean isSafeForSearchWordInDictionary(char[][] a, int m, int n, int x, int y, String word, int index) {
		return x >= 0 && x < m && y >= 0 && y < n && word.charAt(index) == a[x][y];
	}

	
	
}
