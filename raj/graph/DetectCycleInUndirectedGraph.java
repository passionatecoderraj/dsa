package com.raj.graph;

import java.util.HashSet;
import java.util.Set;

import com.raj.nodes.Edge2;
import com.raj.nodes.Graph;
import com.raj.nodes.Vertex2;

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
		Set<Vertex2<Integer>> visited = new HashSet<Vertex2<Integer>>();

		return false;
	}

	public boolean hasCycleUsingDisjointSets(Graph<Integer> g) {
		DisjointSet dset = new DisjointSet();
		for (Vertex2<Integer> v : g.getAllVertex()) {
			dset.makeSet(v.getId());
		}

		for (Edge2<Integer> e : g.getAllEdges()) {
			Vertex2<Integer> v1 = e.getVertex1();
			Vertex2<Integer> v2 = e.getVertex2();
			long parent1 = dset.findSet(v1.getId());
			long parent2 = dset.findSet(v2.getId());
			if (parent1 == parent2)
				return true;
			dset.union(v1.getId(), v2.getId());
		}
		return false;
	}

}
