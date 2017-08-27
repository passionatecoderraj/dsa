package com.interview.onion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class MinStepsToCutAllTrees {

	int levelField(int rows, int cols, List<List<Integer>> field) {
		Map<Integer, Point> trees = new TreeMap<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (field.get(i).get(j) != 1 && field.get(i).get(j) != 0) {
					trees.put(field.get(i).get(j), new Point(i, j));
				}
			}
		}

		System.out.println(trees);
		Point prev = new Point(0, 0);
		int result = 0;
		for (Integer key : trees.keySet()) {
			Point obj = trees.get(key);
			int steps = minSteps(field, prev.x, prev.y, obj.x, obj.y, key);
			System.out.println("prev =" + prev + ", cur = " + obj + ", soln=" + steps);
			if (steps != -1) {
				result += steps;
				prev = obj;
				field.get(obj.x).remove(obj.y);
				field.get(obj.x).add(obj.y, 1);
			}
		}
		// WRITE YOUR CODE HERE
		return result;
	}
	// METHOD SIGNATURE ENDS

	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	public boolean isSafe(List<List<Integer>> a, int x, int y, int val) {
		return x >= 0 && x < a.size() && y >= 0 && y < a.get(0).size()
				&& (a.get(x).get(y) == 1 || a.get(x).get(y) == val);
	}

	public int minSteps(List<List<Integer>> a, int startX, int startY, int endX, int endY, int val) {
		if (!isSafe(a, startX, startY, val))
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
		boolean visited[][] = new boolean[a.size()][a.get(0).size()];
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
				if (isSafe(a, newX, newY, val) && !visited[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new Node(newX, newY, cur.distance + 1));
				}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		MinStepsToCutAllTrees obj = new MinStepsToCutAllTrees();
		List<List<Integer>> field = new ArrayList<>();
		List<Integer> input;

		input = new ArrayList<>();
		input.add(1);
		input.add(1);
		input.add(0);
		input.add(2);
		field.add(input);

		input = new ArrayList<>();
		input.add(3);
		input.add(1);
		input.add(1);
		input.add(1);
		field.add(input);

		int result = obj.levelField(2, 4, field);
		System.out.println(result);
	}
}