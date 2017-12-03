/**
 *
 */
package com.raj.arrays;

/**
 * @author Raj
 * 
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */

public class FindMissingPositive {

    // Time : O(n)
    public int findSmallestMissingPositiveNumber(int[] a) {
        int l = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                a[l++] = a[i];
            }
        }

        int index;
        for (int i = 0; i < l; i++) {
            index = Math.abs(a[i]) - 1;
            if (index < l && a[index] > 0) {
                a[index] = -a[index];
            }
        }

        for (int i = 0; i < l; i++) {
            if (a[i] > 0) {
                return i + 1;
            }
        }
        return l+1;
    }

    public static void main(String[] args) {
        FindMissingPositive obj = new FindMissingPositive();
        int a[] = {2, 3, -7, 6, 8, 1, -10, 15 };
        int result = -1;
       
        result = obj.findSmallestMissingPositiveNumber(a);
        System.out.println(result);
        
        int b[] = {  1, 2, 3 };
        result = obj.findSmallestMissingPositiveNumber(b);
        System.out.println(result);
        

    }

}
