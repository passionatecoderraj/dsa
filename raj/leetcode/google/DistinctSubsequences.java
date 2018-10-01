/**
 * 
 */
package com.raj.leetcode.google;

/**
 * @author Raj
 *
 *         The problem gives two strings, S and T, count the number of distinct
 *         subsequences of T in S. The problem is a bit of ambiguous. It
 *         actually asks that how many distinct subsequences of S which is equal
 *         to T.
 * 
 * 
 *         Here is an example: S = "rabbbit", T = "rabbit" Return 3.
 * 
 *         each time you remove b from rabbbit it forms rabbit so, total 3 ways
 */
public class DistinctSubsequences {

	// Time:O(S*T), Space:O(S*T)
	public static int numOfDistinctSequencesOfSInT(String S, String T) {
		int t[][] = new int[S.length() + 1][T.length() + 1];
		t[0][0] = 1;
		for (int i = 1; i <= S.length(); i++) {
			t[i][0] = 1;
		}
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					t[i][j] = t[i - 1][j] + t[i - 1][j - 1];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[S.length()][T.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String S = "rabbbit", T = "rabbit";
		int res = -1;
		res = numOfDistinctSequencesOfSInT(S, T);
		System.out.println(res);
	}

}
