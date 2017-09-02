/**
 * 
 */
package com.raj.arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class FindKthSmallest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 7, 10, 4, 3, 20, 15 };
		int n = a.length, k = 4, result = -1;

		FindKthSmallest obj = new FindKthSmallest();
		// Time : Theta of n,
		result = obj.quickSelectFindKthSmallest(a, 0, n - 1, k - 1);
		System.out.println(result);

		// Time : Theta of n,
		result = obj.quickSelectRandomPartition(a, 0, n - 1, k - 1);
		System.out.println(result);
	}

	public int quickSelectRandomPartition(int a[], int low, int high, int k) {
		if (low <= high) {
			int pivot = randomPartition(a, low, high);
			if (pivot - low == k) {
				return a[pivot];
			} else if (k > pivot - low) {
				return quickSelectRandomPartition(a, pivot + 1, high, k - (pivot - low) - 1);
			} else {
				return quickSelectRandomPartition(a, low, pivot - 1, k);
			}
		}
		return -1;
	}

	public int randomPartition(int[] a, int low, int high) {
		int n = high - low + 1;
		int rand = (int) ((Math.random() * n) + low);
		CommonUtil.swap(a, rand, high);
		return partition(a, low, high);
	}

	public int quickSelectFindKthSmallest(int a[], int low, int high, int k) {
		if (low <= high) {
			int pivot = partition(a, low, high);
			if (pivot - low == k) {
				return a[pivot];
			} else if (k > pivot - low) {
				// right sub array
				// position of k is changed ,it's k - length of left side -
				// 1(pivot)
				return quickSelectFindKthSmallest(a, pivot + 1, high, k - (pivot - low) - 1);
			} else {
				// lest sub array
				return quickSelectFindKthSmallest(a, low, pivot - 1, k);
			}
		}
		return -1;
	}

	public int partition(int a[], int p, int r) {
		int key = a[r], j = p;
		for (int i = p; i < r; i++) {
			if (a[i] <= key) {
				CommonUtil.swap(a, i, j);
				j++;
			}
		}
		CommonUtil.swap(a, r, j);
		return j;
	}

}
