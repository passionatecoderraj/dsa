/**
 * 
 */
package com.raj.arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *         Follow up for H-Index: What if the citations array is sorted in
 *         ascending order? Could you optimize your algorithm?
 * 
 */
public class HIndex2 {

	// Time : O(logn), Space : O(1)
	public int hIndex(int[] a) {
		/*
		 * when array is reverse sorted it's easier to understand. Two steps to
		 * convert this program to that way 1) in place m+1, put n-m 2) swap
		 * left logics for whie going either left or right
		 */
		int n = a.length;
		int l = 0, r = a.length - 1;
		while (l <= r) {
			int m = (l + r) >> 1;
			if (a[m] >= n - m && (m == 0 || a[m - 1] < n - m + 1))
				return n - m;
			if (a[m] < n - m) {
				l = m + 1;
			} else {
				r = m - 1;

			}
		}
		return 0;
	}

	// Time : O(n)
	public int hIndex2(int[] a) {
		// finding h-index by linear search
		int l = 0, r = a.length - 1;
		while (l < r) {
			CommonUtil.swap(a, l++, r--);
		}
		l = 0;
		r = a.length - 1;
		while (l <= r) {
			int m = (l + r) >> 1;
			if (a[m] >= m + 1 && (m == a.length - 1 || a[m + 1] < m + 2))
				return m + 1;
			if (a[m] < m + 1) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		HIndex2 obj = new HIndex2();
		int a[] = { 0, 1, 3, 5, 6 };
		int result = -1;
		result = obj.hIndex(a);
		System.out.println(result);

		result = obj.hIndex(new int[] { 2, 3, 3, 4, 4, 5 });
		System.out.println(result);
	}

}
