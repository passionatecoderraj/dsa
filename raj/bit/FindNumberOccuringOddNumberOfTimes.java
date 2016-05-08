/**
 * 
 */
package com.raj.bit;

/**
 * @author Raj
 *
 */
public class FindNumberOccuringOddNumberOfTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindNumberOccuringOddNumberOfTimes obj = new FindNumberOccuringOddNumberOfTimes();
		int result = -1;
		int a[] = { 1, 2, 3, 2, 3, 1, 3 };

		// Time :O(n2)
		result = obj.findNumberOccuringOddNumberOfTimesBruteForce(a, a.length);
		System.out.println(result);
		// Time :O(n)
		result = obj.findNumberOccuringOddNumberOfTimesUsingXOR(a, a.length);
		System.out.println(result);

	}

	public int findNumberOccuringOddNumberOfTimesBruteForce(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			count = 0;
			for (int j = 0; j < n; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (count % 2 != 0)
				return a[i];
		}
		return -1;
	}

	public int findNumberOccuringOddNumberOfTimesUsingXOR(int[] a, int n) {
		if (n <= 0)
			return -1;
		if (n == 1)
			return a[0];

		int x = a[0];

		for (int i = 1; i < n; i++) {
			x = x ^ a[i];
		}
		return x;
	}

	public int findMissingNumberUsingXOR(int[] a) {
		int x1 = a[0], x2 = 1, n = a.length;
		for (int i = 1; i < n; i++) {
			x1 = x1 ^ a[i];
		}

		for (int i = 2; i <= n + 1; i++) {
			x2 = x2 ^ i;
		}
		System.out.println(x1);
		System.out.println(x2);
		return x1 ^ x2;
	}

	public int findMissingNumber(int[] a) {
		int tot = 0;
		for (int i = 0; i < a.length; i++) {
			tot += a[i];
		}
		int n = a.length + 1;
		int sum = (n * (n + 1)) / 2;
		return sum - tot;
	}

}
