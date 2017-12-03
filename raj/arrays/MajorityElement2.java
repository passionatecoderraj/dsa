/**
 *
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 * 
 *         Given an integer array of size n, find all elements that appear more than n/3 times. The algorithm
 *         should run in linear time and in O(1) space.
 */
public class MajorityElement2 {

    // Time : O(n), Space : O(1)
    public List<Integer> majorityElement(int[] a) {
        List<Integer> res = new ArrayList<>();
        int cand1 = 0, cand2 = 0, c1 = 0, c2 = 0;

        for (int n : a) {
            if (n == cand1) {
                c1++;
            } else if (n == cand2) {
                c2++;
            } else if (c1 == 0) {
                cand1 = n;
                c1 = 1;
            } else if (c2 == 0) {
                cand2 = n;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int n : a) {
            if (n == cand1) {
                c1++;
            } else if (n == cand2) {
                c2++;
            }
        }
        if (c1 > a.length / 3) {
            res.add(cand1);
        }
        if (c2 > a.length / 3) {
            res.add(cand2);
        }
        return res;

    }

    public static void main(String[] args) {
        MajorityElement2 obj = new MajorityElement2();
        List<Integer> result = null;
        int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4 };

        result = obj.majorityElement(a);
        System.out.println(result);

    }

}
