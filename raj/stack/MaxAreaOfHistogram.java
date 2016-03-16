package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxAreaOfHistogram {

	public static void main(String[] args) {
		MaxAreaOfHistogram obj = new MaxAreaOfHistogram();
		// int a[] = { 2, 1, 2, 3, 1 };
		int a[] = { 2, 1, 4, 5, 1, 3, 3 };
		int result = -1;
		result = obj.maxAreaOfHistogram(a);
		System.out.println(result);
	}

	public int maxAreaOfHistogram(int[] a) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxArea = -1;
		int top, area, i = 0;
		while (i < a.length) {
			if (stack.isEmpty() || a[i] >= a[stack.peekFirst()]) {
				stack.offerFirst(i);
				i++;
			} else {
				top = stack.pollFirst();
				if (stack.isEmpty())
					area = a[top] * i;
				else
					area = a[top] * (i - stack.peekFirst() - 1);
				maxArea = Math.max(area, maxArea);
			}
		}

		while (!stack.isEmpty()) {
			top = stack.removeFirst();
			if (stack.isEmpty())
				area = a[top] * i;
			else
				area = a[top] * (i - stack.peekFirst() - 1);
			maxArea = Math.max(area, maxArea);
		}

		return maxArea;
	}

}
