/**
 * 
 */
package com.raj.arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */

/*
 * pair-sum array for arr[0..n-1] is {arr[0]+arr[1], arr[0]+arr[2], …….,
 * arr[1]+arr[2], arr[1]+arr[3], ……., arr[2]+arr[3], arr[2]+arr[4], ….,
 * arr[n-2]+arr[n-1}.
 */
public class ConstructArrayFromPairSumArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// int pairs[] = { 14, 9, 10, 11, 12, 7 };
		// int n = 4;
		// int a[] = new int[4];

		int pairs[] = { 15, 13, 11, 10, 12, 10, 9, 8, 7, 5 };
		int n = 5;
		int[] a = new int[n];
		ConstructArrayFromPairSumArray obj = new ConstructArrayFromPairSumArray();
		// Time: O(n), Space : O(1)
		obj.constructArrayFromPairSumArray(pairs, a, n);
		CommonUtil.printArray(a);
	}

	// we can observe that arr[0] is half of pair[0] + pair[1] – pair[n-1]. Note
	// that the value of pair[0] + pair[1] – pair[n-1] is (arr[0] + arr[1]) +
	// (arr[0] + arr[2]) – (arr[1] + arr[2]).

	// Time: O(n), Space : O(1)
	public void constructArrayFromPairSumArray(int[] pairs, int[] a, int n) {
		a[0] = (pairs[0] + pairs[1] - pairs[n - 1]) / 2;
		for (int i = 1; i < n; i++) {
			a[i] = pairs[i - 1] - a[0];
		}
	}
}
