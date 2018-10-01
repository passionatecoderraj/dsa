package com.raj.leetcode.google;

import java.util.Arrays;

/**
 * 
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note: The length of A and B will be between 1 and 10000.
 *
 *
 */
public class RepeatedStringMatch {

	// https://leetcode.com/problems/repeated-string-match/discuss/108084/C++-4-lines-O(m-*-n)-or-O(1)-and-7-lines-KMP-O(m-+-n)-or-O(n)
	// Time : O(m+n), Space : O(n)
	public int repeatedStringMatch(String a, String b) {
		int t[] = new int[b.length()];
		makePrefixArray(b, t);
		//System.out.println(Arrays.toString(t));
		for (int i = 0,j=0; i < a.length(); i++,j=0) {
			while (j < b.length()) {
				if (a.charAt((i + j) % a.length()) == b.charAt(j)) {
					j++;
				} else if (j > 0) {
					j = t[j - 1];
				} else {
					j=0;
					break;
				}
			}
			if (j == b.length()) {
				return ((i + j) / a.length()) + ((i + j) % a.length() == 0 ? 0 : 1);
			}

		}
		return -1;

	}

	private void makePrefixArray(String b, int[] t) {
		int i = 1, j = 0;
		while (i < b.length()) {
			if (b.charAt(i) == b.charAt(j)) {
				t[i++] = j++ + 1;
			} else if (j > 0) {
				j = t[j - 1];
			} else {
				j = 0;
				i++;
			}
		}

	}

	// https://leetcode.com/problems/repeated-string-match/discuss/108084/C++-4-lines-O(m-*-n)-or-O(1)-and-7-lines-KMP-O(m-+-n)-or-O(n)
	// Time : O(m*n), Space : O(1)
	public int repeatedStringMatch2(String a, String b) {
		for (int i = 0, j = 0; i < a.length(); i++,j=0) {
			while (j < b.length() && a.charAt((i + j) % a.length()) == b.charAt(j)) {
				j++;
			}
			if (j == b.length()) {
				return ((i + j) / a.length()) + ((i + j) % a.length() == 0 ? 0 : 1);
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		String a = "abcd";
		String b = "cdabcdab";
		RepeatedStringMatch obj = new RepeatedStringMatch();
		int res = -1;
		res = obj.repeatedStringMatch(a, b);
		System.out.println(res);
		res = obj.repeatedStringMatch("aabaabaac","aabaac");
		System.out.println(res);
		
	}

}
