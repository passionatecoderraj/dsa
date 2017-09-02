package com.raj.patternmatching;

import com.interview.graph.CommonUtil;

public class KMP {

	int f[];

	public static void main(String[] args) {
		// String txt = "bacbabababacaca";
		// String pat = "ababaca";

		String txt = "ABABDABACDABABCABAB";
		String pat = "ABACBCABA";
		KMP obj = new KMP();
		obj.kmp(txt.toCharArray(), pat.toCharArray());
		System.out.println(obj.kmp(pat));
	}

	private String kmp(String s) {
		int len = s.length();
		int[] LPS = new int[len];

		int i = 1, j = 0;
		LPS[0] = 0;
		while (i < len) {
			if (s.charAt(i) == s.charAt(j)) {
				LPS[i++] = ++j;
			} else if (j == 0) {
				LPS[i++] = 0;
			} else {
				j = LPS[j - 1];
			}
		}

		int patternLen = len - LPS[len - 1];
		if (patternLen != len && len % patternLen == 0) {
			return s.substring(0, patternLen);
		} else {
			return s;
		}
	}

	public void kmp(char[] t, char[] p) {
		System.out.println(t.length);
		int m = p.length;
		int n = t.length;
		int f[] = new int[m];
		makePrefixArray(p, f.length, f);
		CommonUtil.printArray(f);

		int i = 0, j = 0;
		while (i < n) {
			if (t[i] == p[j]) {
				if (j == m - 1) {
					System.out.println("Pattern found at " + (i - j));
					return;
				}
				i++;
				j++;
			} else if (j > 0) {
				j = f[j - 1];
			} else {
				j = 0;
				i++;
			}
		}
		System.out.println("Pattern Not found");

	}

	public void makePrefixArray(char[] p, int m, int f[]) {
		int i = 1, j = 0;
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
}
