package com.interivew.practice;

public class PracticeMatrices {

	public boolean search(int a[][], int key) {
		int m = a.length, n = a[0].length;
		int i = 0, j = n - 1;
		while (i < m && j >= 0) {
			if (key > a[i][j])
				i++;
			else if (key < a[i][j])
				j--;
			else
				return true;
		}
		return false;
	}

	public void printMatrixInSpiralForm(int a[][], int m, int n) {
		int left = 0, right = n - 1, top = 0, bottom = m - 1;
		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				System.out.print(a[top][i] + " ");
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				System.out.print(a[i][right] + " ");
			}
			right--;
			for (int i = right; i >= left; i--) {
				System.out.print(a[bottom][i] + " ");
			}
			bottom--;
			for (int i = bottom; i >= top; i--) {
				System.out.print(a[i][left] + " ");
			}
			left++;
		}
		System.out.println();
	}

	public void rotateMatrix(int a[][], int m, int n) {
		int left = 0, right = n - 1, top = 0, bottom = m - 1;
		int prev, cur;
		while (left <= right && top <= bottom) {
			prev = a[top + 1][left];
			for (int i = left; i <= right; i++) {
				cur = a[top][i];
				a[top][i] = prev;
				prev = cur;
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				cur = a[i][right];
				a[i][right] = prev;
				prev = cur;
			}
			right--;
			for (int i = right; i >= left; i--) {
				cur = a[bottom][i];
				a[bottom][i] = prev;
				prev = cur;
			}
			bottom--;
			for (int i = bottom; i >= top; i--) {
				cur = a[i][left];
				a[i][left] = prev;
				prev = cur;

			}
			left++;
		}
	}

	public void makeRowsAndColumns1IfCellIs1(int a[][], int m, int n) {
		boolean rowFlag = false, colFlag = false;
		for (int i = 0; i < m; i++) {
			if (a[i][0] == 1)
				rowFlag = true;
		}

		for (int i = 0; i < n; i++) {
			if (a[0][i] == 1)
				colFlag = true;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][j] == 1) {
					a[i][0] = 1;
					a[0][j] = 1;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][0] == 1 || a[0][j] == 1) {
					a[i][j] = 1;
				}
			}
		}
		if (rowFlag) {
			for (int i = 0; i < m; i++)
				a[i][0] = 1;
		}

		if (colFlag) {
			for (int i = 0; i < n; i++)
				a[0][i] = 1;
		}
	}

}
