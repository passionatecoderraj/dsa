package com.raj.nodes;

public class Edge2<T> {
	private boolean isDirected = false;
	private Vertex2<T> vertex1;
	private Vertex2<T> vertex2;
	private int weight;

	public Edge2(Vertex2<T> vertex1, Vertex2<T> vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	public Edge2(Vertex2<T> vertex1, Vertex2<T> vertex2, boolean isDirected, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
		this.isDirected = isDirected;
	}

	public Edge2(Vertex2<T> vertex1, Vertex2<T> vertex2, boolean isDirected) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
	}

	public Vertex2<T> getVertex1() {
		return vertex1;
	}

	public Vertex2<T> getVertex2() {
		return vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
		result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
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
		Edge2 other = (Edge2) obj;
		if (vertex1 == null) {
			if (other.vertex1 != null)
				return false;
		} else if (!vertex1.equals(other.vertex1))
			return false;
		if (vertex2 == null) {
			if (other.vertex2 != null)
				return false;
		} else if (!vertex2.equals(other.vertex2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight
				+ "]";
	}
}