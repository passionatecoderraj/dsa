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
		// Time : Theta of n,
		result = obj.quickSelectFindKthLargest(a, 0, n - 1, k - 1);
		System.out.println(result);
		// Time : Theta of n,
		result = obj.quickSelectRandomPartition(a, 0, n - 1, k - 1);
		System.out.println(result);
	}

	public int quickSelectRandomPartition(int[] a, int low, int high, int k) {
		if (low <= high) {
			int pivot = randomPartitionDescending(a, low, high);
			if (pivot - low == k) {
				for (int i = pivot; i < a.length; i++)
					System.out.print(a[i] + " ");
				System.out.println();
				return a[pivot];
			} else if (k > pivot - low) {
				return quickSelectRandomPartition(a, pivot + 1, high, k - (pivot - low) - 1);
			} else {
				return quickSelectRandomPartition(a, low, pivot - 1, k);
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

	public int quickSelectFindKthLargest(int[] a, int low, int high, int k) {
		if (low <= high) {
			int pivot = partitionDescending(a, low, high);
			if (pivot - low == k) {
				return a[pivot];
			} else if (k > pivot - low) {
				return quickSelectFindKthLargest(a, pivot + 1, high, k - (pivot - low) - 1);
			} else {
				return quickSelectFindKthLargest(a, low, pivot - 1, k);
			}
		}
		return -1;
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

}
