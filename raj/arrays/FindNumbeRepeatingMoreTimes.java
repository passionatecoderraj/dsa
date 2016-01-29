/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 */
/*
 * Find number repeated more times in range 1 to k; k<=n
 */
public class FindNumbeRepeatingMoreTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindNumbeRepeatingMoreTimes obj = new FindNumbeRepeatingMoreTimes();

		// range of value is 0 to k-1 and k<=n
		int a[] = { 2, 3, 3, 5, 2, 4, 1, 7 };

		int n = a.length, k = 8;
		// Time: O(n), Space : O(1)
		obj.findNumberRepeatingMoreTimes(a, n, k);

		int b[] = { 2, 3, 3, 5, 2, 4, 1, 7 };
		// Time: O(n), Space : O(1)
		// if there are multiple numbers repeating at same frequency print all
		// of them
		obj.findAllNumbersRepeatingMoreTimes(b, b.length, k);

	}

	// Time: O(n), Space : O(1)
	public void findAllNumbersRepeatingMoreTimes(int[] a, int n, int k) {
		for (int i = 0; i < n; i++) {
			a[a[i] % k] = a[a[i] % k] + k;
		}

		for (int i = 0; i < n; i++) {
			a[i] = a[i] / k;
		}
		CommonUtil.printArray(a);

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			max = Math.max(a[i], max);
		}
		for (int i = 0; i < n; i++) {
			if (a[i] == max)
				System.out.print(i + " ");
		}
		System.out.println();
	}

	// Time: O(n), Space : O(1)
	public int findNumberRepeatingMoreTimes(int[] a, int n, int k) {
		for (int i = 0; i < n; i++) {
			a[a[i] % k] = a[a[i] % k] + k;
		}
		for (int i = 0; i < n; i++) {
			a[i] = a[i] / k;
		}
		CommonUtil.printArray(a);

		int max = Integer.MIN_VALUE;
		int maxIndex = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
				maxIndex = i;
			}
		}
		System.out.println(maxIndex);
		return maxIndex;
	}

}
