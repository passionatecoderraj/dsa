/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 *         Given an array of n integers nums and a target, find the number of
 *         index triplets i, j, k with 0 <= i < j < k < n that satisfy the
 *         condition nums[i] + nums[j] + nums[k] < target.
 * 
 *         For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 *         Return 2. Because there are two triplets which sums are less than 2:
 * 
 *         [-2, 0, 1] [-2, 0, 3] Follow up: Could you solve it in O(n2) runtime?
 */
public class Find3SumSmaller {

	public static int threeSumSmaller(int[] a, int k) {
		if (a.length < 3) {
			return 0;
		}
		int count = 0;
		Arrays.sort(a);
		for (int i = 0; i < a.length - 2; i++) {
			int l = i + 1, r = a.length - 1;
			while (l < r) {
				if (a[i] + a[l] + a[r] < k) {
					/*
					 * If we know that nums[i] + nums[lo] + nums[hi] < target,
					 * then we know that since the array is sorted, we can
					 * replace hi with any element from lo+1 to nums.length-1,
					 * and the requirements will still be met. Just like in the
					 * example above, we know that since -2 + 0 + 3 < 2, we can
					 * replace hi (3) with 1, and it would still work.
					 */
					count += (r - l);
					l++;
				} else {
					r--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 12, 6, 10, 8 };
		int res = -1, k = 22;
		// Time : O(n2)
		res = threeSumSmaller(a, k);
		System.out.println(res);

		int a2[] = { -2, 0, 1, 3 };
		res = threeSumSmaller(a2, 2);
		System.out.println(res);

		int a3[] = { -2,-1, 0, 1,2, 3 };
		res = threeSumSmaller(a3, 2);
		System.out.println(res);

	}

}
