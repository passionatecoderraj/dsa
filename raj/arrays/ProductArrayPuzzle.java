/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 *
 *         Given an array arr[] of n integers, construct a Product Array prod[]
 *         (of same size) such that prod[i] is equal to the product of all the
 *         elements of arr[] except arr[i]. Solve it without division operator
 *         and in O(n).
 */
public class ProductArrayPuzzle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductArrayPuzzle obj = new ProductArrayPuzzle();
		int a[] = { 10, 3, 5, 6, 2 };
		int n = a.length;
		// Time : O(n), space : O(n), Auxiliary space : O(n)
		obj.productArray(a, n);
		// Time : O(n), space : O(n), Auxiliary space : O(1)
		obj.productArrayWithoutAuxiliarySpace(a, n);
	}

	public void productArrayWithoutAuxiliarySpace(int[] a, int n) {
		if (n <= 0)
			return;
		int product[] = new int[n];
		int temp = 1;

		for (int i = 0; i < n; i++) {
			product[i] = temp;
			temp = temp * a[i];
		}
		temp = 1;

		for (int i = n - 1; i >= 0; i--) {
			product[i] = product[i] * temp;
			temp = temp * a[i];
		}
		CommonUtil.printArray(product);
	}

	public void productArray(int[] a, int n) {
		if (n <= 0)
			return;

		int left[] = new int[n];
		int right[] = new int[n];
		int product[] = new int[n];

		left[0] = a[0];
		right[n - 1] = a[n - 1];
		for (int i = 1; i < n; i++) {
			left[i] = a[i] * left[i - 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			right[i] = a[i] * right[i + 1];
		}

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				product[i] = right[i + 1];
			} else if (i == n - 1) {
				product[i] = left[i - 1];
			} else {
				product[i] = left[i - 1] * right[i + 1];
			}
		}
		CommonUtil.printArray(product);
	}

}
