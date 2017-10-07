/**
 *
 */
package com.raj.mathamatical;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.graph.CommonUtil;

/**
 * @author Raj 
 * 
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j });
                }
            }
        }

        int moves[][] = {{1, 0 }, {-1, 0 }, {0, 1 }, {0, -1 } };

        while (!q.isEmpty()) {
            int[] gate = q.poll();
            for (int[] move : moves) {
                int x = gate[0] + move[0];
                int y = gate[1] + move[1];
                if (isSafe(rooms, x, y)) {
                    rooms[x][y] = rooms[gate[0]][gate[1]] + 1;
                    q.add(new int[]{x, y });
                }
            }
        }
    }

    public boolean isSafe(int[][] a, int x, int y) {
        return x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] == Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int rooms[][] = {{INF, -1, 0, INF }, {INF, INF, INF, -1 }, {INF, -1, INF, -1 }, {0, -1, INF, INF } };
        WallsAndGates obj = new WallsAndGates();
        obj.wallsAndGates(rooms);
        CommonUtil.print2DArray(rooms, rooms.length, rooms[0].length);
    }
}
