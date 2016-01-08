/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class MaxHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 23, 12, 9, 30, 2, 50 };
		MaxHeap obj = new MaxHeap();
		CommonUtil.printArray(a);
		obj.size = a.length;
		obj.buildMaxHeap(a);
		CommonUtil.printArray(a);

		int result = -1;
		obj.increaseKey(a, 6, 100);
		CommonUtil.printArray(a);

		result = obj.extractMax(a);
		System.out.println(result);

		obj.heapSort(a);
		CommonUtil.printArray(a);
	}

	public int size;

	public void buildMaxHeap(int a[]) {
		for (int i = size / 2 - 1; i >= 0; i--) {
			maxHeapify(a, i);
		}
	}

	public void maxHeapify(int a[], int i) {
		int largest, left, right;
		left = (2 * i) + 1;
		right = (2 * i) + 2;

		largest = i;
		if (left < size && a[left] > a[largest]) {
			largest = left;
		}

		if (right < size && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != i) {
			CommonUtil.swap(a, largest, i);
			maxHeapify(a, largest);
		}
	}

	public int extractMax(int a[]) {
		if (size <= 0)
			return -1;
		int max = a[0];
		a[0] = a[size - 1];
		size--;
		maxHeapify(a, 0);
		return max;
	}

	public void increaseKey(int a[], int i, int val) {
		if (i < 0 || i >= size)
			return;
		if (a[i] > val) {
			System.out.println("current value " + a[i] + " is lareger than " + val);
			return;
		}
		a[i] = val;
		int parent;
		parent = (i % 2 == 0) ? (i / 2 - 1) : i / 2;

		while (parent >= 0 && a[parent] < a[i]) {
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
			maxHeapify(a, 0);
		}
		size = tempSize;
	}

}
