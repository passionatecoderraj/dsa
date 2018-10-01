package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 *
 *         Given an array of integers nums, write a method that returns the
 *         "pivot" index of this array.
 * 
 *         We define the pivot index as the index where the sum of the numbers
 *         to the left of the index is equal to the sum of the numbers to the
 *         right of the index.
 * 
 *         If no such index exists, we should return -1. If there are multiple
 *         pivot indexes, you should return the left-most pivot index.
 * 
 *         Example 1: Input: nums = [1, 7, 3, 6, 5, 6] Output: 3 Explanation:
 *         The sum of the numbers to the left of index 3 (nums[3] = 6) is equal
 *         to the sum of numbers to the right of index 3. Also, 3 is the first
 *         index where this occurs. Example 2: Input: nums = [1, 2, 3] Output:
 *         -1 Explanation: There is no index that satisfies the conditions in
 *         the problem statement. Note:
 * 
 *         The length of nums will be in the range [0, 10000]. Each element
 *         nums[i] will be an integer in the range [-1000, 1000].
 */
public class FindPivotIndex {

	// Time : O(n), Space : O(1)
	public int pivotIndex(int[] a) {
		int sum = 0;
		for (int n : a)
			sum += n;
		int lsum = 0;
		for (int i = 0; i < a.length; i++) {
			if (lsum == sum - lsum - a[i])
				return i;
			lsum += a[i];
		}
		return -1;
	}

	// Time : O(n), Space : O(1)
	public int pivotIndex2(int[] a) {
		int rsum = 0;
		for (int n : a)
			rsum += n;
		int lsum = 0;
		for (int i = 0; i < a.length; i++) {
			rsum -= a[i];
			if (lsum == rsum)
				return i;
			lsum += a[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		FindPivotIndex obj = new FindPivotIndex();
		int a[] = { 1, 7, 3, 6, 5, 6 };
		int result = -1;
		result = obj.pivotIndex(a);
		System.out.println(result);
	}

}
