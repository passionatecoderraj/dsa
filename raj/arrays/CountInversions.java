package com.raj.arrays;

/*
 * element in such that i<j and a[i] > a[j]
 */
public class CountInversions {

	public static void main(String[] args) {
		int a[] = { 1, 20, 6, 4, 5 };
		int n = a.length, result = -1;
		CountInversions obj = new CountInversions();
		// Time : O(n2), Space: O(1)
		result = obj.countInversionsBruteForce(a, n);
		System.out.println(result);

		// Time : O(nlogn), Space: O(n)??
		result = obj.countInversionsUsingMergeSort(a, n);
		System.out.println(result);

	}

	public int countInversionsUsingMergeSort(int[] a, int n) {
		return mergeSort(a, 0, n - 1);
	}

	public int mergeSort(int[] a, int p, int r) {
		int lcount = 0, rcount = 0, mcount = 0;
		if (p < r) {
			int q = p + (r - p) / 2;
			lcount = mergeSort(a, p, q);
			rcount = mergeSort(a, q + 1, r);
			mcount = merge(a, p, q, r);
		}
		return lcount + rcount + mcount;
	}

	public int merge(int[] a, int p, int q, int r) {
		int i = 0, j = 0, k = 0;

		int m = q - p + 1, n = r - q;
		int left[] = new int[m];
		int right[] = new int[n];

		for (i = 0; i < m; i++) {
			left[i] = a[p + i];
		}

		for (i = 0; i < n; i++) {
			right[i] = a[q + 1 + i];
		}

		i = 0;
		j = 0;
		k = p;
		int inv_count = 0;
		while (i < m && j < n) {
			if (left[i] <= right[j]) {
				a[k++] = left[i++];
			} else {
				a[k++] = right[j++];
				inv_count++;
			}
		}
		while (i < m) {
			a[k++] = left[i++];
		}
		while (j < n) {
			a[k++] = right[j++];
			inv_count++;
		}

		return inv_count;
	}

	public int countInversionsBruteForce(int[] a, int n) {
		if (n <= 0)
			return -1;
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					count++;
					System.out.println("(" + a[i] + "," + a[j] + ")");
				}
			}
		}

		return count;
	}

}
