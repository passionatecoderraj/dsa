package com.raj.stack;

import java.util.Stack;
/**
 * 
 * @author Raj
 *
 *Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.


 */
public class MaxAreaOfHistogram {

    public int largestRectangleArea(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, area, maxArea = 0;
        while (i <= a.length) {
            while (!stack.isEmpty() && (i == a.length || a[stack.peek()] > a[i])) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = i * a[top];
                } else {
                    area = (i - stack.peek() - 1) * a[top];
                }
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i++);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaOfHistogram obj = new MaxAreaOfHistogram();
        // int a[] = { 2, 1, 2, 3, 1 };
        // int a[] = { 2, 1, 4, 5, 1, 3, 3 };
        int a[] = {6, 2, 5, 4, 5, 1, 6 };
        int result = -1;
        result = obj.largestRectangleArea(a);
        System.out.println(result);
    }

}
