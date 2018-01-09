package com.raj.dp;

/**
 * 
 * @author Raj
 *
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

	// http://buttercola.blogspot.com/2014/08/leetcode-maximum-subarray.html
	// Time : O(n), Space : O(1)
	public int maxSubArray3(int[] a) {
		if (a.length < 0)
			return 0;
		int curSum = a[0];
		int maxSum = a[0];
		for (int i = 1; i < a.length; i++) {
			curSum = Math.max(curSum + a[i], a[i]);
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}

	// Time : O(nlogn), Space : O(logn)
	public int maxSubArray(int[] a) {
		if (a.length < 0)
			return 0;
		return util(a, 0, a.length - 1);
	}

	private int util(int a[], int l, int r) {
		if (l > r)
			return Integer.MIN_VALUE;
		int m = (l + r) >> 1;
		int lmax = util(a, l, m - 1);
		int rmax = util(a, m + 1, r);
		int max = a[m];

		max = Math.max(max, Math.max(lmax, rmax));

		int sum = 0, mlmax = 0, mrmax = 0;

		// find max from middle to left
		for (int i = m - 1; i >= l; i--) {
			sum += a[i];
			mlmax = Math.max(mlmax, sum);
		}

		sum = 0;
		// find max from middle to right
		for (int i = m + 1; i <= r; i++) {
			sum += a[i];
			mrmax = Math.max(mrmax, sum);
		}
		return Math.max(max, mlmax + mrmax + a[m]);
	}

	// Time : O(n), Space : O(n)
	public int maxSubArray2(int[] a) {
		if (a.length < 0)
			return 0;
		int t[] = new int[a.length];
		t[0] = a[0];
		int maxSum = t[0];
		for (int i = 1; i < a.length; i++) {
			t[i] = Math.max(t[i - 1] + a[i], a[i]);
			maxSum = Math.max(maxSum, t[i]);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray obj = new MaximumSubarray();
		int result = -1;
		result = obj.maxSubArray(a);
		System.out.println(result);

		int b[] = { -2, 1, 4 };
		result = obj.maxSubArray(b);
		System.out.println(result);

	}

}
