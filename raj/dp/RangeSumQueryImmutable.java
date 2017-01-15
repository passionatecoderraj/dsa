/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 *         Given an integer array nums, find the sum of the elements between
 *         indices i and j (i ≤ j), inclusive.
 * 
 *         Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 *         sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3
 */
public class RangeSumQueryImmutable {

	static int a[];

	public static void numArray(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i];
		}
		a = arr;
	}

	public static int sumRange(int i, int j) {
		if (0 == i)
			return a[j];
		return a[j] - a[i - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { -2, 0, 3, -5, 2, -1 };
		numArray(a);
		int res = Integer.MIN_VALUE;
		res = sumRange(0, 2);
		System.out.println(res);
		res = sumRange(2, 5);
		System.out.println(res);
		res = sumRange(0, 5);
		System.out.println(res);

	}

}
