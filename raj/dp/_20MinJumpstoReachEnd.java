/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 */

public class _20MinJumpstoReachEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		// int a[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };

		int result = -1;
		_20MinJumpstoReachEnd obj = new _20MinJumpstoReachEnd();
		result = obj.minJumpsToReachEnd(a);
		System.out.println(result);
	}

	private int minJumpsToReachEnd(int[] a) {
		int n = a.length;
		int t[] = new int[n];
		int result[] = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = i;
			result[i] = -1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j + a[j] >= i) {
					if (t[i] > t[j] + 1) {
						t[i] = t[j] + 1;
						result[i] = j;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(t[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		printSolution(a, result, n - 1);
		System.out.println();
		return t[n - 1];
	}

	void printSolution(int[] a, int[] result, int i) {
		if (i == -1 || i == 0) {
			System.out.print(a[0] + "-->");
		} else {
			printSolution(a, result, result[i]);
			System.out.print(a[i] + "-->");
		}
	}

}
