package com.raj.graph;

import java.util.HashSet;
import java.util.Set;

import com.raj.nodes.Edge;
import com.raj.nodes.Graph;
import com.raj.nodes.Vertex;

public class DetectCycleInUndirectedGraph {

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>(false);

		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 1);

		boolean result = false;
		DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();
		// Time : O(V), Space : O(V)
		result = obj.hasCycleUsingDisjointSets(g);
		System.out.println(result);

		// Time : O(V), Space : O(V)
		result = obj.hasCycleUsingDfs(g);
		System.out.println(result);
	}

	public boolean hasCycleUsingDfs(Graph<Integer> g) {
		Set<Vertex<Integer>> visited = new HashSet<Vertex<Integer>>();

		return false;
	}

	public boolean hasCycleUsingDisjointSets(Graph<Integer> g) {
		DisjointSet dset = new DisjointSet();
		for (Vertex<Integer> v : g.getAllVertex()) {
			dset.makeSet(v.getId());
		}

		for (Edge<Integer> e : g.getAllEdges()) {
			Vertex<Integer> v1 = e.getVertex1();
			Vertex<Integer> v2 = e.getVertex2();
			long parent1 = dset.findSet(v1.getId());
			long parent2 = dset.findSet(v2.getId());
			if (parent1 == parent2)
				return true;
			dset.union(v1.getId(), v2.getId());
		}
		return false;
	}

}
