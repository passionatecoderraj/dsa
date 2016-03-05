package com.raj.string;

import com.interivew.graph.CommonUtil;

/*
 * Given a string s, form a shortest palindrome by appending characters at the start of the string
 * abab = babab, ananab = bananab
 */
public class ShortestPalindrome {

	int f[];

	public static void main(String[] args) {

		String result = null, str = "ananab";
		ShortestPalindrome obj = new ShortestPalindrome();
		result = obj.shortestPalindrome(str);
		System.out.println(result);
	}

	public String shortestPalindrome(String s) {
		String rev_s = new StringBuffer(s).reverse().toString();
		String l = s + "#" + rev_s;

		// prefix array , kmp logic
		int f[] = new int[l.length()];
		makePrefixArray(l.toCharArray(), f, l.length());
		CommonUtil.printArray(f);
		return rev_s.substring(0, s.length() - f[l.length() - 1]) + s;
	}

	public void makePrefixArray(char[] a, int[] f, int n) {
		int i = 1, j = 0;
		while (i < n) {
			if (a[i] == a[j]) {
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

	public String reverse(char[] a, int n) {
		int l = 0, r = n - 1 - 1;
		while (l < r) {
			CommonUtil.swap(a, l, r);
			l++;
			r--;
		}
		return new String(a);
	}

}
