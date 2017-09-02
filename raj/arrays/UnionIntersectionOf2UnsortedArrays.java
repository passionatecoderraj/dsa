/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class UnionIntersectionOf2UnsortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 7, 1, 5, 2, 3, 6 };
		int b[] = { 3, 8, 6, 20, 7 };
		UnionIntersectionOf2UnsortedArrays obj = new UnionIntersectionOf2UnsortedArrays();

		// Time : O(mlogm+nlogn),uses sorting
		obj.union(a, b);
		// Time : O(mlogm+nlogn),uses sorting
		obj.intersection(a, b);

		// Another approach that is useful when difference between sizes of two
		// given arrays is significant
		// Time : O(min(mlogm+nlogm,nlogn+mlogn))
		obj.unionUsingBinarySearch(a, b);
		obj.intersectionUsingBinarySearch(a, b);

		// using hash set
		// Theta of(m+n)
		obj.unionUsingHashSet(a, b);
		obj.intersectionUsingHashSet(a, b);

	}

	public void intersectionUsingHashSet(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		Set<Integer> set = new HashSet<Integer>(m + n);
		for (int i = 0; i < m; i++) {
			set.add(a[i]);
		}
		for (int i = 0; i < n; i++) {
			if (set.contains(b[i])) {
				System.out.print(b[i] + " ");
			}
		}
		System.out.println();
	}

	public void unionUsingHashSet(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		Set<Integer> set = new HashSet<Integer>(m + n);
		for (int i = 0; i < m; i++) {
			set.add(a[i]);
		}
		for (int i = 0; i < n; i++) {
			set.add(b[i]);
		}
		CommonUtil.printArray(set);

	}

	public void unionUsingBinarySearch(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		if (m < n) {
			Arrays.sort(a);
			for (int i = 0; i < m; i++) {
				System.out.print(a[i] + " ");
			}
			for (int i = 0; i < n; i++) {
				if (binarySearch(a, 0, m - 1, b[i]) == -1) {
					System.out.print(b[i] + " ");
				}
			}
		} else if (m > n) {
			Arrays.sort(b);
			for (int i = 0; i < n; i++) {
				System.out.print(b[i] + " ");
			}
			for (int i = 0; i < m; i++) {
				if (binarySearch(b, 0, n - 1, a[i]) == -1) {
					System.out.print(a[i] + " ");
				}
			}
		}
		System.out.println();
	}

	public void intersectionUsingBinarySearch(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		if (m < n) {
			Arrays.sort(a);
			for (int i = 0; i < n; i++) {
				if (binarySearch(a, 0, m - 1, b[i]) != -1) {
					System.out.print(b[i] + " ");
				}
			}
		} else if (m > n) {
			Arrays.sort(b);
			for (int i = 0; i < m; i++) {
				if (binarySearch(b, 0, n - 1, a[i]) != -1) {
					System.out.print(a[i] + " ");
				}
			}
		}
		System.out.println();
	}

	public int binarySearch(int a[], int l, int h, int key) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] > key) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public void intersection(int[] a, int[] b) {
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
				System.out.print(a[i] + " ");
				i++;
				j++;

			}
		}
		System.out.println();
	}

	/*
	 * Assuming number are not repeated in same array
	 */
	public void union(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		Arrays.sort(a);
		Arrays.sort(b);

		int i, j;
		i = j = 0;

		while (i < m && j < n) {
			if (a[i] < b[j]) {
				System.out.print(a[i++] + " ");
			} else if (a[i] > b[j]) {
				System.out.print(b[j++] + " ");
			} else {
				System.out.print(a[i++] + " ");
				j++;
			}
		}

		while (i < m) {
			System.out.print(a[i++] + " ");
		}

		while (j < n) {
			System.out.print(b[j++] + " ");
		}

		System.out.println();
	}

}
