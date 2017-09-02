package com.interview.twosigmainvestments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

	private static Stack<Integer> stack = new Stack<>();
	private static Deque<Integer> dq = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = 0;
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			superStack(str);
		}
	}

	private static void superStack(String op) {
		String sp[] = op.split(" ");

		if (sp[0].equals("push")) {
			stack.push(Integer.parseInt(sp[1]));
			dq.addLast(Integer.parseInt(sp[1]));
		} else if (sp[0].equals("pop")) {
			if (!stack.isEmpty())
				stack.pop();
			if (!dq.isEmpty())
				dq.removeLast();
		} else if (sp[0].equals("inc")) {
			int x = Integer.parseInt(sp[1]);
			int d = Integer.parseInt(sp[2]);
			Stack<Integer> temp = new Stack<>();

			while (!stack.isEmpty()) {
				temp.push(stack.pop());
			}
			x = Math.min(x, stack.size());

			for (int i = 0; i < x; i++) {
				if (!temp.isEmpty()) {
					stack.push(temp.pop() + d);
				}
				while (!temp.isEmpty()) {
					stack.push(temp.pop());
				}
				int j = 0;
				for (Iterator itr = dq.iterator(); itr.hasNext() && j < x;) {
					int k = dq.removeFirst();
					dq.addFirst(k + d);
				}
			}
		}
		// if (stack.isEmpty()) {
		// System.out.println("EMPTY");
		//
		// } else {
		// System.out.println(stack.peek());
		// }

		if (dq.isEmpty()) {
			System.out.println("EMPTY");

		} else {
			System.out.println(dq.peekLast());
		}
	}

	public void fun(String[] a) {
		int len = 0;
		for (String st : a) {
			int i = st.lastIndexOf(" ");

			if (i == -1) {
				System.out.println(st + getSpaces(len - st.length()));
			} else {
				System.out.print(st.substring(0, i));
				System.out.println(getSpaces(len - st.length()));
				System.out.println(st.substring(i + 1, st.length()));
			}
		}
	}

	private String getSpaces(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++)
			sb.append(" ");
		return sb.toString();
	}
}
