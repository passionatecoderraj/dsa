/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 * 
 *         Maximum difference between two elements such that larger element
 *         appears after the smaller number
 */
public class MaxDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxDiff obj = new MaxDiff();
		int a[] = { 3, 2, 10, 6, 13, 8, 1 };
		int n = a.length;
		// Time: O(n2)
		obj.maxDiffBruteForce(a, n);
		// Time: O(n)
		obj.maxDiffMethod2Variation1(a, n);
		// Time: O(n)
		obj.maxDiffMethod2Variation2(a, n);
	}

	public void maxDiffMethod2Variation2(int[] a, int n) {
		int maxDiff = a[n - 2] - a[n - 1];
		int max_so_far = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (max_so_far - a[i] > maxDiff) {
				maxDiff = max_so_far - a[i];
			}
			if (a[i] > max_so_far) {
				max_so_far = a[i];
			}
		}
		System.out.println(maxDiff);
	}

	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing
	 * order. Returns 0 if elements are equal
	 */
	public void maxDiffMethod2Variation1(int[] a, int n) {
		int maxDiff = a[1] - a[0];
		int min_so_far = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] - min_so_far > maxDiff) {
				maxDiff = a[i] - min_so_far;
			}
			if (a[i] < min_so_far) {
				min_so_far = a[i];
			}
		}
		System.out.println(maxDiff);
	}

	public void maxDiffBruteForce(int[] a, int n) {
		int maxDiff = Integer.MIN_VALUE;
		int maxPair1 = -1;
		int maxPair2 = -1;

		int diff = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[j] > a[i]) {
					diff = a[j] - a[i];
					if (diff > maxDiff) {
						maxDiff = diff;
						maxPair1 = a[i];
						maxPair2 = a[j];
					}
				}
			}
		}

		System.out.println("1st=" + maxPair2 + ",2nd=" + maxPair1 + ":: Diff=" + maxDiff);
	}

}
