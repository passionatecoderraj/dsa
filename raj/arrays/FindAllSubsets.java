package com.raj.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 */
// http://www.programcreek.com/2013/01/leetcode-subsets-java/
public class FindAllSubsets {

	public static void main(String args[]) {
		FindAllSubsets obj = new FindAllSubsets();
		int a[] = { 1, 2, 3, 4 };
		List<List<Integer>> result = obj.subsets(a);
		for (List<Integer> k : result) {
			System.out.println(k);
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		for (int n : nums) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				List<Integer> temp = new ArrayList<Integer>(list.get(i));
				temp.add(n);
				list.add(temp);
			}
		}
		return list;
	}
	
	

}
