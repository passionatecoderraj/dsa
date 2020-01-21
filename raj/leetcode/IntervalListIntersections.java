/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raj
 Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

public class IntervalListIntersections {
	// https://leetcode.com/problems/interval-list-intersections/discuss/231122/Java-two-pointers-O(m-+-n)
	// Time : O(m+n), Space : O(n)
	public int[][] intervalIntersection(int[][] a, int[][] b) {
		List<int[]> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			int startMax = Math.max(a[i][0], b[j][0]);
			int endMin = Math.min(a[i][1], b[j][1]);
			// it means there is a overlap
			if (startMax <= endMin) {
				list.add(new int[] { startMax, endMin });
			}
			if (a[i][1] == endMin) {
				i++;
			} else {
				j++;
			}
		}

		int[][] res = new int[list.size()][2];
		i = 0;
		for (int item[] : list)
			res[i++] = item;

		return res;
	}

	public int[][] intervalIntersection2(int[][] a, int[][] b) {
		List<int[]> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i][0] < b[j][0] ? overlap(a[i], b[j]) : overlap(b[j], a[i])) {
				list.add(new int[] { Math.max(a[i][0], b[j][0]), Math.min(a[i][1], b[j][1]) });
			}
			if (a[i][1] <= b[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		int[][] res = new int[list.size()][2];
		for (int k = 0; k < res.length; k++) {
			int[] item = list.get(k);
			res[k] = new int[2];
			res[k][0] = item[0];
			res[k][1] = item[1];
		}
		return res;
	}

	private boolean overlap(int[] a, int[] b) {
		return !(a[0] < b[1] && a[1] < b[0]);
	}

	public static void main(String[] args) {
		IntervalListIntersections obj = new IntervalListIntersections();
		int[][] a = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] b = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

		int[][] result = null;
		// Time : O(n), Space : O(1)
		result = obj.intervalIntersection(a, b);
		for (int[] r : result)
			System.out.print(Arrays.toString(r) + " ");
		System.out.println();
	}

}
