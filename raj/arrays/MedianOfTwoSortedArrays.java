/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class MedianOfTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		int a1[] = { 1, 12, 15, 26 };
		int a2[] = { 2, 13, 17, 30 };
		int result = -1;
		result = obj.medianOfTwoSortedArrays(a1, a2, 0, a1.length - 1, 0, a2.length - 1);
		System.out.println(result);
		double res = obj.findMedianSortedArrays(a1, a2);
		System.out.println(res);

	}

	public int medianOfTwoSortedArrays(int[] a1, int[] a2, int l1, int r1, int l2, int r2) {
		int m1, m2, n;
		n = r1 - l1 + 1;
		if (n <= 0) {
			return -1;
		} else if (n == 1) {
			return (a1[n - 1] + a2[n - 1]) / 2;
		} else if (n == 2) {
			int l = Math.max(a1[l1], a2[l2]);
			int m = Math.min(a1[r1], a2[r2]);
			return (l + m) / 2;
		} else {
			m1 = median(a1, l1, r1);
			m2 = median(a2, l2, r2);

			if (m1 < m2) {
				int k = n / 2;
				return medianOfTwoSortedArrays(a1, a2, l1 + k, r1, l2, r2 - k);
			} else if (m1 > m2) {
				int k = n / 2;
				return medianOfTwoSortedArrays(a1, a2, l1, r1 - k, l2 + k, r2);

			} else {
				return m1;
			}
		}
	}

	public int median(int[] a, int start, int end) {

		int n = end - start + 1;
		int k = start + n / 2;

		if (n % 2 != 0) {
			return a[k];
		} else {
			return (a[k] + a[k - 1]) / 2;
		}

	}

	// Time :O(log(m+n))
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		if (total % 2 == 0) {
			int k1 = total / 2 + 1;
			int k = total / 2;
			return (findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k)
					+ findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k1)) / 2;
		} else {
			int k = total / 2 + 1;
			return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
		}
	}

	// https://discuss.leetcode.com/topic/5728/share-one-divide-and-conquer-o-log-m-n-method-with-clear-description/2
	int findKth(int A[], int aL, int aR, int B[], int bL, int bR, int k) {
		if (aL > aR)
			return B[bL + k - 1];
		if (bL > bR)
			return A[aL + k - 1];

		int aMid = (aL + aR) / 2;
		int bMid = (bL + bR) / 2;

		if (A[aMid] <= B[bMid]) {
			if (k <= (aMid - aL) + (bMid - bL) + 1)
				return findKth(A, aL, aR, B, bL, bMid - 1, k);
			else
				return findKth(A, aMid + 1, aR, B, bL, bR, k - (aMid - aL) - 1);
		} else { // A[aMid] > B[bMid]
			if (k <= (aMid - aL) + (bMid - bL) + 1)
				return findKth(A, aL, aMid - 1, B, bL, bR, k);
			else
				return findKth(A, aL, aR, B, bMid + 1, bR, k - (bMid - bL) - 1);
		}
	}

}
