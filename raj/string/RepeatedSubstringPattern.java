/**
 *
 */
package com.raj.string;

/**
 * @author Raj
 * 
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s.isEmpty()) {
            return true;
        }

        for (int i = 2; i <= s.length(); i++) {
            if (s.length() % i == 0) {
                String st = s.substring(0, s.length() / i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    sb.append(st);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern obj = new RepeatedSubstringPattern();

        String str = "";
        boolean result = false;

        str = "bb";
        result = obj.repeatedSubstringPattern(str);
        System.out.println(result);

        str = "abab";
        result = obj.repeatedSubstringPattern(str);
        System.out.println(result);

        str = "aba";
        result = obj.repeatedSubstringPattern(str);
        System.out.println(result);

        str = "abcabcabcabc";
        result = obj.repeatedSubstringPattern(str);
        System.out.println(result);

    }

}
