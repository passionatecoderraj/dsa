/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 *         Given a rows x cols screen and a sentence represented by a list of
 *         words, find how many times the given sentence can be fitted on the
 *         screen. Note: A word cannot be split into two lines. The order of
 *         words in the sentence must remain unchanged. Two consecutive words in
 *         a line must be separated by a single space. Total words in the
 *         sentence won't exceed 100. Length of each word won't exceed 10. 1 ≤
 *         rows, cols ≤ 20,000.
 */
public class SentenceScreenFiltering {

	// Time : O(rows * Lw), Lw = max Length of the word
	// https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution
	public static int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		int start = 0, l = s.length();
		for (int i = 0; i < rows; i++) {
			start += cols;
			if (s.charAt(start % l) == ' ') {
				start++;
			} else {
				while (start > 0 && s.charAt((start - 1) % l) != ' ') {
					start--;
				}
			}
		}

		return start / s.length();
	}

	// Time : O(r*c), Space : O(1)
	public static int sentenceScreenFiltering(String[] sentence, int rows, int cols) {
		int r = 0, c = 0, i = 0, count = 0;
		while (r < rows) {
			c = 0;
			while (c < cols) {
				int wordLen = sentence[i].length();
				int remainingCols = cols - c;
				if (remainingCols >= wordLen) {
					i++;
					if (i == sentence.length) {
						i = 0;
						count++;
					}
					c = c + wordLen + 1;
				} else {
					break;
				}
			}
			r++;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sentence[] = { "a", "bcd", "e" };
		int res = -1;
		int rows = 3, cols = 6;
		res = sentenceScreenFiltering(sentence, rows, cols);
		System.out.println(res);

		String s2[] = { "I", "had", "apple", "pie" };
		res = sentenceScreenFiltering(s2, 4, 5);
		System.out.println(res);

		String s3[] = { "abc", "de", "f" };
		res = wordsTyping(s3, 4, 6);
		System.out.println(res);

	}

}
