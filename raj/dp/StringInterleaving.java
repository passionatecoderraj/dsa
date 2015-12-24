package com.raj.dp;

import com.interivew.graph.CommonUtil;

public class StringInterleaving {

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
