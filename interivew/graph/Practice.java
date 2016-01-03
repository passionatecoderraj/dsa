package com.interivew.graph;

import java.util.Arrays;
import java.util.Comparator;

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

	public void sortArrayByFrequency(int a[], int n) {
		Element[] elements = new Element[n];
		for (int i = 0; i < n; i++) {
			elements[i] = new Element(i, a[i], 1);
		}
		Arrays.sort(elements, valSorter);
		for (int i = 1; i < n; i++) {
			if (elements[i].val == elements[i - 1].val) {
				elements[i].freq = elements[i - 1].freq + 1;
				elements[i].index = elements[i - 1].index;
				elements[i].freq = -1;
			}
		}
		Arrays.sort(elements, indexFreqSorter);
	}

	Comparator<Element> valSorter = new Comparator<Element>() {
		public int compare(Element e1, Element e2) {
			return e2.val - e1.val;
		}
	};

	Comparator<Element> indexFreqSorter = new Comparator<Element>() {
		public int compare(Element e1, Element e2) {
			if (e1.freq == e2.freq) {
				return e1.index - e2.index;
			}
			return e2.val - e1.val;
		}
	};

	public int countInversions(int a[], int l, int h) {
		int lcount, rcount, mcount;
		lcount = rcount = mcount = 0;
		if (l < h) {
			int mid = l + (h - l) / 2;
			lcount = countInversions(a, l, mid);
			rcount = countInversions(a, mid + 1, h);
			mcount = merge(a, l, mid, h);
		}
		return lcount + mcount + rcount;
	}

	public int merge(int[] a, int l, int m, int h) {
		int n1 = m - l + 1, n2 = h - m;
		int a1[] = new int[n1];
		int a2[] = new int[n2];

		int i, j, k;
		i = j = 0;
		for (i = 0; i < n1; i++) {
			a1[i] = a[l + i];
		}

		for (i = 0; i < n2; i++) {
			a2[i] = a[m + i + 1];
		}

		i = j = 0;
		k = l;
		int inv_count = 0;
		while (i < n1 && j < n2) {
			if (a1[i] <= a2[j]) {
				a[k++] = a1[i++];
			} else {
				a[k++] = a1[j++];
				inv_count++;
			}
		}
		return inv_count;
	}

	public void twoElementsSumCloseToZero(int a[], int n) {
		int l = 0, r = n - 1;
		int minX = -1, minY = -1;
		int minSum = Integer.MAX_VALUE, sum;
		while (l < r) {
			sum = a[l] + a[r];
			if (Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				minX = a[l];
				minY = a[r];
			}

			if (sum < 0) {
				l++;
			} else {
				r--;
			}
		}
		System.out.println("minX=" + minX + ",minY=" + minY);
	}

	public void findSmallestandSecondSmallestInSingleTraversal(int a[], int n) {
		int min1, min2;
		min1 = min2 = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (a[i] < min1) {
				min2 = min1;
				min1 = a[i];
			} else if (a[i] < min2 && a[i] != min1) {
				min2 = a[i];
			}
		}
	}

	public boolean isMajorityInSortedArray(int a[], int n, int key) {

		int p = binarySearchForFirstOccurenceOfKey(a, 0, n - 1, key);
		if (p >= 0) {
			int k = p + n / 2;
			if (k < n && a[k] == key)
				return true;
		}
		return false;
	}

	public int binarySearchForFirstOccurenceOfKey(int[] a, int l, int r, int key) {
		int mid;
		while (l < r) {
			mid = l + (r - l) / 2;
			if (a[mid] == key && (mid == 0 || a[mid] > a[mid - 1])) {
				return mid;
			} else if (a[mid] >= key) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public Pair getMinMax(int a[], int l, int r) {
		int n = r - l + 1;
		int min, max;
		if (n == 1) {
			return new Pair(a[l], a[l]);
		}
		if (n == 2) {
			if (a[l] > a[r]) {
				max = a[l];
				min = a[r];
			} else {
				min = a[l];
				max = a[r];
			}
			return new Pair(max, min);
		}
		int mid = l + (r - l) / 2;
		Pair left = getMinMax(a, l, mid);
		Pair right = getMinMax(a, mid + 1, r);

		max = left.max > right.max ? left.max : right.max;
		min = left.min < right.min ? left.min : right.min;

		return new Pair(max, min);
	}

	public Pair getMinMaxInSingleTraversalUsingPairsMethod(int a[], int n) {
		if (n <= 0)
			return null;
		int max, min, i;
		if (n % 2 == 0) {
			if (a[1] > a[0]) {
				max = a[1];
				min = a[0];
			} else {
				max = a[0];
				min = a[1];
			}
			i = 2;
		} else {
			min = max = a[0];
			i = 1;
		}
		while (i < n - 1) {
			if (a[i] > a[i + 1]) {
				if (a[i] > max) {
					max = a[i];
				}
				if (a[i + 1] < min) {
					min = a[i + 1];
				}
			} else {
				if (a[i + 1] > max) {
					max = a[i + 1];
				}
				if (a[i] < min) {
					min = a[i];
				}
			}
		}

		return new Pair(max, min);
	}

	public void segregate0s1s(int a[], int n) {
		if (n <= 0)
			return;
		int l = 0, r = n - 1;
		while (l < r) {
			while (a[l] == 0 && l < r) {
				l++;
			}
			while (a[r] == 1 && l < r) {
				r--;
			}
			if (l < r) {
				CommonUtil.swap(a, l, r);
				l++;
				r--;
			}
		}
	}

	public int quickSelectForKthSmallest(int a[], int p, int r, int k) {
		if (p < r) {
			int q = partition(a, p, r);
			if (q - p == k) {
				return a[q];
			}
			if (k > q - p) {
				quickSelectForKthSmallest(a, q + 1, r, k - (q - p) - 1);
			} else {
				quickSelectForKthSmallest(a, p, q - 1, k);
			}
		}
		return -1;
	}

	public int partition(int a[], int p, int r) {
		int j = p, key = a[r];
		for (int i = p; i < r; i++) {
			if (a[i] <= key) {
				CommonUtil.swap(a, j, r);
				j++;
			}
		}
		CommonUtil.swap(a, r, j);
		return j;
	}

	public void productArray(int a[], int n) {
		int left[] = new int[n];
		int right[] = new int[n];
		int prod[] = new int[n];
		left[0] = a[0];
		right[n - 1] = a[n - 1];

		for (int i = 1; i < n; i++) {
			left[i] = a[i] * left[i - 1];
		}
		for (int j = n - 2; j >= 0; j--) {
			right[j] = right[j + 1] * a[j];
		}

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				prod[i] = right[i + 1];
			} else if (i == n - 1) {
				prod[i] = left[i - 1];
			} else {
				prod[i] = left[i - 1] + right[i + 1];
			}
		}
	}

	public void productArrayWithoutAuxiliarySpace(int a[], int n) {
		int prod[] = new int[n];
		int temp = 1;

		for (int i = 0; i < n; i++) {
			prod[i] = temp;
			temp = temp * a[i];
		}

		temp = 1;
		for (int j = n - 1; j >= 0; j--) {
			prod[j] = temp * prod[j];
			temp = temp * a[j];
		}
	}

}

class Pair {
	int max;
	int min;

	@Override
	public String toString() {
		return "Pair [max=" + max + ", min=" + min + "]";
	}

	public Pair(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
}

class Element {
	int index;
	int val;
	int freq;

	public Element(int index, int val, int freq) {
		super();
		this.index = index;
		this.val = val;
		this.freq = freq;
	}

	@Override
	public String toString() {
		return "Element [index=" + index + ", val=" + val + ", freq=" + freq + "]";
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