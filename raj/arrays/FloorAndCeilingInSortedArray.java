package com.raj.arrays;

public class FloorAndCeilingInSortedArray {

	public static void main(String[] args) {

		FloorAndCeilingInSortedArray obj = new FloorAndCeilingInSortedArray();

		int index = -1, result = -1;
		int a[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = a.length, x = 9;
		// Time : O(n)
		result = obj.celingOfArrayBruteForce(a, n, x);
		System.out.println(result);
		result = obj.floorOfArrayBruteForce(a, n, x);
		System.out.println(result);

		// Time : O(log)
		result = obj.floorOfArrayBinarySearch(a, 0, n - 1, x);
		System.out.println(result);
		result = obj.celingOfArrayBinarySearch(a, 0, n - 1, x);
		System.out.println(result);
		result = obj.floor(a, 0, n - 1, x);
		System.out.println(result);
		result = obj.ceil(a, 0, n - 1, x);
		System.out.println(result);

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

	public int floorOfArrayBinarySearch(int[] a, int l, int h, int x) {
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
			} else if (a[mid] > x) {
				if (x >= a[mid - 1]) {
					return a[mid - 1];
				}
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		return -1;
	}

	public int celingOfArrayBinarySearch(int[] a, int l, int h, int x) {
		int n = a.length;

		if (n <= 0)
			return -1;
		if (x < a[0]) {
			return a[0];
		} else if (x > a[n - 1]) {
			return Integer.MAX_VALUE;
		}

		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == x) {
				return a[mid];
			} else if (x > a[mid]) {
				if (x <= a[mid + 1]) {
					return a[mid + 1];
				}
				l = mid + 1;
			} else {
				h = mid - 1;
			}

		}
		return Integer.MAX_VALUE;
	}

	public int floorOfArrayBruteForce(int[] a, int n, int x) {
		if (n <= 0)
			return -1;
		if (x < a[0]) {
			return Integer.MIN_VALUE;
		}
		if (x > a[n - 1]) {
			return a[n - 1];
		}
		for (int i = 1; i < n; i++) {
			if (a[i] == x) {
				return a[i];
			} else if (x >= a[i - 1] && x < a[i]) {
				return a[i - 1];
			}
		}
		return -1;
	}

	public int celingOfArrayBruteForce(int[] a, int n, int x) {
		if (n <= 0)
			return -1;
		if (x < a[0]) {
			return a[0];
		} else if (x > a[n - 1]) {
			return Integer.MAX_VALUE;
		}
		for (int i = 0; i < n - 1; i++) {
			if (a[i] == x) {
				return a[i];
			} else if (x > a[i] && x <= a[i + 1]) {
				return a[i + 1];
			}
		}
		return -1;
	}

}
