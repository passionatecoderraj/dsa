package com.raj.leetcode.google;

import java.util.Stack;

public class BasicCalculator3 {
	
	
   public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>(); // the stack that stores numbers
        Stack<Character> ops = new Stack<>(); // the stack that stores operators (including parentheses)
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
            	int num = c - '0';
                // iteratively calculate each number
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // do the math when we encounter a ')' until '('
                while (ops.peek() != '(') nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                ops.pop(); // get rid of '(' in the ops stack
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(c, ops.peek())) nums.push(operation(ops.pop(), nums.pop(),nums.pop()));
                ops.push(c);
            }
        }
//        System.out.println(nums);
//        System.out.println(ops);
        while (!ops.isEmpty()) {
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b; // assume b is not 0
        }
        return 0;
    }
    // helper function to check precedence of current operator and the uppermost operator in the ops stack 
    private static boolean precedence(char op1, char op2) {
    	 if (op2 == '(') return false;
         if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
         return true;
    }
    
	public static void main(String[] args) {
		int res = -1;

		String expr = "";
		
		
		expr = " 2-1 + 2 ";
		res = calculate(expr);
		System.out.println(res);
		
		expr = " 6-4 / 2 ";
		res = calculate(expr);
		System.out.println(res);
	
		expr = "2*(5+5*2)/3+(6/2+8)";
		res = calculate(expr);
		System.out.println(res);
	
		expr = "(2+6* 3+5- (3*14/7+2)*5)+3";
		res = calculate(expr);
		System.out.println(res);
		
		
	}
}