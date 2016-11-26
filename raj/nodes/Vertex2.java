package com.raj.nodes;

import java.util.ArrayList;
import java.util.List;

public class Vertex2<T> {
	long id;
	private T data;
	private List<Edge2<T>> edges = new ArrayList<>();
	private List<Vertex2<T>> adjacentVertex = new ArrayList<>();

	public Vertex2(long id) {
		this.id = id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void addAdjacentVertex(Edge2<T> e, Vertex2<T> v) {
		edges.add(e);
		adjacentVertex.add(v);
	}

	public String toString() {
		return String.valueOf(id);
	}

	public List<Vertex2<T>> getAdjacentVertexes() {
		return adjacentVertex;
	}

	public List<Edge2<T>> getEdges() {
		return edges;
	}

	public int getDegree() {
		return edges.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex2 other = (Vertex2) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
