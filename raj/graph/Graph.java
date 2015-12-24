package com.raj.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

	class Vertex{
		T label;
		int id;
	}
	
	int n;
	Map<Vertex,ListNode<Vertex>> map = new HashMap<Vertex,ListNode<Vertex>>();
	List<Vertex> Vertexs;
	List<Vertex>[] edges;
	
	public Graph(int n) {
		this.n = n;
		map = new HashMap<Vertex,ListNode<Vertex>>(n);

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
