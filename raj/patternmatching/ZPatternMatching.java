package com.raj.patternmatching;

import com.interivew.graph.CommonUtil;

public class ZPatternMatching {

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		// String pat = "aabxaayaab";
		ZPatternMatching obj = new ZPatternMatching();

		obj.patternMatch(pat.toCharArray(), txt.toCharArray());

		String p = "aabxaabxcaabxaabxay";
		int m = p.length();
		int z[] = new int[m];
		makeZ(p.toCharArray(), m, z);
		CommonUtil.printArray(z);
	}

	public static void makeZ(char[] p, int m, int[] z) {
		int l, r;
		l = r = 0;
		z[0] = 0;
		for (int i = 1; i < m; i++) {
			if (i > r) {
				l = r = i;
				while (r < m && p[r] == p[r - l]) {
					r++;
				}
				z[i] = r - l;
				r--;
			} else {
				int n = r - i + 1;
				int k = i - l;
				if (z[k] >= n) {
					l = i;
					while (r < m && p[r] == p[r - l]) {
						r++;
					}
					z[i] = r - l;
					r--;
				} else {
					z[i] = z[k];
				}
			}
		}
	}

	public int patternMatch(char[] p, char[] t) {
		int m = p.length, n = t.length;
		int z[] = new int[m + 1 + n];
		char a[] = new char[m + 1 + n];
		for (int i = 0; i < m + 1 + n; i++) {
			if (i < m) {
				a[i] = p[i];
			} else if (i == m) {
				a[i] = '$';
			} else {
				a[i] = t[i - m - 1];
			}
		}
		makeZOn(a, m + 1 + n, z);
		CommonUtil.printArray(a);

		CommonUtil.printArray(z);
		for (int i = 0; i < m + n + 1; i++) {
			if (z[i] == m) {
				System.out.println("Pattern found at " + (i - m - 1));
				return i - m - 1;
			}
		}
		System.out.println("Pattern Not found");

		return -1;
	}

	public void makeZOn(char[] s, int n, int[] z) {
		int l, r;
		l = r = 0;
		z[0] = 0;
		for (int i = 1; i < n; i++) {
			if (i > r) {
				l = r = i;
				while (r < n && s[r] == s[r - l]) {
					r++;
				}
				z[i] = r - l;
				r--;
			} else {
				int k = i - l;

				if (r - i + 1 > z[k]) {
					z[i] = z[k];
				} else {
					l = i;
					while (r < n && s[r] == s[r - l]) {
						r++;
					}
					z[i] = r - l;
					r--;
				}
			}

		}
	}

	public void makeZOn2(char[] p, int m, int[] z) {
		int k, j;
		z[0] = 0;
		for (int i = 1; i < m; i++) {
			k = i;
			j = 0;
			while (k < m && p[k] == p[j]) {
				k++;
				j++;
			}
			z[i] = j;
		}
	}

}
