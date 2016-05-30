/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Raj
 *
 */
public class SkylineProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// each of these are x1, x2 and height
		int[][] buildings = { { 1, 3, 4 }, { 3, 4, 4 }, { 2, 6, 2 }, { 8, 11, 4 }, { 7, 9, 3 }, { 10, 11, 2 } };
		SkylineProblem obj = new SkylineProblem();
		obj.getSkyline(buildings);
	}

	class Edge {
		int x;
		int height;
		boolean isStart;

		public Edge(int start, int height, boolean isStart) {
			super();
			this.x = start;
			this.height = height;
			this.isStart = isStart;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", h=" + height + ", isS=" + isStart + "]";
		}
	}

	public void getSkyline(int[][] buildings) {

		List<Edge> edges = new ArrayList<>();
		for (int[] building : buildings) {
			edges.add(new Edge(building[0], building[2], true));
			edges.add(new Edge(building[1], building[2], false));
		}
		Collections.sort(edges, new Comparator<Edge>() {
			// first compare by x.
			// If they are same then use this logic
			// if two starts are compared then higher height building should be
			// picked first
			// if two ends are compared then lower height building should be
			// picked first
			// if one start and end is compared then start should appear before
			// end
			public int compare(Edge e1, Edge e2) {
				if (e1.x != e2.x)
					return e1.x - e2.x;
				if (e1.isStart && e2.isStart) {
					return e2.height - e1.height;
				} else if (!e1.isStart && !e2.isStart) {
					return e1.height - e2.height;
				}
				return e1.isStart ? -1 : 1;
			}
		});

		List<int[]> result = new ArrayList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 1);
		int prevMaxHeight = 0;
		for (Edge edge : edges) {
			if (edge.isStart) {
				map.compute(edge.height, (key, value) -> {
					if (value != null)
						return value + 1;
					return 1;
				});

			} else {
				map.compute(edge.height, (key, value) -> {
					if (value == 1)
						return null;
					return value - 1;
				});
			}
			// peek the current height after addition or removal of building x.
			// if height changes from previous height then this building x
			// becomes critical x.
			// So add it to the result.
			int curMaxHeight = map.lastKey();
			if (curMaxHeight != prevMaxHeight) {
				result.add(new int[] { edge.x, curMaxHeight });
				prevMaxHeight = curMaxHeight;
			}
		}
		for (int[] r : result)
			System.out.print(Arrays.toString(r) + " ");
		System.out.println();
	}

	public void f(List<Edge> edges) {
		List<int[]> result = new ArrayList<>();

		PriorityQueue<Integer> pq = new PriorityQueue<>(edges.size(), Collections.reverseOrder());
		for (Edge edge : edges) {
			if (edge.isStart) {
				if (pq.isEmpty() || edge.height > pq.peek()) {
					result.add(new int[] { edge.x, edge.height });
				}
				pq.add(edge.height);
			} else {
				pq.remove(edge.height);
				if (pq.isEmpty()) {
					result.add(new int[] { edge.x, 0 });
				} else if (edge.height > pq.peek()) {
					result.add(new int[] { edge.x, pq.peek() });
				}
			}
		}
	}

}
