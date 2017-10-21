/**
*
*/
package com.raj.matrix;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 * 
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].
 */

public class ImageSmoother {

    // Time : O(n), Space : O(1)
    // https://discuss.leetcode.com/topic/101769/c-o-1-space-using-game-of-life-idea
    /*
     * the board has ints in [0, 255], hence only 8-bit is used, we can use the middle 8-bit to store the new state
     * (average value), replace the old state with the new state by shifting all values 8 bits to the right.
     */
    public int[][] imageSmoother(int[][] a) {
        int moves[][] = {{1, 1 }, {-1, 1 }, {1, -1 }, {-1, -1 }, {1, 0 }, {-1, 0 }, {0, 1 }, {0, -1 } };

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int sum = a[i][j];
                int count = 1;

                for (int[] move : moves) {
                    int x = move[0] + i;
                    int y = move[1] + j;

                    if (isSafe(a, x, y)) {
                        count++;
                        sum += (a[x][y] & 255);
                    }

                }
                int val = (sum / count);
                val <<= 8;
                a[i][j] |= val;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] >>= 8;
            }
        }

        return a;
    }

    // Time : O(n), Space : O(n)
    public int[][] imageSmoother2(int[][] a) {
        int t[][] = new int[a.length][a[0].length];
        int moves[][] = {{1, 1 }, {-1, 1 }, {1, -1 }, {-1, -1 }, {1, 0 }, {-1, 0 }, {0, 1 }, {0, -1 } };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int sum = a[i][j];
                int count = 1;
                for (int[] move : moves) {
                    int x = move[0] + i;
                    int y = move[1] + j;
                    if (isSafe(a, x, y)) {
                        count++;
                        sum += a[x][y];
                    }
                }
                t[i][j] = (sum / count);
            }
        }
        return t;
    }

    public boolean isSafe(int[][] a, int x, int y) {
        return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
    }

    public static void main(String[] args) {
        /* @formatter:off*/
        int a[][] = {{1, 1, 1 },
                    {1, 0, 1 },
                    {1, 1, 1 } };
        /* @formatter:on*/

        int[][] result = null;
        ImageSmoother obj = new ImageSmoother();
        result = obj.imageSmoother(a);
        CommonUtil.print2DArray(result, result.length, result[0].length);

    }

}
