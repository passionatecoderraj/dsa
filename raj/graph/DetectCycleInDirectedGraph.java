package com.raj.graph;

import java.util.HashSet;
import java.util.Set;

import com.raj.nodes.Graph;
import com.raj.nodes.Vertex;

public class DetectCycleInDirectedGraph {

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>(true);

		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(4, 1);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);

		boolean result = false;
		DetectCycleInDirectedGraph obj = new DetectCycleInDirectedGraph();
		// Time : O(E+V), Space : O(V)
		result = obj.hasCycleInDirectedGraphUsingDfs(g);
		System.out.println(result);
	}

	public boolean hasCycleInDirectedGraphUsingDfs(Graph<Integer> g) {
		Set<Vertex<Integer>> whiteSet = new HashSet<>();
		Set<Vertex<Integer>> graySet = new HashSet<>();
		Set<Vertex<Integer>> blackSet = new HashSet<>();
		for (Vertex<Integer> v : g.getAllVertex()) {
			whiteSet.add(v);
		}
		g.display();
		Vertex<Integer> current = null;
		while (whiteSet.size() > 0) {
			Vertex<Integer> cur = whiteSet.iterator().next();
			current = cur;
			System.out.println(current.getEdges());
			if (dfs(cur, whiteSet, graySet, blackSet))
				return true;
		}

		return false;
	}

	public boolean dfs(Vertex<Integer> cur, Set<Vertex<Integer>> whiteSet, Set<Vertex<Integer>> graySet,
			Set<Vertex<Integer>> blackSet) {
		// move cur vertex to gray from white set and start exploring it
		graySet.add(cur);
		whiteSet.remove(cur);
		for (Vertex<Integer> neighbour : cur.getAdjacentVertexes()) {
			if (blackSet.contains(neighbour))
				continue;
			// if in gray set then cycle is found
			if (graySet.contains(neighbour))
				return true;
			if (dfs(neighbour, whiteSet, graySet, blackSet))
				return true;
		}

		// move vertex from gray set to black set when done exploring
		graySet.remove(cur);
		blackSet.add(cur);
		return false;
	}

}
