/**
 *
 */
package com.raj.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 * 
 * 
 *         Given an array of words and a length L, format the text such that
 *         each line has exactly L characters and is fully (left and right)
 *         justified.
 * 
 *         You should pack your words in a greedy approach; that is, pack as
 *         many words as you can in each line. Pad extra spaces ' ' when
 *         necessary so that each line has exactly L characters.
 * 
 *         Extra spaces between words should be distributed as evenly as
 *         possible. If the number of spaces on a line do not divide evenly
 *         between words, the empty slots on the left will be assigned more
 *         spaces than the slots on the right.
 * 
 *         For the last line of text, it should be left justified and no extra
 *         space is inserted between words.
 * 
 *         For example, words: ["This", "is", "an", "example", "of", "text",
 *         "justification."] L: 16.
 * 
 *         Return the formatted lines as: [ "This    is    an",
 *         "example  of text", "justification.  " ] Note: Each word is
 *         guaranteed not to exceed L in length.
 */
public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {
		List<String> lines = new ArrayList<String>();

		int start = 0;
		while (start < words.length) {
			int lenSoFar = words[start].length();
			int end = start + 1;
			while (end < words.length) {
				if (lenSoFar + 1 + words[end].length() > L)
					break;
				lenSoFar += 1 + words[end].length();
				end++;
			}

			StringBuilder sb = new StringBuilder();
			int count = end - start;
			// if last line or number of words in the line is 1, left-justified
			if (end == words.length || count == 1) {
				for (int i = start; i < end; i++) {
					sb.append(words[i] + " ");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append(getNSpaces(L - sb.length()));
			} else {

				int reqSpaces = L - lenSoFar;

				int r = reqSpaces % (count - 1);
				// middle justified
				for (int i = start; i < end; i++, r--) {
					sb.append(words[i]);
					if (i != end - 1) {
						// below it's n+1,extra +1 comes from 'default counted
						// space from above'
						int n = (reqSpaces / (count - 1)) + (r > 0 ? 1 : 0);
						sb.append(getNSpaces(1 + n));
					}
				}
			}
			lines.add(sb.toString());
			start = end;
		}

		return lines;
	}

	public List<String> fullJustify2(String[] words, int L) {
		List<String> lines = new ArrayList<String>();

		int start = 0;
		while (start < words.length) {
			int lenSoFar = words[start].length();
			int end = start + 1;
			while (end < words.length) {
				if (lenSoFar + 1 + words[end].length() > L)
					break;
				lenSoFar += 1 + words[end].length();
				end++;
			}

			StringBuilder sb = new StringBuilder();
			int count = end - start;
			// if last line or number of words in the line is 1, left-justified
			if (end == words.length || count == 1) {
				for (int i = start; i < end; i++) {
					sb.append(words[i] + " ");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append(getNSpaces(L - sb.length()));
			} else {

				int reqSpaces = L - lenSoFar;

				// middle justified
				for (int i = start; i < end; i++) {
					sb.append(words[i]);

					if (i != end - 1) {
						int r = reqSpaces % (count - 1);
						int n = (r == 0) ? (reqSpaces / (count - 1)) : (reqSpaces / (count - 1)) + 1;
						// below it's n+1,extra +1 comes from 'default counted
						// space from above'
						sb.append(getNSpaces(n + 1));
						reqSpaces -= n;
						count--;
					}
				}
			}
			lines.add(sb.toString());
			start = end;
		}

		return lines;
	}

	private String getNSpaces(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		TextJustification obj = new TextJustification();
		String sentence[] = { "This", "is", "an", "example", "of", "text", "justification." };
		List<String> res = null;
		int maxWidth = 16;
		res = obj.fullJustify(sentence, maxWidth);
		System.out.println(res);
		String a[] = { "a", "b", "c", "d", "e" };
		res = obj.fullJustify(a, 3);
		System.out.println(res);

		String b[] = { "Here", "is", "an", "example", "of", "text", "justification." };
		res = obj.fullJustify(b, 16);
		System.out.println(res);

	}

}
