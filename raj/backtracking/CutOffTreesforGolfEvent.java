package com.raj.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author Raj
 *
 *         You are asked to cut off trees in a forest for a golf event. The
 *         forest is represented as a non-negative 2D map, in this map:
 * 
 *         0 represents the obstacle can't be reached. 1 represents the ground
 *         can be walked through. The place with number bigger than 1 represents
 *         a tree can be walked through, and this positive number represents the
 *         tree's height. You are asked to cut off all the trees in this forest
 *         in the order of tree's height - always cut off the tree with lowest
 *         height first. And after cutting, the original place has the tree will
 *         become a grass (value 1).
 * 
 *         You will start from the point (0, 0) and you should output the
 *         minimum steps you need to walk to cut off all the trees. If you can't
 *         cut off all the trees, output -1 in that situation.
 * 
 *         You are guaranteed that no two trees have the same height and there
 *         is at least one tree needs to be cut off.
 * 
 *         Example 1: Input: [ [1,2,3], [0,0,4], [7,6,5] ] Output: 6 Example 2:
 *         Input: [ [1,2,3], [0,0,0], [7,6,5] ] Output: -1 Example 3: Input: [
 *         [2,3,4], [0,0,5], [8,7,6] ] Output: 6 Explanation: You started from
 *         the point (0,0) and you can cut off the tree in (0,0) directly
 *         without walking.
 */
public class CutOffTreesforGolfEvent {

	public int cutOffTree(List<List<Integer>> field) {
		PriorityQueue<Tree> trees = new PriorityQueue<>((a, b) -> a.height - b.height);

		for (int i = 0; i < field.size(); i++) {
			for (int j = 0; j < field.get(0).size(); j++) {
				if (field.get(i).get(j) > 1) {
					trees.offer(new Tree(i, j, field.get(i).get(j)));
				}
			}
		}

		Tree prev = new Tree(0, 0, 1);
		int result = 0;

		while (!trees.isEmpty()) {
			Tree obj = trees.poll();
			int steps = minSteps(field, prev.x, prev.y, obj.x, obj.y);
			System.out.println("prev =" + prev + ", cur = " + obj + ", soln=" + steps);

			if (steps == -1) {
				return -1;
			}
			result += steps;
			prev = obj;
		}
		return result;
	}

	public int minSteps(List<List<Integer>> a, int startX, int startY, int endX, int endY) {
		if (!isSafe(a, startX, startY))
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
				if (isSafe(a, newX, newY) && !visited[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new Node(newX, newY, cur.distance + 1));
				}
			}
		}
		return -1;
	}

	public boolean isSafe(List<List<Integer>> a, int x, int y) {
		return x >= 0 && x < a.size() && y >= 0 && y < a.get(0).size() && (a.get(x).get(y) != 0);
	}

	class Tree {
		int x, y;
		int height;

		public Tree(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", height=" + height + "]";
		}

	}

	public static void main(String args[]) {
		CutOffTreesforGolfEvent obj = new CutOffTreesforGolfEvent();
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

		int result = obj.cutOffTree(field);
		System.out.println(result);
	}

}
