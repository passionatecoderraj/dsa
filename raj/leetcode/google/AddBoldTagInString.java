/**
 * 
 */
package com.raj.leetcode.google;

import java.util.Arrays;

/**
 * @author Raj
 *Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].
 */
public class AddBoldTagInString {

	// Time : O(n*m), Space : O(1)
	public String addBoldTag(String s, String[] dict) {
		StringBuilder res = new StringBuilder();
		int start = 0, end = -1;
		for (int cur = 0; cur < s.length(); cur++) {
			for (String w : dict) {
				if (s.startsWith(w, cur)) {
					end = Math.max(end, cur + w.length());
				}
			}
			if (end == cur) {
				res.append("<b>");
				res.append(s.substring(start, end));
				res.append("</b>");
			}
			if (end <= cur) {
				res.append(s.charAt(cur));
				start = cur + 1;
			}
		}
		if (end == s.length()) {
			res.append("<b>");
			res.append(s.substring(start, end));
			res.append("</b>");
		}
		return res.toString();
	}

	// Time : O(n*m), Space : O(n)
	public String addBoldTag2(String s, String[] dict) {
		boolean[] t = new boolean[s.length()];
		for (int cur = 0, end = 0; cur < s.length(); cur++) {
			for (String w : dict) {
				if (s.startsWith(w, cur)) {
					end = Math.max(end, cur + w.length());
				}
			}
			t[cur] = end > cur;
		}
		System.out.println(Arrays.toString(t));
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < t.length;) {
			if (!t[i]) {
				res.append(s.charAt(i++));
				continue;
			}
			int start = i;
			while (i < t.length && t[i])
				i++;
			res.append("<b>");
			res.append(s.substring(start, i));
			res.append("</b>");
		}
		return res.toString();
	}

	public static void main(String[] args) {
		AddBoldTagInString obj = new AddBoldTagInString();
		String result = null;
		String str = "abcxyz123";
		result = obj.addBoldTag(str, new String[] { "abc", "123" });
		System.out.println(result);

		str = "aaabbcc";
		result = obj.addBoldTag(str, new String[] { "aaa", "aab", "bc" });
		System.out.println(result);
	}

}
