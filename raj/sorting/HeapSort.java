/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 23, 12, 9, 30, 2, 50 };
		HeapSort obj = new HeapSort();
		CommonUtil.printArray(a);
		obj.heapSort(a, a.length);
		CommonUtil.printArray(a);

		obj.hepaSortDescending(a, a.length);
		CommonUtil.printArray(a);
	}

	public void hepaSortDescending(int[] a, int n) {
		MinHeap heap = new MinHeap();
		heap.size = n;
		heap.buildMinHeap(a);

		for (int i = n - 1; i > 0; i--) {
			CommonUtil.swap(a, 0, i);
			heap.size = i;
			heap.minHeapify(a, 0);
		}
	}

	public void heapSort(int[] a, int n) {
		MaxHeap heap = new MaxHeap();
		heap.size = n;
		heap.buildMaxHeap(a);

		for (int i = n - 1; i > 0; i--) {
			CommonUtil.swap(a, 0, i);
			heap.size = i;
			heap.maxHeapify(a, 0);
		}
	}

}
