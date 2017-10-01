package com.raj.dp;

/**
 * 
 * @author Raj
 *
 *
 *Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {

    /*
     * consider 'text' is on rows, 'pattern' is on columns
     *  1) t = a, p=a*, res = true, value gets from left;( ignoring star) (a,a)
     *  2) t = ab, p=a*, res = true, value doesn't get from left(ab,a); value gets from top (ab,a*)
     *  3) t = abb, p=a*, res = true, value doesn't get from left(abb,a); value gets from top (abb,a*)
     */
    
    // Time : O(m*n), Space : O(m*n)
    public boolean isWildcardMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        char pat[] = pattern.toCharArray();
        char txt[] = text.toCharArray();

        // replace a**b with a*b
        int left = 1;
        for (int i = 1; i < pat.length; i++) {
            if (pat[i] == '*' && pat[i] == pat[i - 1]) {
                // ignore extra star
            } else {
                pat[left++] = pat[i];
            }
        }

        boolean[][] t = new boolean[txt.length + 1][left + 1];
        t[0][0] = true;

        if (pat[0] == '*' && t[0].length > 1) {
            t[0][1] = true;
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (pat[j - 1] == '?' || pat[j - 1] == txt[i - 1]) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (pat[j - 1] == '*') {
                    t[i][j] = t[i][j - 1] || t[i - 1][j];
                }
            }
        }
        return t[t.length - 1][t[0].length - 1];
    }

    public static void main(String[] args) {
        String pattern = "**x*y**z";
        String text = "xaylmz";

        WildcardMatching obj = new WildcardMatching();
        boolean result = false;

        result = obj.isWildcardMatch(text, pattern);
        System.out.println(result);

    }

}
