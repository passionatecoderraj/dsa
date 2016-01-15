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

	public int first(int a[], int l, int h, int key) {
		if (l > h)
			return -1;
		if (a[l] == key) {
			return l;
		}
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key && (mid == 0 || a[mid] > a[mid - 1]))
				return mid;
			if (a[mid] >= key) {
				l = mid - 1;
			} else {
				h = mid + 1;
			}
		}
		return -1;
	}

	public int last(int a[], int l, int h, int key) {
		int n = h - l + 1;
		if (l > h)
			return -1;
		if (a[h] == key) {
			return h;
		}
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key && (mid == n - 1 || a[mid] < a[mid + 1]))
				return mid;
			if (a[mid] > key) {
				l = mid - 1;
			} else {
				h = mid + 1;
			}
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

	public int floor(int a[], int l, int h, int key) {
		if (l > h)
			return -1;
		if (key < a[l])
			return Integer.MIN_VALUE;
		if (key > a[h])
			return a[h];

		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key) {
				return a[mid];
			} else if (a[mid] > key) {
				if (l < mid && key > a[mid - 1])
					return a[mid - 1];
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		return -1;
	}

	public int ceil(int a[], int l, int h, int key) {
		if (l > h)
			return -1;
		if (key > a[h])
			return Integer.MAX_VALUE;
		if (key < a[l])
			return a[l];
		int mid;
		while(l<=h){
			mid = l+(h-l)/2;
			if(a[mid]>=key)
		}
		return -1;
	}
}
