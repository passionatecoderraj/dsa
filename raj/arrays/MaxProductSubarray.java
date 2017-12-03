/**
 *
 */
package com.raj.arrays;

/**
 * @author Raj
 */
public class MaxProductSubarray {

    public int maxProduct(int[] a) {
        if (a.length <= 0) {
            return 0;
        }
        int min, max, res;
        min = max = res = a[0];
        for (int i = 1; i < a.length; i++) {
            int curMax = Math.max(a[i], Math.max(a[i] * min, a[i] * max));
            int curMin = Math.min(a[i], Math.min(a[i] * min, a[i] * max));
            res = Math.max(curMax, res);
            max = curMax;
            min = curMin;
        }
        return res;
    }

    public static void main(String[] args) {

        MaxProductSubarray obj = new MaxProductSubarray();
        int a[] = {12, 2, -3, -5, -6, -2 };

        int result = -1;
        result = obj.maxProduct(a);
        System.out.println(result);
    }

}
