package com.raj.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Raj
 *
 *         Given a collection of distinct numbers, return all possible
 *         permutations.
 * 
 *         For example, [1,2,3] have the following permutations: [ [1,2,3],
 *         [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */
public class Permutations {

	public List<List<Integer>> permute(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		permuteUtil(0, a, result);
		return result;
	}

	private void permuteUtil(int start, int a[], List<List<Integer>> result) {
		if (a.length == start) {
			List<Integer> list = new ArrayList<>();
			for (int i : a) {
				list.add(i);
			}
			result.add(list);
			return;
		}
		for (int i = start; i < a.length; i++) {
			swap(a, i, start);
			permuteUtil(start + 1, a, result);
			swap(a, i, start);
		}
	}

	private void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String args[]) {
		Permutations obj = new Permutations();
		List<List<Integer>> result = null;
		int a[] = { 1, 2, 3 };
		result = obj.permute(a);
		System.out.println(result);
	}
}