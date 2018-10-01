/**
 * 
 */
package com.raj.leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 *We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.

We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.

Return an array representing the number of bricks that will drop after each erasure in sequence.

Example 1:
Input: 
grid = [[1,0,0,0],[1,1,1,0]]
hits = [[1,0]]
Output: [2]
Explanation: 
If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
Example 2:
Input: 
grid = [[1,0,0,0],[1,1,0,0]]
hits = [[1,1],[1,0]]
Output: [0,0]
Explanation: 
When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.
 

Note:

The number of rows and columns in the grid will be in the range [1, 200].
The number of erasures will not exceed the area of the grid.
It is guaranteed that each erasure will be different from any other erasure, and located inside the grid.
An erasure may refer to a location with no brick - if it does, no bricks drop.
 
 * 
 */
public class BricksFallingWhenHit {

	int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	// https://leetcode.com/problems/bricks-falling-when-hit/discuss/121077/Java-Union-Find-by-backwardly-adding-bricks-back-20ms
	/*
	 * all tests not executed
	 */
	public int[] hitBricks(int[][] grid, int[][] hits) {
		
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < hits.length; i++) {
			if (grid[hits[i][0]][hits[i][1]] == 1) {
				grid[hits[i][0]][hits[i][1]] = 2;
			}
		}
		DisjointSetWithSize ds = new DisjointSetWithSize();
		for (int i = 0; i <= (m * n); i++) {
			ds.makeSet(i);
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					uniononAround(i, j, grid, ds);
				}
			}
		}

		int count = ds.map.get(0).size;

		int res[] = new int[hits.length];
		for (int i = hits.length - 1; i >= 0; i--) {
			if (grid[hits[i][0]][hits[i][1]] == 2) {
				grid[hits[i][0]][hits[i][1]] = 1;
				uniononAround(hits[i][0], hits[i][1], grid, ds);		
			}
			int newCount = ds.map.get(0).size;
			// -1 because we shouldn't count the node that is hit 
			res[i] = newCount - count > 0 ? newCount - count - 1 : 0;
			count = newCount;
		}
		return res;
	}

	private void uniononAround(int x, int y, int[][] grid, DisjointSetWithSize ds) {
		int n = grid[0].length;

		int p1 = x * n + y + 1;
		// use 0 as pivot to connect all elements in row 0
		if (x == 0) {
			ds.union(p1, 0);
		}
		for (int move[] : moves) {
			int _x = x + move[0];
			int _y = y + move[1];
			int p2 = _x * n + _y + 1;
			if (isSafe(grid, _x, _y) && grid[_x][_y] == 1 && ds.findSet(p1) != ds.findSet(p2)) {
				ds.union(p1, p2);
			}
		}
	}

	private boolean isSafe(int[][] a, int x, int y) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
	}

	public static void main(String[] args) {
		BricksFallingWhenHit obj = new BricksFallingWhenHit();
		int res[] = null;

		int[][] grid = { { 1, 0, 0, 0 }, { 1, 1, 1, 0 } };
		int hits[][] = { { 1, 0 } };
		res = obj.hitBricks(grid, hits);
		System.out.println(Arrays.toString(res));

		int[][] grid2 = { { 1, 0, 0, 0 }, { 1, 1, 0, 0 } };
		int hits2[][] = { { 1, 1, }, { 1, 0 } };
		res = obj.hitBricks(grid2, hits2);
		System.out.println(Arrays.toString(res));
	}

}

class DisjointSetWithSize {

	public Map<Integer, Node> map = new HashMap<>();

	class Node {
		int data;
		int rank;
		Node parent;
		int size;

		@Override
		public String toString() {
			return "Node [data=" + data + ", rank=" + rank + ", size=" + size + "]";
		}

	}

	public void makeSet(int data) {
		Node node = new Node();
		node.data = data;
		node.rank = 0;
		node.size = 1;
		node.parent = node;
		map.put(data, node);
	}

	public boolean contains(int data) {
		return map.containsKey(data);
	}

	public int findSet(int data) {
		return findSet(map.get(data)).data;
	}

	public Node findSet(Node node) {
		if (node.parent == node) {
			return node;
		}
		return findSet(node.parent);
	}

	public void union(int x, int y) {
		link(findSet(map.get(x)), findSet(map.get(y)));
	}

	private void link(Node x, Node y) {
		if (x.rank > y.rank) {
			y.parent = x;
			x.size += y.size;
		} else {
			x.parent = y;
			if (x.rank == y.rank) {
				y.rank = y.rank + 1;
			}
			y.size += x.size;
		}
	}

	@Override
	public String toString() {
		return "DisjointSetWithSize [map=" + map + "]";
	}

}
