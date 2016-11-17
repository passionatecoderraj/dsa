package com.raj.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Input : [2, 3, 6, 7] , Sum : 7
 * 
 * Output : [ [7], [2, 2, 3] ]
 * 
 * @author Raj
 * 
 */
public class CombinationSum1 {

	public List<List<Integer>> combinationSum(int a[], int sum) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(a);
		combinationSumUtil(a, 0, sum, new ArrayList<>(), result);
		return result;
	}

	private void combinationSumUtil(int[] a, int i, int sum, ArrayList<Integer> cur, List<List<Integer>> result) {
		if (sum == 0) {
			List<Integer> temp = new ArrayList<>(cur);
			result.add(temp);
			return;
		}
		for (int j = i; j < a.length; j++) {
			if (a[j] > sum)
				break;
			cur.add(a[j]);
			combinationSumUtil(a, j, sum - a[j], cur, result);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String args[]) {
		CombinationSum1 obj = new CombinationSum1();
		int a[] = { 2, 3, 6, 7 };
		List<List<Integer>> result = obj.combinationSum(a, 7);
		System.out.println(result);
	}

}