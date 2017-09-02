/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class PrintDistinctElementsInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintDistinctElementsInArray obj = new PrintDistinctElementsInArray();
		int a[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int n = a.length;
		// Time : O(n), Space : O(n)
		obj.printDistinctElementsUsingHashing(a, n);

		// Time : O(nlogn), Space : O(1)
		obj.printDistinctElementsUsingSorting(a, n);

	}

	public void printDistinctElementsUsingSorting(int a[], int n) {
		if (n <= 1)
			return;
		Arrays.sort(a);

		int prev = a[0];
		System.out.print(a[0] + " ");
		for (int i = 1; i < n; i++) {
			if (a[i] != prev)
				System.out.print(a[i] + " ");
			prev = a[i];
		}
		System.out.println();
	}

	public void printDistinctElementsUsingHashing(int[] a, int n) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i < n; i++) {
			set.add(a[i]);
		}
		CommonUtil.printArray(set);
	}

	public int removeDuplicatesUsingSorting(int[] a, int n) {
		Arrays.sort(a);
		for (int i = 1; i < n; i++) {
			if (a[i] == a[i - 1]) {
				a[i - 1] = 0;
			}
		}

		int l = 0;
		int r = n - 1;
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

	public int removeDuplicates(int[] a, int n) {
		int key, removed = 0;
		for (int i = 0; i < n; i++) {
			key = a[i];
			removed = 0;
			for (int j = i + 1, k = i + 1; j < n; j++) {
				if (key == a[j]) {
					removed++;
				} else {
					a[k++] = a[j];
				}
			}
			n = n - removed;
		}
		return n;
	}

}
