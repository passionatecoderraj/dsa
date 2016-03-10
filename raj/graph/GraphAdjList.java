package com.raj.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class GraphAdjList {
	private final int n;
	private boolean visited[];
	private ListNode edges[];

	public GraphAdjList(int n) {
		this.n = n;
		visited = new boolean[n];
		edges = new ListNode[n];
	}

	public void addEdge(int i, int j) {
		if (i >= 0 && i < n && j >= 0 && j < n) {
			ListNode nn1 = new ListNode(i);
			ListNode nn2 = new ListNode(j);

			nn1.next = edges[j];
			edges[j] = nn1;
			nn2.next = edges[i];
			edges[i] = nn2;
		}
	}

	public void displayGraph() {
		for (int i = 0; i < n; i++) {
			System.out.print("Vertex : " + i + ", Edges : ");

			ListNode cur = edges[i];
			if (cur == null) {
				System.out.print("None");
				System.out.println();
				continue;
			}

			while (cur != null) {
				System.out.print(cur.data + " ");
				cur = cur.next;
			}
			System.out.println();
		}
	}

	public void dfs(int vertex) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		ListNode cur = edges[vertex];
		while (cur != null) {
			if (!visited[cur.data])
				dfs(cur.data);
			cur = cur.next;
		}
	}

	public void bfs(int vertex) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.addLast(vertex);
		visited[vertex] = true;
		while (!q.isEmpty()) {
			int node = q.removeFirst();
			System.out.print(node + " ");
			ListNode cur = edges[node];
			while (cur != null) {
				if (!visited[cur.data]) {
					visited[cur.data] = true;
					q.addLast(cur.data);
				}
				cur = cur.next;
			}
		}
	}

	public static void main(String[] args) {
		GraphAdjList g = new GraphAdjList(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);

		g.displayGraph();
		g.dfs(0);

		System.out.println();
		for (int i = 0; i < g.n; i++)
			g.visited[i] = false;
		g.bfs(0);

	}

}

class ListNode {
	public int data;
	public ListNode next;

	public ListNode() {

	}

	public ListNode(int data) {
		super();
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + "]";
	}

}
