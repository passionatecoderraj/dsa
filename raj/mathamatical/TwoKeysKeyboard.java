/**
 *
 */
package com.raj.mathamatical;

/**
 * @author Raj
 * 
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.

https://discuss.leetcode.com/topic/97752/very-simple-java-solution-with-detail-explanation
 */
public class TwoKeysKeyboard {

    public int minStepsDp(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                count += i;
                n /= i;
            }
        }
        return count;
    }

    
    public int minSteps(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                count += i;
                n /= i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoKeysKeyboard obj = new TwoKeysKeyboard();
        int res = -1;
        res = obj.minSteps(9);
        System.out.println(res);
        res = obj.minSteps(18);
        System.out.println(res);
    }

}
