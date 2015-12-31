/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 *
 *         Equilibrium index of an array is an index such that the sum of
 *         elements at lower indexes is equal to the sum of elements at higher
 *         indexes.
 */
public class EqulibriumIndexOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EqulibriumIndexOfArray obj = new EqulibriumIndexOfArray();
		int a[] = { -7, 1, 5, 2, -4, 3, 0 };
		// int a[] = { 1, 2, 3, 4, 3, 1, 2 };
		int n = a.length;

		// Time :O(n), Space : O(n)
		obj.findEqulibriumIndex(a, n);
		// Time :O(n), Space : O(1)
		obj.findEqulibriumIndexWithoutExtraSpace(a, n);
	}

	public void findEqulibriumIndexWithoutExtraSpace(int[] a, int n) {
		int sum = 0;
		int leftSum = 0;

		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		for (int i = 0; i < n; i++) {
			sum -= a[i];
			if (leftSum == sum) {
				System.out.println("Equlibrium Index : " + i);
			}
			leftSum += a[i];
		}
	}

	public void findEqulibriumIndex(int[] a, int n) {
		if (n <= 0)
			return;
		int left[] = new int[n];
		int right[] = new int[n];
		left[0] = a[0];
		right[n - 1] = a[n - 1];
		for (int i = 1; i < n; i++) {
			left[i] = a[i] + left[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			right[i] = a[i] + right[i + 1];
		}
		for (int i = 0; i < n; i++) {
			if (left[i] == right[i]) {
				System.out.println("Equlibrium Index : " + i);
			}
		}
	}

}
