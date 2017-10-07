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

				// middle justified
				for (int i = start; i < end; i++) {
					sb.append(words[i]);

					if (i != end - 1) {
						int r = reqSpaces % (count - 1);
						int n = (r == 0) ? (reqSpaces / (count - 1)) : (reqSpaces / (count - 1)) + 1;
						// below it's n+1,extra +1 comes from 'default counted space from above'
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

	public List<String> fullJustify3(String[] words, int L) {
		List<String> lines = new ArrayList<String>();

		int index = 0;
		while (index < words.length) {
			int count = words[index].length();
			int last = index + 1;
			while (last < words.length) {
				if (words[last].length() + count + 1 > L)
					break;
				count += words[last].length() + 1;
				last++;
			}

			StringBuilder builder = new StringBuilder();
			int diff = last - index - 1;
			// if last line or number of words in the line is 1, left-justified
			if (last == words.length || diff == 0) {
				for (int i = index; i < last; i++) {
					builder.append(words[i] + " ");
				}
				builder.deleteCharAt(builder.length() - 1);
				for (int i = builder.length(); i < L; i++) {
					builder.append(" ");
				}
			} else {
				// middle justified
				int spaces = (L - count) / diff;
				int r = (L - count) % diff;
				for (int i = index; i < last; i++) {
					builder.append(words[i]);
					if (i < last - 1) {
						for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
							builder.append(" ");
						}
					}
				}
			}
			lines.add(builder.toString());
			index = last;
		}

		return lines;
	}

	public List<String> fullJustify2(String[] words, int maxWidth) {
		List<String> lines = new ArrayList<>();
		List<String> result = new ArrayList<>();
		String s = String.join(" ", words) + " ";

		if (s.length() == 1) {
			result.add(getNSpaces(maxWidth));
			return result;
		}

		int start = 0, end = 0;
		int l = s.length();
		while (start < l - 1) {
			end = start + maxWidth;
			if (s.charAt(end % l) == ' ') {
				lines.add(s.substring(start, Math.min(l - 1, end)));
				start = end + 1;
			} else {
				while (start < end && s.charAt(end % l) != ' ') {
					end--;
				}
				lines.add(s.substring(start, Math.min(l - 1, end)));
				start = end + 1;
			}
		}

		// System.out.println(lines);
		for (int j = 0; j < lines.size(); j++) {
			String line = lines.get(j);
			String a[] = line.split(" ");
			StringBuilder op = new StringBuilder();
			if (a.length == 1) {
				op.append(a[0]);
				op.append(getNSpaces(maxWidth - a[0].length()));
			} else if (j == lines.size() - 1) {
				for (String st : a) {
					op.append(st);
					op.append(" ");
				}
				op.deleteCharAt(op.length() - 1);
				op.append(getNSpaces(maxWidth - op.length()));
			} else {
				int curL = 0;
				for (int i = 0; i < a.length; i++) {
					curL += a[i].length();
				}
				int count = a.length;
				int reqSpaces = maxWidth - curL;
				for (String st : a) {
					op.append(st);
					if (count > 1) {
						int t = reqSpaces / (count - 1);
						int n = (reqSpaces % (count - 1) == 0) ? t : (t + 1);
						op.append(getNSpaces(n));
						reqSpaces -= n;
						count--;
					}
				}
			}
			result.add(op.toString());
		}

		return result;
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
