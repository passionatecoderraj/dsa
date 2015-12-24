package com.raj.dp.lis;

import com.interivew.graph.CommonUtil;

public class LongestDecreasingSequence {
	public static void main(String[] args) {
		LongestDecreasingSequence obj = new LongestDecreasingSequence();
		int result = -1;

		int a[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		// int a[] = { 80, 60, 41, 50, 21, 33, 9, 22, 10 };
		result = obj.ldsDpOn2(a);
		System.out.println(result);
		result = obj.ldsDpOnlogn(a);
		System.out.println(result);

	}

	public int ldsDpOnlogn(int[] a) {
		int n = a.length;
		if (n <= 0)
			return -1;

		int t[] = new int[n];
		int result[] = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = -1;
		}

		int len = 0;
		t[len] = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] < a[t[len]]) {
				len++;
				t[len] = i;
				result[i] = t[len - 1];
			} else if (a[i] > a[t[0]]) {
				t[0] = i;
			} else {
				int index = binarySearchForIndex(a, t, -1, len, a[i]);
				t[index] = i;
				result[i] = t[index - 1];
			}
		}
//		CommonUtil.printArray(t);
//		CommonUtil.printArray(result);
		printPath(a, result, t[len]);
		System.out.println();
		return len + 1;
	}

	public void printPath(int[] a, int[] result, int i) {
		if (i >= 0) {
			printIncreasingPath(a, result, result[i]);
			System.out.print(a[i] + "->");
		}
	}

	public void printIncreasingPath(int[] a, int[] result, int i) {
		if (i >= 0) {
			printIncreasingPath(a, result, result[i]);
			System.out.print(a[i] + "->");
		}
	}

	public int binarySearchForIndex(int[] a, int[] c, int l, int r, int x) {

		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (a[c[m]] <= x) {
				r = m;
			} else {
				l = m;
			}

		}
		return r;
	}

	public int ldsDpOn2(int[] a) {

		int n = a.length;

		if (n <= 0)
			return -1;

		int t[] = new int[n];

		for (int i = 0; i < n; i++) {
			t[i] = 1;
		}

		int max = t[0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					if (t[j] + 1 > t[i]) {
						t[i] = t[j] + 1;
						if (t[i] > max)
							max = t[i];
					}
				}
			}
		}
		CommonUtil.printArray(t);
		return max;
	}
}
