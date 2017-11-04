/**
 *
 */
package com.raj.dp;

/**
 * @author Raj
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.


 */

public class JumpGame2 {

    public int jump(int[] a) {
        // e: longest distance in current minimum step
        // steps: minimum steps for reaching e

        int steps = 0;
        int e = 0;
        int max = 0;
        // we don't need to calculate for last, because there is no point in jumping from last step
        for (int i = 0; i < a.length - 1; i++) {
            max = Math.max(max, i + a[i]);
            if (i == e) {
                steps++;
                e = max;
            }
        }
        return max>=a.length-1?steps:Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

        int result = -1;
        JumpGame2 obj = new JumpGame2();
        result = obj.jump(a);
        System.out.println(result);
        int b[] = {3, 2, 1, 0, 4 };
        result = obj.jump(b);
        System.out.println(result);

    }

}
