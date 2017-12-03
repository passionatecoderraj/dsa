/**
 *
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Example 2:
Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] a) {
        List<String> res = new ArrayList<>();
        for (int start = 0, i = 1; i <= a.length; i++) {
            if (i == a.length || a[i] - a[i - 1] != 1) {
                res.add(createRange(a[start], a[i - 1]));
                start = i;
            }
        }
        return res;
    }

    private String createRange(int from, int to) {
        return from == to ? Integer.toString(from) : from + "->" + to;
    }

    public static void main(String[] args) {

        SummaryRanges obj = new SummaryRanges();
        List<String> result = null;
        int a[] = {0, 1, 3, 50, 75 };
        result = obj.summaryRanges(a);
        System.out.println(result);

        int a2[] = {0, 2, 3, 4, 6, 8, 9 };
        result = obj.summaryRanges(a2);
        System.out.println(result);
    }

}
