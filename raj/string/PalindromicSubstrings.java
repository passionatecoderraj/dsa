/**
 *
 */
package com.raj.string;

/**
 * @author Raj
 * 
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int count[] = new int[1];

        for (int i = 0; i < s.length(); i++) {// i is the mid point
            palindromCount(s, i, i, count); // odd length;
            palindromCount(s, i, i + 1, count); // even length
        }
        return count[0];
    }

    private void palindromCount(String s, int l, int r, int count[]) {
        while (l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) {
            count[0]++;
        }

    }

    public static void main(String[] args) {
        PalindromicSubstrings obj = new PalindromicSubstrings();
        int result = -1;
        String str = "abc";
        result = obj.countSubstrings(str);
        System.out.println(result);

        str = "aaa";
        result = obj.countSubstrings(str);
        System.out.println(result);
    }

}
