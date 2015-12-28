package com.raj.arrays;

import com.interivew.graph.CommonUtil;

public class RotateArray {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int d = 4, n = a.length;
		RotateArray obj = new RotateArray();
		// Time : O(n), Space: O(n)
		obj.rotateArray(a, n, d);
		CommonUtil.printArray(a);

		// Time : O(n), Space: O(d)
		obj.rotateArrayWithTempArrayForD(a, n, d);
		CommonUtil.printArray(a);

		// Time : O(n*d), Space: O(1)
		obj.rotateArrayBySinglePositionEachTime(a, n, d);
		CommonUtil.printArray(a);

		// Time : O(n), Space: O(1); using reversal technique
		obj.rotateArrayUsingReversal(a, n, d);
		CommonUtil.printArray(a);

	}

	public void rotateArrayUsingReversal(int[] a, int n, int d) {
		reverse(a, 0, d - 1);
		reverse(a, d, n - 1);
		reverse(a, 0, n - 1);
	}

	public void reverse(int a[], int start, int end) {
		int temp;
		while (start < end) {
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	public void rotateArrayBySinglePositionEachTime(int[] a, int n, int d) {
		for (int i = 0; i < d; i++) {
			leftRotate(a);
		}
	}

	private void leftRotate(int[] a) {
		int n = a.length;
		int temp = a[0];
		for (int i = 0; i < n - 1; i++) {
			a[i] = a[i + 1];
		}
		a[n - 1] = temp;
	}

	public void rotateArrayWithTempArrayForD(int[] a, int n, int d) {
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = a[i];
		}
		int j = 0;
		for (int i = d; i < n; i++) {
			a[j] = a[i];
			j++;
		}

		for (int i = 0; i < d; i++) {
			a[j] = temp[i];
			j++;
		}

	}

	public void rotateArray(int[] a, int n, int d) {
		int temp[] = new int[n];
		for (int i = 0; i < n; i++)
			temp[i] = a[i];

		int j = 0;
		for (int i = d; i < n; i++) {
			a[j] = temp[i];
			j++;
		}
		for (int i = 0; i < d; i++) {
			a[j] = temp[i];
			j++;
		}
	}

}
