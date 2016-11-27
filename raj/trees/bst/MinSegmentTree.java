/**
 * 
 */
package com.raj.trees.bst;

import java.util.Arrays;

import com.raj.bit.NextPowerOf2;

/**
 * @author Raj
 *
 */
public class MinSegmentTree {

	// Time :O(n), Space : O(n)
	public int[] constructSegmentTree(int[] a) {
		if (null == a || a.length == 0) {
			return a;
		}

		NextPowerOf2 nextPowOf2 = new NextPowerOf2();
		// if size of a is power of 2, then st size is 2^n-1
		// if size of a is NOT power of 2, then st size is nextPowerof 2 *2-1
		int st[] = new int[nextPowOf2.nextPowerOf2(a.length) * 2 - 1];
		Arrays.fill(st, Integer.MAX_VALUE);
		System.out.println(st.length);
		constructSegmentTree(st, 0, a, 0, a.length - 1);
		return st;
	}

	private void constructSegmentTree(int[] st, int root, int[] a, int low, int high) {
		if (low == high) {
			st[root] = a[low];
			return;
		}
		int mid = low + (high - low) / 2;

		int left = 2 * root + 1;
		int right = 2 * root + 2;
		constructSegmentTree(st, left, a, low, mid);
		constructSegmentTree(st, right, a, mid + 1, high);
		st[root] = Math.min(st[left], st[right]);
	}

	public int rangeMinimumQuery(int[] st, int root, int low, int high, int qlow, int qhigh) {
		// if there is no overlap
		if (qlow > high || low > qhigh)
			return Integer.MAX_VALUE;

		// if low to high overlaps with query low and high
		if (low >= qlow && high <= qhigh)
			return st[root];
		int mid = low + (high - low) / 2;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		int lresult = rangeMinimumQuery(st, left, low, mid, qlow, qhigh);
		int rresult = rangeMinimumQuery(st, right, mid + 1, high, qlow, qhigh);

		return Math.min(lresult, rresult);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MinSegmentTree obj = new MinSegmentTree();
		int a[] = { 0, 3, 4, 2, 1, 6, -1 };

		int st[] = obj.constructSegmentTree(a);
		System.out.println(Arrays.toString(st));
		int result = Integer.MAX_VALUE;

		int qlow, qhigh;
		qlow = 2;
		qhigh = 5;
		result = obj.rangeMinimumQuery(st, 0, 0, a.length - 1, qlow, qhigh);
		System.out.println(result);

	}

}
