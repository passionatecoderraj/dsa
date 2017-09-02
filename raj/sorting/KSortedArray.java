/**
 * 
 */
package com.raj.sorting;

import com.interview.graph.CommonUtil;
import com.interview.graph.MinHeap;
import com.raj.nodes.AVLTreeNode;
import com.raj.trees.bst.AVLTree;;

/**
 * @author Raj
 *
 */

/*
 * Given an array of N elements, where each element is at most 'k' positions
 * away from its right position in the sorted array, what is the complexity of
 * algorithm that sorts the array
 * 
 * Example, let us consider k is 2, an element at index 7 in the sorted array,
 * can be at indexes 5, 6, 7, 8, 9 in the given array.
 */

public class KSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 2, 6, 3, 12, 56, 8 };
		KSortedArray obj = new KSortedArray();

		int n = a.length;
		int k = 3;

		// Time : O(nk), Space : O(1)
		obj.sortKSortedArrayUsingInsertionSort(a, n, k);
		CommonUtil.printArray(a);

		int b[] = { 2, 6, 3, 12, 56, 8 };

		// Time : O(nlogk), Space : O(k)
		obj.sortKSortedArrayUsingMinHeap(b, n, k);
		CommonUtil.printArray(b);

		int c[] = { 2, 6, 3, 12, 56, 8 };
		// Time : O(nlogk), Space : O(k)
		obj.sortKSortedArrayUsingBalancedBST(c, n, k);
		CommonUtil.printArray(c);

	}

	public void sortKSortedArrayUsingBalancedBST(int[] c, int n, int k) {
		AVLTree tree = new AVLTree();
		for (int i = 0; i < k; i++) {
			tree.root = tree.insert(tree.root, c[i]);
		}
		AVLTreeNode<Integer> min;
		int j = 0;
		for (int i = k; i < n; i++) {
			min = tree.findMin(tree.root);
			c[j++] = min.data;
			tree.root = tree.delete(tree.root, min.data);
			tree.root = tree.insert(tree.root, c[i]);
		}
		for (int i = 0; i < k; i++) {
			min = tree.findMin(tree.root);
			c[j++] = min.data;
			tree.root = tree.delete(tree.root, min.data);
		}
	}

	public void sortKSortedArrayUsingMinHeap(int[] b, int n, int k) {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		for (int i = 0; i < k; i++) {
			heap.add(b[i]);
		}
		int j = 0;
		for (int i = k; i < n; i++) {
			b[j++] = heap.minValue();
			heap.remove();
			heap.add(b[i]);
		}
		for (int i = 0; i < k; i++) {
			b[j++] = heap.minValue();
			heap.remove();
		}

	}

	public void sortKSortedArrayUsingInsertionSort(int[] a, int n, int k) {

		int j, key;
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			while (j > i - k && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}
}
