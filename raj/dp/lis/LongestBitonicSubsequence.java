package com.raj.dp.lis;

import com.interivew.graph.CommonUtil;

public class LongestBitonicSubsequence {
	public static void main(String[] args) {
		LongestBitonicSubsequence obj = new LongestBitonicSubsequence();
		int result = -1;
		// int a[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		// int a[] = { 1, 101, 2, 3, 100, 4, 5 };
		// int a[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		int[] a = { 1, 11, 2, 10, 4, 5, 2, 1 };
		result = obj.bitonicDpOn2(a);
		System.out.println(result);
//		result = obj.bitonicDpOnlogn(a);
//		System.out.println(result);
	}

	public int bitonicDpOn2(int[] a) {

		int n = a.length;

		if (n <= 0)
			return -1;

		int lis[] = new int[n];
		int lds[] = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					if (lis[j] + 1 > lis[i]) {
						lis[i] = lis[j] + 1;
					}
				}
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (a[i] > a[j]) {
					if (lds[j] + 1 > lds[i]) {
						lds[i] = lds[j] + 1;
					}
				}
			}
		}

		CommonUtil.printArray(lis);
		CommonUtil.printArray(lds);
			int max = 1;
		for (int i = 0; i < n; i++) {
			System.out.print(lis[i] + "-" + lds[i] + ", ");
			if (lis[i] + lds[i] - 1 > max)
				max = lis[i] + lds[i] - 1;
		}
		System.out.println();
		return max;
	}
	
/*	public int bitonicDpOnlogn(int[] a) {
		int n = a.length;
		int max = -1;

		if (n <= 0)
			return max;
		int lis[] = new int[n];
		int result1[] = new int[n];
		for (int i = 0; i < n; i++)
			result1[i] = -1;
		int len1 = 0;
		lis[len1] = 0;

		for (int i = 1; i < n; i++) {
			if (a[i] > a[lis[len1]]) {
				len1++;
				lis[len1] = i;
				result1[i] = lis[len1 - 1];
			} else if (a[i] <= a[lis[0]]) {
				lis[0] = i;
			} else {
				int index = binarySearchForIndex(a, lis, -1, len1, a[i]);
				lis[index] = i;
				result1[i] = lis[index - 1];
			}
		}
		printIncreasingPath(a, result1, lis[len1]);
		System.out.println();
		CommonUtil.printArray(lis);

		int lds[] = new int[n];
		lds[n - 1] = a[n - 1];
		int result2[] = new int[n];
		for (int i = 0; i < n; i++)
			result1[i] = -1;
		int len2 = 0;

		return len1 + 1;
	}

	public void printIncreasingPath(int[] a, int[] result, int i) {
		if (i >= 0) {
			printIncreasingPath(a, result, result[i]);
			System.out.print(a[i] + "->");
		}
	}

	public int binarySearchForIndex(int a[], int c[], int l, int r, int key) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (a[c[m]] >= key) {
				r = m;
			} else {
				l = m;
			}
		}
		return r;
	}
	*/


}
