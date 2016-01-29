package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;

import com.interivew.graph.CommonUtil;

public class StockSpan {

	public static void main(String[] args) {
		StockSpan obj = new StockSpan();

		int a[] = { 100, 80, 60, 70, 60, 75, 85 };
		int n = a.length;
		obj.calculateSpan(a, n);
	}

	public void calculateSpan(int[] a, int n) {
		if (n <= 0)
			return;

		int t[] = new int[n];
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && a[i] >= a[stack.peekFirst()]) {
				stack.pop();
			}

			if (stack.isEmpty())
				t[i] = i + 1;
			else
				t[i] = i - stack.peekFirst();

			stack.push(i);
		}

		CommonUtil.printArray(t);
	}
}
