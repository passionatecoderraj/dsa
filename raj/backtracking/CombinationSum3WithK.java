package com.raj.backtracking;

import java.util.ArrayList;
import java.util.List;

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

	public List<List<Integer>> combinationSum3WithK(int k, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum3WithKUtil(1, sum, new ArrayList<>(), result);
		return result;
	}

	private void combinationSum3WithKUtil(int i, int sum, ArrayList<Integer> cur, List<List<Integer>> result) {
		if (sum == 0) {
			List<Integer> temp = new ArrayList<>(cur);
			result.add(temp);
			return;
		}
		for (int j = i; j <= 9; j++) {
			if (j > sum)
				break;
			cur.add(j);
			combinationSum3WithKUtil(j + 1, sum - j, cur, result);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String args[]) {
		CombinationSum3WithK obj = new CombinationSum3WithK();

		List<List<Integer>> result = null;
		int k = 3;

		result = obj.combinationSum3WithK(k, 7);
		System.out.println(result);

	}

}