package com.raj.leetcode;

public class SearchInRotatedSortedArray {

	// With Duplicates
	public boolean search2(int[] a, int k) {
		int l = 0, r = a.length - 1;
		while (l <= r) {
			int m = (l + r) >>> 1;
			if (a[m] == k) {
				return true;
			}
			if (a[m] == a[l] && a[m] == a[r]) {
				l++;
				r--;
				continue;
			}
			// left is sorted
			if (a[m] >= a[l]) {
				// if element in range go left
				if (k >= a[l] && k <= a[m]) {
					r = m + 1;
				} else {
					// if element not in range go right
					l = m + 1;
				}
			}
			// right is sorted*
			else {
				// if element in range go right
				if (k >= a[m] && k <= a[r]) {
					l = m + 1;
				} else {
					// if element not in range go left
					r = m - 1;
				}
			}
		}
		return false;
	}

	// Without Duplicates
	public int search(int[] a, int k) {
		int l = 0, r = a.length - 1;
		while (l <= r) {
			int m = (l + r) >>> 1;
			if (a[m] == k) {
				return m;
			}
			if (a[m] >= a[l]) {
				if (k >= a[l] && k <= a[m]) {
					r = m + 1;
				} else {
					l = m + 1;
				}
			} else {
				if (k >= a[m] && k <= a[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
		}
		return -1;
	}

	// Without Duplicates and using recursion
	public int findElementInSortedRotatedArray(int a[], int l, int r, int key) {
		int mid = l + (r - l) / 2;
		if (key == a[mid]) {
			return mid;
		}
		// left is sorted
		if (a[mid] >= a[l]) {
			if (key >= a[l] && key <= a[mid]) {
				// if element in range go left
				return findElementInSortedRotatedArray(a, l, mid - 1, key);
			} else {
				// if element not in range go right
				return findElementInSortedRotatedArray(a, mid + 1, r, key);
			}
		}
		// right is sorted
		else {
			if (key >= a[mid] && key <= a[r]) {
				// if element in range go right
				return findElementInSortedRotatedArray(a, mid + 1, r, key);
			} else {
				// if element not in range go left
				return findElementInSortedRotatedArray(a, l, mid - 1, key);
			}
		}
	}

	public static void main(String[] args) {
		int b[] = { 3, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3 };
		int a[] = { 73, 85, 94, 21, 27, 34, 47, 54, 66 };
		int result = -1, k = 85;
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

		result = obj.search(a, k);
		System.out.println(result);

		boolean res = obj.search2(b, 2);
		System.out.println(res);

	}

}
