package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 *
 *         Given two strings S and T, return if they are equal when both are
 *         typed into empty text editors. # means a backspace character.
 * 
 *         Example 1:
 * 
 *         Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T
 *         become "ac". Example 2:
 * 
 *         Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T
 *         become "". Example 3:
 * 
 *         Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T
 *         become "c". Example 4:
 * 
 *         Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c"
 *         while T becomes "b". Note:
 * 
 *         1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain
 *         lowercase letters and '#' characters. Follow up:
 * 
 *         Can you solve it in O(N) time and O(1) space?
 */
public class BullsAndCows {

	// Time :O(n), Space: O(1)
	public String getHint(String secret, String guess) {
		int t[] = new int[10];
		int bulls = 0, cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				if (t[secret.charAt(i) - '0']++ < 0) {
					cows++;
				}
				if (t[guess.charAt(i) - '0']-- > 0) {
					cows++;
				}
			}
		}
		return bulls + "A" + cows + "B";
	}

	public static void main(String[] args) {
		BullsAndCows obj = new BullsAndCows();
		String result = null;
		String secret = "", guess = "";

		secret = "1807";
		guess = "7810";
		result = obj.getHint(secret, guess);
		System.out.println(result);

		secret = "1123";
		guess = "0111";
		result = obj.getHint(secret, guess);
		System.out.println(result);

	}

}
