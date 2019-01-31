/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 *
 *Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.

 */

public class ReversePairs {

	// https://leetcode.com/problems/reverse-pairs/discuss/97280/Very-Short-and-Clear-MergeSort-and-BST-Java-Solutions
	// Time : O(nlogn), Space : O(n)
	public int reversePairs(int[] nums) {
		int[] count = new int[1];
		mergesort(nums, count, 0, nums.length - 1);
		return count[0];
	}

	private void mergesort(int[] nums, int[] count, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergesort(nums, count, start, mid);
			mergesort(nums, count, mid + 1, end);
			for (int i = start, j = mid + 1; i <= mid; i++) {
				while (j <= end && nums[i] / 2.0 > nums[j])
					j++;
				count[0] += j - (mid + 1);
			}
			merge(nums, start, mid, end);
		}
	}

	private void merge(int[] a, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int[] res = new int[end - start + 1];

		int k = 0;
		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				res[k++] = a[i++];
			} else {
				res[k++] = a[j++];
			}
		}
		while (i <= mid) {
			res[k++] = a[i++];
		}
		while (j <= end) {
			res[k++] = a[j++];
		}
		for (int p = 0; p < res.length; p++) {
			a[start + p] = res[p];
		}
	}

	public static void main(String[] args) {
		ReversePairs obj = new ReversePairs();
		int a[] = { 1, 3, 2, 3, 1 };
		int res = -1;
		res = obj.reversePairs(a);
		System.out.println(res);
	}

}
