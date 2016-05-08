package com.raj.bit;

/*
 * Find the two non-repeating elements in an array of repeating elements
 */

/*
 * http://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 */
public class FindTwoNonRepeatingNumbers {

	public static void main(String[] args) {
		FindTwoNonRepeatingNumbers obj = new FindTwoNonRepeatingNumbers();
		int a[] = { 2, 4, 7, 9, 2, 4 };
		int n = a.length;

		obj.findTwoNonRepeatingNumbers(a, n);

	}

	public void findTwoNonRepeatingNumbers(int[] a, int n) {
		int xor = 0;
		for (int i = 0; i < n; i++)
			xor ^= a[i];
		int x = 0, y = 0;
		int k;
		int set_bit = xor & ~(xor - 1);
		for (int i = 0; i < n; i++) {
			k = set_bit & a[i];
			if (k > 0) {
				x ^= a[i];
			} else {
				y ^= a[i];
			}
			System.out.println("k=" + k + ",x=" + x + ",y=" + y);
		}
		System.out.println("x=" + x + ",y=" + y);
	}

}
