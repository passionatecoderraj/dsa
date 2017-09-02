package com.raj.dp;

import com.interview.graph.CommonUtil;

public class WildcardMatching {

	public static void main(String[] args) {
		String pattern = "**x*y**z";
		String text = "xaylmz";

		WildcardMatching obj = new WildcardMatching();
		boolean result = false;

		result = obj.isWildcardMatch(text, pattern);
		System.out.println(result);

	}

	private boolean isWildcardMatch(String text, String pattern) {

		char pat[] = pattern.toCharArray();
		char txt[] = text.toCharArray();

		int left = 0;
		char prev = pat[left++];
		// replace a**b with a*b
		for (int i = 1; i < pat.length; i++) {
			if (pat[i] == '*') {
				if (prev != '*') {
					pat[left++] = pat[i];
					prev = pat[i];
				}
			} else {
				pat[left++] = pat[i];
				prev = pat[i];
			}
		}

		boolean[][] t = new boolean[txt.length + 1][left + 1];
		t[0][0] = true;

		if (pat[0] == '*') {
			t[0][1] = true;
		}

		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				if (pat[j - 1] == '?' || pat[j - 1] == txt[i - 1]) {
					t[i][j] = t[i - 1][j - 1];
				} else if (pat[j - 1] == '*') {
					t[i][j] = t[i][j - 1] || t[i - 1][j];
				}
			}
		}
		CommonUtil.print2DArray(t, t.length, t[0].length);
		return t[t.length - 1][t[0].length - 1];
	}
}
