package com.raj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/remove-comments/description/
 *
 */
public class RemoveComments {
	
	// https://leetcode.com/articles/remove-comments/
	public List<String> removeComments(String[] source) {
		List<String> res = new ArrayList<>();
		boolean inMultiLineComment = false;
		StringBuilder sb = new StringBuilder();
		for (String str : source) {
			if (!inMultiLineComment) {
				sb.setLength(0);
			}
			for (int i = 0; i < str.length();) {
				if (inMultiLineComment && i + 1 < str.length() && str.charAt(i) == '*' && str.charAt(i + 1) == '/') {
					inMultiLineComment = false;
					i++;
				} else if (!inMultiLineComment && i + 1 < str.length() && str.charAt(i) == '/'
						&& str.charAt(i + 1) == '*') {
					inMultiLineComment = true;
					i++;
				} else if (!inMultiLineComment && i + 1 < str.length() && str.charAt(i) == '/'
						&& str.charAt(i + 1) == '/') {
					break;
				} else if (!inMultiLineComment) {
					sb.append(str.charAt(i));
				}
				i++;
				
			}
			if (!inMultiLineComment && sb.length() > 0) {
				res.add(sb.toString());
			}
		}
		return res;
	}

	public static void main(String... args) {
		RemoveComments obj = new RemoveComments();
		List<String> res = null;

		String[] src = { "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
				"/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" };
		res = obj.removeComments(src);
		System.out.println(res);

		String src1[] = { "a/*comment", "line", "more_comment*/b" };

		res = obj.removeComments(src1);
		System.out.println(res);

	}
}