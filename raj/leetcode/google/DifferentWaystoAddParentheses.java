package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Raj
 * 
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 *
 */
public class DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String s) {
		List<Integer> res = new ArrayList<>();
		String operators = "+-*";
		for (int i = 0; i < s.length(); i++) {
			char op = s.charAt(i);
			if (operators.contains(op + "")) {
				List<Integer> left = diffWaysToCompute(s.substring(0, i));
				List<Integer> right = diffWaysToCompute(s.substring(i + 1));
				for (int lvalue : left) {
					for (int rvalue : right) {
						res.add(value(lvalue,rvalue,op));
					}
				}
			}
		}
		if (res.isEmpty()) {
			res.add(Integer.parseInt(s));
		}
		return res;
	}

	private int value(int lval,int rval,char op){
		switch (op) {
		case '+':
			return lval+rval;
		case '-':
			return lval-rval;
		case '*':
			return lval*rval;
		}
		return 0;
	}
	  
	public static void main(String... args) {
		DifferentWaystoAddParentheses obj = new DifferentWaystoAddParentheses();
		List<Integer> res = null;
		String input = "";

		input = "2-1-1";
		res = obj.diffWaysToCompute(input);
		System.out.println(res);

		input = "2*3-4*5";
		res = obj.diffWaysToCompute(input);
		System.out.println(res);

	}
}