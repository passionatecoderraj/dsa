/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 */
public class WordWrap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 3, 2, 2, 5 };

		int result = -1, widthOfLine = 6;
		WordWrap obj = new WordWrap();
		result = obj.wordWrap(a, a.length, widthOfLine);
		System.out.println(result);

	}

	// len is the length of the line
	// a = array of words sized, n : size of a
	public int wordWrap(int[] a, int n, int len) {
		int c[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			c[i][i] = len - a[i];
			for (int j = i + 1; j < n; j++) {
				c[i][j] = c[i][j - 1] - 1 - a[j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (c[i][j] < 0) {
					c[i][j] = Integer.MAX_VALUE;
				} else {
					c[i][j] = c[i][j] * c[i][j];
				}
			}
		}

		int t[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			t[i] = c[i][n - 1];
			for (int j = n - 1; j > i; j--) {
				if (c[i][j - 1] == Integer.MAX_VALUE)
					continue;
				t[i] = Math.min(t[i], c[i][j - 1] + t[j]);
			}
		}
		// CommonUtil.printArray(t);
		return t[0];
	}
}
