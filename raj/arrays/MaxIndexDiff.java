/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 *         find the maximum j – i such that arr[j] > arr[i]
 */
public class MaxIndexDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxIndexDiff obj = new MaxIndexDiff();
		int a[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		// int a[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		// int a[] ={1, 2, 3, 4, 5, 6};
		// int a[] = {6, 5, 4, 3, 2, 1};

		int n = a.length;
		// Time: O(n2), space : O(1)
		obj.findMaxIndexDiffBruteForce(a, n);
		// Time : O(n), Space : O(n)
		obj.findMaxIndexDiff(a, n);

	}

	public void findMaxIndexDiff(int[] a, int n) {
		if (n <= 0)
			return;
		int leftMin[] = new int[n];
		int rightMax[] = new int[n];
		leftMin[0] = a[0];

		for (int i = 1; i < n; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], a[i]);
		}

		rightMax[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], a[i]);
		}
		int i, j, maxIndexDiff = Integer.MIN_VALUE;
		i = j = 0;
		int maxLeft = -1, maxRight = -1;

		while (i < n && j < n) {
			if (leftMin[i] < rightMax[j]) {
				if ((j - i) > maxIndexDiff) {
					maxIndexDiff = j - i;
					maxLeft = i;
					maxRight = j;
				}
				j++;
			} else {
				i++;
			}
		}
		System.out
				.println("maxLeft:" + maxLeft + ", " + "maxRight:" + maxRight + ":: " + "maxIndexDiff:" + maxIndexDiff);

	}

	public void findMaxIndexDiffBruteForce(int[] a, int n) {
		int maxIndexDiff = Integer.MIN_VALUE;
		int maxLeft = -1, maxRight = -1;
		boolean isFound = false;

		for (int i = 0; i < n; i++) {
			isFound = false;
			for (int j = n - 1; j > i && !isFound; j--) {
				if (a[j] > a[i]) {
					if ((j - i) > maxIndexDiff) {
						maxIndexDiff = j - i;
						maxLeft = i;
						maxRight = j;
					}
					isFound = true;
				}
			}
		}
		System.out
				.println("maxLeft:" + maxLeft + ", " + "maxRight:" + maxRight + ":: " + "maxIndexDiff:" + maxIndexDiff);
	}

}
