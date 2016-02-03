/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

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
	public static void main(String[] args) {
		CountSmallerNodesOnRight obj = new CountSmallerNodesOnRight();
		int a[] = { 10, 6, 15, 20, 30, 5, 7 };
		int n = a.length;
		obj.countSmallerNodesOnRight(a, n);
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
}
