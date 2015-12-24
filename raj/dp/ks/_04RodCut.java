	/**
 * 
 */
package com.raj.dp.ks;

/**
 * @author Raj
 *
 */
public class _04RodCut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int len[] = { 1, 2, 3, 4 };
		// int profits[] = { 2, 5, 7, 8 };

		int len[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int profits[] = { 1, 5, 8, 9, 10, 17, 17, 20 };

		int result = -1, n = 8;
		_04RodCut obj = new _04RodCut();
		result = obj.cutRod(len, profits, n);
		System.out.println(result);
	}

	public int cutRod(int[] a, int[] profits, int n) {
		int t[][] = new int[a.length + 1][n + 1];

		for (int i = 0; i < a.length + 1; i++) {	
			t[i][0] = 0;
		}

		for (int j = 0; j < n + 1; j++) {
			t[0][j] = 0;
		}

		for (int i = 1; i < a.length + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j >= i) {
					t[i][j] = max(t[i - 1][j], profits[i - 1] + t[i][j - i]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		for (int i = 0; i < a.length + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}

		return t[a.length][n];
	}

	public int max(int i, int j) {
		return i > j ? i : j;
	}

}
