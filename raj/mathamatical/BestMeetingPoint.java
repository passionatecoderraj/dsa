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

	// Time : O(mn), Space : O(mn)
	public static int bestMeetingPointMinDistance(int a[][]) {

		ArrayList<Integer> rows = new ArrayList<>();
		ArrayList<Integer> cols = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1) {
					rows.add(i);
				}
			}
		}
		// two iterations required to avoid sorting cols again
		for (int j = 0; j < a[0].length; j++) {
			for (int i = 0; i < a.length; i++) {
				if (a[i][j] == 1) {
					cols.add(j);
				}
			}
		}
		// rows and cols are already sorted
		int rowMedian = median(rows);
		int colMedian = median(cols);

		// System.out.println(rows);
		// System.out.println(cols);

		int distance = 0;
		for (int i : rows) {
			distance += Math.abs(i - rowMedian);
		}

		for (int i : cols) {
			distance += Math.abs(i - colMedian);
		}

		return distance;
	}

	public static int median(ArrayList<Integer> a) {

		int k = a.size() / 2;

		if (k % 2 != 0) {
			return a.get(k);
		} else {
			return (a.get(k) + a.get(k - 1)) / 2;
		}

	}

	/**
	 * @param args
	 */
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
