package com.interview.design.othello;

import static com.interview.design.othello.OthelloGame.Color.BLACK;
import static com.interview.design.othello.OthelloGame.Color.WHITE;

/**
 *
 */

public class OthelloGame {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static OthelloGame singleton_instance = null;
    private Board board;
    private Player[] players;

    private OthelloGame() {
        board = new Board(ROWS, COLS);
        players[0] = new Player(WHITE);
        players[1] = new Player(BLACK);
    }

    public static OthelloGame getInstance() {
        if (null == singleton_instance) {
            singleton_instance = new OthelloGame();
        }
        return singleton_instance;
    }

    public Board getBoard() {
        return board;
    }

    public class Board {
        Piece[][] board;
        int moves[][] = {{0, -2 }, {-2, 0 }, {0, 2 }, {2, 0 }, {2, 2 }, {2, -2 }, {-2, 2 }, {-2, -2 } };

        public Board(int r, int c) {
            board = new Piece[r][c];
        }

        public void place(int r, int c, Color color) {
            for (int[] move : moves) {
                int x = r + move[0];
                int y = c + move[1];
                if (isSafe(x, y)) {
                    // some logic to check whether between color is other and flip it

                }
            }
        }

        private boolean isSafe(int r, int c) {
            return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
        }

        public int getScore(Color color) {
            return (color == WHITE) ? OthelloGame.getInstance().players[0].getScore()
                    : OthelloGame.getInstance().players[1].getScore();
        }

        public void updateScore(Color color) {
            if (color == WHITE) {
                OthelloGame.getInstance().players[0].score++;
                OthelloGame.getInstance().players[1].score--;
            } else {
                OthelloGame.getInstance().players[0].score--;
                OthelloGame.getInstance().players[1].score++;
            }
        }
    }

    public enum Color {
        WHITE, BLACK;
    }

    public class Piece {
        private Color color;

        public Piece(Color color) {
            this.color = color;
        }

        public void flip() {
            this.color = (this.color == WHITE) ? BLACK : WHITE;
        }
    }

    public class Player {
        private Color color;
        private int score;

        public Player(Color color) {
            this.color = color;
            this.score = 0;
        }

        public int getScore() {
            return score;
        }

        public Color getColor() {
            return color;
        }

        public void playPiece(int r, int c) {
            OthelloGame.getInstance().getBoard().place(r, c, color);
        }

    }

}