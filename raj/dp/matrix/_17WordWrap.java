/**
 * 
 */
package com.raj.dp.matrix;

/**
 * @author Raj
 *
 */
public class _17WordWrap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 6, 3, 5, 2, 4 };

		int result = -1, widthOfLine = 10;
		_17WordWrap obj = new _17WordWrap();
		result = obj.wordWrapDpOn2(a, widthOfLine);
		System.out.println(result);
		result = obj.wordWrapDpReversePrintOn2(a, widthOfLine);
		System.out.println(result);
	}

	public int wordWrapDpReversePrintOn2(int[] a, int width) {
		int n = a.length;
		if (n <= 0)
			return -1;
		int t[][] = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			t[i][i] = width - a[i - 1];
			for (int j = i + 1; j < n + 1; j++) {
				t[i][j] = t[i][j - 1] - 1 - a[j - 1];
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = i; j < n + 1; j++) {
				if (t[i][j] < 0) {
					t[i][j] = Integer.MAX_VALUE;
				} else {
					t[i][j] = t[i][j] * t[i][j];
				}
			}
		}

		// for (int i = 1; i < n + 1; i++) {
		// for (int j = 1; j < n + 1; j++) {
		// System.out.print(t[i][j] + " ");
		// }
		// System.out.println();
		// }

		int c[] = new int[n + 1];
		int p[] = new int[n + 1];

		c[0] = 0;
		for (int j = 1; j <= n; j++) {
			c[j] = Integer.MAX_VALUE;
			for (int i = 1; i <= j; i++) {
				if (c[i - 1] != Integer.MAX_VALUE && t[i][j] != Integer.MAX_VALUE && (c[i - 1] + t[i][j] < c[j])) {
					c[j] = c[i - 1] + t[i][j];
					p[j] = i;
				}
			}
		}
		// for (int i = 0; i < n + 1; i++)
		// System.out.print(c[i] + " ");
		// System.out.println();
		//
		// for (int i = 0; i < n + 1; i++)
		// System.out.print(p[i] + " ");
		// System.out.println();

		return c[n];
	}

	public int wordWrapDpOn2(int[] a, int width) {
		int n = a.length;
		if (n <= 0)
			return -1;
		int t[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			t[i][i] = width - a[i];
			for (int j = i + 1; j < n; j++) {
				t[i][j] = t[i][j - 1] - 1 - a[j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (t[i][j] < 0) {
					t[i][j] = Integer.MAX_VALUE;
				} else {
					t[i][j] = t[i][j] * t[i][j];
				}
			}
		}

		int minCost[] = new int[n + 1];
		int result[] = new int[n + 1];

		// for (int i = n - 1; i >= 0; i--) {
		// minCost[i] = t[i][n - 1];
		// result[i] = n;
		// for (int j = n - 1; j >= i; j--) {
		// if (t[i][j - 1] != Integer.MAX_VALUE && minCost[i] > t[i][j - 1] +
		// minCost[j]) {
		// minCost[i] = t[i][j - 1] + minCost[j];
		// result[i] = j;
		// }
		// }
		// }
		//
		//
		minCost[n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			minCost[i] = Integer.MAX_VALUE;
			result[i] = n;
			for (int j = n - 1; j >= i; j--) {
				if (t[i][j] != Integer.MAX_VALUE && minCost[i] > t[i][j] + minCost[j + 1]) {
					minCost[i] = t[i][j] + minCost[j + 1];
					result[i] = j;
				}
			}
		}

		for (int i = 0; i < n + 1; i++)
			System.out.print(minCost[i] + " ");
		System.out.println();

		for (int i = 0; i < n + 1; i++)
			System.out.print(result[i] + " ");
		System.out.println();

		return minCost[0];
	}

}
