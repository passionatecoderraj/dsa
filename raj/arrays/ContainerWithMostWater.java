/**
 *
 */
package com.raj.arrays;

/**
 * @author Raj
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

public class ContainerWithMostWater {

    // Time : O(n), Space : O(1);
    public int maxArea(int[] a) {
        int l = 0, r = a.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(Math.min(a[l], a[r]) * (r - l), maxArea);
            if (a[l] < a[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int a[] = {1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int result = -1;

        ContainerWithMostWater obj = new ContainerWithMostWater();
        result = obj.maxArea(a);
        System.out.println(result);
    }

}
