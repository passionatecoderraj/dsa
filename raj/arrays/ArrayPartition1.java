/**
 *
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 */
public class ArrayPartition1 {

    public int arrayPairSum(int[] a) {
        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < a.length - 1; i += 2) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayPartition1 obj = new ArrayPartition1();
        int a[] = {1, 4, 3, 2 };
        int res = -1;
        // Time : O(n2)
        res = obj.arrayPairSum(a);
        System.out.println(res);
    }

}
