/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class MinHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 23, 12, 9, 30, 2, 50 };
		MinHeap obj = new MinHeap();
		CommonUtil.printArray(a);
		obj.size = a.length;
		obj.buildMinHeap(a);
		CommonUtil.printArray(a);

		int result = -1;
		obj.decreaseKey(a, 6, -100);
		CommonUtil.printArray(a);

		result = obj.extractMin(a);
		System.out.println(result);

		obj.heapSort(a);
		CommonUtil.printArray(a);
	}

	public int size;

	public void buildMinHeap(int a[]) {
		for (int i = size / 2 - 1; i >= 0; i--) {
			minHeapify(a, i);
		}
	}

	public void minHeapify(int a[], int i) {
		int smallest, left, right;
		left = (2 * i) + 1;
		right = (2 * i) + 2;

		smallest = i;
		if (left < size && a[left] < a[smallest]) {
			smallest = left;
		}

		if (right < size && a[right] < a[smallest]) {
			smallest = right;
		}
		if (smallest != i) {
			CommonUtil.swap(a, smallest, i);
			minHeapify(a, smallest);
		}
	}

	public int extractMin(int a[]) {
		if (size <= 0)
			return -1;
		int min = a[0];
		a[0] = a[size - 1];
		size--;
		minHeapify(a, 0);
		return min;
	}

	public void decreaseKey(int a[], int i, int val) {
		if (i < 0 || i >= size)
			return;
		if (a[i] < val) {
			System.out.println("current value " + a[i] + " is smaller than " + val);
			return;
		}
		a[i] = val;
		int parent;
		parent = (i % 2 == 0) ? (i / 2 - 1) : i / 2;

		while (parent >= 0 && a[parent] > a[i]) {
			CommonUtil.swap(a, i, parent);
			i = parent;
			parent = (i % 2 == 0) ? (i / 2 - 1) : i / 2;
		}
	}

	public void heapSort(int a[]) {
		int tempSize = size;
		while (size > 1) {
			CommonUtil.swap(a, 0, size - 1);
			size--;
			minHeapify(a, 0);
		}
		size = tempSize;
	}

}
