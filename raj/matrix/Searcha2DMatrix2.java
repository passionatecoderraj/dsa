package com.raj.matrix;

public class Searcha2DMatrix2 {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		int m = a.length, n = a[0].length;
		Cell result = null;

		Searcha2DMatrix2 obj = new Searcha2DMatrix2();

		int key = 29;

		// Time : O(m+n), if m==n , then Time :O(n)
		result = obj.search(a, m, n, key);
		System.out.println(result);
	}

	private Cell search(int[][] a, int m, int n, int key) {
		int i = 0, j = n - 1;
		while (i < m && j >= 0) {
			if (key < a[i][j])
				j--;
			else if (key > a[i][j])
				i++;
			else
				return new Cell(i, j);

		}
		return null;
	}

}

class Cell {
	int i;
	int j;

	public Cell(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		return "(i=" + i + ", j=" + j + ")";
	}

}