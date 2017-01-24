package com.raj.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	public GraphNode cloneGraph(GraphNode node) {
		if (node == null)
			return null;

		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();

		GraphNode newHead = new GraphNode(node.val * 10);

		queue.add(node);
		map.put(node, newHead);

		while (!queue.isEmpty()) {
			GraphNode curr = queue.pop();
			for (GraphNode aNeighbor : curr.neighbours) {
				if (!map.containsKey(aNeighbor)) {
					GraphNode copy = new GraphNode(aNeighbor.val * 10);
					map.put(aNeighbor, copy);
					queue.add(aNeighbor);
				}
				map.get(curr).neighbours.add(map.get(aNeighbor));
			}

		}
		return newHead;
	}

	public GraphNode cloneGraph2(GraphNode source) {
		if (null == source)
			return null;

		Queue<GraphNode> q = new LinkedList<>();
		q.offer(source);
		// An HashMap to keep track of all the
		// nodes which have already been created
		Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();

		// Put the node into the HashMap
		map.put(source, new GraphNode(source.val * 10));

		while (!q.isEmpty()) {
			GraphNode cur = q.poll();

			for (GraphNode adj : cur.neighbours) {
				if (!map.containsKey(adj)) {
					map.put(adj, new GraphNode(adj.val * 10));
					q.add(adj);
					map.get(adj).neighbours.add(map.get(cur));
					map.get(cur).neighbours.add(map.get(adj));
				} else {
					map.get(cur).neighbours.add(map.get(adj));
				}
			}
		}
		return map.get(source);
	}

	// BFS traversal of a graph to
	// check if the cloned graph is correct
	public void bfs(GraphNode source) {
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(source);
		HashMap<GraphNode, Boolean> visit = new HashMap<GraphNode, Boolean>();
		visit.put(source, true);
		while (!q.isEmpty()) {
			GraphNode u = q.poll();
			System.out.println("Value of Node " + u + ", Neighbours : " + u.neighbours);
			if (u.neighbours != null) {
				ArrayList<GraphNode> v = u.neighbours;
				for (GraphNode g : v) {
					if (visit.get(g) == null) {
						q.add(g);
						visit.put(g, true);
					}
				}
			}
		}
		System.out.println();
	}

	public static void main(String args[]) {
		CloneGraph obj = new CloneGraph();

		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);

		ArrayList<GraphNode> v = new ArrayList<GraphNode>();
		v.add(node2);
		v.add(node4);
		node1.neighbours = v;

		v = new ArrayList<GraphNode>();
		v.add(node1);
		v.add(node3);

		node2.neighbours = v;
		v = new ArrayList<GraphNode>();
		v.add(node2);
		v.add(node4);
		node3.neighbours = v;

		v = new ArrayList<GraphNode>();
		v.add(node3);
		v.add(node1);
		node4.neighbours = v;

		obj.bfs(node1);

		GraphNode result = obj.cloneGraph(node1);
		obj.bfs(result);
	}
}

class GraphNode {
	int val;

	// A neighbour ArrayList which contains references to
	// all the neighbours of a GraphNode
	ArrayList<GraphNode> neighbours;

	public GraphNode(int val) {
		this.val = val;
		neighbours = new ArrayList<GraphNode>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
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
		GraphNode other = (GraphNode) obj;
		if (val != other.val)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node(val=" + val + ")";
	}
}
