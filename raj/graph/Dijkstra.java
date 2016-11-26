package com.raj.graph;

import java.util.HashMap;
import java.util.Map;

import com.raj.nodes.Edge;
import com.raj.nodes.Vertex;

public class Dijkstra {

	public Map<Vertex, Integer> shortestDistance(Graph graph) {
		Map<Vertex, Integer> distanceMap = new HashMap<>();
		Map<Vertex, Vertex> pathMap = new HashMap<>();
		BinaryMinHeap<Vertex> minHeap = new BinaryMinHeap<>();
		for (Vertex v : graph.getVertices()) {
			minHeap.add(Integer.MAX_VALUE, v);
		}
		Vertex start = graph.getVertices().iterator().next();
		minHeap.decrease(start, 0);

		while (!minHeap.empty()) {
			int curDistance = minHeap.getWeight(minHeap.min());
			Vertex cur = minHeap.extractMin();
			distanceMap.put(cur, curDistance);

			for (Edge e : graph.getAdjascentEdges(cur)) {
				Vertex adj = e.getAdjascentVertex(cur);
				if (minHeap.containsData(adj) && curDistance + e.weight < minHeap.getWeight(adj)) {
					minHeap.decrease(adj, curDistance + e.weight);
					pathMap.put(adj, cur);
				}
			}
		}
		System.out.println(pathMap);
		return distanceMap;
	}

	public static void main(String args[]) {
		Graph graph = new Graph(false);
		/*
		 * graph.addEdge(0, 1, 4); graph.addEdge(1, 2, 8); graph.addEdge(2, 3,
		 * 7); graph.addEdge(3, 4, 9); graph.addEdge(4, 5, 10); graph.addEdge(2,
		 * 5, 4); graph.addEdge(1, 7, 11); graph.addEdge(0, 7, 8);
		 * graph.addEdge(2, 8, 2); graph.addEdge(3, 5, 14); graph.addEdge(5, 6,
		 * 2); graph.addEdge(6, 8, 6); graph.addEdge(6, 7, 1); graph.addEdge(7,
		 * 8, 7);
		 */

		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 2);
		graph.addEdge(1, 4, 9);
		graph.addEdge(1, 5, 3);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 4, 2);
		graph.addEdge(3, 4, 3);

		Dijkstra obj = new Dijkstra();

		Map<Vertex, Integer> res = obj.shortestDistance(graph);
		for (Vertex v : res.keySet()) {
			System.out.print(v + " - " + res.get(v) + ", ");
		}
		System.out.println();
	}

}