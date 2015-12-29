package com.interivew.graph;

import java.util.Arrays;

public class Practice {

	void checkForPairsWithSum(int a[], int n, int sum) {
		Arrays.sort(a);
		int l = 0, r = n - 1, t;
		while (l < r) {
			t = a[l] + a[r];
			if (t == sum) {
				System.out.println(a[l] + "," + a[r]);
			} else if (sum > t) {
				l++;
			} else {
				r--;
			}
		}
	}

	int findMajority(int a[], int n) {
		if (n <= 0)
			return -1;
		int count = 0, candidate = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (count == 0) {
				count = 1;
				candidate = a[i];
			} else {
				if (candidate == a[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == candidate) {
				count++;
			}
		}
		return count > n / 2 ? candidate : -1;
	}

	int findNumberOccuringOddNumberOfTimes(int a[], int n) {
		if (n <= 0)
			return -1;
		int x = a[0];
		for (int i = 1; i < n; i++) {
			x = x ^ a[i];
		}
		return x;
	}

	// Space : O(n)
	int largestContiguousSumUsingDp(int a[], int n) {
		int sum[] = new int[n];
		sum[0] = a[0];
		int max = sum[0];
		for (int i = 1; i < n; i++) {
			sum[i] = Math.max(sum[i - 1] + a[i], a[i]);
			max = Math.max(sum[i], max);
		}
		return max;
	}

	KadaneResult largestContiguousSumUsingKadane(int a[], int n) {
		int maxSum = 0;
		int maxStart = -1;
		int maxEnd = -1;

		int curSum = 0;
		int curStart = 0;

		for (int i = 0; i < n; i++) {
			curSum += a[i];
			if (curSum < 0) {
				curSum = 0;
				curStart = i + 1;
			}
			if (curSum > maxSum) {
				maxSum = curSum;
				maxStart = curStart;
				maxEnd = i;
			}
		}
		return new KadaneResult(maxSum, maxStart, maxEnd);
	}

	int findMissingNumber(int a[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		n = n + 1;
		int t = (n * (n + 1)) / 2;
		return t - sum;
	}

	int findPivot(int a[], int n) {
		if (n <= 0)
			return -1;
		if (n == 1)
			return 0;
		if (a[0] <= a[n - 1])
			return 0;
		int l = 0, r = n - 1, mid;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (a[mid] > a[mid + 1])
				return mid + 1;
			else if (a[mid] > a[l]) {
				l = mid + 1;
			} else if (a[r] > a[mid]) {
				r = mid - 1;
			}
		}
		return -1;
	}

	int findElementInSortedRotatedArray(int a[], int n, int key) {
		int pivot = findPivot(a, n);
		if (pivot < 0)
			return -1;

		if (a[0] >= key && a[pivot - 1] <= key) {
			return binarySearch(a, 0, pivot - 1, key);
		} else {
			return binarySearch(a, pivot, n - 1, key);
		}
	}

	int binarySearch(int a[], int l, int r, int key) {
		int mid;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (a[mid] == key)
				return mid;
			else if (a[mid] > key)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return -1;
	}

	void reverse(int a[], int l, int r) {
		int temp;
		while (l <= r) {
			temp = a[l];
			a[l] = a[r];
			a[r] = temp;
			l++;
			r--;
		}
	}

	void rotateArray(int a[], int n, int d) {
		reverse(a, 0, d - 1);
		reverse(a, d, n - 1);
		reverse(a, 0, n - 1);
	}

	int maxSumNonAdjascnent(int a[], int n) {
		if (n <= 0)
			return -1;
		int incl = a[0], excl = 0, temp;

		if (n == 1)
			return incl;

		for (int i = 1; i < n; i++) {
			temp = incl;
			incl = Math.max(excl + a[i], a[i]);
			excl = temp;
		}
		return incl;
	}

	void leadersInArray(int a[], int n) {
		if (n <= 0)
			return;
		if (n == 1) {
			System.out.println(a[0]);
			return;
		}

		int maxFromRight = a[n - 1];
		System.out.print(a[n - 1] + " ");

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] > maxFromRight) {
				maxFromRight = a[i];
				System.out.print(a[i] + " ");
			}
		}
		System.out.println();
	}
}

class KadaneResult {

	int maxSum;
	int maxStart;
	int maxEnd;

	public KadaneResult(int maxSum, int maxStart, int maxEnd) {
		super();
		this.maxSum = maxSum;
		this.maxStart = maxStart;
		this.maxEnd = maxEnd;
	}

	@Override
	public String toString() {
		return "KadaneResult [maxSum=" + maxSum + ", maxStart=" + maxStart + ", maxEnd=" + maxEnd + "]";
	}

}