/**
 *
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj 
 * 
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {

    private List<String> missingRanges(int[] a, int lower, int upper) {
        List<String> result = new ArrayList<>();
        // the next number we need to find
        int next = lower;
        for (int n : a) {
            // not within the range yet
            if (next > n) {
                continue;
            }

            // continue to find the next one
            if (next == n) {
                next++;
                continue;
            }
            // get the missing range string format
            result.add(createRange(next, n - 1));

            // now we need to find the next number
            next = n + 1;
        }

        // do a final check
        if (next <= upper) {
            result.add(createRange(next, upper));
        }
        return result;
    }

    private String createRange(int from, int to) {
        return from == to ? Integer.toString(from) : from + "->" + to;
    }

    public static void main(String[] args) {
        MissingRanges obj = new MissingRanges();
        List<String> result = null;
        int a[] = {0, 1, 3, 50, 75 };
        result = obj.missingRanges(a, 0, 99);
        System.out.println(result);

        int a2[] = {-2147483648, 2147483647 };
        result = obj.missingRanges(a2, -2147483648, 2147483647);
        System.out.println(result);

        int a3[] = {1, 1, 1 };
        result = obj.missingRanges(a3, 1, 1);
        System.out.println(result);

    }

}
