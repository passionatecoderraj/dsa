package com.raj.backtracking;

import com.interview.graph.CommonUtil;

/*
 * @Author Raj
 * 
 * 
 */

public class FloodFill {

	public static void main(String[] args) {
		FloodFill obj = new FloodFill();

		int screen[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 },
				{ 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 }, };
		int x = 4, y = 4, newColor = 3;
		obj.floodFill(screen, screen.length, screen[0].length, x, y, newColor);
		CommonUtil.print2DArray(screen, screen.length, screen[0].length);
	}

	public void floodFill(int[][] screen, int m, int n, int x, int y, int newColor) {
		int oldColor = screen[x][y];
		floodFill(screen, m, n, x, y, oldColor, newColor);
	}

	public void floodFill(int[][] screen, int m, int n, int x, int y, int oldColor, int newColor) {
		if (x < 0 || x >= m || y < 0 || y >= n)
			return;
		if (screen[x][y] != oldColor)
			return;
		screen[x][y] = newColor;
		floodFill(screen, m, n, x + 1, y, oldColor, newColor);
		floodFill(screen, m, n, x - 1, y, oldColor, newColor);
		floodFill(screen, m, n, x, y + 1, oldColor, newColor);
		floodFill(screen, m, n, x, y - 1, oldColor, newColor);
	}

}
