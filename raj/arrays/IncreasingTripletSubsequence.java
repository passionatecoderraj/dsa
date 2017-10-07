/**
 *
 */
package com.raj.arrays;

/**
 * @author Raj 
 * 
 * Given an array of n integers, find the 3 elements such that a[i] <a[j] < a[k] and i < j < k in 0(n) time
 */
public class IncreasingTripletSubsequence {

    // Time : O(n), Space:O(1)
    public boolean increasingTriplet(int[] a) {
        if (a.length < 3) {
            return false;
        }
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated,
        // return true.
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int n : a) {
            if (n <= firstMin) {
                firstMin = n;
            } else if (n <= secondMin) {
                secondMin = n;
            } else {
                return true;
            }
        }
        return false;
    }

    // Time : O(n), Space:O(n)
    public boolean increasingTriplet2(int[] a) {
        if (a.length < 3) {
            return false;
        }
        int lmin[] = new int[a.length];
        int rmax[] = new int[a.length];
        int min = a[0], max = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            lmin[i] = min;
            min = Math.min(a[i], min);
        }

        for (int i = a.length - 2; i >= 0; i--) {
            rmax[i] = max;
            max = Math.max(a[i], max);
        }

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > lmin[i] && a[i] < rmax[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();
        int a[] = {12, 11, 10, 5, 6, 2, 30 };

        boolean result = false;
        result = obj.increasingTriplet(a);
        System.out.println(result);

    }

}
