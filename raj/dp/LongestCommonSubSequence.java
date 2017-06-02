package com.raj.dp;

public class LongestCommonSubSequence {

	public int lcsBruteForce(String a, String b, int i, int j) {
		if (i == 0 || j == 0)
			return 0;
		if (a.charAt(i - 1) == b.charAt(j - 1))
			return 1 + lcsBruteForce(a, b, i - 1, j - 1);

		return Math.max(lcsBruteForce(a, b, i - 1, j), lcsBruteForce(a, b, i, j - 1));
	}

	public int lcsBottomUp(String a, String b) {
		if (null == a || null == b)
			return 0;

		int[][] t = new int[a.length() + 1][b.length() + 1];

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
				}
			}
		}
		return t[a.length()][b.length()];
	}

	public static void main(String[] args) {
		String x = "agccat";
		String y = "acgct";
		LongestCommonSubSequence obj = new LongestCommonSubSequence();
		int result = obj.lcsBruteForce(x, y, x.length(), y.length());
		System.out.println(result);
		result = obj.lcsBottomUp(x, y);
		System.out.println(result);

	}

}
