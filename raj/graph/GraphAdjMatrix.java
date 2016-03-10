package com.raj.graph;

import java.util.ArrayDeque;
import java.util.Deque;

import com.interivew.graph.CommonUtil;

public class GraphAdjMatrix {

	private final int n;
	private boolean adjMatrix[][];
	private boolean visited[];

	public GraphAdjMatrix(int n) {
		this.n = n;
		visited = new boolean[n];
		adjMatrix = new boolean[n][n];
	}

	public void addEdge(int i, int j) {
		if (i >= 0 && i < n && j >= 0 && j < n) {
			adjMatrix[i][j] = true;
			adjMatrix[j][i] = true;
		}
	}

	public void dfs(int vertex) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		for (int i = 0; i < n; i++) {
			if (adjMatrix[vertex][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	public void bfs(int vertex) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.addLast(vertex);
		visited[vertex] = true;
		while (!queue.isEmpty()) {
			int node = queue.removeFirst();
			System.out.print(node + " ");
			for (int i = 0; i < n; i++) {
				if (adjMatrix[node][i] && !visited[i]) {
					visited[i] = true;
					queue.addLast(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		GraphAdjMatrix g = new GraphAdjMatrix(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		CommonUtil.print2DArray(g.adjMatrix, g.n, g.n);
		g.dfs(0);
		System.out.println();

		for (int i = 0; i < g.n; i++)
			g.visited[i] = false;
		g.bfs(0);
	}

}
