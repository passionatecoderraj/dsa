/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */

/*
 * Given two sorted arrays such the arrays may have some common elements. Find
 * the sum of the maximum sum path to reach from beginning of any array to end
 * of any of the two arrays. We can switch from one array to another array only
 * at common elements.
 */
public class MaxSumPathSumInTwoArrays {

	public static void main(String[] args) {

		MaxSumPathSumInTwoArrays obj = new MaxSumPathSumInTwoArrays();
		int a[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int b[] = { 1, 5, 7, 8, 10, 15, 16, 19 };

		int m = a.length, n = b.length;
		int result = -1;

		result = obj.maxSumPathSumInTwoArrays(a, m, b, n);
		System.out.println(result);

		result = obj.maxSumPathInTwoArraysShowsResult(a, m, b, n);
		System.out.println(result);
	}

	// Time : O(m+n)
	public int maxSumPathSumInTwoArrays(int[] a, int m, int[] b, int n) {
		int i, j, aSum, bSum;
		i = j = aSum = bSum = 0;
		int resultSum = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				aSum += a[i++];
			} else if (a[i] > b[j]) {
				bSum += b[j++];
			} else {
				aSum += a[i];
				bSum += b[j];

				if (aSum > bSum) {
					resultSum += aSum;
				} else {
					resultSum += bSum;
				}
				aSum = bSum = 0;
				i++;
				j++;
			}
		}

		while (i < m) {
			aSum += a[i];
			i++;
		}

		while (j < n) {
			bSum += b[j];
			j++;
		}

		if (aSum > bSum) {
			resultSum += aSum;
		} else {
			resultSum += bSum;
		}

		return resultSum;
	}

	public int maxSumPathInTwoArraysShowsResult(int[] a, int m, int[] b, int n) {
		int result[] = new int[m + n];
		int i, j, aSum, bSum, leftA, leftB;
		i = j = aSum = bSum = 0;
		leftA = leftB = 0;
		int k = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				aSum += a[i];
				i++;
			} else if (a[i] > b[j]) {
				bSum += b[j];
				j++;
			} else {
				aSum += a[i];
				bSum += b[j];

				if (aSum > bSum) {
					System.arraycopy(a, leftA, result, k, i - leftA + 1);
					k += (i - leftA + 1);
				} else {
					System.arraycopy(b, leftA, result, k, j - leftB + 1);
					k += (j - leftB + 1);
				}
				aSum = bSum = 0;
				leftA = i + 1;
				leftB = j + 1;
				i++;
				j++;
			}
		}

		while (i < m) {
			aSum += a[i];
			i++;
		}

		while (j < n) {
			bSum += b[j];
			j++;
		}

		if (aSum > bSum) {
			System.arraycopy(a, leftA, result, k, i - leftA);
		} else {
			System.arraycopy(b, leftA, result, k, j - leftB);
		}

		CommonUtil.printArray(result);
		int sum = 0;
		for (i = 0; i < result.length; i++) {
			sum += result[i];
		}
		return sum;
	}

}
