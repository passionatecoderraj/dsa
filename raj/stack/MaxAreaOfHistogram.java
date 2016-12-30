package com.raj.stack;

import java.util.Stack;

public class MaxAreaOfHistogram {

	public static void main(String[] args) {
		MaxAreaOfHistogram obj = new MaxAreaOfHistogram();
		// int a[] = { 2, 1, 2, 3, 1 };
		// int a[] = { 2, 1, 4, 5, 1, 3, 3 };
		int a[] = { 6, 2, 5, 4, 5, 1, 6 };
		int result = -1;
		result = obj.maxAreaOfHistogram(a);
		System.out.println(result);
	}

	public int maxAreaOfHistogram(int[] a) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = -1, area;
		int i = 0;
		while (i < a.length) {
			if (stack.isEmpty() || a[i] >= a[stack.peek()]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					area = a[top] * i;
				} else {
					area = a[top] * (i - stack.peek() - 1);
				}
				maxArea = Math.max(area, maxArea);
			}
		}

		return maxArea;
	}

}
