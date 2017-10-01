package com.raj.arrays;

import com.interview.graph.CommonUtil;

public class RotateArray {

    public void rotate(int a[], int k) {
        k = k % a.length;
        reverse(a, 0, a.length - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
    }

    public void reverse(int a[], int l, int r) {
        while (l < r) {
            CommonUtil.swap(a, l++, r--);
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7 };
        int d = 9;
        RotateArray obj = new RotateArray();
        // Time : O(n), Space: O(n)
        obj.rotate(a, d);
        CommonUtil.printArray(a);

    }

}
