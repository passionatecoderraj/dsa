/**
 *
 */
package com.raj.dp;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 */
public class LongestPalindromeSubString {

    public String longest(String s) {
        boolean[][] t = new boolean[s.length()][s.length()];
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            t[i][i] = true;
        }

        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l - 1;
                if (l == 2) {
                    t[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    t[i][j] = s.charAt(i) == s.charAt(j) && t[i + 1][j - 1];
                }
                if (t[i][j] && l > longest.length()) {
                    longest = s.substring(i, j + 1);
                }
            }
        }

        return longest;

    }

    public int longestPalindormeDpOn2(char[] str, int s, int n) {
        int t[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            t[i][i] = 1;
        }
        int max = Integer.MIN_VALUE;
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (str[i] == str[j]) {
                    if (l == 2) {
                        t[i][j] = 2;
                    } else {
                        t[i][j] = 2 + t[i + 1][j - 1];
                    }
                } else {
                    t[i][j] = 0;
                }
                max = Math.max(max, t[i][j]);
            }
        }

        CommonUtil.print2DArray(t, n, n);
        return max;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";

        int result = -1, n = str.length();

        LongestPalindromeSubString obj = new LongestPalindromeSubString();
        result = obj.longestPalindormeDpOn2(str.toCharArray(), 0, n);
        System.out.println(result);
        System.out.println(obj.longest(str));
    }

}
