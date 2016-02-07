package com.raj.stack;

import java.util.Deque;
import java.util.LinkedList;

import com.interivew.graph.CommonUtil;

/*
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day
 */
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
