/**
 * 
 */
package com.raj.leetcode.google;

import java.util.PriorityQueue;

/**
 * @author Raj
 *
 *There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)

Output: "lul"
Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

Example 2

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)
Output: "impossible"
Explanation: The ball cannot reach the hole.

Note:
There is only one ball and one hole in the maze.
Both the ball and hole exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30. 
 * 
 */
public class TheMaze3 {

	class Point {
		int x, y, l;
		String path;

		public Point(int _x, int _y, int _l, String path) {
			x = _x;
			y = _y;
			l = _l;
			this.path = path;
		}
	}

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		int m = maze.length, n = maze[0].length;
		int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		String[] dir_letters = { "u", "r", "d", "l" };
		PriorityQueue<Point> list = new PriorityQueue<>((o1, o2) -> {
			if (o1.l == o2.l) {
				return o1.path.toString().compareTo(o2.path.toString());
			}
			return o1.l - o2.l;
		});
		list.offer(new Point(ball[0], ball[1], 0, ""));
		boolean visited[][] = new boolean[maze.length][maze[0].length];
		int minDistance = Integer.MAX_VALUE;
		String res = "impossible";
		while (!list.isEmpty()) {
			Point p = list.poll();
			visited[p.x][p.y] = true;
			for (int i = 0; i < 4; i++) {
				int xx = p.x, yy = p.y, l = p.l;
				String path = p.path + dir_letters[i];
				while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
					xx += dir[i][0];
					yy += dir[i][1];
					l++;
					if (xx == hole[0] && yy == hole[1]) {
						if (l <= minDistance) {
							if (minDistance == Integer.MAX_VALUE) {
								res = path;
							} else {
								res = res.compareTo(path) < 0 ? res : path;
							}
							minDistance = l;
						}
					}
				}
				xx -= dir[i][0];
				yy -= dir[i][1];
				l--;
				if (!visited[xx][yy]) {
					list.offer(new Point(xx, yy, l, path));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TheMaze3 obj = new TheMaze3();
		int[][] a = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		String result = "empty";
		int[] start = { 4, 3 };
		int[] hole = { 0, 1 };
		result = obj.findShortestWay(a, start, hole);
		System.out.println(result);
		int[] hole2 = { 3, 0 };
		result = obj.findShortestWay(a, start, hole2);
		System.out.println(result);

	}

}
