package com.raj.dp.lis;

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

		int max = 1;
		for (int i = 0; i < n; i++) {
			System.out.print(lis[i] + "-" + lds[i] + ", ");
			if (lis[i] + lds[i] - 1 > max)
				max = lis[i] + lds[i] - 1;
		}
		System.out.println();
		return max;
	}
}
