/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj Suppose you have N integers from 1 to N. We define a beautiful
 *         arrangement as an array that is constructed by these N numbers
 *         successfully if one of the following is true for the ith position (1
 *         <= i <= N) in this array:
 * 
 *         The number at the ith position is divisible by i. i is divisible by
 *         the number at the ith position. Now given N, how many beautiful
 *         arrangements can you construct?
 * 
 *         Example 1: Input: 2 Output: 2 Explanation:
 * 
 *         The first beautiful arrangement is [1, 2]:
 * 
 *         Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * 
 *         Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * 
 *         The second beautiful arrangement is [2, 1]:
 * 
 *         Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * 
 *         Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 *         Note: N is a positive integer and will not exceed 15.
 */
public class VerifyinganAlienDictionary {

	/*
	 * Assume this is the verification normal alphabets
	 * 
	 * https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/203185/JavaC++Python-Mapping-to-Normal-Order
	 * look for comment
	 */
	public boolean isAlienSorted(String[] words, String order) {
		int t[] = new int[26];
		for (int i = 0; i < order.length(); i++) {
			t[order.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < words.length - 1; i++) {
			if (!isSorted(words[i], words[i + 1], t))
				return false;
		}
		return true;
	}

	private boolean isSorted(String s1, String s2, int[] t) {
		for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
			int idx1 = t[s1.charAt(i) - 'a'], idx2 = t[s2.charAt(i) - 'a'];
			if (idx1 > idx2) {
				return false;
			} else if (idx1 < idx2) {
				return true;
			}
		}
		/*
		 * if code reach here there is only one possibility that both strings are equal
		 * until their lengths are equal.
		 * 
		 * ex : hel, hello, then smaller length string should come first
		 * 
		 */
		return s1.length() <= s2.length();
	}

	public static void main(String[] args) {
		VerifyinganAlienDictionary obj = new VerifyinganAlienDictionary();

		boolean res = false;

		res = obj.isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz");
		System.out.println(res);

		res = obj.isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz");
		System.out.println(res);

		res = obj.isAlienSorted(new String[] { "apple", "app" }, "abcdefghijklmnopqrstuvwxyz");
		System.out.println(res);
	}
}
