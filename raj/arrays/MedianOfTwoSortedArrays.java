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

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		if (total % 2 == 0) {
			return (findKth(total / 2 + 1, nums1, nums2, 0, 0) + findKth(total / 2, nums1, nums2, 0, 0)) / 2.0;
		} else {
			return findKth(total / 2 + 1, nums1, nums2, 0, 0);
		}
	}

	public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2) {
		if (s1 >= nums1.length)
			return nums2[s2 + k - 1];

		if (s2 >= nums2.length)
			return nums1[s1 + k - 1];

		if (k == 1)
			return Math.min(nums1[s1], nums2[s2]);

		int m1 = s1 + k / 2 - 1;
		int m2 = s2 + k / 2 - 1;

		int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

		if (mid1 < mid2) {
			return findKth(k - k / 2, nums1, nums2, m1 + 1, s2);
		} else {
			return findKth(k - k / 2, nums1, nums2, s1, m2 + 1);
		}
	}

}
