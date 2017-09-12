/**
 * 
 */
package com.raj.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 *
 */
public class SearchAnagramSubstrings {

	public static int searchAnagramSubstring(String text, String pattern) {
		int anagramsCount = 0;
		if (pattern.length() > text.length())
			return anagramsCount;

		int t[] = new int[26];
		int p[] = new int[26];
		for (int i = 0; i < pattern.length(); i++) {
			t[text.charAt(i) - 'A']++;
			p[pattern.charAt(i) - 'A']++;
		}
		int count = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] == p[i]) {
				count++;
			}
		}
		for (int i = pattern.length(); i < text.length(); i++) {
			if (count == 26) {
				System.out.print(i - pattern.length() + " ");
				anagramsCount++;
				System.out.println(text.substring(i - pattern.length(), i));
			}
			int r = text.charAt(i) - 'A';
			int l = text.charAt(i - pattern.length()) - 'A';
			t[r]++;
			if (t[r] == p[r]) {
				count++;
			} else if (t[r] - 1 == p[r]) {
				count--;
			}

			t[l]--;
			if (t[l] == p[l]) {
				count++;
			} else if (t[l] + 1 == p[l]) {
				count--;
			}
		}
		if (count == 26) {
			anagramsCount++;
			System.out.print(text.length() - pattern.length() + " ");
			System.out.println(text.substring(text.length() - pattern.length()));
		}
		return anagramsCount;
	}

	private static boolean isSame(int[] a1, int[] a2) {
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i]) {
				return false;
			}
		}
		return true;
	}

	public static int searchAnagramSubstring2(String text, String pattern) {
		int count = 0;
		int n = text.length();
		int m = pattern.length();
		List<Integer> list = new ArrayList<>();

		if (n < m | m == 0 | m == 0) {
			return 0;
		}

		int textHist[] = new int[256];
		int patHist[] = new int[256];

		// initial histogram window of size m
		for (int i = 0; i < m; i++) {
			patHist[pattern.charAt(i)]++;
			textHist[text.charAt(i)]++;
		}
		int i = m;
		for (; i < n; i++) {
			if (isSame(textHist, patHist)) {
				System.out.println("anagram found : " + text.substring(i - m, i));
				count++;
				list.add(i - m);
			}
			textHist[text.charAt(i)]++;
			textHist[text.charAt(i - m)]--;
		}

		if (isSame(textHist, patHist)) {
			System.out.println("anagram found : " + text.substring(i - m, i));
			list.add(i - m);
			count++;
		}
		System.out.println(list);
		return count;
	}

	public static void main(String args[]) {
		String txt = "BACDGABCDA";
		String pat = "ABCD";
		int count = searchAnagramSubstring(txt, pat);
		System.out.println(count);
		searchAnagramSubstring2(txt, pat);
	}
}
