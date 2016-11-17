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

	private static boolean isSame(int[] a1, int[] a2) {
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i]) {
				return false;
			}
		}
		return true;
	}

	public static int searchAnagramSubstring(String text, String pattern) {
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
	}
}
