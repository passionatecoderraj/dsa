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
		int a[] = { 4, 2, -3, 1, 6 };

		int n = a.length;
		boolean result = false;
		result = obj.subArraysOfSumZero(a, n);
		System.out.println(result);
	}

	public boolean subArraysOfSumZero(int[] a, int n) {

		int sum = 0;
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (a[i] == 0 || sum == 0 || set.contains(sum)) {
				return true;
			}
			set.add(sum);
		}
		return false;
	}

}
