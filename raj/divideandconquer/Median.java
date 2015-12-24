package com.raj.divideandconquer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Median {

	public static void main(String[] args) {
		Median obj = new Median();
		Set<Integer> series;

		Random rand = new Random();
		int m, n, j;
		int max = 30;

		m = 6;
		series = new HashSet<Integer>(m);
		for (int i = 0; i < m; i++) {
			while (!series.add(rand.nextInt(max))) {
			}
		}

		int[] a = new int[m];
		j = 0;
		for (int item : series) {
			a[j] = item;
			j++;
		}
		series.clear();

		// series

		n = 6;
		series = new HashSet<Integer>(n);
		for (int i = 0; i < n; i++) {
			while (!series.add(rand.nextInt(max))) {
			}
		}
		int[] b = new int[n];
		j = 0;
		for (int item : series) {
			b[j] = item;
			j++;
		}

		int c[] = new int[m + n];
		int k = 0;
		for (int i = 0; i < m; i++) {
			c[k] = a[i];
			k++;
		}

		for (int i = 0; i < n; i++) {
			c[k] = b[i];
			k++;
		}

		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);

		for (int i = 0; i < m; i++)
			System.out.print(i + "=" + a[i] + ", ");
		System.out.println();

		for (int i = 0; i < n; i++)
			System.out.print(i + "=" + b[i] + ", ");
		System.out.println();
		for (int i = 0; i < c.length; i++)
			System.out.print(i + "=" + c[i] + ", ");

		System.out.println();
		System.out.println(obj.median(a, 0, m - 1));
		System.out.println(obj.median(b, 0, n - 1));
		System.out.println(obj.median(c, 0, m + n - 1));

		System.out.println(obj.medianForTwoSortedArraysOfSameSize(a, b, 0, m - 1, 0, n - 1));
	}

	public int medianForTwoSortedArraysOfSameSize(int[] a, int[] b, int low1, int high1, int low2, int high2) {
		int m1, m2;
		int n = high1 - low1 + 1;

		if (n <= 0)
			return -1;
		else if (n == 1) {
			return a[0];
		} else if (n == 2) {
			int l = a[low1] > b[low2] ? a[low1] : b[low2];
			int m = a[high1] < b[high2] ? a[high1] : b[high2];

			return (l + m) / 2;
		} else {
			m1 = median(a, low1, high1);
			m2 = median(b, low2, high2);
			if (m1 == m2)
				return m1;
			else if (m1 > m2) {
				if (n % 2 == 0) {
					return medianForTwoSortedArraysOfSameSize(a, b, low1, low1 + n / 2 - 1, low2 + n / 2, high2);
				} else {
					return medianForTwoSortedArraysOfSameSize(a, b, low1, low1 + n / 2, low2 + n / 2, high2);

				}
			} else if (m1 < m2) {
				if (n % 2 == 0) {
					return medianForTwoSortedArraysOfSameSize(a, b, low1 + n / 2, high1, low2, low2 + n / 2 - 1);
				} else {
					return medianForTwoSortedArraysOfSameSize(a, b, low1 + n / 2, high1, low2, low2 + n / 2);

				}

			}
		}
		return -1;
	}

	public int median(int[] a, int low, int high) {
		int n = high - low + 1;
		if (n % 2 != 0) {
			return a[low + n / 2];
		} else {
			return (a[low + n / 2] + a[low + n / 2 - 1]) / 2;
		}
	}

}
