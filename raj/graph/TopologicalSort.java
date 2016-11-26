package com.raj.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.raj.nodes.Edge;
import com.raj.nodes.Vertex;

/**
 * If there is a vertex from u to v, v always comes after u.
 * 
 * @author Raj
 *
 */
public class TopologicalSort {

	// Time : O(v+e), Space : O(v)
	public Stack<Vertex> topologicalSort(Graph graph) {
		Set<Vertex> visited = new HashSet<>();
		Stack<Vertex> stack = new Stack<Vertex>();
		for (Vertex v : graph.getVertices()) {
			if (!visited.contains(v)) {
				topologicalSortUtil(graph, visited, v, stack);
			}
		}
		return stack;
	}

	private void topologicalSortUtil(Graph g, Set<Vertex> visited, Vertex v, Stack<Vertex> stack) {
		visited.add(v);
		if (g.getVertexToEdges().containsKey(v)) {
			for (Edge e : g.getVertexToEdges().get(v)) {
				Vertex adj = e.getAdjascentVertex(v);
				if (!visited.contains(adj)) {
					topologicalSortUtil(g, visited, adj, stack);
				}
			}
		}
		stack.add(v);
	}

	public static void main(String args[]) {
		Graph graph = new Graph(true);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 2, 1);
		graph.addEdge(3, 4, 1);
		graph.addEdge(5, 6, 1);
		graph.addEdge(6, 3, 1);
		graph.addEdge(3, 8, 1);
		graph.addEdge(8, 11, 1);

		TopologicalSort obj = new TopologicalSort();
		Stack<Vertex> res = obj.topologicalSort(graph);
		while (!res.isEmpty()) {
			System.out.print(res.pop() + " ");
		}
		System.out.println();
	}

}