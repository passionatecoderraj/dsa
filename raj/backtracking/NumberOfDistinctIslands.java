/**
 *
 */
package com.raj.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Raj
 * @formatter:off
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
@formatter:on
 */
public class NumberOfDistinctIslands {

    public int numDistinctIslands(int[][] a) {
        Set<List<List<Integer>>> set = new HashSet<>();
        boolean visited[][] = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                List<List<Integer>> island = new ArrayList<>();
                dfs(a, i, j, i, j, island, visited);
                set.add(island);
            }
        }
        return set.size();
    }

    private void dfs(int[][] a, int originI, int originJ, int i, int j, List<List<Integer>> island,
            boolean visited[][]) {
        visited[i][j] = true;
        island.add(Arrays.asList(i - originI, j - originJ));
        int moves[][] = {{1, 0 }, {-1, 0 }, {0, 1 }, {0, -1 } };
        for (int[] move : moves) {
            int x = move[0] + i;
            int y = move[1] + j;
            if (isSafe(a, x, y) && a[x][y] == 1 && !visited[x][y]) {
                dfs(a, originI, originJ, x, y, island, visited);
            }
        }
    }

    public boolean isSafe(int[][] a, int x, int y) {
        return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
    }

    public static void main(String[] args) {
        NumberOfDistinctIslands obj = new NumberOfDistinctIslands();
        int result = -1;
        /*@formatter:off*/
		int a[][] = {
		        { 1, 1, 0, 0, 0 },
		        { 1, 1, 0, 0, 0 },
		        { 0, 0, 0, 1, 1 },
		        { 0, 0, 0, 1, 1 } };

        int b[][] = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 1 } };
		/*@formatter:on*/

        // Time :O(rows*cols), Space : O(rows*cols)
        result = obj.numDistinctIslands(a);
        System.out.println(result);
        result = obj.numDistinctIslands(b);
        System.out.println(result);

    }

}
