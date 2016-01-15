/**
 * 
 */
package com.raj.dp.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Raj
 *
 */
/*
 * Given an input string and a dictionary of words, find out if the input string
 * can be segmented into a space-separated sequence of dictionary words.
 */
public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean result = false;
		String str = "iamace";
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("i");
		dictionary.add("a");
		dictionary.add("am");
		dictionary.add("ace");

		WordBreak obj = new WordBreak();
		// Time : O(n3), Space: O(n2)
		result = obj.wordBreak(str, str.length(), dictionary);
		System.out.println(result);
		// TODO: Time : O(n2) from geeksforgeeks

	}

	public boolean wordBreak(String str, int n, Set<String> dictionary) {
		boolean t[][] = new boolean[n][n];

		for (int l = 1; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (dictionary.contains(str.substring(i, j + 1))) {
					t[i][j] = true;
				} else {
					for (int k = i; k <= j; k++) {
						t[i][j] = t[i][j] || (t[i][k] && t[k + 1][j]);
					}
				}
			}
		}
		return t[0][n - 1];
	}

}
