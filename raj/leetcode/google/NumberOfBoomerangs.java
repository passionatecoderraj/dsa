package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Raj
 * 
 * 
 *         Given n points in the plane that are all pairwise distinct, a
 *         "boomerang" is a tuple of points (i, j, k) such that the distance
 *         between i and j equals the distance between i and k (the order of the
 *         tuple matters).
 * 
 *         Find the number of boomerangs. You may assume that n will be at most
 *         500 and coordinates of points are all in the range [-10000, 10000]
 *         (inclusive).
 * 
 *         Example: Input: [[0,0],[1,0],[2,0]]
 * 
 *         Output: 2
 * 
 *         Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and
 *         [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {

	// Time :O(n2), Space: O(1)
	public int numberOfBoomerangs(int[][] points) {
		int boomerangs = 0;

		for (int i = 0; i < points.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			// since order of tuple matters start from j=0 again
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				int distance = distance(points[i], points[j]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
			for (int value : map.values()) {
				/*
				 * permuting with 2 points from n = np2
				 */
				boomerangs += (value * (value - 1));
			}
		}

		return boomerangs;
	}

	private int distance(int[] a, int[] b) {
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];

		return dx * dx + dy * dy;
	}

	public static void main(String[] args) {
		NumberOfBoomerangs obj = new NumberOfBoomerangs();
		int[][] points = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
		int result = -1;
		result = obj.numberOfBoomerangs(points);
		System.out.println(result);

	}

}
