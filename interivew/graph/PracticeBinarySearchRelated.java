package com.interivew.graph;

public class PracticeBinarySearchRelated {

	public int binarySearch(int[] a, int l, int h, int key) {
		if (l > h)
			return -1;
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key)
				return mid;
			else if (a[mid] > key)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return -1;
	}

	/*
	 * The main idea for finding pivot is – for a sorted (in increasing order)
	 * and pivoted array, pivot element is the only only element for which next
	 * element to it is smaller than it.
	 */
	// {60,70,80, 10,20,30,40}
	// it return index 2(of 80) in above example
	public int findPivotInSortedArray(int a[], int l, int h) {
		if (l > h)
			return -1;
		if (l == h)
			return l;
		if (h == l + 1) {
			if (a[h] >= a[l]) {
				return h;
			} else {
				return l;
			}
		}

		int mid = l + (h - l) / 2;

		if (mid < h && a[mid] > a[mid + 1]) {
			return mid;
		}

		if (l < mid && a[mid - 1] > a[mid]) {
			return mid - 1;
		}
		if (a[mid] > a[l]) {
			return findPivotInSortedArray(a, mid + 1, h);
		} else {
			return findPivotInSortedArray(a, l, mid - 1);
		}
	}

	public int findPivot(int a[], int l, int h) {
		if (l > h)
			return -1;
		if (a[l] <= a[h])
			return 0;
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] > a[mid + 1])
				return mid + 1;
			if (a[mid] > a[l]) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return -1;
	}

	public int floor(int[] a, int l, int h, int x) {
		int n = a.length;
		if (n <= 0)
			return -1;
		if (x < a[0])
			return Integer.MIN_VALUE;
		else if (x > a[n - 1])
			return a[n - 1];

		int mid;

		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == x) {
				return a[mid];
			}
			if (a[mid] > x && a[mid - 1] < x) {
				return a[mid - 1];
			}

			if (a[mid] >= x) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		return -1;
	}

	public int ceil(int[] a, int l, int h, int x) {
		int n = a.length;
		if (n <= 0)
			return -1;
		if (x < a[0])
			return a[0];
		else if (x > a[n - 1])
			return Integer.MAX_VALUE;

		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == x) {
				return a[mid];
			}
			if (x > a[mid] && x < a[mid + 1]) {
				return a[mid + 1];
			}

			if (a[mid] > x) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		return -1;
	}

	public int first(int[] a, int l, int r, int key) {
		if (l > r)
			return -1;
		if (a[l] == key)
			return l;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] == key && (m == 0 || a[m - 1] != key)) {
				return m;
			}
			if (a[m] >= key) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return -1;
	}

	public int last(int[] a, int l, int r, int key) {
		if (l > r)
			return -1;
		int n = r - l + 1;
		if (a[r] == key)
			return r;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] == key && (m == n - 1 || a[m + 1] != key)) {
				return m;
			}
			if (a[m] > key) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return -1;
	}

	public int searchInRotatedArray(int a[], int n, int k) {
		int pivot = findPivot(a, 0, n - 1);
		if (pivot != -1) {
			if (k > a[0] && k <= a[pivot - 1])
				return binarySearch(a, 0, pivot - 1, k);
			else
				return binarySearch(a, pivot, n - 1, k);
		}
		return -1;
	}

	public boolean checkForMajority(int a[], int n, int key) {
		int first = first(a, 0, n - 1, key);
		if (first != -1) {
			int k = first + n / 2;
			if (k <= n && a[k] == key)
				return true;
		}
		return false;
	}

	public int findSmallestMissingNumberUsingBinarySearch(int[] a, int l, int r) {
		int mid, n = r - l + 1;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (a[mid] != mid && (mid == 0 || a[mid - 1] == mid - 1)) {
				return mid;
			} else if (a[mid] == mid) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return n;
	}

	public int countNumberofOccurencesInSortedArray(int a[], int n, int key) {
		int first = first(a, 0, n - 1, key);
		int last = last(a, 0, n - 1, key);
		if (first == -1 || last == -1)
			return 0;
		return last - first + 1;
	}

	public int findFixedPoint(int a[], int l, int h) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == mid)
				return mid;
			else if (a[mid] > mid)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return -1;
	}

	public int findMaxInBitonicUsingBinarySearch(int[] a, int l, int r) {
		int mid;

		while (l <= r) {
			// if there are only two elements
			if (l == r) {
				return a[l];
			}
			if (l + 1 == r) {
				return a[l] > a[r] ? a[l] : a[r];
			}

			mid = l + (r - l) / 2;
			if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
				return a[mid];
			} else if (a[mid] > a[mid + 1]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	// Time :O(logn), Space : O(1)
	public int findPeak(int[] a, int n) {
		if (n <= 0)
			return Integer.MIN_VALUE;
		int l = 0, r = n - 1, mid;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == n - 1 || a[mid] >= a[mid + 1])) {
				return a[mid];
			}
			if (a[mid] > a[mid - 1]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return Integer.MIN_VALUE;
	}
}
