package com.raj.leetcode;

import com.interview.graph.CommonUtil;
/**
 * 
 * @author Raj
 *
 *According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife {

    public void gameOfLife(int[][] a) {
        int moves[][] = {{1, 1 }, {-1, 1 }, {1, -1 }, {-1, -1 }, {1, 0 }, {-1, 0 }, {0, 1 }, {0, -1 } };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int isAlive = a[i][j] & 1;
                int count = 0;
                for (int[] move : moves) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if (isSafe(a, x, y)) {
                        count += (a[x][y] & 1);
                    }
                }
                int val = 0;
                if (isAlive == 1 && (count == 2 || count == 3)) {
                    val = 0;
                } else if (isAlive != 1 && count == 3) {
                    val = 1;
                }
                a[i][j] |= (val << 1);
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] >>= 1;
            }
        }

    }

    public boolean isSafe(int[][] a, int x, int y) {
        return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
    }

    public static void main(String args[]) {
        int a[][] = {{1, 0, 1, 0, 1 }, {0, 1, 0, 0, 1 }, {0, 1, 0, 0, 1 }, {0, 1, 0, 1, 1 } };
        GameOfLife obj = new GameOfLife();
        obj.gameOfLife(a);
        CommonUtil.print2DArray(a, a.length, a[0].length);
    }
}
