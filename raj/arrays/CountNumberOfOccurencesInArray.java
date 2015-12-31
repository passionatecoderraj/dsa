/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj Count the number of occurrences in a sorted array
 */
public class CountNumberOfOccurencesInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 2, 4, 4, 8, 8, 8, 12, 12, 13 };
		int result = -1, n = a.length, x = 8;

		CountNumberOfOccurencesInArray obj = new CountNumberOfOccurencesInArray();
		// Time : O(n)
		result = obj.countNumberOfOccurencesInArrayBruteForce(a, n, x);
		System.out.println(result);
		// Time : O(logn), Using floor and ceiling
		result = obj.countNumberOfOccurencesInArrayUsingFloorCeiling(a, n, x);
		System.out.println(result);

		// Time : O(logn), finding first and last occurrence of x
		result = obj.countNumberOfOccurencesInArrayUsingBinarySearch(a, n, x);
		System.out.println(result);

	}

	public int countNumberOfOccurencesInArrayUsingBinarySearch(int[] a, int n, int x) {
		int first = first(a, 0, n - 1, x);
		int last = last(a, 0, n - 1, x);

		if (first == -1 || last == -1)
			return 0;

		return last - first + 1;
	}

	public int last(int[] a, int l, int h, int x) {
		int mid, n = h - l + 1;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if ((a[mid] == x) && (mid == n - 1 || x < a[mid + 1])) {
				return mid;
			} else if (x >= a[mid]) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return -1;
	}

	public int first(int[] a, int l, int h, int x) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if ((a[mid] == x) && (mid == 0 || x > a[mid - 1])) {
				return mid;
			} else if (a[mid] >= x) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public int countNumberOfOccurencesInArrayUsingFloorCeiling(int[] a, int n, int x) {
		int ceiling = ceiling(a, 0, n - 1, x + 1);
		int floor = floor(a, 0, n - 1, x - 1);
		return (ceiling - 1) - (floor + 1) + 1;
	}

	public int floor(int a[], int l, int h, int x) {
		int n = a.length;

		if (n <= 0)
			return -1;
		if (x < a[0]) {
			return -1;
		} else if (x > a[n - 1]) {
			return n - 1;
		}
		int mid;

		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (a[mid] > x) {
				if (x >= a[mid - 1]) {
					return mid - 1;
				}
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public int ceiling(int a[], int l, int h, int x) {
		int n = a.length;
		if (n <= 0)
			return -1;
		if (x < a[0]) {
			return 0;
		} else if (x > a[n - 1]) {
			return n;
		}
		int mid;

		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (x > a[mid]) {
				if (a[mid + 1] >= x) {
					return mid + 1;
				}
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return -1;
	}

	public int countNumberOfOccurencesInArrayBruteForce(int[] a, int n, int x) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == x) {
				count++;
			}
		}

		return count;
	}

}
