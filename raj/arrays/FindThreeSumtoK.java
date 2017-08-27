/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 */
public class FindThreeSumtoK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindThreeSumtoK obj = new FindThreeSumtoK();
		int a[] = { 1, 4, 12, 6, 10, 8 };
		int n = a.length, k = 22;
		// Time : O(n2)
		obj.findTriplet(a, n, k);
	}

	public void findTriplet(int[] a, int n, int k) {
		if (n < 3) {
			return;
		}
		Arrays.sort(a);
		int l, r, sum = 0;
		for (int i = 0; i < n - 2; i++) {
			l = i + 1;
			r = n - 1;
			while (l < r) {
				sum = a[i] + a[l] + a[r];
				if (sum == k) {
					System.out.println("1st=" + a[i] + ",2nd=" + a[l] + ",3rd=" + a[r] + " :: Sum=" + sum);
					l++;
					r--;
				} else if (sum > k) {
					r--;
				} else {
					l++;
				}
			}
		}
	}

}
