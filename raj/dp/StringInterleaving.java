package com.raj.dp;

import com.interivew.graph.CommonUtil;

public class StringInterleaving {

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;

		boolean t[][] = new boolean[s1.length() + 1][s2.length() + 1];

		t[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
				t[i][0] = true;
			}
		}
		for (int j = 1; j <= s2.length(); j++) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
				t[0][j] = true;
			}
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
					t[i][j] = t[i - 1][j];
				} else if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					t[i][j] = t[i][j - 1];
				}
			}
		}

		return t[s1.length()][s2.length()];
	}

	public static void main(String[] args) {

		String a = "aab";
		String b = "axy";
		String c = "aaxaby";

		// String a = "XXY";
		// String b = "XXZ";
		// String c = "XXXXZY";

		boolean result;
		StringInterleaving obj = new StringInterleaving();
		result = obj.isStringsInterleavedDp(a.toCharArray(), b.toCharArray(), c.toCharArray());
		System.out.println(result);
		result = obj.stringInterLeaving(a.toCharArray(), b.toCharArray(), c.toCharArray());
		System.out.println(result);

		result = isInterleave(a, b, c);
		System.out.println(result);
	}

	public boolean stringInterLeaving(char a[], char b[], char c[]) {
		int m = a.length, n = b.length;
		if (m + n != c.length)
			return false;
		boolean t[][] = new boolean[m + 1][n + 1];

		t[0][0] = true;
		for (int i = 1; i <= n; i++) {
			if (c[i - 1] == a[i - 1]) {
				t[0][i] = t[0][i - 1];
			}
		}

		for (int i = 1; i <= m; i++) {
			if (c[i - 1] == b[i - 1]) {
				t[i][0] = t[i - 1][0];
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (c[i + j - 1] == a[j - 1]) {
					t[i][j] = t[i][j - 1];
				} else if (c[i + j - 1] == b[i - 1]) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = false;
				}

			}
		}
		CommonUtil.print2DArray(t, m + 1, n + 1);

		return t[m][n];
	}

	public boolean isStringsInterleavedDp(char[] a, char[] b, char[] c) {
		if (a.length + b.length != c.length)
			return false;

		int m = b.length, n = a.length;

		boolean[][] t = new boolean[m + 1][n + 1];
		t[0][0] = true;

		for (int j = 1; j < n + 1; j++) {
			if (a[j - 1] == c[j - 1]) {
				t[0][j] = t[0][j - 1];
			} else {
				t[0][j] = false;
			}
		}

		for (int i = 1; i < m + 1; i++) {
			if (b[i - 1] == c[i - 1]) {
				t[i][0] = t[i - 1][0];
			} else {
				t[i][0] = false;
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (a[j - 1] == c[i + j - 1]) {
					t[i][j] = t[i][j - 1];
				} else if (b[i - 1] == c[i + j - 1]) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = false;
				}
			}
		}
		CommonUtil.print2DArray(t, m + 1, n + 1);

		return t[m][n];
	}

}
