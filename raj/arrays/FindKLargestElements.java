/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

import com.raj.ds.MaxHeap;

/**
 * @author Raj
 *
 */
public class FindKLargestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 23, 12, 9, 30, 2, 50 };
		int n = a.length, k = 3;
		FindKLargestElements obj = new FindKLargestElements();

		// modifying bubble sort Time:O(nk)
		obj.printKLargestElementsUsingBubbleSort(a, n, k);

		// modifying selection sort Time:O(nk)
		obj.printKLargestElementsUsingSelectionSort(a, n, k);

		// using sorting Time:O(nlogn)
		obj.printKLargestElementsUsingSorting(a, n, k);

		// using max heap:O(n + klogn)
		obj.printKLargestElementsUsingMaxHeap(a, n, k);

	}

	public void printKLargestElementsUsingMaxHeap(int[] a, int n, int k) {
		MaxHeap obj = new MaxHeap();
		obj.build_heap(a);
		for (int i = 0; i < k; i++) {
			System.out.print(obj.extract_max() + " ");
		}
		System.out.println();
	}

	public void printKLargestElementsUsingSorting(int[] a, int n, int k) {
		Arrays.sort(a);
		for (int i = n - 1; i > k; i--) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void printKLargestElementsUsingSelectionSort(int[] a, int n, int k) {
		int max_index = -1, temp;
		for (int i = 0; i < k; i++) {
			max_index = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] > a[max_index]) {
					max_index = j;
				}
			}
			if (max_index != i) {
				temp = a[max_index];
				a[max_index] = a[i];
				a[i] = temp;
			}
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void printKLargestElementsUsingBubbleSort(int[] a, int n, int k) {
		int temp;
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			System.out.print(a[n - i] + " ");
		}
		System.out.println();
	}

}
