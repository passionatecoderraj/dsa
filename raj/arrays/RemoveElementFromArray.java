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
public class RemoveElementFromArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveElementFromArray obj = new RemoveElementFromArray();
		int a[] ={ 3, 3, 4, 2, 4, 4, 2, 4, 4 };;
		int newSize = -1, n = a.length;
		int k = 2;

		// without sorting : O(n2)
		newSize = obj.removeElementK(a, n, k);
		System.out.println(newSize);
		CommonUtil.printArray(a, 0, newSize);

	}

	public int removeElementK(int[] a, int n, int k) {
		int l = 0;
		int removed = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] != k) {
				a[l++] = a[i];
			} else {
				removed++;
			}
		}
		return n - removed;
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
