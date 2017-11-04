	/**
 *
 */
package com.raj.mathamatical;

/**
 * @author Raj
 * 
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]
 */
public class MaximumSwap {

    // Time : O(n), Space : O(1)
    // https://leetcode.com/articles/maximum-swap/
    public int maximumSwap(int n) {
        int last[] = new int[10];
        char a[] = Integer.toString(n).toCharArray();

        // We will compute last[d] = i, the index i of the last occurrence of digit d (if it exists).
        for (int i = 0; i < a.length; i++) {
            last[a[i] - '0'] = i;
        }

        // scan number left to right
        for (int i = 0; i < a.length; i++) {
            // scan 'last' array from right to left
            for (int d = 9; d > a[i] - '0'; d--) {
                // if there is a larger digit in the future swap it and return
                /*
                 * we don't need to worry about large digts that are already rightly placed because those indices are
                 * smaller so those last[d] will be smaller than i
                 *
                 * For ex: 98(3)6 ->when i=2 and scanning for 3; we start from 9 on the right but it's index is 0 and
                 * index of 3 is 2 it will fail anyway
                 */

                if (last[d] > i) {
                    char temp = a[i];
                    a[i] = a[last[d]];
                    a[last[d]] = temp;
                    return Integer.parseInt(new String(a));
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int res = -1;
        MaximumSwap obj = new MaximumSwap();

        res = obj.maximumSwap(2736);
        System.out.println(res);

        res = obj.maximumSwap(98324);
        System.out.println(res);
    }

}
