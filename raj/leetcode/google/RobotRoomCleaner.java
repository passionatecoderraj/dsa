package com.raj.leetcode.google;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Raj
 * 
 * Given a robot cleaner in a room modeled as a grid.

Each cell in the grid can be empty or blocked.

The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

Design an algorithm to clean the entire room using only the 4 given APIs shown below.

interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}
Example:

Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Notes:

The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
The robot's initial position will always be in an accessible cell.
The initial direction of the robot will be facing up.
All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
Assume all four edges of the grid are all surrounded by wall.

 */

public class RobotRoomCleaner {

	int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	
	/*
	 * They dont' give grid. This is similar to dfs walking problem. 
	 * Here, we don't need to check safe or valid cell check. Because, it's done by robot
	 */
	//https://leetcode.com/problems/robot-room-cleaner/discuss/139057/Very-easy-to-understand-Java-solution
	public void cleanRoom(Robot robot) {
		int[] pos = { 0, 0 };
		Set<String> visited = new HashSet<String>();
		int cur_dir = 0; // 0: Right, 90: Down, 180: Left, 270: Up
		util(robot, pos, visited, cur_dir);
	}

	private void util(Robot robot, int[] pos, Set<String> visited, int cur_dir) {
		String cell = pos[0] + "->" + pos[1];
		if (!visited.contains(cell)) {
			visited.add(cell);
			robot.clean();
			for (int i = 0; i < dirs.length; i++) {
				int new_dir = (i + cur_dir) % dirs.length;
				if (robot.move()) {
					int newPos[] = { pos[0] + dirs[new_dir][0], pos[1] + dirs[new_dir][1] };
					util(robot, newPos, visited, new_dir);
					robot.turnLeft();
					robot.turnLeft();
					robot.move();
					robot.turnRight();
					robot.turnRight();
				}
				robot.turnRight();
			}
		}
	}

	public static void main(String[] args) {
		RobotRoomCleaner obj = new RobotRoomCleaner();
		obj.cleanRoom(new RobotImpl());
	}

}

class RobotImpl implements Robot {

	@Override
	public boolean move() {
		return false;
	}

	@Override
	public void turnLeft() {

	}

	@Override
	public void turnRight() {

	}

	@Override
	public void clean() {

	}

}

interface Robot {
	// returns true if next cell is open and robot moves into the cell.
	// returns false if next cell is obstacle and robot stays on the current cell.
	boolean move();

	// Robot will stay on the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	void turnLeft();

	void turnRight();

	// Clean the current cell.
	void clean();
}
