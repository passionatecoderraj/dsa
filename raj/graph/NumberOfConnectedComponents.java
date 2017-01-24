package com.raj.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *         Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 *         (each edge is a pair of nodes), write a function to find the number
 *         of connected components in an undirected graph.
 * 
 * 
 *         Example 1: 0 3 | | 1 --- 2 4 Given n = 5 and edges = [[0, 1], [1, 2],
 *         [3, 4]], return 2.
 * 
 *         Example 2: 0 4 | | 1 --- 2 --- 3 Given n = 5 and edges = [[0, 1], [1,
 *         2], [2, 3], [3, 4]], return 1.
 * 
 *         Note: You can assume that no duplicate edges will appear in edges.
 *         Since all edges are undirected, [0, 1] is the same as [1, 0] and thus
 *         will not appear together in edges.
 */
public class NumberOfConnectedComponents {

	public static int countComponentsUnionFind(int n, int[][] edges) {

		if (n <= 0 || edges.length == 0) {
			return 0;
		}

		DisjointSet ds = new DisjointSet();
		for (int i = 0; i < n; i++) {
			ds.makeSet(i);
		}

		for (int[] edge : edges) {
			ds.union(edge[0], edge[1]);
		}

		Set<Long> result = new HashSet<>();
		for (int i = 0; i < n; i++) {
			result.add(ds.findSet(i));
		}
		return result.size();
	}

	public static int countComponentsDfs(int n, int[][] edges) {

		if (n <= 0 || edges.length == 0) {
			return 0;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();
		Set<Integer> visited = new HashSet<>();

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

		int count = 0;
		for (int ver : map.keySet()) {
			if (!visited.contains(ver)) {
				dfs(ver, visited, map);
				count++;
			}
		}
		return count;
	}

	private static void dfs(int ver, Set<Integer> visited, Map<Integer, Set<Integer>> map) {
		visited.add(ver);
		if (map.containsKey(ver)) {
			for (int neighbour : map.get(ver)) {
				if (!visited.contains(neighbour)) {
					dfs(neighbour, visited, map);
				}
			}
		}
	}

	public static void main(String args[]) {
		int n = 5, edges[][] = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		int result = -1;
		result = countComponentsDfs(n, edges);
		System.out.println(result);

		n = 5;
		int edges2[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
		result = countComponentsDfs(5, edges2);
		System.out.println(result);

		result = countComponentsUnionFind(n, edges);
		System.out.println(result);

		result = countComponentsUnionFind(5, edges2);
		System.out.println(result);

	}
}
