package com.raj.string;

public class KMP {

	int f[];

	public static void main(String[] args) {
		String txt = "bacbabababacaca";
		String pat = "ababaca";
		KMP obj = new KMP();
		System.out.println(obj.kmp(pat.toCharArray(), txt.toCharArray()));
	}

	void makePrefixArray(char[] p) {
		int i = 1, j = 0, m = p.length;

		f = new int[m];
		f[0] = 0;

		while (i < m) {
			if (p[i] == p[j]) {
				f[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = f[j - 1];
			} else {
				f[i] = 0;
				i++;
			}
		}
	}

	int kmp(char[] pattern, char[] text) {
		makePrefixArray(pattern);
		int m = pattern.length, n = text.length;
		int i = 0, j = 0;
		while (i < n) {
			if (text[i] == pattern[j]) {
				if (j == m - 1) {
					return i - j;
				} else {
					i++;
					j++;
				}
			} else if (j > 0) {
				j = f[j - 1];
			} else {
				i++;
			}
		}
		return -1;
	}
}
