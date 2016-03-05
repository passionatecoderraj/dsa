package com.interivew.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckForDuplicatesWithInKDistanceOfMatrix {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = 0;
		N = Integer.parseInt(br.readLine());

		int[][] matrix = null;

		for (int i = 0; i < N; ++i) {
			String[] s = br.readLine().split("\\s+");
			int[] colValues = new int[s.length];

			for (int j = 0; j < colValues.length; ++j)
				colValues[j] = Integer.parseInt(s[j]);
			if (null == matrix) {
				matrix = new int[N][colValues.length];
			}
			for (int j = 0; j < colValues.length; ++j)
				matrix[i][j] = colValues[j];
		}

		int k = Integer.parseInt(br.readLine());

		boolean result;
		result = checkDuplicateWithinK(matrix, k);
		if (result)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static boolean checkDuplicateWithinK(int[][] mat, int k) {
		class Cell {
			int row;
			int col;

			public Cell(int r, int c) {
				this.row = r;
				this.col = c;
			}
		}

		int n = mat.length;
		int m = mat[0].length;
		k = Math.min(k, n * m);

		Map<Integer, Set<Cell>> map = new HashMap<Integer, Set<Cell>>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map.containsKey(mat[i][j])) {
					for (Cell c : map.get(mat[i][j])) {
						int manhattanDist = Math.abs(i - c.row) + Math.abs(j - c.col);

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