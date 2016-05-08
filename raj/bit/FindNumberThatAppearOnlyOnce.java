/**
 * 
 */
package com.raj.bit;

/**
 * @author Raj
 *
 */
/*
 * All numbers occur twice except one number which occurs once. Find the number
 * in O(n) time & constant extra space.
 */

public class FindNumberThatAppearOnlyOnce {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindNumberThatAppearOnlyOnce obj = new FindNumberThatAppearOnlyOnce();
		int result = -1;
		int a[] = { 7, 3, 5, 4, 5, 3, 4 };

		// Time :O(n)
		result = obj.findNumberThatApearOnce(a, a.length);
		System.out.println(result);

	}

	public int findNumberThatApearOnce(int[] a, int n) {
		if (n <= 0)
			return -1;
		int k = a[0];
		for (int i = 1; i < n; i++) {
			k = k ^ a[i];
		}
		return k;
	}

}
