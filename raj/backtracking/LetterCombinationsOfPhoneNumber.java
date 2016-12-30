package com.raj.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LetterCombinationsOfPhoneNumber {

	public void letterCombinations(int digits) {
		letterCombinationsUtil(Integer.toString(digits), 0, new StringBuilder());
		System.out.println();
	}

	public void letterCombinationsUtil(String digits, int cur, StringBuilder sb) {
		if (cur == digits.length()) {
			System.out.print(sb.toString() + " ");
			return;
		}
		int d = digits.charAt(cur) - '0';
		String str = map.get(d);
		for (char ch : str.toCharArray()) {
			sb.append(ch);
			letterCombinationsUtil(digits, cur + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public void letterCombinationsUsingQueue(int dgts) {
		String digits = Integer.toString(dgts);
		Queue<String> q = new LinkedList<>();
		q.add("");
		for (int i = 0; i < digits.length(); i++) {
			int d = digits.charAt(i) - '0';
			while (q.peek().length() == i) {
				String t = q.poll();
				for (char ch : map.get(d).toCharArray()) {
					q.add(t + ch);
				}
			}
		}
		System.out.println(q);
	}

	public void letterCombinationsUsingQueueMethod2(int dgts) {
		String digits = Integer.toString(dgts);
		if (null == digits || digits.length() == 0)
			return;
		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();
		Queue<String> temp;
		int d = digits.charAt(0) - '0';
		for (char ch : map.get(d).toCharArray()) {
			q1.add(Character.toString(ch));
		}

		for (int i = 1; i < digits.length(); i++) {
			d = digits.charAt(i) - '0';
			while (!q1.isEmpty()) {
				String t = q1.poll();
				for (char ch : map.get(d).toCharArray()) {
					q2.add(t + ch);
				}
			}
			// swap q1 and q2
			temp = q1;
			q1 = q2;
			q2 = temp;
		}
		System.out.println(q1);
	}

	Map<Integer, String> map = new HashMap<>();

	public LetterCombinationsOfPhoneNumber() {
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}

	public static void main(String args[]) {
		LetterCombinationsOfPhoneNumber obj = new LetterCombinationsOfPhoneNumber();
		int digits = 234;
		obj.letterCombinations(digits);
		obj.letterCombinationsUsingQueue(digits);
		obj.letterCombinationsUsingQueueMethod2(digits);
	}

}
