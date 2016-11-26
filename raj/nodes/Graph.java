package com.raj.nodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

	private List<Edge2<T>> allEdges;
	private Map<Long, Vertex2<T>> allVertex;
	boolean isDirected = false;

	public Graph(boolean isDirected) {
		allEdges = new ArrayList<Edge2<T>>();
		allVertex = new HashMap<Long, Vertex2<T>>();
		this.isDirected = isDirected;
	}

	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}

	// This works only for directed graph because for undirected graph we can
	// end up
	// adding edges two times to allEdges
	public void addVertex(Vertex2<T> vertex) {
		if (allVertex.containsKey(vertex.getId())) {
			return;
		}
		allVertex.put(vertex.getId(), vertex);
		for (Edge2<T> edge : vertex.getEdges()) {
			allEdges.add(edge);
		}
	}

	public Vertex2<T> addSingleVertex(long id) {
		if (allVertex.containsKey(id)) {
			return allVertex.get(id);
		}
		Vertex2<T> v = new Vertex2<T>(id);
		allVertex.put(id, v);
		return v;
	}

	public Vertex2<T> getVertex(long id) {
		return allVertex.get(id);
	}

	public void addEdge(long id1, long id2, int weight) {
		Vertex2<T> vertex1 = null;
		if (allVertex.containsKey(id1)) {
			vertex1 = allVertex.get(id1);
		} else {
			vertex1 = new Vertex2<T>(id1);
			allVertex.put(id1, vertex1);
		}
		Vertex2<T> vertex2 = null;
		if (allVertex.containsKey(id2)) {
			vertex2 = allVertex.get(id2);
		} else {
			vertex2 = new Vertex2<T>(id2);
			allVertex.put(id2, vertex2);
		}

		Edge2<T> edge = new Edge2<T>(vertex1, vertex2, isDirected, weight);
		allEdges.add(edge);
		vertex1.addAdjacentVertex(edge, vertex2);
		if (!isDirected) {
			vertex2.addAdjacentVertex(edge, vertex1);
		}

	}

	public List<Edge2<T>> getAllEdges() {
		return allEdges;
	}

	public Collection<Vertex2<T>> getAllVertex() {
		return allVertex.values();
	}

	public void setDataForVertex(long id, T data) {
		if (allVertex.containsKey(id)) {
			Vertex2<T> vertex = allVertex.get(id);
			vertex.setData(data);
		}
	}

	public void display() {
		for (Long key : allVertex.keySet()) {
			Vertex2<T> v = allVertex.get(key);
			List<Vertex2<T>> adjacentVertex = v.getAdjacentVertexes();
			System.out.print(v + "->");
			for (Vertex2<T> vertex : adjacentVertex) {
				System.out.print(vertex.id + " ");
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Edge2<T> edge : getAllEdges()) {
			buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
