/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class UnionIntersectionOf2SortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 4, 5, 7 };
		int b[] = { 2, 3, 5, 6 };
		UnionIntersectionOf2SortedArrays obj = new UnionIntersectionOf2SortedArrays();

		// Time : O(m+n)
		obj.union(a, b);
		// Time : O(m+n)
		obj.intersection(a, b);
		// Another approach that is useful when difference between sizes of two
		// given arrays is significant
		// Time : O(min(mlogn,nlogm))
		obj.intersectionUsingBinarySearch(a, b);

	}

	public void intersectionUsingBinarySearch(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		if (m < n) {
			for (int i = 0; i < m; i++) {
				if (binarySearch(b, 0, n - 1, a[i]) != -1) {
					System.out.print(a[i] + " ");
				}
			}
		} else if (m > n) {
			for (int i = 0; i < n; i++) {
				if (binarySearch(a, 0, m - 1, b[i]) != -1) {
					System.out.print(b[i] + " ");
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
