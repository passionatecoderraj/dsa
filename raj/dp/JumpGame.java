/**
 *
 */
package com.raj.dp;

/**
 * @author Raj
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


 */

public class JumpGame {

    /*
     * The basic idea is this: at each step, we keep track of the furthest reachable index. The nature of the problem
     * (eg. maximal jumps where you can hit a range of targets instead of singular jumps where you can only hit one
     * target) is that for an index to be reachable, each of the previous indices have to be reachable.
     */
    // Time : O(n)
    public boolean canJump(int[] a) {
        int reachable = 0;
        for (int i = 0; i < a.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + a[i]);
        }
        return true;
    }

    /*
     * Idea is to work backwards from the last index. Keep track of the smallest index that can "jump" to the last
     * index. Check whether the current index can jump to this smallest index.
     */
    public boolean canJump2(int[] a) {
        int lastPos = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (i + a[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

        boolean result = false;
        JumpGame obj = new JumpGame();
        result = obj.canJump(a);
        System.out.println(result);
        int b[] = {3, 2, 1, 0, 4 };
        result = obj.canJump(b);
        System.out.println(result);

    }

}
