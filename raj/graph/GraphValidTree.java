package com.raj.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *         Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 *         (each edge is a pair of nodes), check if these edges form a valid
 *         tree.
 */
public class GraphValidTree {

	public static boolean validTreeBfs(int n, int[][] edges) {
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
		Set<Integer> visited = new HashSet<>();

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(map.keySet().iterator().next());
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (visited.contains(cur))
				return false;

			visited.add(cur);

			if (map.containsKey(cur)) {
				for (int neighbour : map.get(cur)) {
					if (!visited.contains(neighbour)) {
						queue.offer(neighbour);
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean validTreeDfs(int n, int[][] edges) {
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
		Set<Integer> visited = new HashSet<>();

		if (!dfs(map.keySet().iterator().next(), -1, visited, map)) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(int cur, int parent, Set<Integer> visited, Map<Integer, Set<Integer>> map) {
		if (visited.contains(cur))
			return false;
		visited.add(cur);
		if (map.containsKey(cur)) {
			for (int neighbour : map.get(cur)) {
				if (parent == neighbour)
					continue;
				if (!dfs(neighbour, cur, visited, map)) {
					return false;
				}
			}
		}
		return true;
	}

	// Time : O(V), Space : O(V)
	public static boolean validTreeUnionFind(int n, int[][] edges) {
		if (n == 0 || edges.length == 0)
			return true;

		DisjointSet ds = new DisjointSet();
		for (int i = 0; i < n; i++) {
			ds.makeSet(i);
		}
		for (int[] edge : edges) {
			long parent1 = ds.findSet(edge[0]);
			long parent2 = ds.findSet(edge[1]);
			if (parent1 == parent2)
				return false;
			ds.union(parent1, parent2);
		}
		return true;
	}

	public static void main(String[] args) {
		int edges[][] = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 1 } };
		int edges2[][] = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 4 }, { 4, 5 } };
		boolean result = false;

		result = validTreeUnionFind(6, edges);
		System.out.println(result);

		result = validTreeUnionFind(6, edges2);
		System.out.println(result);

		result = validTreeDfs(6, edges);
		System.out.println(result);

		result = validTreeDfs(6, edges2);
		System.out.println(result);

		result = validTreeBfs(6, edges);
		System.out.println(result);

		result = validTreeBfs(6, edges2);
		System.out.println(result);
	}

}
