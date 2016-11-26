/**
 * 
 */
package com.raj.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.raj.nodes.Edge;
import com.raj.nodes.Vertex;

/**
 * @author Raj
 *
 */
public class Graph {
	private Set<Vertex> vertices = new HashSet<>();
	private Set<Edge> edges = new HashSet<>();
	private Map<Vertex, Set<Edge>> vertexToEdges = new HashMap<>();

	private boolean isDirected;

	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public void addVertex(int id) {
		Vertex v = new Vertex(id);
		vertices.add(v);
	}

	public void addEdge(Vertex v1, Vertex v2, int weight) {
		if (!vertices.contains(v1)) {
			vertices.add(v1);
		}

		if (!vertices.contains(v2)) {
			vertices.add(v2);
		}

		Edge e1 = new Edge(v1, v2, weight);
		edges.add(e1);
		vertexToEdges.compute(v1, (key, value) -> {
			if (null == value) {
				Set<Edge> edges = new HashSet<>();
				edges.add(e1);
				return edges;
			}
			value.add(e1);
			return value;
		});

		if (!isDirected) {
			Edge e2 = new Edge(v2, v1, weight);
			vertexToEdges.compute(v2, (key, value) -> {
				if (null == value) {
					Set<Edge> edges = new HashSet<>();
					edges.add(e2);
					return edges;
				}
				value.add(e2);
				return value;
			});
		}
	}

	public void addEdge(int id1, int id2, int weight) {
		Vertex v1 = new Vertex(id1);
		Vertex v2 = new Vertex(id2);
		addEdge(v1, v2, weight);
	}

	public Set<Vertex> getVertices() {
		return vertices;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public Map<Vertex, Set<Edge>> getVertexToEdges() {
		return vertexToEdges;
	}

	public Vertex getVertex(int id) {
		for (Vertex v : vertices) {
			if (v.id == id)
				return v;
		}
		return null;
	}

	public Set<Edge> getAdjascentEdges(int id) {
		Vertex v = new Vertex(id);
		return getAdjascentEdges(v);
	}

	public Set<Edge> getAdjascentEdges(Vertex v) {
		return vertexToEdges.get(v);
	}

	public void dfs(Vertex v) {
		Set<Vertex> visited = new HashSet<>();
		dfsUtil(v, visited);
		System.out.println();
	}

	private void dfsUtil(Vertex v, Set<Vertex> visited) {
		System.out.print(v + " ");
		visited.add(v);
		if (!vertexToEdges.containsKey(v))
			return;
		for (Edge e : vertexToEdges.get(v)) {
			Vertex adj = e.getAdjascentVertex(v);
			if (!visited.contains(adj)) {
				dfsUtil(adj, visited);
			}
		}
	}

	public void bfs(Vertex v) {
		Queue<Vertex> q = new LinkedList<>();
		Set<Vertex> visited = new HashSet<>();
		q.add(v);
		visited.add(v);
		while (!q.isEmpty()) {
			Vertex cur = q.poll();
			System.out.print(cur + " ");
			if (!vertexToEdges.containsKey(cur))
				continue;
			for (Edge e : vertexToEdges.get(cur)) {
				Vertex adj = e.getAdjascentVertex(cur);
				if (!visited.contains(adj)) {
					visited.add(adj);
					q.add(adj);
				}
			}
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph(false);
		g.addEdge(1, 2, 3);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 1, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 4, 3);
		g.addEdge(4, 5, 6);
		g.addEdge(5, 6, 2);
		g.addEdge(3, 5, 5);
		g.addEdge(3, 6, 4);

		System.out.println(g.getVertices());
		System.out.println(g.getEdges());

		System.out.println(g.getVertexToEdges());
		Vertex v1 = g.getVertex(3);

		System.out.println(g.getAdjascentEdges(v1));
		g.dfs(v1);
		g.bfs(v1);
	}

}
