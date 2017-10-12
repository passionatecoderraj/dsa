/**
 *
 */
package com.raj.arrays;

/**
 * @author Raj
 */
public class FindMissingNumber {

    public int missingNumber(int[] a) {
        int r = 0;
        for (int i = 0; i <= a.length; i++) {
            if (i == a.length) {
                r = (r ^ i);
            } else {
                r = (r ^ i ^ a[i]);
            }
        }
        return r;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        FindMissingNumber obj = new FindMissingNumber();
        int result = -1;
        int a[] = {1, 2, 4, 6, 3, 7, 8 };

        // Time :O(n) but there can be a overflow of integer while adding all of
        // them
        result = obj.findMissingNumber(a);
        System.out.println(result);
        result = obj.findMissingNumberUsingXOR(a);
        System.out.println(result);

        // Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from
        // the array.

        result = obj.missingNumber(new int[]{0, 1, 3 });
        System.out.println(result);

    }

    public int findMissingNumberUsingXOR(int[] a) {
        int x1 = a[0], x2 = 1, n = a.length;
        for (int i = 1; i < n; i++) {
            x1 = x1 ^ a[i];
        }

        for (int i = 2; i <= n + 1; i++) {
            x2 = x2 ^ i;
        }
        return x1 ^ x2;
    }

    public int findMissingNumber(int[] a) {
        int tot = 0;
        for (int element : a) {
            tot += element;
        }
        int n = a.length + 1;
        int sum = (n * (n + 1)) / 2;
        return sum - tot;
    }
}
