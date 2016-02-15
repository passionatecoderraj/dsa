/**
 * 
 */
package com.raj.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Raj
 * 
 *         Check for Pair of numbers with sum X
 * 
 */
public class CheckForDuplicatesWithInKDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckForDuplicatesWithInKDistance obj = new CheckForDuplicatesWithInKDistance();
		int a[] = { 1, 2, 3, 4, 1, 2, 3, 4 };
		int k = 3, n = a.length;
		boolean result = false;

		// Time : O(n) , Space : O(k)
		result = obj.checkForDuplicatesWithInKDistance(a, n, k);
		System.out.println(result);

		int b[] = { 1, 2, 3, 1, 4, 5 };
		k = 3;
		result = obj.checkForDuplicatesWithInKDistance(b, b.length, k);
		System.out.println(result);

	}

	// Time : O(n) , Space : O(k)
	public boolean checkForDuplicatesWithInKDistance(int[] a, int n, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (set.contains(a[i])) {
				return true;
			}
			set.add(a[i]);
			if (i >= k) {
				set.remove(a[i - k]);
			}
		}
		return false;
	}

}
