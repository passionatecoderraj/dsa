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

		int temp = n;
		while (n > 1) {
			CommonUtil.swap(a, 0, n - 1);
			n--;
			heap.size = n;
			heap.minHeapify(a, 0);
		}
		n = temp;
	}

	public void heapSort(int[] a, int n) {
		MaxHeap heap = new MaxHeap();
		heap.size = n;
		heap.buildMaxHeap(a);

		int temp = n;
		while (n > 1) {
			CommonUtil.swap(a, 0, n - 1);
			n--;
			heap.size = n;
			heap.maxHeapify(a, 0);
		}
		n = temp;
	}

}
