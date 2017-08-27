/**
 *
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raj
 */
public class FindTripletSumtoK {

    public List<List<Integer>> threeSum(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i + 2 < a.length; i++) {
            if (i > 0 && a[i] == a[i - 1]) { // skip same result
                continue;
            }
            int j = i + 1, k = a.length - 1;
            while (j < k) {
                if (a[i] + a[j] + a[k] == target) {
                    res.add(Arrays.asList(a[i], a[j], a[k]));
                    j++;
                    k--;
                    while (j < k && a[j] == a[j - 1]) {
                        j++; // skip same result
                    }
                    while (j < k && a[k] == a[k + 1]) {
                        k--; // skip same result
                    }
                } else if (a[i] + a[j] + a[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public void findTriplet(int[] a, int n, int k) {
        if (n < 3) {
            return;
        }
        Arrays.sort(a);
        int l, r, sum = 0;
        for (int i = 0; i < n - 2; i++) {
            l = i + 1;
            r = n - 1;
            while (l < r) {
                sum = a[i] + a[l] + a[r];
                if (sum == k) {
                    System.out.println("1st=" + a[i] + ",2nd=" + a[l] + ",3rd=" + a[r] + " :: Sum=" + sum);
                    l++;
                    r--;
                } else if (sum > k) {
                    r--;
                } else {
                    l++;
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        FindTripletSumtoK obj = new FindTripletSumtoK();
        int a[] = {1, 4, 12, 6, 10, 8 };
        int n = a.length, k = 22;
        // Time : O(n2)
        obj.findTriplet(a, n, k);
        System.out.println(obj.threeSum(a, 22));
    }

}
