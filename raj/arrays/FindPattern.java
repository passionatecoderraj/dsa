/**
 * 
 */
package com.raj.arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *
 */
public class FindPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindPattern obj = new FindPattern();
		// int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		obj.findPattern(a);
	}

	public void findPattern(int[] a) {
		int k = (int) Math.sqrt(a.length);

		for (int i = 0; i < k; i++) {
			for (int j = i; j < a.length; j += k) {
				System.out.print(a[j] + " ");
			}
		}
		System.out.println();
	}

}
