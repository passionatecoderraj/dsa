/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 *
 *         There is a brick wall in front of you. The wall is rectangular and
 *         has several rows of bricks. The bricks have the same height but
 *         different width. You want to draw a vertical line from the top to the
 *         bottom and cross the least bricks.
 * 
 *         The brick wall is represented by a list of rows. Each row is a list
 *         of integers representing the width of each brick in this row from
 *         left to right.
 * 
 *         If your line go through the edge of a brick, then the brick is not
 *         considered as crossed. You need to find out how to draw the line to
 *         cross the least bricks and return the number of crossed bricks.
 * 
 *         You cannot draw a line just along one of the two vertical edges of
 *         the wall, in which case the line will obviously cross no bricks.
 * 
 *         Example: Input: [[1,2,2,1], [3,1,2], [1,3,2], [2,4], [3,1,2],
 *         [1,3,1,1]] Output: 2 Explanation:
 * 
 *         Note: The width sum of bricks in different rows are the same and
 *         won't exceed INT_MAX. The number of bricks in each row is in range
 *         [1,10,000]. The height of wall is in range [1,10,000]. Total number
 *         of bricks of the wall won't exceed 20,000.
 * 
 */
public class ExpressiveWords {
	/*
	 * As far as I can see, the requirements are as follows:
	 * 
	 * If a letter is not repeated in a word in the words list, the stretched word
	 * must contain either one such letter, or three or more such letters, but not
	 * two such letters. If a letter is repeated once (two same consecutive
	 * letters), the stretched word must contain two or more such letters.
	 */
	// https://leetcode.com/problems/expressive-words/discuss/122660/C++JavaPython-2-Pointers-and-4-pointers
	public int expressiveWords(String s, String[] words) {
		int res = 0;
		for (String w : words) {
			if (check(s, w))
				res++;
		}
		String []a;
		System.arraycopy(src, srcPos, dest, destPos, length);
		return res;
	}

	private boolean check(String s, String w) {
		int m = s.length(), j = 0, n = w.length();
		for (int i = 0; i < m; i++) {
			if (j < n && s.charAt(i) == w.charAt(j))
				j++;
			else if (i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2))
				;
			else if (i > 0 && i < m - 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1))
				;
			else
				return false;
		}
		return j == n;
	}

	// https://leetcode.com/problems/expressive-words/solution/
	/*
	 * Now, let's say we have individual counts c1 = S.count[i] and c2 =
	 * word.count[i].
	 * 
	 * If c1 < c2, then we can't make the ith group of word equal to the ith word of
	 * S by adding characters.
	 * 
	 * If c1 >= 3, then we can add letters to the ith group of word to match the ith
	 * group of S, as the latter is extended.
	 * 
	 * Else, if c1 < 3, then we must have c2 == c1 for the ith groups of word and S
	 * to match.
	 */
	public int expressiveWords2(String s, String[] words) {
		RLE s_rle = new RLE(s);
		int res = 0;
		search: for (String w : words) {
			RLE w_rle = new RLE(w);
			if (!s_rle.sb.toString().equals(w_rle.sb.toString()))
				continue;
			for (int i = 0; i < s_rle.sb.length(); i++) {
				int s1 = s_rle.count.get(i);
				int w1 = w_rle.count.get(i);
				if ((s1 < 3 && s1 != w1) || s1 < w1)
					continue search;
			}
			res++;
		}
		return res;
	}

	class RLE {
		List<Integer> count;
		StringBuilder sb;

		public RLE(String s) {
			count = new ArrayList<>();
			sb = new StringBuilder();
			calculate(s);
		}

		private void calculate(String s) {
			if (s.isEmpty())
				return;
			int cnt = 1;
			char prev = s.charAt(0);
			for (int i = 1; i < s.length(); i++) {
				char cur = s.charAt(i);
				if (prev == cur) {
					cnt++;
				} else {
					sb.append(prev);
					count.add(cnt);
					prev = cur;
					cnt = 1;
				}
			}
			sb.append(prev);
			count.add(cnt);
		}
	}

	public static void main(String[] args) {
		ExpressiveWords obj = new ExpressiveWords();
		String words[] = { "hello", "hi", "helo" };
		String S = "heeellooo";
		int res = obj.expressiveWords(S, words);
		System.out.println(res);
	}

}
