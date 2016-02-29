package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @Author Raj
 * 
 */
/*
 * Given an array of integers, update every element with multiplication of
 * previous and next elements with following exceptions. a) First element is
 * replaced by multiplication of first and second. b) Last element is replaced
 * by multiplication of last and second last.
 */
public class ReplaceWithLeftRightMultiplication {

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 5, 6 };
		int n = a.length;
		ReplaceWithLeftRightMultiplication obj = new ReplaceWithLeftRightMultiplication();

		// Time : O(n), Space: O(1) ; traverse from reverse
		obj.replaceWithLeftRightMultiplication(a, n);
		CommonUtil.printArray(a);

	}

	/*
	 * Given an array of integers, update every element with multiplication of
	 * previous and next elements with following exceptions. a) First element is
	 * replaced by multiplication of first and second. b) Last element is
	 * replaced by multiplication of last and second last.
	 */
	public void replaceWithLeftRightMultiplication(int[] a, int n) {
		if (n <= 1)
			return;
		int cur, prev;

		prev = a[0];
		a[0] = a[0] * a[1];

		for (int i = 1; i < n - 1; i++) {
			cur = a[i];
			a[i] = prev * a[i + 1];
			prev = cur;
		}
		a[n - 1] = a[n - 1] * prev;
	}
}
