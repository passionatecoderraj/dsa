/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 * 
 *         Check for Pair of numbers with sum X
 * 
 */
public class CheckForPairWIthDifferenceX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckForPairWIthDifferenceX obj = new CheckForPairWIthDifferenceX();
		int a[] = { 8, 12, 16, 4, 0, 20 };
		int x = 4, n = a.length;
		boolean result = false;

		// method 1 : Time : O(n2) , Space : O(1)
		// result = obj.checkForPairWithDiffXBruteForce(a, n, x);
		// System.out.println(result);

		// method 2 : Time : O(nlogn) , Space : O(1)
		result = obj.checkForPairWithDiffUsingSorting(a, n, x);
		System.out.println(result);
	}

	public boolean checkForPairWithDiffUsingSorting(int[] a, int n, int x) {
		Arrays.sort(a);
		boolean isFound = false;
		int l = 0, r = 0;
		int diff;

		while (r < n) {
			diff = a[r] - a[l];
			if (diff < x) {
				r++;
			} else if (diff > x) {
				l++;
			} else {
				isFound = true;
				System.out.println(a[l] + " - " + a[r] + " = " + x);
				l++;
				r++;
			}
		}

		return isFound;
	}

	public boolean checkForPairWithDiffXBruteForce(int[] a, int n, int x) {

		boolean isFound = false;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(a[i] - a[j]) == Math.abs(x)) {
					isFound = true;
					System.out.println(a[i] + " - " + a[j] + " = " + x);
				}
			}
		}
		return isFound;
	}

}
