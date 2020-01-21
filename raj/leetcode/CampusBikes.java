package com.raj.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * @author Raj 
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.

Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the bike to that worker. (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index). We repeat this process until there are no available workers.

The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.

 

Example 1:



Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: [1,0]
Explanation: 
Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
Example 2:



Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
Output: [0,2,1]
Explanation: 
Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
 

Note:

0 <= workers[i][j], bikes[i][j] < 1000
All worker and bike locations are distinct.
1 <= workers.length <= bikes.length <= 1000
 * 
 */

public class CampusBikes {

	// Time : O(mn), Space : O(mn)
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		class Node {
			int dist;
			int w;
			int b;

			Node(int dist, int w, int b) {
				this.dist = dist;
				this.w = w;
				this.b = b;
			}

			public String toString() {
				return "w=" + w + ",b=" + b + ",dist=" + dist;
			}
		}

		int m = workers.length, n = bikes.length;
		int res[] = new int[m];
		Arrays.fill(res, -1);

		PriorityQueue<Node> pq = new PriorityQueue<>((m1, m2) -> {
			if (m1.dist == m2.dist && m1.w == m2.w)
				return m1.b - m2.b;
			if (m1.dist == m2.dist)
				return m1.w - m2.w;
			return m1.dist - m2.dist;
		});

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				pq.offer(new Node(manhattanDistance(workers[i], bikes[j]), i, j));
			}
		}

		Set<Integer> bvisited = new HashSet<>();
		while (!pq.isEmpty()) {
			Node ob = pq.poll();
			// if worker is already assigned bike or bike is already grabbed by other
			// worker, then continue
			if (res[ob.w] != -1 || bvisited.contains(ob.b))
				continue;
			res[ob.w] = ob.b;
			bvisited.add(ob.b);
		}
		return res;
	}

	int manhattanDistance(int[] w, int[] b) {
		return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
	}

	public static void main(String[] args) {
		CampusBikes obj = new CampusBikes();

		int[][] workers = { { 0, 0 }, { 2, 1 } };
		int bikes[][] = { { 1, 2 }, { 3, 3 } };
		int res[] = null;
		res = obj.assignBikes(workers, bikes);
		System.out.println(Arrays.toString(res));

	}

}
