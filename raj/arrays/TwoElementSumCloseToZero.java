package com.raj.arrays;

import java.util.Arrays;

/*
 *
 */
public class TwoElementSumCloseToZero {

	public static void main(String[] args) {
		int a[] = { 1, 60, -10, 70, -80, 85 };
		int n = a.length, result = -1;
		TwoElementSumCloseToZero obj = new TwoElementSumCloseToZero();
		// Time : O(n2), Space: O(1)
		result = obj.twoElementSumCloseToZeroBruteForce(a, n);
		System.out.println(result);

		// Time : O(nlogn), Space: O(1)
		result = obj.twoElementSumCloseToZeroUsingSorting(a, n);
		System.out.println(result);

	}

	public int twoElementSumCloseToZeroUsingSorting(int[] a, int n) {
		Arrays.sort(a);

		int sum, min1, min2;
		sum = min1 = min2 = Integer.MAX_VALUE;
		int l = 0, r = n - 1;
		int t;
		while (l < r) {
			t = a[l] + a[r];
			if (t > 0) {
				if (Math.abs(t) < Math.abs(sum)) {
					sum = t;
					min1 = a[l];
					min2 = a[r];
				}
				r--;
			} else if (t < 0) {
				if (Math.abs(t) < Math.abs(sum)) {
					sum = t;
					min1 = a[l];
					min2 = a[r];
				}
				l++;
			} else {
				sum = 0;
				min1 = a[l];
				min2 = a[r];
			}
		}

		for (int i = 1; i < n; i++) {
			if (Math.abs(a[i - 1] + a[i]) < Math.abs(sum)) {
				sum = a[i - 1] + a[i];
				min1 = a[i - 1];
				min2 = a[i];
			}
		}
		System.out.println("min1=" + min1 + ", min2=" + min2 + " :: sum=" + sum);
		return sum;
	}

	public int twoElementSumCloseToZeroBruteForce(int[] a, int n) {
		int sum = Integer.MAX_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				if (Math.abs(a[i] + a[j]) < Math.abs(sum)) {
					sum = a[i] + a[j];
					min1 = a[i];
					min2 = a[j];
				}
			}
		}

		System.out.println("min1=" + min1 + ", min2=" + min2 + " :: sum=" + sum);
		return sum;
	}

}
