package com.raj.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.raj.nodes.Edge;
import com.raj.nodes.Vertex;

public class PrimMST {

	public List<Edge> primMST(Graph graph) {
		BinaryMinHeap<Vertex> minHeap = new BinaryMinHeap<>();
		Map<Vertex, Edge> vertexToEdge = new HashMap<>();
		List<Edge> result = new ArrayList<>();

		// insert all vertices with infinite value initially.
		for (Vertex v : graph.getVertices()) {
			minHeap.add(Integer.MAX_VALUE, v);
		}

		// start from any random vertex
		Vertex startVertex = graph.getVertices().iterator().next();

		// for the start vertex decrease the value in heap + map to 0
		minHeap.decrease(startVertex, 0);

		// iterate till heap + map has elements in it
		while (!minHeap.empty()) {
			Vertex cur = minHeap.extractMin();

			// get the corresponding edge for this vertex if present and add it
			// to final result.
			// This edge wont be present for first vertex.
			Edge spanningTreeEdge = vertexToEdge.get(cur);
			if (spanningTreeEdge != null) {
				result.add(spanningTreeEdge);
			}

			// iterate through all the adjacent vertices
			for (Edge edge : graph.getAdjascentEdges(cur)) {
				Vertex adjacent = edge.getAdjascentVertex(cur);

				// check if adjacent vertex exist in heap + map and weight
				// attached with this vertex is greater than this edge weight
				if (minHeap.containsData(adjacent) && minHeap.getWeight(adjacent) > edge.weight) {
					// decrease the value of adjacent vertex to this edge
					// weight.
					minHeap.decrease(adjacent, edge.weight);
					// add vertex->edge mapping in the graph.
					vertexToEdge.put(adjacent, edge);
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		Graph graph = new Graph(false);

		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 1, 1);
		graph.addEdge(1, 4, 1);
		graph.addEdge(2, 4, 3);
		graph.addEdge(4, 5, 6);
		graph.addEdge(5, 6, 2);
		graph.addEdge(3, 5, 5);
		graph.addEdge(3, 6, 4);

		PrimMST prims = new PrimMST();
		List<Edge> edges = prims.primMST(graph);
		for (Edge edge : edges) {
			System.out.println(edge);
		}
	}

}