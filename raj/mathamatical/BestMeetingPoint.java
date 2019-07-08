/**
 * 
 */
package com.raj.mathamatical;

import java.util.ArrayList;

/**
 * @author Raj
 *
 *         A group of two or more people wants to meet and minimize the total
 *         travel distance. You are given a 2D grid of values 0 or 1, where each
 *         1 marks the home of someone in the group. The distance is calculated
 *         using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| +
 *         |p2.y - p1.y|.
 * 
 *         https://discuss.leetcode.com/topic/27710/14ms-java-solution
 */
public class BestMeetingPoint {

	/*
	 * One may think that the optimal meeting point must fall on one of the 1's. This is true for cases with odd number of 1's, 
	 * but not necessarily true when there are even number of 1's
	 * Example: 1 1 0 0 1 1 (even) , odd : 1 1 0 0 1
	 * 
	 * Explanation:
	 * 1) meeting point need not be on the houses
	 * 2) find all house locations - as rows and columns
	 * 3) find mid point
	 * 4) now find the distance from mid point to others location to calculate the distance
	 * 
	 */
	// Time : O(mn), Space : O(m+n)
	public static int bestMeetingPointMinDistance(int grid[][]) {

		ArrayList<Integer> rows = new ArrayList<>();
		ArrayList<Integer> cols = new ArrayList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
				}
			}
		}
		// two iterations required to avoid sorting cols again
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 1) {
					cols.add(j);
				}
			}
		}
		// rows and cols are already sorted
		int rowMedian = rows.get(rows.size()/2);
		int colMedian = cols.get(cols.size()/2);

		int distance = 0;
		for (int i : rows) {
			distance += Math.abs(i - rowMedian);
		}

		for (int i : cols) {
			distance += Math.abs(i - colMedian);
		}

		return distance;
	}


	public static void main(String[] args) {

		int a[][] = { { 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };

		int res = -1;
		res = bestMeetingPointMinDistance(a);
		System.out.println(res);
		int b[][] = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 } };
		res = bestMeetingPointMinDistance(b);
		System.out.println(res);

		int c[][] = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		res = bestMeetingPointMinDistance(c);
		System.out.println(res);

	}

}
