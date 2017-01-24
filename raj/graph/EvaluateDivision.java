package com.raj.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *         Equations are given in the format A / B = k, where A and B are
 *         variables represented as strings, and k is a real number (floating
 *         point number). Given some queries, return the answers. If the answer
 *         does not exist, return -1.0.
 * 
 *         Example:
 * 
 *         Given a / b = 2.0, b / c = 3.0.
 * 
 *         queries are: a / c = ?, b /a = ?, a / e = ?, a / a = ?, x / x = ? .
 * 
 *         return [6.0, 0.5, -1.0, 1.0,-1.0 ].
 * 
 *         The input is: vector<pair<string, string>> equations, vector<double>&
 *         values, vector<pair<string, string>> queries , where equations.size()
 *         == values.size(), and the values are positive. This represents the
 *         equations. Return vector<double>.
 * 
 *         According to the example above:
 * 
 *         equations = [ ["a", "b"], ["b", "c"] ],
 * 
 *         values = [2.0, 3.0],
 * 
 *         queries= [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]
 *         ].
 * 
 *         https://discuss.leetcode.com/topic/59146/java-ac-solution-using-graph
 */
public class EvaluateDivision {
	/*
	 * a/b = k as a Edge from node a to b, with weight of k ,and as a Edge from
	 * node b to node a, with weight of 1/k
	 * 
	 */
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double[] result = new double[queries.length];

		Map<String, Set<Edge>> map = new HashMap<>();

		// construct Graph
		for (int i = 0; i < equations.length; i++) {
			String eq[] = equations[i];
			Edge AbyB = new Edge(eq[0], eq[1], values[i]);
			Edge BbyA = new Edge(eq[1], eq[0], 1 / values[i]);
			map.compute(eq[0], (key, value) -> {
				if (null == value) {
					value = new HashSet<>();
				}
				value.add(AbyB);
				return value;
			});

			map.compute(eq[1], (key, value) -> {
				if (null == value) {
					value = new HashSet<>();
				}
				value.add(BbyA);
				return value;
			});
		}

		Set<String> visited = new HashSet<>();
		for (int i = 0; i < queries.length; i++) {
			String qry[] = queries[i];
			double res = dfs(qry[0], qry[1], 1.0, visited, map);
			result[i] = res != 0.0 ? res : -1.0;
		}
		return result;
	}

	private static double dfs(String start, String end, double value, Set<String> visited, Map<String, Set<Edge>> map) {
		if (visited.contains(start) || !map.containsKey(start)) {
			return 0.0;
		}
		if (start.equals(end)) {
			return value;
		}
		visited.add(start);
		double val = 0.0;
		for (Edge neighbour : map.get(start)) {
			val = dfs(neighbour.to, end, value * neighbour.weight, visited, map);
			if (0.0 != val)
				break;
		}
		visited.remove(start);
		return val;
	}

	public static void main(String[] args) {
		String[][] equations = { { "a", "b" }, { "b", "c" } };
		double[] values = { 2.0, 3.0 };
		String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
		double[] result = null;
		result = calcEquation(equations, values, queries);
		System.out.println(Arrays.toString(result));

	}

	static class Edge {
		String from;
		String to;
		double weight;

		public Edge(String from, String to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((from == null) ? 0 : from.hashCode());
			result = prime * result + ((to == null) ? 0 : to.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (from == null) {
				if (other.from != null)
					return false;
			} else if (!from.equals(other.from))
				return false;
			if (to == null) {
				if (other.to != null)
					return false;
			} else if (!to.equals(other.to))
				return false;
			return true;
		}

	}
}
