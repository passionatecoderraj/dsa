package com.raj.mathamatical;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Raj
 * 
 *         The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 *         By listing and labeling all of the permutations in order, We get the
 *         following sequence (ie, for n = 3):
 * 
 *         "123" "132" "213" "231" "312" "321"
 * 
 *         https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-
 *         solution-in-o-n/2
 * 
 */
public class PermutationSequence {

	// Time :O(n)
	public static String permuteSequence(int n, int k) {
		List<Integer> numbers = new ArrayList<>();
		StringBuilder res = new StringBuilder();
		int[] factorial = new int[n + 1];

		// memorization of factorial
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
			factorial[i] = i * factorial[i - 1];
		}

		while (numbers.size() > 0) {

			// factorial of n-1 numbers
			int p = factorial[numbers.size() - 1];

			// idx ranges from 0 to n-1. (k-1)/p gives that
			int idx = (k - 1) / p;
			res.append(numbers.get(idx));
			numbers.remove(idx);

			// update k for next set
			k = k - (idx * p);
		}
		return res.toString();
	}

	public static void main(String args[]) {
		String res = null;
		res = permuteSequence(4, 24);
		System.out.println(res);
	}

}