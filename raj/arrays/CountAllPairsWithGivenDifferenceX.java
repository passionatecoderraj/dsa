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
public class CountAllPairsWithGivenDifferenceX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountAllPairsWithGivenDifferenceX obj = new CountAllPairsWithGivenDifferenceX();
		int a[] = { 8, 12, 16, 4, 0, 20 };
		int x = 4, n = a.length;
		int result = -1;

		// method 2 : Time : O(nlogn) , Space : O(1)
		result = obj.countAllPairsWithGivenDifferenceX(a, n, x);
		System.out.println(result);
	}

	public int countAllPairsWithGivenDifferenceX(int[] a, int n, int x) {

		Arrays.sort(a);
		int count, l, r;
		l = r = count = 0;
		int d;
		while (r < n) {
			d = a[r] - a[l];
			if (d > x) {
				l++;
			} else if (d < x) {
				r++;
			} else {
				System.out.println("1st=" + a[l] + ",2nd=" + a[r]);
				l++;
			//	r++;
				count++;
			}
		}
		return count;
	}

}
