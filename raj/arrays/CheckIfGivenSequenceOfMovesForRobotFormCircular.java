/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class CheckIfGivenSequenceOfMovesForRobotFormCircular {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIfGivenSequenceOfMovesForRobotFormCircular obj = new CheckIfGivenSequenceOfMovesForRobotFormCircular();
		boolean result = false;
		result = obj.checkIfGivenSequenceOfMovesForRobotFormCircular(0, 0, obj.NORTH, "GLGLGLG");
		System.out.println(result);
	}

	int NORTH = 0;
	int EAST = 1;
	int SOUTH = 2;
	int WEST = 3;

	public boolean checkIfGivenSequenceOfMovesForRobotFormCircular(int x, int y, int direction, String moves) {
		char move = ' ';
		int curX = x, curY = y;
		for (int i = 0; i < moves.length(); i++) {
			move = moves.charAt(i);
			if (move == 'L') {
				direction = (direction + 1) % 4;
			} else if (move == 'R') {
				direction = (4 + direction - 1) % 4;
			} else {
				if (direction == NORTH) {
					curY++;
				} else if (direction == EAST) {
					curX++;
				} else if (direction == WEST) {
					curX--;
				} else if (direction == SOUTH) {
					curY--;
				}
			}
		}
		return curX == x && curY == y;
	}
}
