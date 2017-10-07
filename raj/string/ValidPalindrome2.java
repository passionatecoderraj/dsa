/**
 *
 */
package com.raj.string;

/**
 * @author Raj
 * 
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */

public class ValidPalindrome2 {

    // Time : O(n), Space : O(1)
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome2 obj = new ValidPalindrome2();

        String str = "abcdba";
        boolean result = false;

        // Time : O(n) Space :O(1)
        result = obj.validPalindrome(str);
        System.out.println(result);

        str = "aba";
        result = obj.validPalindrome(str);
        System.out.println(result);

    }

}
