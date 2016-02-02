package com.interivew.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

import com.interivew.graph.CommonUtil;

class JustPractice {

	public int findSmallestMissingNumber(int a[], int l, int r, int n) {
		if (n <= 0)
			return -1;
		if (a[l] > 0)
			return 0;
		if (a[r] == r)
			return r + 1;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m - 1] == m - 1 && a[m] > m)
				return m;
			if (a[m] == m) {
				l = m + 1;
			} else {
				r = m - 1;
			}

		}
		return -1;
	}

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

	public void maxOfAllSubarraysOfSizeK(int a[], int n, int k) {
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()])
				dq.removeLast();
			dq.addLast(i);
		}
		for (int i = k; i < n; i++) {
			System.out.print(dq.peekFirst() + " ");

			while (!dq.isEmpty() && i - dq.peekFirst() >= k)
				dq.removeFirst();
			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()])
				dq.removeLast();
			dq.addLast(i);
		}
		System.out.print(dq.peekFirst() + " ");
	}

	public int findMaxInBitonicUsingBinarySearch(int[] a, int l, int r) {
		int mid;

		while (l <= r) {
			// if there is only one element
			if (l == r) {
				return a[l];
			}
			// if there are only two elements
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

	public int findSmallestPositiveMissingNumber(int a[], int n) {
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && a[l] > 0)
				l++;
			while (l < r && a[r] < 0)
				r--;
			if (l < r) {
				CommonUtil.swap(a, l++, r--);
			}
		}
		// so there are L positive numbers
		for (int i = 0; i < l; i++) {
			int index = a[i] - 1;
			if (index < l && index > 0) {
				if (a[index] < 0)
					a[index] = -a[index];
			}
		}

		for (int i = 0; i < n; i++) {
			if (a[i] > 0)
				return i + 1;

		}
		return l;
	}

	public int celebrityProblem(int a[], int n) {
		int l = 0, r = n - 1;
		while (l < r) {
			if (knows(l, r)) {
				l++;
			} else {
				r--;
			}
		}
		int celebrity = knows(l, r) ? r : l;
		for (int i = 0; i < n; i++) {
			if (celebrity != i) {
				if (knows(celebrity, i) || !knows(i, celebrity))
					return -1;
			}
		}
		return celebrity;
	}

	public boolean knows(int x, int y) {
		return true;
	}

	public void findPairWithGivenDifferenceK(int a[], int n, int k) {
		Arrays.sort(a);
		int l = 0, r = 0;
		int diff;
		while (r < n) {
			diff = Math.abs(a[l] - a[r]);
			if (diff > k) {
				l++;
			} else if (diff < k) {
				r++;
			} else {
				System.out.println("1st=" + a[l] + ", 2nd=" + a[r]);
				l++;
				r++;
			}
		}
	}

	public void replaceWithMaxOnRight(int a[], int n) {
		if (n <= 0)
			return;
		int maxOnRight = a[n - 1];
		a[n - 1] = -1;
		int temp;
		for (int i = n - 2; i >= 0; i--) {
			temp = a[i];
			a[i] = maxOnRight;
			maxOnRight = Math.max(temp, maxOnRight);
		}
	}

	public void findFourElementsWithSumK(int a[], int n, int k) {
		if (n < 4)
			return;
		int l, r, sum;
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				l = j + 1;
				r = n - 1;
				while (l < r) {
					sum = a[i] + a[j] + a[l] + a[r];
					if (sum > k)
						r--;
					else if (sum < k)
						l++;
					else {
						// print a of (i,j,l,r)
						l++;
						r--;
					}
				}
			}
		}
	}

	public void findFourElementsWithSumKOptimized(int a[], int n, int k) {
		int m = (n * (n - 1)) / 2;
		Ele t[] = new Ele[m];
		int idx = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				t[idx++] = new Ele(a[i] + a[j], i, j);
			}
		}
		Arrays.sort(t);
		int l = 0, r = m - 1, sum;
		while (l < r) {
			sum = t[l].val + t[r].val;
			if (sum == k && isNotRepelated(t[l], t[r])) {
				// print t[l] - first, second, t[r]- first,second
			} else if (sum > k) {
				l++;
			} else {
				r--;
			}
		}
	}

	public boolean isNotRepelated(Ele e1, Ele e2) {
		return e1.first != e2.first && e1.first != e2.second && e1.second != e1.first & e1.second != e2.first;
	}

	public int MaxCircularSumSubarray(int a[], int n) {
		KadaneResult norm_kadane = new PracticeArrays().largestContiguousSumUsingKadane(a, n);
		int sum_flipped = 0;
		for (int i = 0; i < n; i++) {
			a[i] = -a[i];
			sum_flipped += a[i];
		}
		KadaneResult flipped_kadane = new PracticeArrays().largestContiguousSumUsingKadane(a, n);
		int max_wrap = -(sum_flipped - flipped_kadane.maxSum);
		int max_kadane = norm_kadane.maxSum;
		return max_kadane > max_wrap ? max_kadane : max_wrap;
	}

	// Time :O(m+n)
	public int findRowWithMax1s(int a[][], int m, int n) {
		int max = Integer.MIN_VALUE;
		int j = 0;
		for (int i = 0; i < m; i++) {
			while (j < n && a[i][j] == 1) {
				j++;
				max = i;
			}
		}
		return max;
	}

	// Time :O(m+n)
	public int findRowWithMax0s(int a[][], int m, int n) {
		int max = Integer.MIN_VALUE;
		int j = n - 1;
		for (int i = 0; i < m; i++) {
			while (j >= 0 && a[i][j] == 0) {
				j--;
				max = i;
			}
		}
		return max;
	}

	public void sorArrayToFormBiggestNumber(int a[], int n) {
		String s[] = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = Integer.toString(a[i]);
		}
		Arrays.sort(s, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String xy = s1 + s2;
				String yx = s2 + s1;
				return yx.compareTo(xy);
			}

		});
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s[i]);
		}

	}

	public void flip(int[] a, int l, int r) {
		while (l < r) {
			CommonUtil.swap(a, l++, r--);
		}
	}

	public int findMaxIndex(int a[], int l, int r) {
		int max_index = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] > a[max_index])
				max_index = i;
		}
		return max_index;
	}

	public int findMinIndex(int a[], int l, int r) {
		int min_index = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] > a[min_index])
				min_index = i;
		}
		return min_index;
	}

	public void pancakeSorting(int a[], int n) {
		int max_index;
		for (int i = n - 1; i > 1; i--) {
			max_index = findMaxIndex(a, 0, i);
			if (i != max_index) {
				flip(a, 0, max_index);
				flip(a, 0, i);
			}
		}
	}

	public void binaryPancakeSorting(int a[], int n) {
		int index;
		for (int i = 1; i < n - 1; i++) {
			index = findBinaryIndex(a, -1, i - 1, a[i]);
			if (index != i) {
				flip(a, index, i - 1);
				flip(a, index, i);
			}
		}
	}

	public int findBinaryIndex(int a[], int l, int r, int key) {
		int m;
		while (r - l > 1) {
			m = l + (r - l) / 2;
			if (a[m] >= key) {
				r = m;
			} else {
				l = m;
			}
		}
		return r;
	}

	public void findAllNumbersRepatingMoreTimes(int a[], int n, int k) {
		for (int i = 0; i < n; i++) {
			a[a[i] % k] = a[a[i] % k] + k;
		}
		for (int i = 0; i < n; i++) {
			a[i] = a[i] / k;
		}
		int max_repeated = 0;
		for (int i = 0; i < n; i++) {
			max_repeated = Math.max(a[i], max_repeated);
		}

		for (int i = 0; i < n; i++) {
			if (a[i] == max_repeated) {
				System.out.println(i);
			}
		}
	}

	public void rearrangePostiveNegative(int a[], int n) {
		int left = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > 0)
				CommonUtil.swap(a, i, left++);
		}
		// there are left positive numbers
		// p = number of positive numbers
		// m = number of negative numbers
		int p, m;
		p = left;
		m = n - p;
		if (p > m) {
			int j = 1;
			for (int i = left; i < n; i++) {
				CommonUtil.swap(a, i, j);
				j = j += 2;
			}
		} else {
			int j = left;
			for (int i = 1; i < p; i += 2) {
				CommonUtil.swap(a, i, j);
				j++;
			}
		}
	}

	public int findPeak(int a[], int l, int r, int n) {
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if ((m == 0 || a[m] >= a[m - 1]) && (m == n - 1 || a[m] >= a[m + 1]))
				return a[m];
			if (m < n - 1 && a[m + 1] > a[m])
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}

	public void printCombinations(String str, int k, int n, StringBuilder sb) {
		if (k == n)
			return;
		for (int i = k; i < n; i++) {
			sb.append(str.charAt(i));
			System.out.println(sb.toString());
			printCombinations(str, k + 1, n, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public void printCombinationsOfSizeR(char[] s, int n, int k, int r, char[] op, int index) {
		if (k == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(op[i]);
			}
			System.out.println();
		}
		for (int i = k; i < n; i++) {
			op[index] = s[i];
			printCombinationsOfSizeR(s, n, k + 1, r, op, index + 1);
		}
	}
}

class Ele {
	int val;
	int first;
	int second;

	public Ele(int val, int first, int second) {
		super();
		this.val = val;
		this.first = first;
		this.second = second;
	}

}
