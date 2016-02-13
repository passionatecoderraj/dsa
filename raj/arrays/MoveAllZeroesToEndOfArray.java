package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/*
 * @Author Raj
 * 
 * 
 */

public class MoveAllZeroesToEndOfArray {

	public static void main(String[] args) {
		int a[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
		int n = a.length;
		MoveAllZeroesToEndOfArray obj = new MoveAllZeroesToEndOfArray();
		// Time : O(n), Space: O(1)
		obj.moveZeroesToEndOfArray(a, n);
		CommonUtil.printArray(a);

		int b[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };

		// Time : O(n), Space: O(1)
		obj.moveZeroesToEndOfArrayMethod2(b, b.length);
		CommonUtil.printArray(b);

	}

	public void moveZeroesToEndOfArrayMethod2(int[] a, int n) {
		int l = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] != 0)
				a[l++] = a[i];
		}
		while (l < n)
			a[l++] = 0;
	}

	public void moveZeroesToEndOfArray(int[] a, int n) {
		int l = 0, r = n - 1;
		while (l < r) {
			while (a[l] != 0 && l < r)
				l++;
			while (a[r] == 0 && l < r)
				r--;
			if (l < r)
				CommonUtil.swap(a, l++, r--);
		}
	}

}
