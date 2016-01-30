/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

import com.interivew.graph.CommonUtil;

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
