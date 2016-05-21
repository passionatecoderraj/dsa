package com.raj.matrix;

public class PrintMatrixDiagnolly {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };
		int m = a.length, n = a[0].length;

		PrintMatrixDiagnolly obj = new PrintMatrixDiagnolly();
		obj.printMatrixDiangolly(a, m, n);
	}

	public void printMatrixDiangolly(int[][] a, int m, int n) {
		int i, j;
		for (int r = 0; r < m; r++) {
			i = r;
			j = 0;
			while (i >= 0 && j < n) {
				System.out.print(a[i][j] + " ");
				i--;
				j++;
			}
			System.out.println();
		}
		for (int c = 1; c < n; c++) {
			i = m - 1;
			j = c;
			while (i >= 0 && j < n) {
				System.out.print(a[i][j] + " ");
				i--;
				j++;
			}
			System.out.println();
		}
	}

}
