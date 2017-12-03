package com.raj.dp;

/**
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty
 * space is marked as 1 and 0 respectively in the grid. For example, There is one obstacle in the middle of a 3x3 grid
 * as illustrated below. [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * @author Raj
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int a[][]) {
        int t[] = new int[a[0].length];
        
        if(a[0][0]==1 || a[a.length-1][a[0].length-1]==1)
            return 0;
        
        t[0]=1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1)
                    t[j]=0;
                else if(j>0)
                    t[j]+=t[j-1];
            }
        }

        return t[a[0].length-1];
    }

    // Space :O(m*n)
    public static int uniquePathsWithObstacles2(int a[][]) {
        int m = a.length, n = a[0].length;
        int t[][] = new int[m][n];

        if (t[0][0] == 1)
            return 0;
        for (int i = 0; i < m; i++) {
            if (a[i][0] == 1)
                break;
            t[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (a[0][i] == 1)
                break;
            t[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] != 1) {
                    t[i][j] = t[i - 1][j] + t[i][j - 1];
                }
            }
        }

        return t[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths2 obj = new UniquePaths2();
        int result = -1;
        int a[][] = {{0, 0, 0 }, {0, 1, 0 }, {0, 0, 0 } };
        result = obj.uniquePathsWithObstacles(a);
        System.out.println(result);
    }
}
