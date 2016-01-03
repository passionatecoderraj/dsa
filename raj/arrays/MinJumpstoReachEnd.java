package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */

public class MinJumpstoReachEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		// int a[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };

		int result = -1;
		MinJumpstoReachEnd obj = new MinJumpstoReachEnd();
		result = obj.minJumpsToReachEnd(a);
		System.out.println(result);
	}

	public int minJumpsToReachEnd(int[] a) {
		int n = a.length;
		if (n <= 0)
			return -1;

		int result[] = new int[n];
		int t[] = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = Integer.MAX_VALUE;
			result[i] = -1;
		}
		t[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j + a[j] >= i) {
					if (1 + t[j] < t[i]) {
						t[i] = 1 + t[j];
						result[i] = j;
					}
				}
			}
		}
		printSolution(result, n - 1);
		System.out.println();
		return t[n - 1];
	}

	public void printSolution(int[] result, int i) {
		if (i == -1) {
			return;
		} else {
			printSolution(result, result[i]);
			System.out.print(i + "-->");
		}

	}

}
