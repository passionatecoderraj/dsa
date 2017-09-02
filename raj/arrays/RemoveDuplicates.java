/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicates obj = new RemoveDuplicates();
		int a[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int newSize = -1, n = a.length;

		// without sorting : O(n2)
		newSize = obj.removeDuplicates(a, n);
		System.out.println(newSize);
		CommonUtil.printArray(a);
		int b[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		// Time : O(nlogn)
		newSize = obj.removeDuplicatesUsingSorting(b, b.length);
		System.out.println(newSize);
		CommonUtil.printArray(b);
	}

	public int removeDuplicatesUsingSorting(int[] a, int n) {
		Arrays.sort(a);
		int l = 1;
		for (int i = 1; i < n; i++) {
			if (a[i] != a[i - 1]) {
				a[l++] = a[i];
			}
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
