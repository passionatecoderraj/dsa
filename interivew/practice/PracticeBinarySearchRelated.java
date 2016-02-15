package com.interivew.practice;

import java.util.Arrays;

import com.interivew.graph.CommonUtil;

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
			if (k >= a[pivot] && k <= a[n - 1])
				return binarySearch(a, pivot, n - 1, k);
			else
				return binarySearch(a, 0, pivot - 1, k);
		}
		return -1;
	}

	public boolean checkForMajority(int a[], int n, int key) {
		int first = first(a, 0, n - 1, key);
		if (first != -1) {
			int k = first + n / 2;
			if (k < n && a[k] == key)
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

	/*
	 * Given an array which is sorted, but after sorting some elements are moved
	 * to either of the adjacent positions, i.e., arr[i] may be present at
	 * arr[i+1] or arr[i-1]. Write an efficient function to search an element in
	 * this array. Basically the element arr[i] can only be swapped with either
	 * arr[i+1] or arr[i-1].
	 */
	// Time : O(logn)
	public int searchInAlmostSortedArray(int[] a, int l, int h, int key) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key)
				return mid;
			if (mid > l && a[mid - 1] == key)
				return mid - 1;
			if (mid < h && a[mid + 1] == key)
				return mid + 1;
			if (a[mid] > key)
				h = mid - 2;
			else
				l = mid + 2;
		}
		return -1;
	}

	public void sortArrayInWaveFormUsingSorting(int a[], int n) {
		Arrays.sort(a);
		for (int i = 0; i < n - 1; i += 2) {
			CommonUtil.swap(a, i, i + 1);
		}
	}

	public void sortArrayInWaveForm(int a[], int n) {
		for (int i = 0; i < n; i += 2) {
			if (i > 0 && a[i - 1] > a[i]) {
				CommonUtil.swap(a, i, i - 1);
			}
			if (i < n - 1 && a[i + 1] > a[i]) {
				CommonUtil.swap(a, i, i + 1);
			}
		}
	}

	public void findPairFromTwoArraysWhoseSumIsCloseToX(int[] a1, int[] a2, int m, int n, int x) {
		int x1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
		int l1 = 0;// left of 1st array
		int r2 = n - 1; // right of 2nd array
		int minDiff = Integer.MAX_VALUE;
		int curDiff;
		while (l1 < m && r2 >= 0) {
			curDiff = a1[l1] + a2[r2] - x;
			if (Math.abs(curDiff) < minDiff) {
				minDiff = curDiff;
				x1 = a1[l1];
				x2 = a2[r2];
			}
			if (curDiff < 0) {
				l1++;
			} else {
				r2--;
			}

		}
		System.out.println("x1=" + x1 + ", x2=" + x2 + ", close To : " + x);
	}

	// Time : O(n1+n2+n3), Space : O(1)
	public void intersectionWithoutExtraSpace(int[] a, int[] b, int[] c) {
		int n1 = a.length, n2 = b.length, n3 = c.length;
		int i, j, k;
		i = j = k = 0;

		while (i < n1 && j < n2 && k < n3) {
			if (a[i] == b[j] && b[j] == c[k]) {
				System.out.print(a[i] + " ");
				i++;
				j++;
				k++;
			}
			// a[i]
			else if (a[i] < b[j]) {
				i++;
			} else if (b[j] < c[k]) {
				j++;
			} else {
				// we reach here when a[i]>b[j] && b[j] > c[k]
				// it means c[k] is the smallest
				k++;
			}
		}
		System.out.println();
	}

	public void findPairWithSumCloseToK(int a[], int n, int k) {
		int l = 0, r = n - 1;
		int diff;
		int minDiff = Integer.MAX_VALUE;
		int x = -1, y = -1;
		while (l < r) {
			diff = a[l] + a[r] - k;
			if (Math.abs(diff) < minDiff) {
				minDiff = diff;
				x = a[l];
				y = a[r];
			}
			if (diff < 0) {
				l++;
			} else {
				r--;
			}
		}
		System.out.println("x=" + x + ",y=" + y);
	}

}
