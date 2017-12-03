package com.raj.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 *
 *         Given a collection of numbers that might contain duplicates, return
 *         all possible unique permutations.
 * 
 *         For example, [1,1,2] have the following unique permutations: [
 *         [1,1,2], [1,2,1], [2,1,1] ]
 */
public class Permutations2 {

	public List<List<Integer>> permute(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(a);
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
			if (!containsDuplication(a, start, i)) {
				CommonUtil.swap(a, i, start);
				permuteUtil(start + 1, a, result);
				CommonUtil.swap(a, i, start);
			}
		}
	}

	private boolean containsDuplication(int a[], int start, int end) {
		int val = a[end];
		for (int i = start; i < end; i++) {
			if (a[i] == val)
				return true;
		}
		return false;
	}

	public static void main(String args[]) {
		Permutations2 obj = new Permutations2();
		List<List<Integer>> result = null;
		int a[] = { 1, 1, 2 };
		result = obj.permute(a);
		System.out.println(result);
	}
}