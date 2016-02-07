package com.interivew.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

import com.interivew.graph.BinaryMinHeap;
import com.interivew.graph.CommonUtil;
import com.interivew.graph.MinHeap;
import com.raj.arrays.AVLTreeWithSize;
import com.raj.trees.bst.AVLTree;

public class PracticeArrays {

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

	void checkForPairWithSumK(int a[], int n, int k) {
		boolean map[] = new boolean[100000];

		int temp;
		for (int i = 0; i < n; i++) {
			temp = k - a[i];
			if (temp >= 0 && map[temp] == true) {
				System.out.println("1st=" + a[i] + ",2nd=" + temp);
			}
			map[a[i]] = true;
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

	int findMissingNumberUsingBits(int a[], int n) {
		int x1 = 0, x2 = 0;
		for (int i = 0; i < n; i++) {
			x1 = x1 ^ a[i];
		}

		for (int i = 1; i <= n + 1; i++) {
			x2 = x2 ^ i;
		}
		return x1 ^ x2;
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
			} else {
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
		while (l <= r) {
			CommonUtil.swap(a, l, r);
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
				elements[i - 1].freq = -1;
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

	// Given is unsorted array
	// Time : O(nlogn), Space: O(1)
	public void twoElementsSumCloseToZero(int a[], int n) {
		Arrays.sort(a);

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

	// if k is 4 then we pass k-1 to this function
	// ex, { 7, 10, 4, 3, 20, 15 }, 4th smallest is 10 ,
	// but we call function f(a,0,n-1,k-1)
	public int quickSelectForKthSmallest(int a[], int p, int r, int k) {
		if (p <= r) {
			int q = partition(a, p, r);
			if (q - p == k) {
				return a[q];
			}
			if (k > q - p) {
				return quickSelectForKthSmallest(a, q + 1, r, k - (q - p) - 1);
			} else {
				return quickSelectForKthSmallest(a, p, q - 1, k);
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

	public int maxDiff(int[] a, int n) {
		if (n <= 0)
			return -1;
		int maxDiff = Integer.MIN_VALUE;
		int minSoFar = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] - minSoFar > maxDiff) {
				maxDiff = a[i] - minSoFar;
			}
			if (a[i] < minSoFar) {
				minSoFar = a[i];
			}
		}
		return maxDiff;
	}

	public int maxDiffVariation2(int[] a, int n) {
		if (n <= 0)
			return -1;
		int maxDiff = Integer.MIN_VALUE;
		int maxSoFar = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (maxSoFar - a[i] > maxDiff) {
				maxDiff = maxSoFar - a[i];
			}
			if (a[i] > maxSoFar) {
				maxSoFar = a[i];
			}
		}
		return maxDiff;
	}

	public void productArray(int a[], int n) {
		int left[] = new int[n];
		int right[] = new int[n];
		int prod[] = new int[n];
		left[0] = 1;
		right[n - 1] = 1;

		for (int i = 1; i < n; i++) {
			left[i] = a[i - 1] * left[i - 1];
		}
		for (int j = n - 2; j >= 0; j--) {
			right[j] = right[j + 1] * a[j + 1];
		}

		for (int i = 0; i < n; i++) {
			prod[i] = left[i] + right[i];
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

	public void segregateEvenAndOdd(int[] a, int n) {
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && a[l] % 2 == 0) {
				l++;
			}
			while (l < r && a[r] % 2 != 0) {
				r--;
			}
			if (l < r) {
				CommonUtil.swap(a, l, r);
				l++;
				r--;
			}
		}
	}

	public void findTwoRepeatingNumbersUsingSignChange(int[] a, int n) {
		int j;
		for (int i = 0; i < n; i++) {
			j = Math.abs(a[i]);
			if (a[j] < 0) {
				System.out.println("Repeated : " + j);
			} else {
				a[j] = -a[j];
			}
		}
	}

	public void segregate0s1s2sInSinglePass(int[] a, int n) {
		int low = 0, mid = 0, high = n - 1;

		while (mid <= high) {
			switch (a[mid]) {
			case 0:
				CommonUtil.swap(a, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				CommonUtil.swap(a, mid, high);
				high--;
			}
		}
	}

	public int minLengthOfUnsortedArray(int a[], int n) {
		if (n == 1)
			return 0;
		int l = 0, r = n - 1;
		for (int i = 1; i < n; i++) {
			if (a[i] < a[i - 1]) {
				l = i;
				break;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] > a[i + 1]) {
				r = i;
				break;
			}
		}

		Pair minmax = findMinMaxUsingTournamentMethod(a, l, r);
		int min = minmax.min, max = minmax.max;
		int low = l, high = r;
		for (int i = 0; i < l; i++) {
			if (a[i] > min) {
				low = i;
				break;
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			if (a[i] < max) {
				high = i;
				break;
			}
		}
		return high - low + 1;
	}

	public Pair findMinMaxUsingTournamentMethod(int[] a, int l, int r) {
		int n = r - l + 1;
		if (n == 1) {
			return new Pair(a[l], a[r]);
		} else if (n == 2) {
			if (a[l] > a[r]) {
				return new Pair(a[l], a[r]);
			} else {
				return new Pair(a[r], a[l]);
			}
		}
		int max, min, mid = l + (r - l) / 2;
		Pair lmax = findMinMaxUsingTournamentMethod(a, l, mid);
		Pair rmax = findMinMaxUsingTournamentMethod(a, mid + 1, r);
		max = lmax.max > rmax.max ? lmax.max : rmax.max;
		min = lmax.min < rmax.min ? lmax.min : rmax.min;
		return new Pair(max, min);
	}

	public void findDuplicates(int a[], int n) {
		int j;
		for (int i = 0; i < n; i++) {
			j = Math.abs(a[i]);

			if (j == n || a[j] < 0) {
				System.out.println("Duplicate : " + j);
			} else if (a[j] == 0) {
				a[j] = -n;
			} else {
				a[j] = -a[j];
			}
		}
	}

	public void findEqulibriumIndexWithoutExtraSpace(int[] a, int n) {
		int sum = 0;
		int leftSum = 0;

		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		for (int i = 0; i < n; i++) {
			sum -= a[i];
			if (leftSum == sum) {
				System.out.println("Equlibrium Index : " + i);
			}
			leftSum += a[i];
		}
	}

	public void nextGreatElement(int a[], int n) {
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(a[0]);
		for (int i = 1; i < n; i++) {

			if (!stack.isEmpty() && a[i] > stack.peek()) {
				System.out.println(stack.pop() + " - " + a[i]);
			}
			stack.push(a[i]);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " - null");
		}
	}

	public boolean checkIfArrayelementsAreConsecutive(int a[], int n) {
		Pair minmax = findMinMaxUsingTournamentMethod(a, 0, n - 1);
		if (minmax.max - minmax.min + 1 != n) {
			return false;
		}

		int j;
		for (int i = 0; i < n; i++) {
			j = Math.abs(a[i] - minmax.min);
			if (j == n || a[j] < 0) {
				return false;
			} else if (a[j] == 0) {
				a[j] = -n;
			} else { // if{a[j]>0)
				a[j] = -a[j];
			}
		}
		return true;
	}

	// insert and delete k values at end(like stack)
	// delete max from front always(like queue)
	// Time : O(n), Space : O(k)
	public int maxIndexDiff(int a[], int n) {
		int maxIndexDiff = Integer.MIN_VALUE;

		if (n <= 0)
			return maxIndexDiff;
		int leftMin[] = new int[n];
		int rightMax[] = new int[n];

		leftMin[0] = a[0];
		rightMax[n - 1] = a[n - 1];
		for (int i = 1; i < n; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], a[i]);
		}

		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], a[i]);
		}
		int i = 0, j = 0;
		while (i < n && j < n) {
			if (leftMin[i] < rightMax[j]) {
				maxIndexDiff = Math.max(j - i, maxIndexDiff);
				j++;
			} else {
				i++;
			}
		}
		return maxIndexDiff;
	}

	// Time : O(n)
	public void maxOfAllSubarraysOfSizeK(int a[], int n, int k) {

		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		for (int i = k; i < n; i++) {
			System.out.print(a[dq.peekFirst()] + " ");
			while (!dq.isEmpty() && i - dq.peekFirst() >= k) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.println(a[dq.peekFirst()] + " ");

	}

	// Time : O(mlogm+nlogn)
	public boolean checkWhetherBisSubSetofA(int a[], int m, int b[], int n) {
		if (m < n)
			return false;
		Arrays.sort(a);
		Arrays.sort(b);

		int i = 0, j = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				return false;
			} else {
				i++;
				j++;
			}
		}

		if (j < n)
			return false;
		return true;
	}

	// Time : O(m+n), Space : O(n)
	public boolean checkWhetherBisSubSetofAUsingHashSet(int a[], int m, int b[], int n) {
		if (m < n)
			return false;

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			set.add(a[i]);
		}
		for (int i = 0; i < n; i++) {
			if (!set.contains(b[i]))
				return false;
		}
		return true;
	}

	public int minDistanceBetweenTwoNumber(int a[], int n, int x, int y) {
		int minDistance = Integer.MIN_VALUE;
		if (n <= 0)
			return minDistance;

		int lastFound = -1, lastFoundIndex = -1;

		for (int i = 0; i < n; i++) {
			if (a[i] == x || a[i] == y) {
				if (lastFound == -1) {
					lastFound = a[i];
					lastFoundIndex = i;
				} else if (lastFound != a[i]) {
					minDistance = Integer.min(i - lastFoundIndex, minDistance);
					lastFound = a[i];
					lastFoundIndex = i;
				} else {
					lastFoundIndex = i;
				}
			}
		}

		return minDistance;
	}

	public void findMissingAndRepeating(int a[], int n) {
		int j;

		for (int i = 0; i < n; i++) {
			j = Math.abs(a[i]) - 1;
			if (a[j] < 0) {
				System.out.println("Repeating : " + (j + 1));
			} else {
				a[j] = -a[j];
			}
		}

		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				System.out.println("Missing : " + (i + 1));
				return;
			}
		}
	}

	public int maxLengthOfBitonic(int a[], int n) {
		int lis[] = new int[n];
		int lds[] = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = lds[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				lis[i] = lis[i - 1] + 1;
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			if (a[i] < a[i + 1]) {
				lds[i] = lds[i + 1] + 1;
			}
		}

		int maxLen = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			maxLen = Integer.max(maxLen, lis[i] + lds[i] - 1);
		}
		return maxLen;
	}

	// Time : O(nlogn), Space : O(n)
	public void countSmallerNodesOnRight(int[] a, int n) {
		AVLTreeWithSize tree = new AVLTreeWithSize();
		int count[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			tree.root = tree.insert(tree.root, a[i]);
			count[i] = tree.count;
		}
		CommonUtil.printArray(a);
		CommonUtil.printArray(count);
	}

	public int minJumpsToReachEnd(int a[], int n) {
		if (n <= 0)
			return Integer.MAX_VALUE;
		int t[] = new int[n];

		if (a[0] <= 0)
			return Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			t[i] = Integer.MAX_VALUE;
		}
		t[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j + a[j] >= i) {
					t[i] = Math.min(t[i], 1 + t[j]);
				}
			}
		}
		return t[n - 1];
	}

	public void subArraysOfSumK(int[] a, int n, int k) {

		int sum = 0;
		int l = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] == k) {
				printSubarray(a, i, i);
				l = i + 1;
				sum = 0;
				continue;
			}

			sum += a[i];
			if (sum == k) {
				printSubarray(a, l, i);
				sum = sum - a[l];
				l++;
			}

			while (sum > k) {
				sum -= a[l];
				l++;
				if (sum == k) {
					printSubarray(a, l, i);
				}
			}
		}
	}

	public void printSubarray(int[] a, int l, int r) {
		for (int i = l; i <= r; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void findTripletWithSumK(int a[], int n, int k) {
		int l, r, sum;
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			l = i + 1;
			r = n - 1;
			while (l < r) {
				sum = a[i] + a[l] + a[r];
				if (sum > k) {
					r--;
				} else if (sum < k) {
					l++;
				} else {
					System.out.println("1st=" + a[i] + ",2nd=" + a[l] + ",3rd=" + a[r] + ",sum=" + k);
					l++;
					r--;
				}
			}
		}
	}

	public int findSmallestMissingPositiveNumber(int[] a, int n) {
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && a[l] > 0) {
				l++;
			}
			while (l < r && a[r] < 0) {
				r--;
			}
			if (l < r) {
				CommonUtil.swap(a, l, r);
				l++;
				r--;
			}
		}
		CommonUtil.printArray(a);

		int index;
		for (int i = 0; i < l; i++) {
			index = Math.abs(a[i]) - 1;
			if (index < l && a[index] > 0) {
				a[index] = -a[index];
			}
		}

		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				return i + 1;
			}
		}
		return l;
	}

	public int celebrityProblem(int a[], int n) {
		int l = 0;
		int r = n - 1;
		while (l < r) {
			if (knows(l, r)) {
				l++;
			} else {
				r--;
			}
		}
		// either l or r can be remnant. let's assume l is remnant
		int celebrity = knows(l, r) ? r : l;
		for (int i = 0; i < n; i++) {
			if (celebrity != i) {
				if (knows(celebrity, i) || !knows(i, celebrity))
					return -1;
			}
		}
		return celebrity;
	}

	public boolean knows(int l, int r) {
		// TODO Auto-generated method stub
		return false;
	}

	public void sortedSequenceOfLength3(int[] a, int n) {
		if (n < 3)
			return;
		int smaller[] = new int[n];
		int larger[] = new int[n];
		int minIndex = 0, maxIndex = n - 1;
		smaller[0] = 0;
		larger[n - 1] = n - 1;
		for (int i = 1; i < n; i++) {
			if (a[i] <= a[minIndex]) {
				smaller[i] = i;
				minIndex = i;
			} else {
				smaller[i] = minIndex;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] >= a[maxIndex]) {
				larger[i] = i;
				maxIndex = i;
			} else {
				larger[i] = maxIndex;
			}
		}
		for (int i = 0; i < n; i++) {
			if (smaller[i] != i && larger[i] != i) {
				System.out.println(a[smaller[i]] + " " + a[i] + " " + a[larger[i]]);
			}
		}
	}

	public void findSortedSequenceOfLength3(int[] a, int n) {

		if (n < 3)
			return;

		int smaller[] = new int[n];
		int larger[] = new int[n];
		int min = 0;
		int max = n - 1;

		smaller[0] = -1;
		larger[n - 1] = -1;

		for (int i = 1; i < n; i++) {
			if (a[i] > a[min]) {
				smaller[i] = min;
			} else {
				smaller[i] = -1;
				min = i;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] < a[max]) {
				larger[i] = max;
			} else {
				larger[i] = -1;
				max = i;
			}
		}

		for (int i = 0; i < n; i++) {
			if (smaller[i] != -1 && larger[i] != -1) {
				System.out.println(a[smaller[i]] + " " + a[i] + " " + a[larger[i]]);
			}
		}
	}

	public int maxProductSubArray(int a[], int n) {
		if (n <= 0) {
			return Integer.MIN_VALUE;
		}

		int maxProduct, maxEndingHere, minEndingHere;
		maxProduct = maxEndingHere = minEndingHere = a[0];
		int tempMax, tempMin;
		for (int i = 1; i < n; i++) {
			tempMax = maxEndingHere;
			tempMin = minEndingHere;
			maxEndingHere = Math.max(a[i], Math.max(a[i] * tempMax, a[i] * tempMin));
			minEndingHere = Math.min(a[i], Math.min(a[i] * tempMax, a[i] * tempMin));
			maxProduct = Math.max(maxEndingHere, maxProduct);
		}
		return maxProduct;
	}

	public void findPairWithGivenDifferenceK(int a[], int n, int k) {
		int l, r, diff;
		l = r = 0;
		while (r < n) {
			diff = a[r] - a[l];
			if (k > diff) {
				r++;
			} else if (k < diff) {
				l++;
			} else {
				System.out.println(a[r] + "-" + a[l] + "=" + diff);
				l++;
				r++;
			}
		}
	}

	public void replaceWithMaxOnRight(int[] a, int n) {
		if (n <= 0)
			return;
		int maxFromRight = a[n - 1];
		a[n - 1] = -1;
		int temp;
		for (int i = n - 2; i >= 0; i--) {
			temp = maxFromRight;
			maxFromRight = Math.max(a[i], maxFromRight);
			a[i] = temp;
		}
	}

	// Time : O(n2logn)
	public void fourElementsSumToK(int a[], int n, int k) {
		if (n < 4)
			return;
		int size = (n * (n - 1)) / 2;
		Elem t[] = new Elem[size];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				t[index++] = new Elem(a[i], i, j);
			}
		}
		Arrays.sort(t, sortByVal);

		int l = 0, r = size - 1;
		int sum;
		while (l < r) {
			sum = t[l].value + t[r].value;
			if (sum > k) {
				r--;
			} else if (sum < k) {
				l++;
			} else {
				if (nocommonIndex(t[l], t[r])) {
					System.out
							.println(a[t[l].first] + " " + a[t[l].second] + " " + a[t[r].first] + " " + a[t[r].second]);
					l++;
					r--;
				}
			}
		}
	}

	Comparator<Elem> sortByVal = new Comparator<Elem>() {
		public int compare(Elem e1, Elem e2) {
			return e1.value - e2.value;
		}
	};

	public boolean nocommonIndex(Elem e1, Elem e2) {
		if (e1.first == e2.first || e1.first == e2.second || e1.second == e2.first || e1.second == e2.second) {
			return false;
		}
		return true;
	}

	// Time : O(nlogk), Space : O(k)
	public void sortKSortedArray(int a[], int n, int k) {
		MinHeap<Integer> minHeap = new MinHeap<>();
		for (int i = 0; i < k; i++) {
			minHeap.add(a[i]);
		}
		int val, j = 0;
		for (int i = k; i < n; i++) {
			val = minHeap.minValue();
			a[j++] = val;
			minHeap.remove();
			minHeap.add(a[i]);
		}
		for (int i = 0; i < k; i++) {
			val = minHeap.minValue();
			a[j++] = val;
			minHeap.remove();
		}
	}

	// Time : O(nlogk), Space : O(k)
	public void sortKSortedArrayUsingAvl(int a[], int n, int k) {
		AVLTree tree = new AVLTree();
		for (int i = 0; i < k; i++) {
			tree.root = tree.insert(tree.root, a[i]);
		}
		int val, j = 0;
		for (int i = k; i < n; i++) {
			val = tree.findMin(tree.root).data;
			a[j++] = val;
			tree.root = tree.delete(tree.root, val);
			tree.root = tree.insert(tree.root, a[i]);
		}
		for (int i = 0; i < k; i++) {
			val = tree.findMin(tree.root).data;
			a[j++] = val;
			tree.root = tree.delete(tree.root, val);
		}
	}

	// Time : O(n)
	public int maxCircularSubarraySum(int a[], int n) {
		int max_actual_kadane = largestContiguousSumUsingKadane(a, n).maxSum;
		int flipped_total = 0;
		for (int i = 0; i < n; i++) {
			a[i] = -a[i];
			flipped_total += a[i];
		}
		int max_flipped_kadane = largestContiguousSumUsingKadane(a, n).maxSum;
		int max_wrap = -(flipped_total - max_flipped_kadane);
		return max_actual_kadane > max_wrap ? max_actual_kadane : max_wrap;
	}

	public int findRowWithMax1s(int a[][], int m, int n) {
		int maxRow = -1;
		int j = n - 1;
		for (int i = 0; i < m; i++) {
			while (j >= 0 && a[i][j] == 1) {
				j--;
				maxRow = i;
			}
		}
		return maxRow;
	}

	public int findRowWithMax0s(int a[][], int m, int n) {
		int maxRow = -1;
		int j = 0;
		for (int i = 0; i < m; i++) {
			while (j < n && a[i][j] == 0) {
				j++;
				maxRow = i;
			}
		}
		return maxRow;
	}

	// Time :O(n)
	public void shuffle(int a[], int n) {
		int rand;
		for (int i = n - 1; i > 0; i--) {
			rand = (int) (Math.random() * (i + 1));
			CommonUtil.swap(a, i, rand);
		}
	}

	public int countPossibleTriangles(int a[], int n) {
		int count = 0;
		if (n < 3)
			return count;
		int k;
		Arrays.sort(a);
		for (int i = 0; i < n - 2; i++) {
			k = i + 2;
			for (int j = i + 1; j < n - 1; j++) {
				while (k < n && a[i] + a[j] > a[k]) {
					if (k != j) {
						count++;
						System.out.println(a[i] + " + " + a[j] + " > " + a[k] + "");
					}
					k++;
				}
			}
		}
		return count;
	}

	public int coutnPythogareanTriplets(int a[], int n) {
		int count = 0;
		if (n < 3)
			return count;
		int k;
		Arrays.sort(a);
		for (int i = 0; i < n - 2; i++) {
			k = i + 2;
			for (int j = i + 1; j < n - 1; j++) {
				while (k < n && a[i] + a[j] > a[k]) {
					if (k != j && isPythogarean(a[i], a[j], a[k])) {
						count++;
						System.out.println(a[i] + " + " + a[j] + " > " + a[k] + "");
					}
					k++;
				}
			}
		}
		return count;
	}

	public int coutnPythogareanTripletsMethod2(int a[], int n) {
		for (int i = 0; i < n; i++) {
			a[i] = a[i] * a[i];
		}
		Arrays.sort(a);
		int l, r, sum;
		int count = 0;
		for (int i = n - 1; i >= 2; i--) {
			l = 0;
			r = i - 1;
			while (l < r) {
				sum = a[l] + a[r];
				if (sum > a[i]) {
					r--;
				} else if (sum < a[i]) {
					l++;
				} else {
					count++;
					l++;
					r--;
				}
			}
		}
		return count;
	}

	public boolean isPythogarean(int a, int b, int c) {
		return (a * a) + (b * b) == (c * c);
	}

	// new size of array, after removing duplicates
	// Time : O(n2)
	public int removeDuplicatesInArray(int a[], int n) {
		int key, removed;
		for (int i = 0; i < n; i++) {
			key = a[i];
			removed = 0;
			for (int j = i + 1, k = i + 1; j < n; j++) {
				if (a[j] == key) {
					removed++;
				} else {
					a[k++] = a[j];
				}
			}
			n = n - removed;
		}
		return n;
	}

	// Time : O(nlogn)
	public int removeDuplicateInArrayUsingSorting(int a[], int n) {
		Arrays.sort(a);
		for (int i = 1; i < n; i++) {
			if (a[i] == a[i - 1])
				a[i - 1] = 0;
		}
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && a[l] != 0)
				l++;
			while (l < r && a[r] == 0)
				r--;
			if (l < r)
				CommonUtil.swap(a, l++, r--);
		}
		return l;
	}

	public int rainWaterTrapped(int a[], int n) {
		if (n <= 1)
			return 0;
		int lMax[] = new int[n];
		int rMax[] = new int[n];

		int max_on_left = a[0];
		int max_on_right = a[n - 1];

		for (int i = 1; i < n; i++) {
			lMax[i] = max_on_left;
			max_on_left = Math.max(a[i], max_on_left);
		}

		for (int i = n - 2; i >= 0; i--) {
			rMax[i] = max_on_right;
			max_on_right = Math.max(a[i], max_on_right);
		}

		int t = 0;

		for (int i = 1; i < n - 1; i++) {
			if (a[i] < lMax[i] && a[i] < rMax[i]) {
				t += Math.min(lMax[i], rMax[i]) - a[i];
			}
		}
		return t;
	}

	public int maxProfitWith1Transactions(int a[], int n) {
		if (n <= 1)
			return 0;
		int min_so_far = a[0];
		int max_profit = 0;
		for (int i = 1; i < n; i++) {
			max_profit = Math.max(a[i] - min_so_far, max_profit);
			min_so_far = Math.min(min_so_far, a[i]);
		}
		return max_profit;
	}

	public int maxProfitWithAnyNumberOfTransactions(int a[], int n) {
		if (n <= 1)
			return 0;
		int profit = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1])
				profit += a[i] - a[i - 1];
		}
		return profit;
	}

	public int maxProfitWithKTransactions(int a[], int n, int k) {
		if (n <= 1)
			return 0;
		int t[][] = new int[k + 1][n];
		for (int i = 0; i < n; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= k; i++) {
			t[i][0] = 0;
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				int val = 0;
				for (int m = 0; m < j; m++) {
					val = Math.max(a[j] - a[m] + t[i - 1][m], val);
				}
				t[i][j] = Math.max(t[i - 1][j], val);
			}
		}
		return t[k][n - 1];
	}

	public int maxProfitWithKTransactionsUsingMaxDiff(int a[], int n, int k) {
		if (n <= 1)
			return 0;
		int t[][] = new int[k + 1][n];
		for (int i = 0; i < n; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= k; i++) {
			t[i][0] = 0;
		}
		int maxDiff;
		for (int i = 1; i <= k; i++) {
			maxDiff = t[i - 1][0] - a[0];
			for (int j = 1; j < n; j++) {
				t[i][j] = Math.max(t[i - 1][j], maxDiff + a[j]);
				maxDiff = Integer.max(maxDiff, t[i - 1][j] - a[j]);
			}
		}
		return t[k][n - 1];
	}

	public char findMostFrequentCharacter(char[] a, int n) {
		int t[] = new int[256];
		for (int i = 0; i < n; i++) {
			t[a[i]]++;
		}
		int maxCount = 0;
		char frequentChar = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] > maxCount) {
				maxCount = t[i];
				frequentChar = (char) i;
			}
		}
		return frequentChar;
	}

	// if 468 is given,it's reversed to 864
	public int reverseInteger(int n) {
		int rev = 0;
		while (n != 0) {
			rev = rev * 10 + (n % 10);
			n = n / 10;
		}
		return rev;
	}

	// if string is aaacccbbde,then it should print a3c3b2de
	// if string is abc,then it should print abc
	public String compressString(String str, int n) {
		if (null == str || str.length() <= 1)
			return str;
		StringBuffer sb = new StringBuffer();

		char pre = str.charAt(0), cur;
		int count = 1;
		for (int i = 1; i < n; i++) {
			cur = str.charAt(i);
			if (cur == pre) {
				count++;
			} else {
				sb.append(pre);
				if (count > 1)
					sb.append(count);
				pre = cur;
				count = 1;
			}
		}
		sb.append(pre);
		if (count > 1)
			sb.append(count);
		return sb.toString();
	}

	/*
	 * We have two sorted array. Without using additional memory we need to
	 * merge these two arrays(longer array is having more space for merging).
	 * Output should return through second arraY
	 */
	public void mergeTwoArraysWithoutExtraSpace(int longArr[], int longUsed, int shortArr[], int shortArrLen) {
		int longArrTail = longUsed - 1;
		int shortArrTail = shortArrLen - 1;
		while (shortArrTail >= 0 && longArrTail >= 0) {
			if (longArr[longArrTail] > shortArr[shortArrTail]) {
				longArr[longArrTail + shortArrTail + 1] = longArr[longArrTail];
				longArrTail--;
			} else {
				longArr[longArrTail + shortArrTail + 1] = shortArr[shortArrTail];
				shortArrTail--;
			}
		}

		while (shortArrTail >= 0) {
			longArr[shortArrTail] = shortArr[shortArrTail];
			shortArrTail--;
		}
	}

	// array is of k*n size
	// k sorted array and each array has length of n
	// O(nklogk), space : O(k)
	public int[] mergeKSortedArrays(int a[][], int n, int k) {
		int ptr[] = new int[k];
		// pointers of each array
		for (int i = 0; i < k; i++) {
			ptr[i] = 0;
		}
		BinaryMinHeap<HeapNode> heap = new BinaryMinHeap<>();
		for (int i = 0; i < k; i++) {
			if (ptr[i] < n) {
				HeapNode node = new HeapNode(a[i][ptr[i]], i);
				heap.add(a[i][ptr[i]], node);
			} else {
				HeapNode node = new HeapNode(Integer.MAX_VALUE, i);
				heap.add(Integer.MAX_VALUE, node);
			}
		}

		int res[] = new int[n * k];

		HeapNode temp;
		for (int i = 0; i < n * k; i++) {
			temp = heap.extractMin();
			res[i] = temp.value;
			ptr[temp.listNumber]++;
			if (ptr[temp.listNumber] < n) {
				HeapNode node = new HeapNode(a[temp.listNumber][ptr[temp.listNumber]], temp.listNumber);
				heap.add(a[temp.listNumber][ptr[temp.listNumber]], node);
			} else {
				HeapNode node = new HeapNode(Integer.MAX_VALUE, temp.listNumber);
				heap.add(Integer.MAX_VALUE, node);
			}
		}
		return res;
	}

	// Time : O(nk2), Space: it becomes more
	public int[] mergeKSortedArraysUsingMergeProcedure(int a[][], int n, int k) {
		if (k <= 0)
			return null;
		int[] p;
		p = a[0];
		for (int i = 1; i < k; i++) {
			p = merge(p, p.length, a[i], a[i].length);
		}

		return p;
	}

	public int[] merge(int a[], int m, int b[], int n) {
		int c[] = new int[m + n];
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		while (i < m) {
			c[k++] = a[i++];
		}

		while (j < n) {
			c[k++] = b[j++];
		}

		return c;
	}
}

class HeapNode {
	int value;
	int listNumber;

	public HeapNode(int value, int listNumber) {
		super();
		this.value = value;
		this.listNumber = listNumber;
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

class Elem {
	int value;
	int first;
	int second;

	public Elem(int value, int first, int second) {
		super();
		this.value = value;
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Elem [value=" + value + ", first=" + first + ", second=" + second + "]";
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