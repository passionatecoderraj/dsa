/**
 * 
 */
package com.raj.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Raj
 *
 */
/*
 * Given an array of positive and negative numbers, find if there is a subarray
 * (of size at-least one) with 0 sum
 */
public class FindSubarrayOfSumZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FindSubarrayOfSumZero obj = new FindSubarrayOfSumZero();
		int a[] = { 6, 2, 4, 3, -2, -2, -2, -1, -1, 3 };

		int n = a.length;
		boolean result = false;
		// Time : O(n), Space : O(n)
		result = obj.subArraysOfSumZero(a, n);
		System.out.println(result);
		new FindSubarrayOfSumK().subArraysOfSumK(a, n, 0);
	}

	// Time : O(n), Space : O(n)
	public boolean subArraysOfSumZero(int[] a, int n) {

		int sum = 0;
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (a[i] == 0 || sum == 0 || set.contains(sum)) {
				return true;
			}
			set.add(sum);
			System.out.println(set);
		}
		return false;
	}

}
