package com.raj.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 */
// http://blog.welkinlan.com/2015/07/17/subsets-i-subsets-ii-leetcode-java/
public class FindAllSubsets {

	public List<List<Integer>> subsetsRecursiveWithoutDuplicate(int[] a) {
		Arrays.sort(a);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		subsetsRecursiveWithoutDuplicateUtil(result, new ArrayList<Integer>(), a, 0);
		return result;
	}

	public void subsetsRecursiveWithoutDuplicateUtil(List<List<Integer>> result, ArrayList<Integer> cur, int[] a,
			int i) {
		if (i == a.length)
			return;
		for (int j = i; j < a.length; j++) {
			if (j > i && a[j] == a[j - 1])
				continue;
			cur.add(a[j]);
			result.add(new ArrayList<>(cur));
			subsetsRecursiveWithoutDuplicateUtil(result, cur, a, j + 1);
			cur.remove(cur.size() - 1);
		}
	}

	public List<List<Integer>> subsetsRecursive(int[] a) {
		Arrays.sort(a);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		subsetsRecursiveUtil(result, new ArrayList<Integer>(), a, 0);
		return result;
	}

	public void subsetsRecursiveUtil(List<List<Integer>> result, ArrayList<Integer> cur, int[] a, int i) {
		if (i == a.length)
			return;
		for (int j = i; j < a.length; j++) {
			cur.add(a[j]);
			result.add(new ArrayList<>(cur));
			subsetsRecursiveUtil(result, cur, a, j + 1);
			cur.remove(cur.size() - 1);
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		for (int n : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> l = new ArrayList<Integer>(result.get(i));
				l.add(n);
				result.add(l);
			}
		}
		return result;
	}

	public static void main(String args[]) {
		FindAllSubsets obj = new FindAllSubsets();
		int a[] = { 1, 2, 3 };
		List<List<Integer>> result = obj.subsets(a);
		System.out.println(result);
		result = obj.subsetsRecursive(a);
		System.out.println(result);

		int b[] = { 2, 1, 2 };
		result = obj.subsetsRecursiveWithoutDuplicate(b);
		System.out.println(result);

	}

}
