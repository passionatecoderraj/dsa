/**
 * 
 */
package com.raj.sorting;

import com.interview.graph.CommonUtil;;

/**
 * @author Raj
 *
 */

public class FindKClosestElementsInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		FindKClosestElementsInSortedArray obj = new FindKClosestElementsInSortedArray();

		int n = a.length;
		int x = 39, k = 4;

		// Time : O(n+k), Space : O(1)
		// linear search for element index
		obj.findKCloseElementsForX(a, n, x, k);

		// binary search for element index
		// Time : O(logn+k), Space : O(1)
		obj.findKCloseElementsForXUsingBinarySearch(a, 0, n - 1, x, k);
		CommonUtil.printArray(a);

	}

	public void findKCloseElementsForXUsingBinarySearch(int[] a, int l, int h, int key, int k) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key) {
				printKCloseElementsFor(a, a.length, mid, k);
				break;
			} else if (a[mid] > key) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
	}

	public void findKCloseElementsForX(int[] a, int n, int x, int k) {
		for (int i = 0; i < n; i++) {
			if (a[i] == x) {
				printKCloseElementsFor(a, n, i, k);
				break;
			}
		}
	}

	public void printKCloseElementsFor(int[] a, int n, int i, int k) {
		int l, r, count = 0;
		l = i - 1;
		r = i + 1;
		while (l >= 0 && r < n && count < k) {
			if (Math.abs(a[i] - a[l]) < Math.abs(a[r] - a[i])) {
				System.out.print(a[l--] + " ");
			} else {
				System.out.print(a[r++] + " ");
			}
			count++;
		}

		while (count < k && l >= 0) {
			System.out.print(a[l--] + " ");
			count++;
		}

		while (count < k && r < n) {
			System.out.print(a[r++] + " ");
			count++;
		}
		System.out.println();
	}

}
