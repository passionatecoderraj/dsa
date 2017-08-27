/**
 * 
 */
package com.raj.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.raj.graph.DisjointSet;

/**
 * @author Raj
 *
 *         A 2d grid map of m rows and n columns is initially filled with water.
 *         We may perform an addLand operation which turns the water at position
 *         (row, col) into a land. Given a list of positions to operate, count
 *         the number of islands after each addLand operation. An island is
 *         surrounded by water and is formed by connecting adjacent lands
 *         horizontally or vertically. You may assume all four edges of the grid
 *         are all surrounded by water.
 * 
 *         Example:
 * 
 *         Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 *         Initially, the 2d grid grid is filled with water. (Assume 0
 *         represents water and 1 represents land).
 * 
 * 
 *         0 0 0 0 0 0 0 0 0
 * 
 *         Operation #1: addLand(0, 0) turns the water at grid[0][0] into a
 *         land.
 * 
 *         1 0 0 0 0 0 Number of islands = 1 0 0 0
 * 
 *         Operation #2: addLand(0, 1) turns the water at grid[0][1] into a
 *         land.
 * 
 *         1 1 0 0 0 0 Number of islands = 1 0 0 0
 * 
 *         Operation #3: addLand(1, 2) turns the water at grid[1][2] into a
 *         land.
 * 
 *         1 1 0 0 0 1 Number of islands = 2 0 0 0
 * 
 *         Operation #4: addLand(2, 1) turns the water at grid[2][1] into a
 *         land.
 * 
 *         1 1 0 0 0 1 Number of islands = 3 0 1 0
 * 
 *         We return the result as an array: [1, 1, 2, 3]
 * 
 *         Challenge:
 * 
 *         Can you do it in time complexity O(k log mn), where k is the length
 *         of the positions?
 */
public class NumberOfIslands2 {

	public List<Integer> numIslands2(int m, int n, int[][] positions) {

		DisjointSet ds = new DisjointSet();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int count = 0;

		for (int k = 0; k < positions.length; k++) {
			count++;

			int[] p = positions[k];

			long curRoot = p[0] * n + p[1];
			ds.makeSet(curRoot);
			for (int r = 0; r < directions.length; r++) {
				int i = p[0] + directions[r][0];
				int j = p[1] + directions[r][1];

				// get neighbor
				int nR = i * n + j;

				// if safe and already have entry in DisjoingSet
				if (i >= 0 && j >= 0 && i < m && j < n && ds.contains(nR)) {
					// get neighbor's root
					long neighbourRout = ds.findSet(nR);
					// if root is not same union
					if (neighbourRout != curRoot) {
						ds.union(curRoot, neighbourRout);
						// after union curRoot's root may have changed
						curRoot = ds.findSet(curRoot);
						count--;
					}
				}
			}
			result.add(count);
		}

		return result;
	}

	public static void main(String[] args) {
		NumberOfIslands2 obj = new NumberOfIslands2();
		List<Integer> result = null;
		// int positions[][] = { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } };
		int positions[][] = { { 0, 1 }, { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 2 }, { 0, 0 }, { 1, 1 } };
		result = obj.numIslands2(3, 3, positions);

		System.out.println(result);

	}

}
