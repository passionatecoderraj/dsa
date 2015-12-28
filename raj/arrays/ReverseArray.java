/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseArray obj = new ReverseArray();
		int a[] = { 1, 2, 3, 4, 5 };
		obj.reverse(a);
		CommonUtil.printArray(a);
		obj.reverseRecursive(a, 0, a.length - 1);
		CommonUtil.printArray(a);
	}

	public void reverseRecursive(int[] a, int l, int r) {
		if (l > r)
			return;
		int temp;

		temp = a[l];
		a[l] = a[r];
		a[r] = temp;
		reverseRecursive(a, ++l, --r);
	}

	public void reverse(int[] a) {
		int l = 0, r = a.length - 1, temp;

		while (l < r) {
			temp = a[l];
			a[l] = a[r];
			a[r] = temp;
			l++;
			r--;
		}

	}

}
