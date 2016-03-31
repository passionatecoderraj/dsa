/**
 * 
 */
package com.raj.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.interivew.graph.CommonUtil;
import com.raj.arrays.AVLTreeWithCount;
import com.raj.nodes.AVLTreeNodeWithCount;

/**
 * @author Raj
 *
 */
/*
 * Sort an array according to the order defined by another array
 */
public class SortArrayByAnotherArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int b[] = { 2, 1, 8, 3 };
		SortArrayByAnotherArray obj = new SortArrayByAnotherArray();

		// Time : O(m+n+plogp), Space : O(n)
		// plogp - is to sort un-common values in two arrays
		// I did not do it but if it's required it can be done
		obj.sortArrayByAnotherArrayUsingHashing(a, a.length, b, b.length);
		CommonUtil.printArray(a);

		int c[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int d[] = { 2, 1, 8, 3 };

		// Time : O(mlogm+nlogm), Space : O(m)
		obj.sortArrayByAnotherArrayUsingAVLTree(c, c.length, d, d.length);
		CommonUtil.printArray(c);
	}

	public void sortArrayByAnotherArrayUsingAVLTree(int[] a, int m, int[] b, int n) {
		AVLTreeWithCount<Integer> tree = new AVLTreeWithCount<Integer>();
		// O(mlogm)
		for (int i = 0; i < m; i++) {
			tree.root = tree.insert(tree.root, a[i]);
		}

		int k = 0;
		AVLTreeNodeWithCount<Integer> node = null;
		// O(nlogm)
		for (int i = 0; i < n; i++) {
			node = tree.search(tree.root, b[i]);
			if (node != null) {
				for (int j = 0; j < node.count; j++) {
					a[k++] = b[i];
				}
				node.setVisited(true);
			}
		}
		this.index = k;
		// O(m)
		fillNotCommonValuesUsingInorder(tree.root, a);
	}

	public void fillNotCommonValuesUsingInorder(AVLTreeNodeWithCount<Integer> root, int[] a) {
		if (root != null) {
			fillNotCommonValuesUsingInorder(root.left, a);
			if (!root.visited) {
				a[index++] = root.data;
			}
			fillNotCommonValuesUsingInorder(root.right, a);
		}
	}

	int index = 0;

	public void sortArrayByAnotherArrayUsingHashing(int[] a, int m, int[] b, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < m; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}

		int k = 0;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(b[i])) {
				for (int j = 0; j < map.get(b[i]); j++) {
					a[k++] = b[i];
				}
				map.remove(b[i]);
				// map.put(b[i], 0);
			}
		}

		// there are un-common values in two arrays
		if (k < m) {

			int c[] = new int[m - k];
			int index = 0;

			for (int key : map.keySet()) {
				for (int j = 0; j < map.get(key); j++) {
					c[index++] = key;
				}
			}

			// sorting uncommon values
			Arrays.sort(c);

			for (int i = 0; i < c.length; i++) {
				a[k++] = c[i];
			}

		}

	}
}
