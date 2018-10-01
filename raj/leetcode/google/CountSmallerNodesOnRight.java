/**
 * 
 */
package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.List;

import com.interview.graph.CommonUtil;
import com.raj.arrays.AVLTreeWithSize;

/**
 * @author Raj
 *
 */

/*
 * Write a function to count number of smaller elements on right of each element
 * in an array. Given an unsorted array arr[] of distinct integers, construct
 * another array countSmaller[] such that countSmaller[i] contains count of
 * smaller elements on right side of each element arr[i] in array.
 */
public class CountSmallerNodesOnRight {

	int[] count;

	// Time : O(nlogn), Space : O(n)
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();

		count = new int[nums.length];
		int[] indexes = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			indexes[i] = i;
		}
		mergesort(nums, indexes, 0, nums.length - 1);
		for (int i = 0; i < count.length; i++) {
			res.add(count[i]);
		}
		return res;
	}

	private void mergesort(int[] nums, int[] indexes, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergesort(nums, indexes, start, mid);
			mergesort(nums, indexes, mid + 1, end);
			merge(nums, indexes, start, mid, end);
		}
	}

	private void merge(int[] a, int[] indexes, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int rightcount = 0;
		int[] res = new int[end - start + 1];

		int k = 0;
		while (i <= mid && j <= end) {
			if (a[indexes[j]] < a[indexes[i]]) {
				res[k++] = indexes[j++];
				rightcount++;
			} else {
				count[indexes[i]] += rightcount;
				res[k++] = indexes[i++];
			}
		}
		while (i <= mid) {
			count[indexes[i]] += rightcount;
			res[k++] = indexes[i++];
		}
		while (j <= end) {
			res[k++] = indexes[j++];
		}
		for (int p = 0; p < res.length; p++) {
			indexes[start + p] = res[p];
		}
	}

	// Time : O(nlogn), Space : O(n)
	public void countSmallerNodesOnRight(int[] a, int n) {
		AVLTreeWithSize tree = new AVLTreeWithSize();
		int count[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			tree.root = tree.insert(tree.root, a[i]);
			count[i] = tree.count;
		}
		CommonUtil.printArray(a);
		CommonUtil.printArray(count);
	}

	public static void main(String[] args) {
		CountSmallerNodesOnRight obj = new CountSmallerNodesOnRight();
		int a[] = { 10, 6, 15, 20, 30, 5, 7 };
		int n = a.length;
		// obj.countSmallerNodesOnRight(a, n);
		List<Integer> res = null;
		res = obj.countSmaller(a);
		System.out.println(res);
	}

}
