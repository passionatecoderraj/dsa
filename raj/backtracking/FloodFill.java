package com.raj.backtracking;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 *An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

 */
public class FloodFill {

    int moves[][] = {{0, 1 }, {1, 0 }, {0, -1 }, {-1, 0 } };

    public int[][] floodFill(int[][] a, int sr, int sc, int newColor) {
        if (a[sr][sc] == newColor) {
            return a;
        }
        util(a, sr, sc, a[sr][sc], newColor);
        return a;
    }

    void util(int[][] a, int sr, int sc, int prev, int newColor) {
        if (a[sr][sc] != prev) {
            return;
        }
        a[sr][sc] = newColor;

        for (int[] move : moves) {
            int x = move[0] + sr;
            int y = move[1] + sc;
            if (isSafe(a, x, y)) {
                util(a, x, y, prev, newColor);
            }
        }

    }

    boolean isSafe(int a[][], int i, int j) {
        return i < a.length && j < a[0].length && i >= 0 && j >= 0;
    }

    public void floodFill(int[][] screen, int m, int n, int x, int y, int newColor) {
        int oldColor = screen[x][y];
        floodFill(screen, m, n, x, y, oldColor, newColor);
    }

    public void floodFill(int[][] screen, int m, int n, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (screen[x][y] != oldColor) {
            return;
        }
        screen[x][y] = newColor;
        floodFill(screen, m, n, x + 1, y, oldColor, newColor);
        floodFill(screen, m, n, x - 1, y, oldColor, newColor);
        floodFill(screen, m, n, x, y + 1, oldColor, newColor);
        floodFill(screen, m, n, x, y - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        FloodFill obj = new FloodFill();

        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1 }, {1, 1, 1, 1, 1, 1, 0, 0 }, {1, 0, 0, 1, 1, 0, 1, 1 },
                {1, 2, 2, 2, 2, 0, 1, 0 }, {1, 1, 1, 2, 2, 0, 1, 0 }, {1, 1, 1, 2, 2, 2, 2, 0 },
                {1, 1, 1, 1, 1, 2, 1, 1 }, {1, 1, 1, 1, 1, 2, 2, 1 }, };
        int x = 4, y = 4, newColor = 3;

        obj.floodFill(screen, x, y, newColor);
        CommonUtil.print2DArray(screen, screen.length, screen[0].length);
    }

}
