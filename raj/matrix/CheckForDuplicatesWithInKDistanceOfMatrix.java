package com.raj.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckForDuplicatesWithInKDistanceOfMatrix {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 2, 3, 4 }, { 3, 13, 7, 8 }, { 9, 3, 11, 12 }, { 13, 14, 15, 16 } };

		int m = a.length, n = a[0].length;
		int k = 3;
		boolean result = false;
		result = checkDuplicateWithinK(a, m, n, k);
		System.out.println(result);
	}

	public static boolean checkDuplicateWithinK(int[][] mat, int m, int n, int k) {
		class Cell {
			int row;
			int col;

			public Cell(int r, int c) {
				this.row = r;
				this.col = c;
			}

			@Override
			public String toString() {
				return "Cell [row=" + row + ", col=" + col + "]";
			}

		}

		k = Math.min(k, n * m);

		Map<Integer, Set<Cell>> map = new HashMap<Integer, Set<Cell>>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map.containsKey(mat[i][j])) {
					for (Cell c : map.get(mat[i][j])) {
						int manhattanDist = Math.abs(i - c.row) + Math.abs(j - c.col);
						System.out.println(c);
						System.out.println(new Cell(i, j));

						System.out.println(manhattanDist);
						if (manhattanDist <= k) {
							return true;
						}

						if (i - c.row > k) {
							map.remove(c);
						}
					}

					map.get(mat[i][j]).add(new Cell(i, j));
				} else {
					map.put(mat[i][j], new HashSet<Cell>());
					map.get(mat[i][j]).add(new Cell(i, j));
				}
			}
		}

		return false;
	}

	static void print2DArray(int[][] t, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}

}