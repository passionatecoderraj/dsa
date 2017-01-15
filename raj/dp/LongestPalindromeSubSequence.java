/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 */
public class LongestPalindromeSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "agbdba";

		int result = -1, n = str.length();

		LongestPalindromeSubSequence obj = new LongestPalindromeSubSequence();
		result = obj.longestPalindormeBruteForce(str.toCharArray(), 0, n - 1);
		System.out.println(result);
		result = obj.longestPalindormeDp(str.toCharArray(), 0, n);
		System.out.println(result);
	}

	public int longestPalindormeDp(char[] str, int s, int n) {
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = 1;
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (str[i] == str[j]) {
					if (l == 2) {
						t[i][j] = 2;
					} else {
						t[i][j] = 2 + t[i + 1][j - 1];
					}
				} else {
					t[i][j] = max(t[i + 1][j], t[i][j - 1]);
				}
			}
		}

		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n; j++) {
		// System.out.print(t[i][j] + " ");
		// }
		// System.out.println();
		// }
		return t[0][n - 1];
	}

	public int longestPalindormeBruteForce(char[] str, int i, int n) {
		if (i > n)
			return 0;
		if (i == n)
			return 1;
		if (str[i] == str[n]) {
			return 2 + longestPalindormeBruteForce(str, i + 1, n - 1);
		} else {
			return max(longestPalindormeBruteForce(str, i + 1, n), longestPalindormeBruteForce(str, i, n - 1));
		}
	}

	public int max(int i, int j) {
		return i > j ? i : j;
	}

}
