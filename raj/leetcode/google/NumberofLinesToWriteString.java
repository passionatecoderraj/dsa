package com.raj.leetcode.google;

import java.util.Arrays;

/**
 * 
 * @author Raj
 * 
 *         We are to write the letters of a given string S, from left to right
 *         into lines. Each line has maximum width 100 units, and if writing a
 *         letter would cause the width of the line to exceed 100 units, it is
 *         written on the next line. We are given an array widths, an array
 *         where widths[0] is the width of 'a', widths[1] is the width of 'b',
 *         ..., and widths[25] is the width of 'z'.
 * 
 *         Now answer two questions: how many lines have at least one character
 *         from S, and what is the width used by the last such line? Return your
 *         answer as an integer list of length 2.
 * 
 * 
 * 
 *         Example : Input: widths =
 *         [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 *         S = "abcdefghijklmnopqrstuvwx	yz" Output: [3, 60] Explanation: All
 *         letters have the same length of 10. To write all 26 letters, we need
 *         two full lines and one line with 60 units. Example : Input: widths =
 *         [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 *         S = "bbbcccdddaaa" Output: [2, 4] Explanation: All letters except 'a'
 *         have the same length of 10, and "bbbcccdddaa" will cover 9 * 10 + 2 *
 *         4 = 98 units. For the last 'a', it is written on the second line
 *         because there is only 2 units left in the first line. So the answer
 *         is 2 lines, plus 4 units in the second line.
 * 
 * 
 *         Note:
 * 
 *         The length of S will be in the range [1, 1000]. S will only contain
 *         lowercase letters. widths is an array of length 26. widths[i] will be
 *         in the range of [2, 10].
 *
 * 
 */
public class NumberofLinesToWriteString {

	public int[] numberOfLines(int[] widths, String S) {
		int lines = 1, cur = 0;
		for (char ch : S.toCharArray()) {
			int width = widths[ch - 'a'];
			lines = (cur + width) > 100 ? lines + 1 : lines;
			cur = (cur + width) > 100 ? width : (cur + width);
		}
		return new int[] { lines, cur };
	}

	public int[] numberOfLines2(int[] widths, String S) {
		int[] res = new int[2];
		int i = 0, r = 100, lines = 0;
		while (i < S.length()) {
			lines++;
			r = 100;
			while (i < S.length() && r >= widths[S.charAt(i) - 'a']) {
				r -= widths[S.charAt(i) - 'a'];
				i++;
			}
		}
		res[0] = lines;
		res[1] = 100 - r;
		return res;
	}

	public static void main(String[] args) {
		NumberofLinesToWriteString obj = new NumberofLinesToWriteString();
		int[] result = null;

		int[] widths = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10 };
		String s = "abcdefghijklmnopqrstuvwxyz";

		result = obj.numberOfLines(widths, s);
		System.out.println(Arrays.toString(result));

		int[] widths2 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10, 10 };
		String s2 = "bbbcccdddaaa";
		result = obj.numberOfLines(widths2, s2);
		System.out.println(Arrays.toString(result));

	}

}
