/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 *         Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or
 *         empty '0' (the number zero), return the maximum enemies you can kill
 *         using one bomb. The bomb kills all the enemies in the same row and
 *         column from the planted point until it hits the wall since the wall
 *         is too strong to be destroyed. Note that you can only put the bomb at
 *         an empty cell. Example: For the given grid
 * 
 *         0 E 0 0 E 0 W E 0 E 0 0
 * 
 *         return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 */
public class BombEnemy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BombEnemy obj = new BombEnemy();
		char[][] matrix = { { '0', 'E', '0', '0' }, { 'E', '0', 'W', 'E' }, { '0', 'E', '0', '0' } };

		int result = obj.maxEnemies(matrix);
		System.out.println(result);

	}

	public int maxEnemies(char[][] a) {
		int m = a.length;
		int n = a[0].length;
		int maxEnemiess = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == '0') {
					int enemiesKilled = countEnemies(a, i, j);
					// System.out.println(enemiesKilled);
					maxEnemiess = Math.max(maxEnemiess, enemiesKilled);
				}
			}
		}
		return maxEnemiess;
	}

	private int countEnemies(char[][] a, int x, int y) {
		int enemies = 0;
		int i = x + 1;
		while (i < a.length && a[i][y] == 'E') {
			enemies++;
			i++;
		}

		i = x - 1;
		while (i >= 0 && a[i][y] == 'E') {
			enemies++;
			i--;
		}

		int j = y + 1;
		while (j < a[0].length && a[x][j] == 'E') {
			enemies++;
			j++;
		}

		j = y - 1;
		while (j >= 0 && a[x][j] == 'E') {
			enemies++;
			j--;
		}
		return enemies;
	}
}
