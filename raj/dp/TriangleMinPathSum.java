package com.raj.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Raj
 *
 *         Given a triangle, find the minimum path sum from top to bottom. Each
 *         step you may move to adjacent numbers on the row below.
 * 
 *         For example, given the following triangle [ [2], [3,4], [6,5,7],
 *         [4,1,8,3] ] The minimum path sum from top to bottom is 11 (i.e., 2 +
 *         3 + 5 + 1 = 11).
 */
public class TriangleMinPathSum {

	public static int minimumTotal(List<List<Integer>> list) {

		if (null == list || list.size() == 0) {
			return Integer.MAX_VALUE;
		}
		// size of list is same as number of elements in last row
		int t[] = new int[list.size()];
		int lastRow = list.size() - 1;

		for (int i = 0; i < list.get(lastRow).size(); i++) {
			t[i] = list.get(lastRow).get(i);
		}
		for (int i = lastRow - 1; i >= 0; i--) {
			System.out.println(Arrays.toString(t));
			for (int j = 0; j < list.get(i).size(); j++) {
				t[j] = list.get(i).get(j) + Math.min(t[j], t[j + 1]);
			}
		}
		return t[0];
	}

	public static void main(String args[]) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new ArrayList<>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);

		int res = minimumTotal(list);
		System.out.println(res);
	}
}