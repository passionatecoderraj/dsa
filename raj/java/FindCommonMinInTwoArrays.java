/**
 * 
 */
package com.raj.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Raj
 *
 */
public class FindCommonMinInTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 7, 1, 5, 2, 3, 6 };
		int b[] = { 3, 8, 6, 20, 7 };
		FindCommonMinInTwoArrays obj = new FindCommonMinInTwoArrays();

		int result = -1;
		// Time : O(m+n),Space : O(min(m,n))
		result = obj.findCommonUsingHashSet(a, b);
		System.out.println(result);

		// Time : O(mlogm+nlogn),uses sorting
		result = obj.findCommonoMinUsingSorting(a, b);
		System.out.println(result);

	}

	public int findCommonoMinUsingSorting(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		int m = a.length;
		int n = b.length;

		int i, j;
		i = j = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				return a[i];
			}
		}
		return 0;
	}

	public int findCommonUsingHashSet(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;

		int firstMin = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<Integer>(m + n);
		if (m > n) {
			for (int i = 0; i < n; i++) {
				set.add(b[i]);
			}
			for (int i = 0; i < m; i++) {
				if (set.contains(a[i])) {
					firstMin = Math.min(firstMin, a[i]);
				}
			}

		} else {
			for (int i = 0; i < m; i++) {
				set.add(a[i]);
			}

			for (int i = 0; i < n; i++) {
				if (set.contains(b[i])) {
					firstMin = Math.min(firstMin, b[i]);
				}
			}
		}
		return firstMin;
	}

}
