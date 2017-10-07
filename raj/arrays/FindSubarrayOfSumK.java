/**
 *
 */
package com.raj.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 */

public class FindSubarrayOfSumK {

    /*
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum
     * equals to k.
     */
    // Time : O(n), Space : O(n)
    public int subarraySum(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int element : a) {
            sum += element;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

        FindSubarrayOfSumK obj = new FindSubarrayOfSumK();
        int a[] = {3, 4, 7, 2, -3, 1, 4, 2 };
        int k = 7;
        obj.subArraysOfSum2(a, k);
        int res = obj.subarraySum(a, k);
        System.out.println(res);
    }

    public void subArraysOfSum2(int[] a, int k) {

        int l = 0, r = 0;
        int sum = a[r];

        while (true) {
            if (sum < k) {
                r++;
                if (r == a.length) {
                    return;
                }
                sum += a[r];
            } else if (sum > k) {
                sum -= a[l++];
            } else {
                printSubarray(a, l, r);
                sum = 0;
                l = r + 1;
            }
        }

    }

    // assumption is k >=1
    public void subArraysOfSum(int[] a, int k) {

        int sum = 0;
        int l = 0;

        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            while (sum > k && l <= r) {
                sum -= a[l++];
            }
            if (sum == k) {
                printSubarray(a, l, r);
                sum = 0;
                l = r + 1;
            }
        }
    }

    // assumption is k >=1
    public void subArraysOfSumK(int[] a, int n, int k) {

        int sum = 0;
        int l = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                printSubarray(a, i, i);
                l = i + 1;
                sum = 0;
                continue;
            }

            sum += a[i];

            while (l <= i && sum > k) {
                sum -= a[l++];
            }

            if (sum == k) {
                printSubarray(a, l, i);
                sum = 0;
                l = i + 1;
            }

        }
    }

    private void printSubarray(int[] a, int l, int r) {
        for (int i = l; i <= r; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
