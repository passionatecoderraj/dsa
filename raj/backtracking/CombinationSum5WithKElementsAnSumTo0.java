package com.raj.backtracking;

import java.util.ArrayList;

/**
 * 
 * Given an unsorted array of integers (e.g [1, -2, 4, 100]), write a method
 * that checks if there is a triplet that sums to 0. You may use a number more
 * than once. (e.g [-2, 1, 1] exists in said array and sums to 0, so true should
 * be returned)
 * 
 * @author Raj
 *
 */
public class CombinationSum5WithKElementsAnSumTo0 {

	public void combinationsSum0(int[] a, int k) {
		combinations(a, 0, k, 0, new ArrayList<>());
	}

	public void combinations(int a[], int start, int k, int sum, ArrayList<Integer> result) {
		if (result.size() == k) {
			if (sum == 0) {
				System.out.println(result);
			}
			return;
		}

		for (int i = 0; i < a.length; i++) {
			result.add(a[i]);
			combinations(a, i + 1, k, sum + a[i], result);
			result.remove(result.size() - 1);
		}
	}

	public static void main(String args[]) {
		CombinationSum5WithKElementsAnSumTo0 obj = new CombinationSum5WithKElementsAnSumTo0();

		int k = 3;
		int a[] = { 1, -2, 4, 100 };

		obj.combinationsSum0(a, k);
	}

}