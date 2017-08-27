package com.raj.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

	private Map<Long, Node> map = new HashMap<>();

	class Node {
		long data;
		int rank;
		Node parent;
	}

	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.rank = 0;
		node.parent = node;
		map.put(data, node);
	}

	public boolean contains(long data) {
		return map.containsKey(data);
	}

	public long findSet(long data) {
		return findSet(map.get(data)).data;
	}

	public Node findSet(Node node) {
		if (node.parent == node) {
			return node;
		}
		return findSet(node.parent);
	}

	public void union(long x, long y) {
		link(findSet(map.get(x)), findSet(map.get(y)));
	}

	private void link(Node x, Node y) {
		if (x.rank > y.rank) {
			y.parent = x;
		} else {
			x.parent = y;
			if (x.rank == y.rank) {
				y.rank = y.rank + 1;
			}
		}
	}

	public static void main(String args[]) {
		DisjointSet ds = new DisjointSet();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);

		ds.union(1, 2);
		ds.union(2, 3);
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(5, 6);
		ds.union(3, 7);

		System.out.println(ds.findSet(1));
		System.out.println(ds.findSet(2));
		System.out.println(ds.findSet(3));
		System.out.println(ds.findSet(4));
		System.out.println(ds.findSet(5));
		System.out.println(ds.findSet(6));
		System.out.println(ds.findSet(7));

	}

}
