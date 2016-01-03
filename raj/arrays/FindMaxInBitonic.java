/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindMaxInBitonic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
		int n = a.length, result = -1;
		FindMaxInBitonic obj = new FindMaxInBitonic();
		// Time : O(n)
		result = obj.findMaxInBitonic(a, n);
		System.out.println(result);
		// Time : O(logn)
		result = obj.findMaxInBitonicUsingBinaySearch(a, 0, n - 1);
		System.out.println(result);
	}

	public int findMaxInBitonic(int[] a, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}

	public int findMaxInBitonicUsingBinaySearch(int[] a, int l, int r) {
		int mid;
		int n = r - l + 1;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if ((mid == 0 && a[mid] > a[mid + 1]) || (mid == n - 1 && a[mid] > a[mid - 1])
					|| (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])) {
				return a[mid];
			} else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

}
