/**
 * 
 */
package com.raj.leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Raj
 *
 *         There is a ball in a maze with empty spaces and walls. The ball can
 *         go through empty spaces by rolling up, down, left or right, but it
 *         won't stop rolling until hitting a wall. When the ball stops, it
 *         could choose the next direction.
 * 
 *         Given the ball's start position, the destination and the maze,
 *         determine whether the ball could stop at the destination.
 * 
 *         The maze is represented by a binary 2D array. 1 means the wall and 0
 *         means the empty space. You may assume that the borders of the maze
 *         are all walls. The start and destination coordinates are represented
 *         by row and column indexes.
 * 
 *         Example 1
 * 
 *         Input 1: a maze represented by a 2D array
 * 
 *         0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 1 1 0 0 0 0 0
 * 
 *         Input 2: start coordinate (rowStart, colStart) = (0, 4) Input 3:
 *         destination coordinate (rowDest, colDest) = (4, 4)
 * 
 *         Output: true Explanation: One possible way is : left -> down -> left
 *         -> down -> right -> down -> right.
 * 
 *         Example 2
 * 
 *         Input 1: a maze represented by a 2D array
 * 
 *         0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 1 1 0 0 0 0 0
 * 
 *         Input 2: start coordinate (rowStart, colStart) = (0, 4) Input 3:
 *         destination coordinate (rowDest, colDest) = (3, 2)
 * 
 *         Output: false Explanation: There is no way for the ball to stop at
 *         the destination.
 * 
 *         Note: There is only one ball and one destination in the maze. Both
 *         the ball and the destination exist on an empty space, and they will
 *         not be at the same position initially. The given maze does not
 *         contain border (like the red rectangle in the example pictures), but
 *         you could assume the border of the maze are all walls. The maze
 *         contains at least 2 empty spaces, and both the width and height of
 *         the maze won't exceed 100.
 * 
 */
public class TheMaze {

	public boolean hasPath(int[][] a, int[] start, int[] destination) {
		int moves[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		class Point {
			int x;
			int y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		boolean visited[][] = new boolean[a.length][a[0].length];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(start[0], start[1]));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			visited[cur.x][cur.y] = true;
			if (cur.x == destination[0] && cur.y == destination[1]) {
				return true;
			}
			for (int move[] : moves) {
				int _x = cur.x + move[0];
				int _y = cur.y + move[1];
				while (isSafe(a, _x, _y) && a[_x][_y] == 0) {
					_x += move[0];
					_y += move[1];
				}
				_x -= move[0];
				_y -= move[1];

				if (!visited[_x][_y]) {
					q.offer(new Point(_x, _y));
				}
			}
		}
		return false;
	}

	private boolean isSafe(int[][] a, int x, int y) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
	}

	public static void main(String[] args) {
		TheMaze obj = new TheMaze();
		int[][] a = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } };
		boolean result = false;
		int[] start = { 0, 4 };
		int[] destination = { 4, 4 };
		result = obj.hasPath(a, start, destination);
		System.out.println(result);
		int[] destination2 = { 3, 2 };
		result = obj.hasPath(a, start, destination2);
		System.out.println(result);
		
	}

}
