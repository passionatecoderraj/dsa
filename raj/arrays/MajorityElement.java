/**
 *
 */
package com.raj.arrays;

/**
 * @author Raj
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more thanmk n/2  times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public int majorityElement(int[] a) {
        int count = 0, candidate = 0;
        for (int n : a) {
            if (candidate == n) {
                count++;
            } else if (count == 0) {
                candidate = n;
                count = 1;
            } else {
                count--;
            }
        }

        count = 0;
        for (int n : a) {
            if (n == candidate) {
                count++;
            }
        }
        return count > a.length / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int result = -1;
        int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4 };

        result = obj.majorityElement(a);
        System.out.println(result);

    }

}
