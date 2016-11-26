/**
 * 
 */
package com.raj.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.raj.nodes.Edge;
import com.raj.nodes.Vertex;

/**
 * @author Raj
 *
 */
public class KruskalMST {

	public List<Edge> kruskalMST(Graph graph) {
		List<Edge> result = new ArrayList<>();
		DisjointSet ds = new DisjointSet();

		for (Vertex v : graph.getVertices()) {
			ds.makeSet(v.id);
		}

		List<Edge> edges = new ArrayList<>(graph.getEdges());
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});

		for (Edge e : edges) {
			long parent1 = ds.findSet(e.v1.id);
			long parent2 = ds.findSet(e.v2.id);
			if (parent1 == parent2) {
				continue;
			}
			ds.union(parent1, parent2);
			result.add(e);
			if (result.size() == graph.getVertices().size() - 1) {
				break;
			}
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph(false);
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 5, 1);
		graph.addEdge(2, 6, 3);
		graph.addEdge(2, 4, 2);
		graph.addEdge(6, 5, 2);
		graph.addEdge(6, 4, 3);
		graph.addEdge(4, 7, 2);
		graph.addEdge(3, 4, 5);
		graph.addEdge(3, 7, 8);

		KruskalMST obj = new KruskalMST();
		List<Edge> result = obj.kruskalMST(graph);
		System.out.println(result);
		System.out.println(graph.getVertices());
	}

}
