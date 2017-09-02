/**
 * 
 */
package com.interview.design;

/**
 * @author Raj
 *
 */

// http://stackoverflow.com/questions/6572194/review-my-design-tic-tac-toe-game-using-oo-methodology
enum Player {
	X('X'), O('O');
	char id;

	private Player(char id) {
		this.id = id;
	}

	public char getId() {
		return id;
	}

}

class Point {
	int x;
	int y;
	Player player;

}

class Board {
	Point board[][];

	Board(int n) {
		board = new Point[n][n];
	}

	void display() {

	}

	void placeMove(Player p, int x, int y) {

	}

	Point[] getAvailableMoves() {
		return null;
	}
}

interface GameRule {
	boolean isGameWon(Board board);

	boolean isGameLost(Board board);

	boolean isGameTie(Board board);
}

interface GamePlay {

	Player takeTurn();

	void markNextBox();
}

public class TicTacToe {

	public void play() {

	}
}
