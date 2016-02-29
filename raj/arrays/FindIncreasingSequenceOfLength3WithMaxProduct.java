/**
 * 
 */
package com.raj.arrays;

import java.util.Stack;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 * 
 */
/*
 * Given a sequence of non-negative integers, find the subsequence of length 3
 * having maximum product with the numbers of the subsequence being in ascending
 * order.
 */
public class FindIncreasingSequenceOfLength3WithMaxProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindIncreasingSequenceOfLength3WithMaxProduct obj = new FindIncreasingSequenceOfLength3WithMaxProduct();
		int a[] = { 1, 5, 10, 8, 9 };
		// int a[] = { 6, 7, 8, 1, 2, 3, 9, 9, 9 };
		int n = a.length;

		// Time : O(n), Space:O(n)
		obj.findIncreasingSequenceOfLength3WithMaxProduct(a, n);

	}

	public void findIncreasingSequenceOfLength3WithMaxProduct(int[] a, int n) {
		if (n < 3)
			return;
		// The largest smaller element on left of given element
		int lsl[] = new int[n];
		// The largest greater element on right of given element.
		int lgr[] = new int[n];

		int max = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] > max) {
				max = a[i];
				lgr[i] = -1;
			} else {
				lgr[i] = max;
			}
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (lgr[i] == -1) {
				lsl[i] = -1;
				continue;
			}
			max = -1;
			while (!stack.isEmpty() && a[i] > stack.peek()) {
				max = stack.pop();
			}
			lsl[i] = max;
			stack.push(a[i]);
		}

		CommonUtil.printArray(lsl);
		CommonUtil.printArray(a);
		CommonUtil.printArray(lgr);
		int maxProduct = 0, curProd = 0;
		int b, c, d;
		b = c = d = 0;
		for (int i = 0; i < n; i++) {
			curProd = lsl[i] * lgr[i] * a[i];
			if (curProd > maxProduct) {
				maxProduct = curProd;
				b = lsl[i];
				c = a[i];
				d = lgr[i];
			}
		}
		System.out.println("1st=" + b + ",2nd=" + c + ",3rd=" + d);
	}

}
