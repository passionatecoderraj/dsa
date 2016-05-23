package com.raj.leetcode;

import com.interivew.graph.CommonUtil;

/*
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * 
 * http://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
 * 
 *For example,
	Given s = "the sky is blue",
	return "blue is sky the".
 */
public class ReverseWordsInString {

	public static void main(String args[]) {
		ReverseWordsInString s = new ReverseWordsInString();
		String string = "the sky is blue";
		String result = s.reverseWordInString(string);
		System.out.println(result);
		string = "the sky is blue";
		result = s.reverseWordInStringWithOutExtraSpace(string.toCharArray());
		System.out.println(result);
	}

	// Time :O(n), Space :O(k) k words
	public String reverseWordInString(String string) {
		String[] tokens = string.split("\\s");
		StringBuilder sb = new StringBuilder();
		for (int i = tokens.length - 1; i >= 0; i--) {
			sb.append(tokens[i]);
			if (i != 0)
				sb.append(" ");
		}
		return sb.toString();
	}

	// Time :O(n), Space :O(k) k words
	public String reverseWordInStringWithOutExtraSpace(char a[]) {
		if (null == a)
			return null;
		if (0 == a.length)
			return "";
		int l = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == ' ') {
				reverse(a, l, i - 1);
				l = i + 1;
			}
		}
		reverse(a, l, a.length - 1);
		reverse(a, 0, a.length - 1);
		return String.valueOf(a);
	}

	private void reverse(char[] a, int l, int r) {
		while (l < r) {
			CommonUtil.swap(a, l++, r--);
		}
	}
}