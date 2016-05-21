/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class FindKthLargest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 7, 10, 4, 3, 20, 15 };
		int n = a.length, k = 4, result = -1;

		FindKthLargest obj = new FindKthLargest();
		// Time : Average case O(n), Worse case O(n2)
		result = obj.quickSelectRandomPartition(a, 0, n - 1, k - 1);
		System.out.println(result);
		CommonUtil.printArray(a, 0, k);
	}

	public int quickSelectRandomPartition(int[] a, int low, int high, int k) {
		while (low <= high) {
			int pivot = randomPartitionDescending(a, low, high);
			if (pivot == k) {
				return a[pivot];
			}
			if (pivot > k) {
				high = pivot - 1;
			} else {
				low = pivot + 1;
			}
		}
		return -1;
	}

	public int randomPartitionDescending(int[] a, int low, int high) {
		int n = high - low + 1;
		int rand = (int) ((Math.random() * n)) + low;
		CommonUtil.swap(a, rand, high);
		return partitionDescending(a, low, high);
	}

	public int partitionDescending(int a[], int p, int r) {
		int j = p, key = a[r];
		for (int i = p; i < r; i++) {
			if (a[i] >= key) {
				CommonUtil.swap(a, i, j);
				j++;
			}
		}
		CommonUtil.swap(a, r, j);
		return j;
	}

	/*
	 * public int quickSelectFindKthLargest(int[] a, int low, int high, int k) {
	 * if (low <= high) { int pivot = partitionDescending(a, low, high); //
	 * System.out.println("pivot =" + pivot); if (pivot - low == k) { return
	 * a[pivot]; } else if (k > pivot - low) { return
	 * quickSelectFindKthLargest(a, pivot + 1, high, k - (pivot - low) - 1); }
	 * else { return quickSelectFindKthLargest(a, low, pivot - 1, k); } } return
	 * -1; }
	 */

}
