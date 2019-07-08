/**
 * 
 */
package com.raj.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Raj
 * 
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.

graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

 

Example 1:

Input: [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
Example 2:

Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
 

Note:

1 <= graph.length <= 12
0 <= graph[i].length < graph.length
 */
public class ShortestPathVisitingAllNodes {

	
	// Time : O(2^n*n), Space : O(2^n)
	public int shortestPathLength(int[][] a) {
		class Node {
			int id;
			int state;

			Node(int id, int state) {
				this.id = id;
				this.state = state;
			}
		}

		Queue<Node> q = new LinkedList<>();
		int steps = 0;
		for (int i = 0; i < a.length; i++) {
			q.offer(new Node(i, 1 << i));
		}

		int target = (1 << a.length) - 1;

		Set<Integer> visited = new HashSet<>();
		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				if (node.state == target) {
					return steps;
				}
				int key = (node.id << 16) | node.state;
				if (visited.contains(key)) {
					continue;
				}
				visited.add(key);
				for (int adj : a[node.id]) {
					q.offer(new Node(adj, (1 << adj) | node.state));
				}
			}
			steps++;
		}
		return -1;
	}

	public static void main(String[] args) {
		ShortestPathVisitingAllNodes obj = new ShortestPathVisitingAllNodes();
		int result = -1;
		int a[][] = { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } };

		// Time :O(rows*cols), Space : O(rows*cols)
		result = obj.shortestPathLength(a);
		System.out.println(result);

		int b[][] = { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } };
		result = obj.shortestPathLength(b);
		System.out.println(result);

	}
}
