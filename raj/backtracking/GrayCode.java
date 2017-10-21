package com.raj.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

    // https://discuss.leetcode.com/topic/3021/share-my-solution
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 1; i <= n; i++) {
            int size = result.size();
            int bit_pos = 1 << (i - 1);
            for (int k = size - 1; k >= 0; k--) {
                result.add(result.get(k) | bit_pos);
            }
        }
        return result;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> res_stack = new LinkedList<>();
        res_stack.push(0);

        for (int i = 1; i <= n; i++) {
            Deque<Integer> temp_stack = new LinkedList<>();
            temp_stack.addAll(res_stack);
            int bit_pos = 1 << (i - 1);
            while (!res_stack.isEmpty()) {
                temp_stack.push(res_stack.pop() | bit_pos);
            }
            res_stack.addAll(temp_stack);
        }
        while (!res_stack.isEmpty()) {
            result.add(0, res_stack.pop());
        }
        return result;
    }

    public List<Integer> grayCode3(int n) {
        List<Integer> result = new ArrayList<Integer>();

        if (n == 0) {
            result.add(0);
            return result;
        }

        List<Integer> lastGray = grayCode3(n - 1);
        int addOnNum = 1 << (n - 1);

        result.addAll(lastGray);

        for (int i = lastGray.size() - 1; i >= 0; i--) {
            result.add(lastGray.get(i) + addOnNum);
        }

        return result;
    }

    public static void main(String[] args) {
        GrayCode obj = new GrayCode();

        List<Integer> result = null;
        result = obj.grayCode3(3);
        System.out.println(result);
        result = obj.grayCode2(3);
        System.out.println(result);
        result = obj.grayCode2(3);
        System.out.println(result);
    }
}