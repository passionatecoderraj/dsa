/**
 * 
 */
package com.raj.leetcode;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 * 
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]

 * 
 */


public class WiggleSort {

	// Time : O(n), Space : O(1)
	public void wiggleSort(int[] a) {
		for (int i = 1; i < a.length; i += 2) {
			if (i > 0 && a[i] < a[i - 1]) {
				CommonUtil.swap(a, i, i - 1);
			}
			if (i < a.length - 1 && a[i] < a[i + 1]) {
				CommonUtil.swap(a, i, i + 1);
			}
		}
	}

	public static void main(String[] args) {

		WiggleSort obj = new WiggleSort();

		int a[] = { 10, 90, 49, 2, 1, 5 };

		obj.wiggleSort(a);
		CommonUtil.printArray(a);
	}

}
