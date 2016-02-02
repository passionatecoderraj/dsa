/**
 * 
 */
package com.raj.dp.matrix;

import java.util.HashSet;
import java.util.Set;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class PalindromePartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcbb";

		int result = -1;
		PalindromePartition obj = new PalindromePartition();
		// result =
		// obj.minCutsForPalindromePartitionsBruteForce(str.toCharArray(), 0,
		// str.length() - 1);
		// System.out.println(result);
		// result = obj.minCutsForPalindromePartitionsDpOn3(str.toCharArray());
		// System.out.println(result);
		// result = obj.minCutsForPalindromePartitionsDpOn2(str.toCharArray());
		// System.out.println(result);
		result = obj.numberOfPalindromes(str);
		System.out.println(result);
	}

	public int numberOfPalindromes(String str) {
		int n = str.length();
		Set<String> set = new HashSet<String>();
		boolean p[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			p[i][i] = true;
			set.add(str.substring(i, i + 1));
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2) {
					p[i][j] = str.charAt(i) == str.charAt(j);
					if (p[i][j])
						set.add(str.substring(i, j + 1));
				} else {
					p[i][j] = str.charAt(i) == str.charAt(j) && p[i + 1][j - 1];
					if (p[i][j])
						set.add(str.substring(i, j + 1));
				}
			}
		}

		return set.size();
	}

	public int minCutsForPalindromePartitionsDpOn2(char[] str) {
		int n = str.length;
		int t[] = new int[n];
		boolean p[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			p[i][i] = true;
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2) {
					p[i][j] = str[i] == str[j];
				} else {
					p[i][j] = str[i] == str[j] && p[i + 1][j - 1];
				}
			}
		}
		CommonUtil.print2DArray(p, n, n);

		for (int i = 0; i < n; i++) {
			if (p[0][i] == true) {
				t[i] = 0;

			} else {
				t[i] = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if (p[j + 1][i] == true && t[i] > 1 + t[j]) {
						t[i] = t[j] + 1;
					}
				}
			}
		}
		CommonUtil.printArray(t);

		return t[n - 1];
	}

	public int minCutsForPalindromePartitionsDpOn3(char[] str) {
		int n = str.length;
		if (n <= 0)
			return -1;
		int[][] t = new int[n][n];
		boolean[][] p = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			t[i][i] = 0;
			p[i][i] = true;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2) {
					p[i][j] = str[i] == str[j];
				} else {
					p[i][j] = str[i] == str[j] && p[i + 1][j - 1];
				}

				if (p[i][j]) {
					t[i][j] = 0;
					// System.out.println(i + "-" + j);

				} else {
					t[i][j] = Integer.MAX_VALUE;
					for (int k = i; k <= j - 1; k++) {
						int m = 1 + t[i][k] + t[k + 1][j];
						if (m < t[i][j]) {
							t[i][j] = m;
						}
					}
				}
			}
		}

		return t[0][n - 1];
	}

	public int minCutsForPalindromePartitionsBruteForce(char[] str, int i, int n) {
		if (i == n)
			return 0;

		if (isPal(str, i, n)) {

			// System.out.println(i + "-" + n);
			return 0;
		} else {
			/**
			 * TODO: should make more cuts*
			 * 
			 */
			return 1 + min(minCutsForPalindromePartitionsBruteForce(str, i + 1, n),
					minCutsForPalindromePartitionsBruteForce(str, i, n - 1));
		}
	}

	private int min(int a, int b) {
		return a < b ? a : b;
	}

	public boolean isPal(char[] str, int begin, int end) {
		int middle = (begin + end) / 2;

		for (int i = begin; i <= middle; i++, end--) {
			if (str[i] != str[end]) {
				return false;
			}
		}
		return true;
	}

}
