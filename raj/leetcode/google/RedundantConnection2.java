/**
 * 
 */
package com.raj.leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj 
 * 
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

 */
public class RedundantConnection2 {

	/*
	 * No. of edges for k nodes without cycle is k-1. If given no. of edges are n,
	 * there is one edge extra, so there are n+1 nodes
	 * 
	 */
	public int[] findRedundantConnection(int[][] edges) {

		Map<Integer, Set<Integer>> map = new HashMap<>();

		for (int edge[] : edges) {
			map.compute(edge[0], (k, v) -> {
				if (null == v)
					v = new HashSet<>();
				v.add(edge[1]);
				return v;
			});

		}

		int n = edges.length;

		int res[] = null;

		Set<Integer> whiteSet = new HashSet<>();
		Set<Integer> graySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();
		for(int i=1;i<=n;i++)
			whiteSet.add(i);
		while (whiteSet.size() > 0) {
			res = dfs(whiteSet.iterator().next(), whiteSet, graySet, blackSet, map);
		}

		return res;
	}

	
	private int[] dfs(int cur, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet,
			Map<Integer, Set<Integer>> map) {
		graySet.add(cur);
		whiteSet.remove(cur);

		if (map.containsKey(cur)) {
			for (int adj : map.get(cur)) {
				if (blackSet.contains(adj))
					continue;
				if (graySet.contains(adj)) {
					return new int[] { cur, adj };
				}
				int[] res = dfs(adj, whiteSet, graySet, blackSet, map);
				if (null != res) {
					return res;
				}
			}
		}
		graySet.remove(cur);
		blackSet.add(cur);
		return null;
	}

	public static void main(String[] args) {
		RedundantConnection2 obj = new RedundantConnection2();
		int[] result = null;
		int edges[][] = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		result = obj.findRedundantConnection(edges);
		System.out.println(Arrays.toString(result));

		int edges2[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1,5 } };
		result = obj.findRedundantConnection(edges2);
		System.out.println(Arrays.toString(result));

	}

}
