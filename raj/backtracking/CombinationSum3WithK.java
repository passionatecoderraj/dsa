package com.raj.backtracking;

import java.util.ArrayList;

/**
 * 
 * @author Raj
 * 
 *         Find all possible combinations of k numbers that add up to a number
 *         n, given that only numbers from 1 to 9 can be used and each
 *         combination should be a unique set of numbers.
 * 
 * 
 *         Input : k = 3, n = 9
 * 
 *         Output : [[1,2,6], [1,3,5], [2,3,4]]
 * 
 */
public class CombinationSum3WithK {

	public void combinations(int k, int n) {
		combinationsUtil(k, n, 1, new ArrayList<Integer>());
	}

	public void combinationsUtil(int k, int n, int cur, ArrayList<Integer> result) {
		if (result.size() == k) {
			if (0 == n)
				System.out.println(result);
			return;
		}
		for (int i = cur; i <= 9; i++) {
			if (i > n)
				break;

			result.add(i);
			combinationsUtil(k, n - i, i + 1, result);
			result.remove(result.size() - 1);
		}
	}

	public static void main(String args[]) {
		CombinationSum3WithK obj = new CombinationSum3WithK();

		int k = 3;

		obj.combinations(k, 7);
	}

}