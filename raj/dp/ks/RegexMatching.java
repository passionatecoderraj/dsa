package com.raj.dp.ks;

public class RegexMatching {

	public static void main(String[] args) {
		String pattern = "xa*b.c";
		String text = "xaabyc";

		RegexMatching obj = new RegexMatching();
		boolean result = false;

		result = obj.isRegexMatch(text, pattern);
		System.out.println(result);

	}

	private boolean isRegexMatch(String text, String pattern) {

		boolean[][] t = new boolean[text.length()][pattern.length()];
		t[0][0] = true;

		for (int i = 1; i < text.length(); i++) {
			for (int j = 1; j < pattern.length(); j++) {
				if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
					t[i][j] = t[i - 1][j - 1];
				} else if (pattern.charAt(j - 1) == '*') {
					t[i][j] = t[i][j - 2];
					if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
						t[i][j] = t[i][j] || t[i - 1][j];
					}
				}
			}
		}
		return t[t.length - 1][t[0].length - 1];
	}

}
