package com.raj.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author Raj
 *  Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Subsets2 {

    public List<List<Integer>> subsets2(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        int last = 0;
        for (int i = 0; i < a.length; i++) {
            int start = 0;
            if (i > 0 && a[i] == a[i - 1]) {
                start = result.size() - last;
            }

            last = 0;
            int size = result.size();
            for (int j = start; j < size; j++) {
                ArrayList<Integer> list = new ArrayList<>(result.get(j));
                list.add(a[i]);
                result.add(list);
                last++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Subsets2 obj = new Subsets2();
        int a[] = {1, 2, 2 };
        List<List<Integer>> result = obj.subsets2(a);
        System.out.println(result);

    }

}
