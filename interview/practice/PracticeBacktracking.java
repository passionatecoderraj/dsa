package com.interview.practice;

import com.interview.graph.CommonUtil;

public class PracticeBacktracking {

	public void permute(char[] word, int cur) {
		if (word.length == cur) {
			System.out.println(word);
			return;
		}
		for (int i = cur; i < word.length; i++) {
			CommonUtil.swap(word, i, cur);
			permute(word, cur + 1);
			CommonUtil.swap(word, i, cur);
		}
	}

	public void permuteLengthK(char[] word, int cur, int k) {
		if (k == cur) {
			System.out.println(word);
			return;
		}
		for (int i = cur; i < word.length; i++) {
			CommonUtil.swap(word, i, cur);
			permuteLengthK(word, cur + 1, k);
			CommonUtil.swap(word, i, cur);
		}
	}

	public void permuteUnique(char[] word, int cur) {
		if (word.length == cur) {
			System.out.println(word);
			return;
		}
		for (int i = cur; i < word.length; i++) {
			if (!containsDuplicate(word, cur, i - 1, word[i])) {
				CommonUtil.swap(word, i, cur);
				permuteUnique(word, cur + 1);
				CommonUtil.swap(word, i, cur);
			}
		}
	}

	private boolean containsDuplicate(char[] a, int start, int end, int k) {
		for (int i = start; i <= end; i++) {
			if (a[i] == k)
				return true;
		}
		return false;
	}

	public void combinations(char word[], int curPosition, StringBuilder sb) {
		if (curPosition == word.length)
			return;
		for (int i = curPosition; i < word.length; i++) {
			sb.append(word[i]);
			System.out.println(sb);
			combinations(word, i + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public void combinationsOfSizeK(char word[], int curPosition, int k, char[] res, int resIndex) {
		if (resIndex == k) {
			CommonUtil.printArray(res);
			return;
		}
		for (int i = curPosition; i < word.length; i++) {
			res[resIndex] = word[i];
			combinationsOfSizeK(word, i + 1, k, res, resIndex + 1);
		}
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
		if (move_no > n * n)
			return true;
		int nxt_x, nxt_y;

		for (int i = 0; i < moves.length; i++) {
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
	public void mColoring(int a[][], int m) {
		int sol[] = new int[a.length];
		if (mColoringUtil(a, 0, sol, m)) {
			CommonUtil.printArray(sol);
		} else {
			System.out.println("No solution");
		}
	}

	public boolean mColoringUtil(int[][] a, int vertex, int[] sol, int m) {
		if (vertex == a.length)
			return true;
		for (int i = 1; i <= m; i++) {
			if (isSafeToColor(a, vertex, i, sol)) {
				sol[vertex] = i;
				if (mColoringUtil(a, vertex + 1, sol, m)) {
					return true;
				}
				sol[vertex] = 0;
			}
		}
		return false;
	}

	public boolean isSafeToColor(int[][] a, int vertex, int color, int[] sol) {
		for (int i = 0; i < a[vertex].length; i++) {
			if (a[vertex][i] == 1 && sol[i] == color)
				return false;
		}
		return true;
	}

	public int countIslands(int a[][]) {
		int count = 0;
		int moves[][] = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 } };
		boolean[][] visited = new boolean[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1 && visited[i][j] == false) {
					count++;
					dfs(a, i, j, visited, moves);
				}

			}
		}
		System.out.println(count);
		return count;
	}

	public void dfs(int[][] a, int x, int y, boolean[][] visited, int[][] moves) {
		visited[x][y] = true;
		for (int i = 0; i < moves.length; i++) {
			int _x = moves[i][0] + x;
			int _y = moves[i][1] + y;
			if (isSafe(a, _x, _y, visited)) {
				dfs(a, _x, _y, visited, moves);
			}
		}
	}

	public boolean isSafe(int[][] a, int x, int y, boolean[][] visited) {
		return x >= 0 && y >= 0 && x < a.length && y < a.length && a[x][y] == 1 && !visited[x][y];
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

	public boolean sudokuSolver(int a[][]) {
		Cell cell = getUnassignedLocation(a);
		if (null == cell)
			return true;
		for (int i = 1; i <= 9; i++) {
			if (isSafeToPlace(a, cell.x, cell.y, i)) {
				a[cell.x][cell.y] = i;
				if (sudokuSolver(a)) {
					return true;
				}
				a[cell.x][cell.y] = 0;
			}
		}
		return false;
	}

	public boolean isSafeToPlace(int[][] a, int x, int y, int n) {
		return isSafeRow(a, x, y, n) && isSafeColumn(a, x, y, n) && isSafeBlock(a, x - x % 3, y - y % 3, n);
	}

	public boolean isSafeRow(int[][] a, int x, int y, int n) {
		for (int i = 0; i < a[0].length; i++) {
			if (a[x][i] == n) {
				return false;
			}
		}
		return true;
	}

	public boolean isSafeColumn(int[][] a, int x, int y, int n) {
		for (int i = 0; i < a.length; i++) {
			if (a[i][y] == n) {
				return false;
			}
		}
		return true;
	}

	public boolean isSafeBlock(int[][] a, int x, int y, int n) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i + x][j + y] == n) {
					return false;
				}
			}
		}
		return true;
	}

	public Cell getUnassignedLocation(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 0)
					return new Cell(i, j);
			}
		}
		return null;
	}

	class Cell {
		int x;
		int y;

		public Cell(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
