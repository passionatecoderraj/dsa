package com.raj.dp;

import java.util.Arrays;

public class FindMinimumInDifferencePairsOfArray {
	public static void main(String[] args) {
		FindMinimumInDifferencePairsOfArray obj = new FindMinimumInDifferencePairsOfArray();
		int result = -1;
		// int a[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		// int a[] = { 1, 101, 2, 3, 100, 4, 5 };
		int a[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		result = obj.findMinDifferencePairsOn2(a);
		System.out.println(result);
		result = obj.findMinDifferencePairsOnlogn(a);
		System.out.println(result);

	}

	private int findMinDifferencePairsOnlogn(int[] a) {
		int n = a.length;
		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			int d = diff(a[i - 1], a[i]);
			if (d < min)
				min = d;
		}
		// int count = 0;
		// for (int i = 1; i < n; i++) {
		// int d = diff(a[i - 1], a[i]);
		// if (d == min)
		// count++;
		// }
		//	// System.out.println(count);

		return min;
	}

	public int diff(int i, int j) {
		return i > j ? i - j : j - i;
	}

	int min = Integer.MAX_VALUE;

	public int findMinDifferencePairsOn2(int[] a) {
		int n = a.length;
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				t[i][j] = diff(a[i], a[j]);
				if (t[i][j] < min)
					min = t[i][j];
			}
		}

		// int count = 0;
		// for (int i = 0; i < n; i++) {
		// for (int j = i + 1; j < n; j++) {
		// if (t[i][j] == min) {
		// System.out.println(a[i] + "," + a[j]);
		// count++;
		// }
		// }
		// }
		// System.out.println(count);
		return min;
	}
}
