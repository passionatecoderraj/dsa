package com.raj.divideandconquer.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BinarySearch {

	public static void main(String[] args) {
		Random rand = new Random();
		int n = 20;
		int max = 30;
		Set<Integer> series = new HashSet<Integer>(n);
		for (int i = 0; i < 20; i++) {
			while (!series.add(rand.nextInt(max))) {

			}
		}
		int[] a = new int[20];
		int j = 0;
		for (int item : series) {
			a[j] = item;
			j++;
		}

		// Arrays.sort(a);
		// for (int i = 0; i < 20; i++)
		// System.out.print(i + "=" + a[i] + " ");
		//
		// System.out.println();

		BinarySearch obj = new BinarySearch();
		System.out.println(obj.binarySearch(a, 0, a.length - 1, 10));

		int b[] = { 1, 2, 2, 3, 3, 4, 4, 4, 4, 4 ,5};
		int result = -1;
		int key = 5;
		result = obj.firstOccurence(b, b.length, key);
		System.out.println(result);
		result = obj.lastOccurence(b, b.length, key);
		System.out.println(result);
	}

	public int lastOccurence(int[] a, int n, int key) {
		if (n <= 0)
			return -1;
		if (a[n - 1] == key)
			return n - 1;
		int l = 0, r = n - 1, m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] == key && (m == n - 1 || a[m + 1] != key)) {
				return m;
			}
			if (a[m] > key) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return -1;
	}
	
	public int firstOccurence(int[] a, int n, int key) {
		if (n <= 0)
			return -1;
		if (a[0] == key)
			return 0;
		int l = 0, r = n - 1, m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] == key && (m == 0 || a[m - 1] != key)) {
				return m;
			}
			if (a[m] >= key) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return -1;
	}



	// A iterative binary search function. It returns location of x in
	// given array arr[l..r] if present, otherwise -1
	int binarySearch(int arr[], int l, int r, int x) {
		while (l <= r) {
			// find index of middle element
			int m = (r - l) / 2 + l;
			// System.out.println(m);
			// Check if x is present at mid
			if (arr[m] == x)
				return m;

			// If x greater, ignore left half
			if (arr[m] < x)
				l = m + 1;

			// If x is smaller, ignore right half
			else
				r = m - 1;
		}

		// if we reach here, then element was not present
		return -1;
	}
}
