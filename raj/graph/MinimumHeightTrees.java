package com.raj.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *         For a undirected graph with tree characteristics, we can choose any
 *         node as the root. The result graph is then a rooted tree. Among all
 *         possible rooted trees, those with minimum height are called minimum
 *         height trees (MHTs). Given such a graph, write a function to find all
 *         the MHTs and return a list of their root labels.
 * 
 *         Format The graph contains n nodes which are labeled from 0 to n - 1.
 *         You will be given the number n and a list of undirected edges (each
 *         edge is a pair of labels).
 * 
 *         You can assume that no duplicate edges will appear in edges. Since
 *         all edges are undirected, [0, 1] is the same as [1, 0] and thus will
 *         not appear together in edges.
 * 
 *         Example 1:
 * 
 *         Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 *         0 | 1 / \ 2 3 return [1]
 * 
 *         Example 2:
 * 
 *         Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 *         0 1 2 \ | / 3 | 4 | 5 return [3, 4]
 * 
 *         https://discuss.leetcode.com/topic/30572/share-some-thoughts
 * 
 *         http://52.20.106.37/minimum-height-trees/
 */
public class MinimumHeightTrees {

	/*
	 * if you have 1 node o it doesn't have leaves (that single node has 0
	 * degree), n won't change, so it's an infinite loop, but anyway it's a
	 * singular solution
	 * 
	 * if there are 2 nodes connected in a tree-like structure it must be: o --
	 * o if you continue the algorithm on this it'll remove both nodes and
	 * you'll end up with an empty tree (n==0), so having 2 nodes is a solution.
	 * 
	 * for 3 or more nodes there must be leaf nodes which can be removed to
	 * eventually reach 1 or 2 nodes left.
	 */
	// Time :O(n), Space :O(n+m)
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();

		if (n <= 0) {
			return result;
		}

		// Corner case: there is a single node and no edge at all
		if (n == 1 && edges.length == 0) {
			result.add(0);
			return result;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();

		// construct graph
		for (int[] edge : edges) {
			map.compute(edge[0], (key, value) -> {
				if (null == value) {
					value = new HashSet<>();
				}
				value.add(edge[1]);
				return value;
			});
			map.compute(edge[1], (key, value) -> {
				if (null == value) {
					value = new HashSet<>();
				}
				value.add(edge[0]);
				return value;
			});
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int ver : map.keySet()) {
			// start with leaf nodes
			if (map.get(ver).size() == 1) {
				queue.offer(ver);
			}

		}

		while (n > 2) {
			n -= queue.size();
			Queue<Integer> newLeaves = new LinkedList<>();
			while (!queue.isEmpty()) {
				int leaf = queue.poll();
				int neighbour = map.get(leaf).iterator().next();
				map.get(neighbour).remove(leaf);
				if (map.get(neighbour).size() == 1) {
					newLeaves.offer(neighbour);
				}
			}
			queue = newLeaves;
		}
		result.addAll(queue);
		return result;
	}

	public static void main(String args[]) {
		int n = 6, edges[][] = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		List<Integer> result = null;
		result = findMinHeightTrees(n, edges);
		System.out.println(result);

	}
}
