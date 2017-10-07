package com.raj.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (x > dp[m]) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            dp[i] = x;
            if (i == size) {
                ++size;
            }
        }
        return size;
    }

    // https://leetcode.com/articles/longest-increasing-subsequence/
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // if element not present it returns -(intended position+1)
            // ex: {2,5} search for 7 it returns - 2
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int lisDpOnlogn(int[] a) {
        int n = a.length;
        int[] c = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        c[0] = 0;
        int len = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] > a[c[len]]) {
                len++;
                c[len] = i;
                result[i] = c[len - 1];
            } else if (a[i] <= a[c[0]]) {
                c[0] = i;
            } else {
                int index = binarySearchForIndex(a, c, -1, len, a[i]);
                c[index] = i;
                result[i] = c[index - 1];
            }

        }
        printIncreasingPath(a, result, c[len]);
        System.out.println();
        return len + 1;
    }

    public void printIncreasingPath(int[] a, int[] result, int i) {
        if (i >= 0) {
            printIncreasingPath(a, result, result[i]);
            System.out.print(a[i] + "->");
        }
    }

    private int binarySearchForIndex(int[] a, int[] c, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (a[c[m]] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    public int lisDpOn2(int[] a) {
        int n = a.length;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    int t = c[j] + 1;
                    if (t > c[i]) {
                        c[i] = t;
                    }
                    if (t > max) {
                        max = t;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int result = -1;
        // int a[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        // int a[] = { 1, 101, 2, 3, 100, 4, 5 };
        int a[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        result = obj.lisDpOn2(a);
        System.out.println(result);
        result = obj.lisDpOnlogn(a);
        System.out.println(result);

        result = obj.lengthOfLIS(a);
        System.out.println(result);
    }

}
