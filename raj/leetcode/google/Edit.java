package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 *
 *         Given two words word1 and word2, find the minimum number of
 *         operations required to convert word1 to word2.
 * 
 *         You have the following 3 operations permitted on a word:
 * 
 *         Insert a character Delete a character Replace a character Example 1:
 * 
 *         Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse ->
 *         rorse (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros
 *         (remove 'e') Example 2:
 * 
 *         Input: word1 = "intention", word2 = "execution" Output: 5
 *         Explanation: intention -> inention (remove 't') inention -> enention
 *         (replace 'i' with 'e') enention -> exention (replace 'n' with 'x')
 *         exention -> exection (replace 'n' with 'c') exection -> execution
 *         (insert 'u')
 * 
 */
public class Edit {

	//https://leetcode.com/problems/edit-distance/discuss/25846/20ms-Detailed-Explained-C++-Solutions-(O(n)-Space)
	// Time : O(m*n), Space : O(n)
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int t[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			t[i] = i;
		for (int i = 1; i <= m; i++) {
			int prev = t[0];
			t[0] = i;
			for (int j = 1; j <= n; j++) {
				int temp = t[j];
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					t[j] = prev;
				} else {
					t[j] = 1 + Math.min(prev, Math.min(t[j], t[j - 1]));
				}
				prev = temp;
			}
		}
		return t[n];
	}

	// Time : O(m*n), Space : O(m*n)
	public int minDistance2(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int t[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			t[i][0] = i;
		}
		for (int j = 1; j <= n; j++) {
			t[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1];
				} else {
					t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i][j - 1], t[i - 1][j]));
				}
			}
		}
		return t[m][n];
	}

	public static void main(String[] args) {
		String x = "horse";
		String y = "ros";
		Edit obj = new Edit();

		int result = -1;

		result = obj.minDistance(x, y);
		System.out.println(result);

		result = obj.minDistance("intention", "execution");
		System.out.println(result);

		result = obj.minDistance("plasma", "altruism");
		System.out.println(result);

	}

	public int minDistance3(String word1, String word2) {
		if (null == word1 && null == word2)
			return 0;
		if (null == word1 && null != word2) {
			return word2.length();
		}
		if (null != word1 && null == word2) {
			return word1.length();
		}

		if (0 == word1.length() && 0 == word2.length())
			return 0;
		if (0 == word1.length() && 0 != word2.length())
			return word2.length();
		if (0 != word1.length() && 0 == word2.length())
			return word1.length();
		if (word1.equals(word2)) {
			return 0;
		}
		int t[][] = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			t[i][0] = i;
		}
		for (int i = 0; i <= word2.length(); i++) {
			t[0][i] = i;
		}

		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				t[i][j] = Math.min(t[i - 1][j - 1], Math.min(t[i - 1][j], t[i][j - 1]));
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					t[i][j] = 1 + t[i][j];
				}
			}
		}
		return t[word1.length()][word2.length()];
	}

	public int editBottomUp(char[] x, char[] y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			t[i][0] = i;
		}
		for (int i = 0; i <= n; i++) {
			t[0][i] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					t[i][j] = t[i - 1][j - 1];
				} else {
					t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i][j - 1], t[i - 1][j]));
				}
			}
		}
		// CommonUtil.print2DArray(t, m + 1, n + 1);
		return t[m][n];
	}

	public int editBruteForce(char[] x, char[] y, int i, int j) {
		if (i == 0 && j == 0)
			return 0;
		else if (i == 0 && j > 0) {
			return j;
		} else if (i > 0 && j == 0) {
			return i;
		} else if (x[i - 1] == y[j - 1])
			return editBruteForce(x, y, i - 1, j - 1);
		else {
			return 1 + min(editBruteForce(x, y, i - 1, j - 1), editBruteForce(x, y, i - 1, j),
					editBruteForce(x, y, i, j - 1));
		}
	}

	private int min(int a, int b, int c) {
		int min = a;
		if (b < min)
			min = b;
		if (c < min)
			min = c;
		return min;
	}

}
