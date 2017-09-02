/**
 * 
 */
package com.raj.dp;

import com.interview.graph.CommonUtil;
import com.raj.mathamatical.MaxNumberWithKDigits;

/**
 * @author Raj
 *
 */
public class CreateMaxNumWithKDigitsFromTwoArrays {

	// Time : O((n+m)^3), Space : O(n+m)
	public static int[] createMaxNumber(int[] nums1, int[] nums2, int k) {
		if (k > nums1.length + nums2.length)
			return null;
		int minLenArr[], maxLenArr[];
		if (nums1.length > nums2.length) {
			maxLenArr = nums1;
			minLenArr = nums2;
		} else {
			maxLenArr = nums2;
			minLenArr = nums1;
		}
		/*
		 * int start = 0, end = k; // if 'k' is less than size of both arrays
		 * size then we need to consider // all possibilities of k i.e. 0 to k
		 * // For example, nums1.size = 4, nums2.size = 6 and k=3, result may //
		 * contain zero elements from either array if (k < minLenArr.length && k
		 * < maxLenArr.length) { start = 0; end = k; } else if (k >
		 * maxLenArr.length && k > minLenArr.length) {
		 * 
		 * // if k is higher than both min len array and max len array then we
		 * // should have atleast few elements from both
		 * 
		 * // For example, nums1.size = 4, nums2.size = 6 and k=7, result must
		 * // contain elements ranging from 3 to 6
		 * 
		 * start = k - minLenArr.length; end = maxLenArr.length; } else { // if
		 * k is between min len array and max len array then we should // have
		 * atleast few elements from max len array
		 * 
		 * // For example, nums1.size = 4, nums2.size = 6 and k=5, max lent //
		 * array must contain elements ranging from 1 to 5
		 * 
		 * start = k - minLenArr.length; end = k; }
		 */

		int rstart = Math.max(0, k - minLenArr.length);
		int rend = Math.min(k, maxLenArr.length);

		int[] ans = new int[k];
		for (int i = rstart; i <= rend; ++i) {
			int a[] = MaxNumberWithKDigits.maxNumberWithKDigits(maxLenArr, i);
			int b[] = MaxNumberWithKDigits.maxNumberWithKDigits(minLenArr, k - i);
			int[] candidate = merge(a, b);
			if (greater(candidate, 0, ans, 0))
				ans = candidate;
		}
		return ans;

	}

	// Time : O((n+m)^3), Space : O(n+m)
	public static int[] createMaxNumber2(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		int m = nums2.length;
		int[] ans = new int[k];
		for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
			int a[] = MaxNumberWithKDigits.maxNumberWithKDigits(nums1, i);
			int b[] = MaxNumberWithKDigits.maxNumberWithKDigits(nums2, k - i);
			int[] candidate = merge(a, b);
			if (greater(candidate, 0, ans, 0))
				ans = candidate;
		}
		return ans;

	}

	private static boolean greater(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			i++;
			j++;
		}
		return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}

	private static int[] merge(int a[], int b[]) {
		int k = a.length + b.length;
		int c[] = new int[a.length + b.length];
		for (int i = 0, j = 0, r = 0; r < k; ++r)
			c[r] = greater(a, i, b, j) ? a[i++] : b[j++];
		return c;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums1[] = { 3, 4, 6, 5 }, nums2[] = { 9, 1, 2, 5, 8, 3 }, k = 5;

		int res[];
		res = createMaxNumber(nums1, nums2, k);
		CommonUtil.printArray(res);

		int a[] = { 6, 7 }, b[] = { 6, 0, 4 };
		res = createMaxNumber(a, b, 5);
		CommonUtil.printArray(res);

	}

}
