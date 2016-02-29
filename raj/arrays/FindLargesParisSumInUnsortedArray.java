/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
/*
 * Given an unsorted of distinct integers, find the largest pair sum in it.
 */
public class FindLargesParisSumInUnsortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindLargesParisSumInUnsortedArray obj = new FindLargesParisSumInUnsortedArray();
		int a[] = { 12, 34, 10, 6, 40 };
		int n = a.length, result = -1;
		
		// Time : O(n), Space : O(1)
		result = obj.findLargestPairSumInArray(a, n);
		System.out.println(result);
	}

	public int findLargestPairSumInArray(int[] a, int n) {

		if (n <= 2)
			return -1;

		int firstmax, secondmax;
		secondmax = Integer.MIN_VALUE;
		firstmax = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] > firstmax) {
				secondmax = firstmax;
				firstmax = a[i];
			}
			else if (a[i] > secondmax) {
				secondmax = a[i];
			}
		}

		System.out.println("1st=" + firstmax + ",2nd=" + secondmax);
		return firstmax + secondmax;
	}

}
