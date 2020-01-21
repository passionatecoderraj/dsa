/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 *
 *On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: "GGLLGG"
Output: true
Explanation: 
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: "GG"
Output: false
Explanation: 
The robot moves north indefinitely.
Example 3:

Input: "GL"
Output: true
Explanation: 
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Note:

1 <= instructions.length <= 100
instructions[i] is in {'G', 'L', 'R'}
 */
public class RobotBoundedInCircle {

	/*
	 * If robot return origin, it will be in the circle.
	   If robot ends with other direction (as shown in the diagram), it will be in the circle.
	   Otherwise, not back to the origin, and still faces north, it will be further and further after instructions and won't be in a circle.
	 */
	// https://leetcode.com/problems/robot-bounded-in-circle/discuss/290856/JavaC++Python-Let-Chopper-Help-Explain
	// Time : O(n), Space : O(1)
	public boolean isRobotBounded(String instructions) {
		/*
		 * These directions are created in order N, E , S ,W in circle
		 * 
		 * From cur direction, moving right is (cur_direction+1) % 4. moving left = moving right 3 times =  (cur_direction+3) % 4.
		 */
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int x = 0, y = 0, cur_direction = 0;
		for (char instruction : instructions.toCharArray()) {
			if (instruction == 'G') {
				x += directions[cur_direction][0];
				y += directions[cur_direction][1];
			} else if (instruction == 'R') {
				cur_direction = (cur_direction + 1) % 4;
			} else if (instruction == 'L') {
				cur_direction = (cur_direction + 3) % 4;
			}

		}
		return (x == 0 && y == 0) || cur_direction > 0;
	}

	public static void main(String[] args) {
		RobotBoundedInCircle obj = new RobotBoundedInCircle();
		boolean result = false;
		result = obj.isRobotBounded("GGLLGG");
		System.out.println(result);

		result = obj.isRobotBounded("GG");
		System.out.println(result);

		result = obj.isRobotBounded("GL");
		System.out.println(result);

	}
}
