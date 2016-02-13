/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 * 
 */
/*
 * Given a sequence of non-negative integers, find the subsequence of length 3
 * having maximum product with the numbers of the subsequence being in ascending
 * order.
 */
public class FindIncreasingSequenceOfLength3WithMaxProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindIncreasingSequenceOfLength3WithMaxProduct obj = new FindIncreasingSequenceOfLength3WithMaxProduct();
		int a[] = {6, 7, 8, 1, 2, 3, 9, 10} ;
		int n = a.length;

		// Time : O(n), Space:O(n)
		obj.findIncreasingSequenceOfLength3WithMaxProduct(a, n);

	}

	public void findIncreasingSequenceOfLength3WithMaxProduct(int[] a, int n) {
		if (n < 3)
			return;
		// The largest smaller element on left of given element
		int lsl[] = new int[n];
		// The largest greater element on right of given element.
		int lgr[] = new int[n];

		int largestMinOnLeft = a[0], largestMaxOnRight = a[n - 1];

		for (int i = 1; i < n; i++) {
			lsl[i] = largestMinOnLeft;
			largestMinOnLeft = Math.max(largestMinOnLeft, a[i]);
		}

		for (int i = n - 2; i >= 0; i--) {
			lgr[i] = largestMaxOnRight;
			largestMaxOnRight = Math.max(largestMaxOnRight, a[i]);
		}
		int maxProduct = 0, curProd = 0;
		int b, c, d;
		b = c = d = 0;
		for (int i = 0; i < n; i++) {
			curProd = lsl[i] * lgr[i] * a[i];
			if (curProd > maxProduct) {
				maxProduct = curProd;
				b = lsl[i];
				c = lgr[i];
				d = a[i];
			}
		}
		System.out.println("1st=" + b + ",2nd=" + c + ",3rd=" + d);
	}

}
