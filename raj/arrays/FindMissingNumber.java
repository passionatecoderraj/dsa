/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindMissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindMissingNumber obj = new FindMissingNumber();
		int result = -1;
		int a[] = { 1, 2, 4, 6, 3, 7, 8 };

		// Time :O(n) but there can be a overflow of integer while adding all of
		// them
		result = obj.findMissingNumber(a);
		System.out.println(result);
		result = obj.findMissingNumberUsingXOR(a);
		System.out.println(result);

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
