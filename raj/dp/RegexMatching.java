package com.raj.dp;
/**
 * 
 * @author Raj
 *
 *Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
public class RegexMatching {

    /*
     * consider 'text' is on rows, 'pattern' is on columns
     *  1) t = x, p=xa*, res = true, value gets from left;( ignoring a and star) (x,x)
     *  2) t = xa, p=xa*, res = true, value doesn't get from left(xa,x); value gets from top (x,xa*)
     *  3) t = xaa, p=xa*, res = true, value doesn't get from left(xaa,x); value gets from top (xa,xa*)
     */
    
    // Time : O(m*n), Space : O(m*n)
    public boolean isRegexMatch(String text, String pattern) {
        boolean[][] t = new boolean[text.length() + 1][pattern.length() + 1];
        t[0][0] = true;
        // (empty_text,a*),(empty_text,a*b*) => set to true
        for (int j = 1; j < t[0].length; j++) {
            if (pattern.charAt(j - 1) == '*') {
                t[0][j] = t[0][j - 2];
            }
        }

        for (int i = 1; i <t.length; i++) {
            for (int j = 1; j <t[0].length; j++) {

                if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    // scenario : t = x, p=xa*, res = true, value gets from left;( ignoring a and star) (x,x)
                    t[i][j] = t[i][j - 2];
            
                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
                        // scenario : t = xa, p=xa*, res = true, value doesn't get from left(xa,x); value gets from top (x,xa*)
                        // scenario : t = xaa, p=xa*, res = true, value doesn't get from left(xaa,x); value gets from top (xa,xa*)
                        t[i][j] = t[i][j] || t[i - 1][j];
                    } 
                }
            }
        }
        return t[t.length - 1][t[0].length - 1];
    }
    
    public static void main(String[] args) {
         String pattern = "xa*b.c";
        String text = "xaabyc";
       
        RegexMatching obj = new RegexMatching();
        boolean result = false;

        result = obj.isRegexMatch(text, pattern);
        System.out.println(result);

    }

 

}
