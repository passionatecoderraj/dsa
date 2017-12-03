package com.raj.dp;

import java.util.Arrays;

public class UniquePaths {

    // Space : O(m*n)
    public int uniquePaths(int m, int n) {
        int t[] = new int[n];
        Arrays.fill(t, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                t[j] += t[j - 1];
            }
        }
        return t[n - 1];
    }

    // Space : O(m*n)
    public int uniquePaths2(int m, int n) {

        int t[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            t[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            t[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                t[i][j] = t[i - 1][j] + t[i][j - 1];
            }
        }

        return t[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        int result = -1, m = 4, n = 4;

        result = obj.uniquePaths(m, n);
        System.out.println(result);
    }

    public int numberofPathsToReachBottomRightFromTopLeftBruteForce(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return numberofPathsToReachBottomRightFromTopLeftBruteForce(m - 1, n)
                + numberofPathsToReachBottomRightFromTopLeftBruteForce(m, n - 1);
    }

}
