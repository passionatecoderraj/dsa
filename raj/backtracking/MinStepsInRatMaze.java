/**
 * 
 */
package com.raj.backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Raj
 *
 */
public class MinStepsInRatMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

		MinStepsInRatMaze obj = new MinStepsInRatMaze();
		int result = -1;
		result = obj.minSteps(a, 0, 0, 3, 4);
		System.out.println(result);
	}

	public int minSteps(int[][] a, int startX, int startY, int endX, int endY) {
		if (!isSafe(a, startX, startY) || !isSafe(a, endX, endY))
			return -1;

		int moves[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		class Node {
			int x;
			int y;
			int distance;

			public Node(int x, int y, int distance) {
				super();
				this.x = x;
				this.y = y;
				this.distance = distance;
			}

			@Override
			public String toString() {
				return "Node [x=" + x + ", y=" + y + ", distance=" + distance + "]";
			}

		}
		boolean visited[][] = new boolean[a.length][a[0].length];
		visited[startX][startY] = true;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.x == endX && cur.y == endY) {
				return cur.distance;
			}
			for (int i = 0; i < moves.length; i++) {
				int newX = cur.x + moves[i][0];
				int newY = cur.y + moves[i][1];
				if (isSafe(a, newX, newY) && !visited[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new Node(newX, newY, cur.distance + 1));
				}
			}
		}
		return -1;
	}

	public boolean isSafe(int[][] a, int x, int y) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] == 1;
	}

}