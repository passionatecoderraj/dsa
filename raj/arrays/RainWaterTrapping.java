/**
 *
 */
package com.raj.arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 */

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 */
public class RainWaterTrapping {

    // Time : O(n), Space : O(1);
    public int rainWaterTrapped(int[] a) {
        if (a.length < 3) {
            return 0;
        }
        int res = 0, maxLeft = 0, maxRight = 0;
        int l = 0, r = a.length - 1;
        while (l < r) {
            // we can count water, from tower with smaller height that's why if
            // left is small we move from left or right is small we move from right
            if (a[l] <= a[r]) {
                if (a[l] >= maxLeft) {
                    maxLeft = a[l];
                } else {
                    res += (maxLeft - a[l]);
                }
                l++;
            } else {
                if (a[r] >= maxRight) {
                    maxRight = a[r];
                } else {
                    res += (maxRight - a[r]);
                }
                r--;
            }
        }
        return res;
    }

    // Time : O(n), Space : O(n);
    public int rainWaterTrapped2(int a[]) {
        int n = a.length;
        if (n <= 3) {
            return 0;
        }
        int lMax[] = new int[n];
        int rMax[] = new int[n];

        int max_on_left = a[0];
        int max_on_right = a[n - 1];

        for (int i = 1; i < n; i++) {
            lMax[i] = max_on_left;
            max_on_left = Math.max(a[i], max_on_left);
        }

        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = max_on_right;
            max_on_right = Math.max(a[i], max_on_right);
        }

        int t = 0;
        CommonUtil.printArray(lMax);
        CommonUtil.printArray(a);
        CommonUtil.printArray(rMax);

        int min;
        for (int i = 1; i < n - 1; i++) {
            min = Math.min(lMax[i], rMax[i]);
            if (a[i] < min) {
                t += min - a[i];
            }
        }
        return t;
    }

    public static void main(String[] args) {

        int a[] = {1, 5, 2, 3, 1, 7, 2 };
        int result = -1;

        RainWaterTrapping obj = new RainWaterTrapping();

        // Time : O(n), Space : O(n)
        // result = obj.trappedQuantityOfRainWater(a, n);
        // System.out.println(result);
        result = obj.rainWaterTrapped(a);
        System.out.println(result);
    }

}
