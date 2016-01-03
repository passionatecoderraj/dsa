/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindMinLengthSubArrayWithSumK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 15, 2, 4, 8, 9, 5, 5, 23 };
		int n = a.length, k = 28;
		int result = -1;
		FindMinLengthSubArrayWithSumK obj = new FindMinLengthSubArrayWithSumK();
		// Time : O(n2)
		result = obj.findSubArraySumBruteForce(a, n, k);
		System.out.println(result);
		// Time : O(n), This works only for non-negative values
		result = obj.findSubArraySum(a, n, k);
		System.out.println(result);

	}

	public int findSubArraySum(int[] a, int n, int k) {
		int minLength = Integer.MAX_VALUE;

		if (n <= 0)
			return -1;
		int start = 0, sum = a[0];
		for (int i = 1; i <= n; i++) {

			while (sum > k && start < i - 1) {
				sum = sum - a[start];
				start++;
			}
			if (sum == k) {
				System.out.println("From=" + start + ",To=" + (i - 1) + " :: Sum=" + k);
				minLength = Math.min(minLength, (i - 1) - start + 1);

				sum -= a[start];
				start++;
			}
			if (i < n) {
				sum += a[i];
			}
		}

		if (sum == k) {
			System.out.println("From=" + start + ",To=" + (n - 1) + " :: Sum=" + k);
		}

		return minLength;
	}

	public int findSubArraySumBruteForce(int[] a, int n, int k) {
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			sum = a[i];
			if (sum == k) {
				minLength = Math.min(minLength, i - i + 1);
				// System.out.println("From=" + i + ",To=" + i + " :: Sum=" +
				// k);
			}
			for (int j = i + 1; j < n; j++) {
				sum += a[j];
				if (sum == k) {
					minLength = Math.min(minLength, j - i + 1);
					// System.out.println("From=" + i + ",To=" + j + " :: Sum="
					// + k);
				}
			}

		}
		return minLength;
	}

}
