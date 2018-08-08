package com.raj.arrays;

/**
 * 
 * @author Raj
 *
 *         Given a list of words and two words word1 and word2, return the
 *         shortest distance between these two words in the list.
 * 
 *         For example, Assume that words = ["practice", "makes", "perfect",
 *         "coding", "makes"].
 * 
 *         Given word1 = �coding�, word2 = �practice�, return 3. Given word1 =
 *         "makes", word2 = "coding", return 1.
 * 
 *         Note: You may assume that word1 does not equal to word2, and word1
 *         and word2 are both in the list.
 * 
 *         Show Company Tags Show Tags Show Similar Problems
 * 
 */
public class ShortestWordDistance {
	
	public static int shortestDistance(String[] words, String word1, String word2) {
		int pre = -1, min = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			String cur = words[i];
			if (cur.equals(word1) || cur.equals(word2)) {
				if (pre == -1) {
					pre = i;
				}
				else {
					if (!cur.equals(words[pre])) {
						min = Math.min(i - pre, min);
					}
					pre = i;
				}
			}
		}
		return min;
	}
	
	public static int shortestDistance2(String[] words, String word1, String word2) {
		int pre = -1, min = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			String cur = words[i];
			if (cur.equals(word1) || cur.equals(word2)) {
				if (pre == -1) {
					pre = i;
					continue;
				}
				if (cur.equals(word1) && words[pre].equals(word2)) {
					min = Math.min(i - pre, min);
				} else if (cur.equals(word2) && words[pre].equals(word1)) {
					min = Math.min(i - pre, min);
				}
				pre = i;
			}
		}
		return min;
	}

	public static void main(String args[]) {
		String words[] = { "practice", "makes", "perfect", "coding", "makes" };
		int res = shortestDistance(words, "practice", "coding");
		System.out.println(res);
	}
}