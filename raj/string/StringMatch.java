package com.raj.string;

public class StringMatch {

	public static void main(String[] args) {
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		StringMatch obj = new StringMatch();
		// obj.BruteForceMatch(pat.toCharArray(), txt.toCharArray());
		// obj.BruteForceMatch2(pat.toCharArray(), txt.toCharArray());
		pat = "ABCD";
		txt = "ABCEABCDABCEABCD";
		obj.bruteForceWhenAllCharsOfPatternDifferent(pat.toCharArray(), txt.toCharArray());
	}

	public void bruteForceWhenAllCharsOfPatternDifferent(char[] p, char[] t) {
		int m = p.length, n = t.length;
		int j;
		for (int i = 0; i < n - m + 1;) {
			boolean isFailed = false;
			for (j = 0; j < m && !isFailed; j++) {
				if (t[i + j] != p[j]) {
					isFailed = true;
				}
			}

			if (!isFailed) {
				// System.out.println("Pattern found at " + i);
				i = i + m;
			} else if (j == 0) {
				i++;
			} else {
				i = i + j;
			}
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void BruteForceMatch2(char[] p, char[] t) {
		int n = p.length, m = t.length;
		for (int i = 0; i < m - n + 1; i++) {
			boolean isFailed = false;
			for (int j = 0; j < n && !isFailed; j++) {
				if (t[i + j] != p[j]) {
					isFailed = true;
				}
			}
			if (!isFailed) {
				System.out.println("Pattern found at " + i);
			}
		}

	}

	int BruteForceMatch(char[] pattern, char[] text) {
		int m = pattern.length;
		int n = text.length;

		for (int i = 0; i <= n - m; i++) {

			int j = 0;
			while (j < m && text[i + j] == pattern[j]) {
				j++;
			}
			if (j == m) {
				System.out.println("Pattern found at " + i);
			}
		}
		return -1;
	}

}
