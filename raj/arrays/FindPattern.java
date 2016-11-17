/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

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
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		obj.findPattern(a);
	}

	public void findPattern(int[] a) {
		int k = (int) Math.sqrt(a.length);
		int t[][] = new int[k][k];

		for (int i = 0, r = 0; i < a.length; i += k, r++) {
			for (int j = i, c = 0; j < i + k; j++, c++) {
				t[r][c] = a[j];
			}
		}
		CommonUtil.print2DArray(t, k, k);
	}

}
