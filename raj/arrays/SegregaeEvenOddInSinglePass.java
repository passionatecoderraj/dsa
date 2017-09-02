/**
 * 
 */
package com.raj.arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class SegregaeEvenOddInSinglePass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 12, 34, 45, 9, 8, 90, 3 };

		SegregaeEvenOddInSinglePass obj = new SegregaeEvenOddInSinglePass();
		// Of course O(n)
		obj.segregateEvenOddInSinglePass(a, a.length);
		CommonUtil.printArray(a);
	}

	public void segregateEvenOddInSinglePass(int[] a, int n) {
		int left = 0, right = n - 1;
		while (left < right) {
			while (a[left] % 2 == 0 && left < right) {
				left++;
			}
			while (a[right] % 2 != 0 && left < right) {
				right--;
			}
			if (left < right) {
				CommonUtil.swap(a, left, right);
				left++;
				right--;
			}
		}
	}

}
