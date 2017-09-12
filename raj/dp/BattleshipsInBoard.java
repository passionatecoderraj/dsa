package com.raj.dp;
/**
 * 
 * @author Raj
 *
 *Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
 */
public class BattleshipsInBoard {
    public int countBattleships(char[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i > 0 && a[i - 1][j] != '.') {
                    continue;
                }
                if (j > 0 && a[i][j - 1] != '.') {
                    continue;
                }
                if (a[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String... args) {
        BattleshipsInBoard obj = new BattleshipsInBoard();
        int count = -1;
        char a[][] = {{'X', '.', '.', 'X' }, {'.', '.', '.', 'X' }, {'.', '.', '.', 'X' } };
        count = obj.countBattleships(a);
        System.out.println(count);
    }
}