/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 *         Given an array S of n integers, find three integers in S such that
 *         the sum is closest to a given number, target. Return the sum of the
 *         three integers. You may assume that each input would have exactly one
 *         solution.
 * 
 *         For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *         The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Find3SumClosest {

	public int threeSumClosest(int[] a, int k) {
		if (a.length < 3) {
			return k;
		}
		long res = Integer.MAX_VALUE;
		Arrays.sort(a);
		for (int i = 0; i < a.length - 1; i++) {
			int l = i + 1, r = a.length - 1;
			while (l < r) {
				int sum = a[i] + a[l] + a[r];
				if (Math.abs(k - sum) < Math.abs(k - res)) {
					res = sum;
					if (res == k) {
						break;
					}
				}
				if (sum > k)
					r--;
				else
					l++;
			}
		}
		return (int) res;
	}

	public static void main(String[] args) {
		Find3SumClosest obj = new Find3SumClosest();

		int res = -1;
		// Time : O(n2)
		res = obj.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1);
		System.out.println(res);

	}

}
