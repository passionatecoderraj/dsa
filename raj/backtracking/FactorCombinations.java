package com.raj.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 * 
 *         Numbers can be regarded as product of its factors. For example,
 * 
 *         8 = 2 x 2 x 2; = 2 x 4.
 * 
 *         Write a function that takes an integer n and return all possible
 *         combinations of its factors.
 * 
 *         Note: You may assume that n is always positive. Factors should be
 *         greater than 1 and less than n.
 * 
 *         Examples: input: 1 output: []
 * 
 *         input: 37 output: []
 * 
 *         input: 12 output: [ [2, 6], [2, 2, 3], [3, 4] ]
 * 
 *         input:32 output: [ [2, 16], [2, 2, 8], [2, 2, 2, 4], [2, 2, 2, 2, 2],
 *         [2, 4, 4], [4, 8] ]
 */
public class FactorCombinations {

	public static List<List<Integer>> factorCombinations(int n) {
		List<List<Integer>> result = new ArrayList<>();
		factorCombinationsUtil(n, 2, new ArrayList<>(), result);
		return result;
	}

	private static void factorCombinationsUtil(int n, int start, ArrayList<Integer> cur, List<List<Integer>> result) {
		// if (new CountPrimes().isPrime(n)) {
		if (n <= 1) {
			return;
		}

		if (cur.size() > 0) {
			ArrayList<Integer> list = new ArrayList<>(cur);
			list.add(n);
			result.add(list);
		}

		for (int i = start; i * i <= n; i++) {
			if (n % i == 0) {
				cur.add(i);
				factorCombinationsUtil(n / i, i, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public static void main(String args[]) {

		List<List<Integer>> result = null;
		result = factorCombinations(3);
		System.out.println(result);
		result = factorCombinations(12);
		System.out.println(result);
		result = factorCombinations(8);
		System.out.println(result);
	}

}