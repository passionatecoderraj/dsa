package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
	//https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
	public static List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		util(result, "", 0, 0, n);
		return result;
	}

	public static void util(ArrayList<String> result, String s, int open, int close, int max) {
		if (s.length() == max * 2) {
			result.add(s);
			return;
		}

		if (open < max) {
			util(result, s + "(", open + 1, close, max);
		}

		if (open > close) {
			util(result, s + ")", open, close + 1, max);
		}
	}

	public static List<String> generateParenthesis2(int n) {
		ArrayList<String> result = new ArrayList<String>();
		dfs(result, "", n, n);
		return result;
	}

	/*
	 * left and right represents the remaining number of ( and ) that need to be
	 * added. When left > right, there are more ")" placed than "(". Such cases are
	 * wrong and the method stops.
	 */
	public static void dfs(ArrayList<String> result, String s, int left, int right) {
		if (left > right)
			return;

		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}

		if (left > 0) {
			dfs(result, s + "(", left - 1, right);
		}

		if (right > 0) {
			dfs(result, s + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {

		List<String> res = generateParenthesis(2);
		System.out.println(res);
	}
}