/**
 *
 */
package com.raj.design;

import static java.lang.Math.abs;

/**
 * @author Raj
 * 
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
 */

public class TicTacToe {
    int rows[];
    int cols[];
    int diagnols;
    int antiDiagnols;
    
    // Space : O(n)
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    // Time : O(1)
    public int move(int row, int col, int player) {
        int toAdd=(player==1)?1:-1;
        rows[row]+=toAdd;
        cols[col]+=toAdd;
        if(row==col){
            diagnols+=toAdd;
        }
        
        if(row+col+1==cols.length){
            antiDiagnols+=toAdd;
        }
        
        int size = rows.length;
        if(abs(rows[row]) == size || abs(cols[col]) == size || abs(diagnols) == size || abs(antiDiagnols) == size){
            return player;
        }
        
        return 0;
    }

    public static void main(String... args) {
        TicTacToe obj = new TicTacToe(3);
        int res = -1;
        res = obj.move(0, 0, 1);
        System.out.println(res);

        res = obj.move(0, 2, 2);
        System.out.println(res);

        res = obj.move(2, 2, 1);
        System.out.println(res);
        
        res = obj.move(1, 1, 2);
        System.out.println(res);
        
        res = obj.move(2, 0, 1);
        System.out.println(res);
        
        res = obj.move(1, 0, 2);
        System.out.println(res);
        
        res = obj.move(2, 1, 1);
        System.out.println(res);

    }

}

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
