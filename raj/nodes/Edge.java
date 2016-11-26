/**
 * 
 */
package com.raj.nodes;

/**
 * @author Raj
 *
 */
public class Edge {
	public Vertex v1;
	public Vertex v2;
	public int weight;

	public Edge(Vertex v1, Vertex v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		return result;
	}

	public Vertex getAdjascentVertex(Vertex v) {
		if (v1.equals(v)) {
			return v2;
		} else if (v2.equals(v)) {
			return v1;
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (v1 == null) {
			if (other.v1 != null)
				return false;
		} else if (!v1.equals(other.v1))
			return false;
		if (v2 == null) {
			if (other.v2 != null)
				return false;
		} else if (!v2.equals(other.v2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge(" + v1.id + ", " + v2.id + ", wt=" + weight + ")";
	}
}
