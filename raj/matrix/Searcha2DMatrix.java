package com.raj.matrix;

public class Searcha2DMatrix {

	// Time : O(log(m+n))
	public Cell search(int[][] a, int m, int n, int key) {
		int mid;
		int l = 0, r = m * n - 1;
		while (l <= r) {
			mid = (l + r) >> 1;
			if (a[mid / n][mid % n] > key) {
				r = mid - 1;
			} else if (a[mid / n][mid % n] < key) {
				l = mid + 1;
			} else {
				return new Cell(mid / n, mid % n);
			}

		}
		return null;
	}

	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int m = a.length, n = a[0].length;
		Cell result = null;

		Searcha2DMatrix obj = new Searcha2DMatrix();

		int key = 34;

		result = obj.search(a, m, n, key);
		System.out.println(result);
	}

}
