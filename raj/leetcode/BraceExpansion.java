/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author Raj 
 * 
 * A string S represents a list of words.

Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.  If there is more than one option, then curly braces delimit the options.  For example, "{a,b,c}" represents options ["a", "b", "c"].

For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].

Return all words that can be formed in this manner, in lexicographical order.

 

Example 1:

Input: "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]
Example 2:

Input: "abcd"
Output: ["abcd"]
 

Note:

1 <= S.length <= 50
There are no nested curly brackets.
All characters inside a pair of consecutive opening and ending curly brackets are different.
 */
public class BraceExpansion {

	public String[] expand(String s) {
		List<String> res = new ArrayList<>();
		dfs(0, s, new StringBuilder(), res);
		return res.toArray(new String[res.size()]);
	}

	private void dfs(int i, String s, StringBuilder sb, List<String> res) {
		if (i == s.length()) {
			res.add(sb.toString());
			return;
		}
		char ch = s.charAt(i);

		if (ch != '{') {
			sb.append(ch);
			dfs(i + 1, s, sb, res);
		} else {
			int cur_length = sb.length();
			List<Character> list = new ArrayList<>();
			i++;
			while (i < s.length() && s.charAt(i) != '}') {
				char c = s.charAt(i++);
				if (Character.isLetter(c))
					list.add(c);
			}
			Collections.sort(list);
			for (char c : list) {
				sb.append(c);
				dfs(i + 1, s, sb, res);
				sb.setLength(cur_length);
			}
		}
	}

	public String[] expand2(String s) {
		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '{') {
				addToList(q, s.charAt(i) + "");
			} else {
				int j = i + 1;
				while (j < s.length() && s.charAt(j) != '}')
					j++;
				String sub = s.substring(i + 1, j);
				String a[] = sub.split(",");
				Queue<String> q1 = new LinkedList<>(q);
				for (int k = 0; k < a.length; k++) {
					if (k == 0) {
						addToList(q, a[k]);
					} else {
						Queue<String> q2 = new LinkedList<>(q1);
						addToList(q2, a[k]);
						q.addAll(q2);
					}
				}

				i = j;
			}
		}
		TreeSet<String> ts = new TreeSet<>(q);

		return ts.toArray(new String[0]);
	}

	private void addToList(Queue<String> q, String ch) {
		if (q.isEmpty()) {
			q.offer(ch);
		} else {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				q.offer(q.poll() + ch);
			}
		}
	}

	public static void main(String[] args) {
		BraceExpansion obj = new BraceExpansion();
		String[] res = null;
		res = obj.expand("{a,b}c{d,e}f");
		System.out.println(Arrays.toString(res));

	}

}
