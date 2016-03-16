/**
 * 
 */
package com.raj.sorting;

import java.util.ArrayList;
import java.util.List;

import com.interivew.graph.BinaryMinHeap;
import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class MergeKSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MergeKSortedArrays obj = new MergeKSortedArrays();

		List<Integer[]> arrays = new ArrayList<Integer[]>();
		arrays.add(new Integer[] { 10, 15, 17, 20 });
		arrays.add(new Integer[] { 5, 7, 11, 19, 22 });
		arrays.	add(new Integer[] { 1, 8, 12 });

		Integer[] result = null;
		int[] res = null;
		// Time : O(n*k2), , Space : O(nk)
		result = obj.merge(arrays, arrays.size());
		CommonUtil.printArray(result);

		int[][] a = new int[5][];
		a[0] = new int[] { 1, 5, 8, 9 };
		a[1] = new int[] { 2, 3, 7, 10 };
		a[2] = new int[] { 4, 6, 11, 15 };
		a[3] = new int[] { 9, 14, 16, 19 };
		a[4] = new int[] { 2, 4, 6, 9 };

		// Time : O(nklogk), Space : O(nk)
		res = obj.mergeUsingHeap(a, a.length, a[0].length);
		CommonUtil.printArray(res);

	}

	// using optimized method
	// n = number of cols, k = number of arrays or rows
	private int[] mergeUsingHeap(int[][] a, int k, int n) {

		int ptrs[] = new int[k];
		// create index pointer for every list.
		for (int i = 0; i < ptrs.length; i++) {
			ptrs[i] = 0;
		}

		int res[] = new int[n * k];
		BinaryMinHeap<HeapNode> heap = new BinaryMinHeap<HeapNode>();

		for (int i = 0; i < k; i++) {
			if (ptrs[i] < n) {
				heap.add(a[i][ptrs[i]], new HeapNode(a[i][ptrs[i]], i));
			} else {
				// if any of this list burns out,
				heap.add(Integer.MAX_VALUE, new HeapNode(Integer.MAX_VALUE, i));
			}
		}
		HeapNode temp;
		int r, c;
		for (int i = 0; i < n * k; i++) {
			temp = heap.extractMin();
			res[i] = temp.value;
			ptrs[temp.listNumber]++;

			r = temp.listNumber;
			c = ptrs[temp.listNumber];

			if (c < n) {
				heap.add(a[r][c], new HeapNode(a[r][c], r));
			} else {
				// if any of this list burns out,
				heap.add(Integer.MAX_VALUE, new HeapNode(Integer.MAX_VALUE, r));
			}
		}

		return res;
	}

	// using merge sort merging
	public Integer[] merge(List<Integer[]> arrays, int k) {
		if (null == arrays || arrays.size() == 0)
			return null;

		Integer[] p = arrays.get(0);
		for (int i = 1; i < k; i++) {
			p = merge(p, p.length, arrays.get(i), arrays.get(i).length);
		}
		return p;
	}

	public Integer[] merge(Integer[] left, int m, Integer[] right, int n) {

		Integer[] result = new Integer[m + n];

		int k = 0, i = 0, j = 0;

		while (i < m && j < n) {
			if (left[i] <= right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		while (i < m) {
			result[k++] = left[i++];
		}
		while (j < n) {
			result[k++] = right[j++];
		}
		return result;
	}

}

class HeapNode {
	int value;
	int listNumber;

	public HeapNode(int value, int listNumber) {
		super();
		this.value = value;
		this.listNumber = listNumber;
	}

	@Override
	public String toString() {
		return "HeapNode [value=" + value + ", listNumber=" + listNumber + "]";
	}

}
