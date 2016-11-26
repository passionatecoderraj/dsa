/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 */

/*
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 */
public class RainWaterTrapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 5, 2, 3, 1, 7, 2 };
		int result = -1, n = a.length;

		RainWaterTrapping obj = new RainWaterTrapping();

		// Time : O(n), Space : O(n)
	//	result = obj.trappedQuantityOfRainWater(a, n);
	//	System.out.println(result);
		result = obj.rainWaterTrapped(a, n);
		System.out.println(result);
	}

	// same logic but easy to code
	public int rainWaterTrapped(int a[], int n) {
		if (n <= 1)
			return 0;
		int lMax[] = new int[n];
		int rMax[] = new int[n];

		int max_on_left = a[0];
		int max_on_right = a[n - 1];

		for (int i = 1; i < n; i++) {
			lMax[i] = max_on_left;
			max_on_left = Math.max(a[i], max_on_left);
		}

		for (int i = n - 2; i >= 0; i--) {
			rMax[i] = max_on_right;
			max_on_right = Math.max(a[i], max_on_right);
		}

		int t = 0;
		CommonUtil.printArray(lMax);
		CommonUtil.printArray(a);
		CommonUtil.printArray(rMax);

		int min;
		for (int i = 1; i < n - 1; i++) {
			min = Math.min(lMax[i], rMax[i]);
			if (a[i] < min) {
				t += min - a[i];
			}
		}
		return t;
	}

	public int trappedQuantityOfRainWater(int[] a, int n) {
		if (n <= 2)
			return 0;
		int[] lMax = new int[n];
		int[] rMax = new int[n];
		int[] t = new int[n];

		lMax[0] = 0;
		rMax[n - 1] = n - 1;

		int max_so_far = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] >= a[max_so_far]) {
				lMax[i] = i;
				max_so_far = i;
			} else {
				lMax[i] = max_so_far;
			}
		}

		max_so_far = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			if (a[i] >= a[max_so_far]) {
				rMax[i] = i;
				max_so_far = i;
			} else {
				rMax[i] = max_so_far;
			}
		}

		CommonUtil.printArray(lMax);
		CommonUtil.printArray(a);
		CommonUtil.printArray(rMax);
		int trapped_water = 0;
		for (int i = 1; i < n - 1; i++) {
			if (lMax[i] == i || rMax[i] == i) {
				t[i] = 0;
			} else {
				t[i] = Math.min(a[lMax[i]], a[rMax[i]]) - a[i];
				trapped_water += t[i];
			}
		}
		CommonUtil.printArray(t);

		return trapped_water;
	}

}
