package com.raj.dp;

import com.interview.graph.CommonUtil;

public class MinimumPathSum {

    // if matrix cannot be modified , Space : O(m)
    public int minPathSum(int a[][]) {
        int t[] = new int[a[0].length];
        t[0] = a[0][0];
        for (int j = 1; j < a[0].length; j++) {
            t[j] = t[j - 1] + a[0][j];
        }
        for (int i = 1; i < a.length; i++) {
            t[0] += a[i][0];
            for (int j = 1; j < a.length; j++) {
                t[j] = Math.min(t[j], t[j - 1]) + a[i][j];
            }
        }
        return t[a[0].length - 1];
    }

    // if matrix cannot be modified , Space : O(m*n)
    public int minPathSum2(int a[][]) {
        int t[][] = new int[a.length][a[0].length];
        t[0][0] = a[0][0];

        for (int j = 1; j < a[0].length; j++) {
            t[0][j] = a[0][j] + t[0][j - 1];
        }

        for (int i = 1; i < a.length; i++) {
            t[i][0] = a[i][0] + t[i - 1][0];
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                t[i][j] = a[i][j] + Math.min(t[i][j - 1], t[i - 1][j]);
            }
        }
        return t[a.length - 1][a[0].length - 1];
    }

    // if matrix can be modified
    public int minPathSum3(int a[][]) {
        for (int j = 1; j < a[0].length; j++) {
            a[0][j] = a[0][j] + a[0][j - 1];
        }

        for (int i = 1; i < a.length; i++) {
            a[i][0] = a[i][0] + a[i - 1][0];
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                a[i][j] = a[i][j] + Math.min(a[i][j - 1], a[i - 1][j]);
            }
        }
        return a[a.length - 1][a[0].length - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum obj = new MinimumPathSum();

        int a[][] = {{1, 2, 3 }, {4, 8, 2 }, {1, 5, 3 } };
        int result = -1;
        result = obj.minPathSum(a);
        CommonUtil.print2DArray(a, a.length, a[0].length);
        System.out.println(result);
    }

}
