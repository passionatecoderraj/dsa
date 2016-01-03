/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Raj
 * 
 *         Check for Pair of numbers with sum X
 * 
 */
public class CheckForPairWithSumX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckForPairWithSumX obj = new CheckForPairWithSumX();
		int a[] = { 1, 4, 45, 6, 10, 8 };
		int sum = 16;
		boolean result = false;
		// method 1 : Time : O(n2) , Space : O(1)
		result = obj.checkForPairWithSumXON2(a, sum);
		System.out.println(result);
		// method 2 : Time : O(nLogn) , Space : O(1) (uses sorting)
		result = obj.checkForPairWithSumXONLogN(a, sum);
		System.out.println(result);
		// method 3 : Time : O(n), Space : O(R)
		// all values must be positive(Uses All values must be positive )
		result = obj.checkForPairWithSumXON(a, sum);
		System.out.println(result);
		// method 4 : using hash set - set.contains() and set.add() are O(1)
		// Time : O(n), Space : O(n)
		result = obj.checkForPairWithSumXONUsingHashSet(a, sum);
		System.out.println(result);

	}

	/**
	 * @param a
	 * @param sum
	 * @return
	 */
	public boolean checkForPairWithSumXONUsingHashSet(int[] a, int sum) {
		Set<Integer> set = new HashSet<Integer>(a.length);
		boolean isPairFound = false;

		for (int i = 0; i < a.length; i++) {
			int temp = sum - a[i];
			if (!set.contains(temp)) {
				set.add(a[i]);
			} else {
				System.out.println("(" + a[i] + "," + temp + ")");
				isPairFound = true;
			}

		}
		return isPairFound;

	}

	/**
	 * @param a
	 * @param sum
	 * @return
	 */
	public boolean checkForPairWithSumXON(int[] a, int sum) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		boolean binaryMap[] = new boolean[max - min + 2];

		boolean isPairFound = false;
		int temp;
		for (int i = 0; i < a.length; i++) {
			temp = sum - a[i];
			if (temp >= 0 && binaryMap[temp]) {
				System.out.println("(" + a[i] + "," + temp + ")");
				isPairFound = true;
			}
			binaryMap[a[i]] = true;
		}
		return isPairFound;
	}

	/**
	 * @param a
	 * @param sum
	 */
	public boolean checkForPairWithSumXONLogN(int[] a, int sum) {
		Arrays.sort(a);
		int l = 0;
		int r = a.length - 1;
		boolean isPairFound = false;
		while (l < r) {
			int total = a[l] + a[r];
			if (sum == total) {
				System.out.println("(" + a[l] + "," + a[r] + ")");
				l++;
				r--;
				isPairFound = true;
			} else if (sum > total) {
				l++;
			} else if (sum < total) {
				r--;
			}
		}
		return isPairFound;
	}

	public boolean checkForPairWithSumXON2(int[] a, int sum) {
		int n = a.length;
		boolean isPairFound = false;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] + a[j] == sum) {
					System.out.println("(" + a[i] + "," + a[j] + ")");
					isPairFound = true;

				}
			}
		}
		return isPairFound;
	}

}
