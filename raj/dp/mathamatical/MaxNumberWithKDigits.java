package com.raj.dp.mathamatical;

import java.util.Arrays;
import java.util.Stack;

import com.interivew.graph.CommonUtil;

/**
 * 
 * @author Raj
 *
 *         Given one array of length n, create the maximum number of length k
 *         with relative order of elements.
 * 
 *         nums = [9, 1, 2, 5, 8, 3], k= 3 ,
 * 
 *         result = [9,8,3]
 * 
 */
public class MaxNumberWithKDigits {

	public static int[] maxNumberWithKDigits(int[] nums, int k) {
		return maxNumberByRemovingNDigits(nums, nums.length - k);
	}

	private static int[] maxNumberByRemovingNDigits(int a[], int n) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] ans = new int[a.length - n];
		for (int i : a) {
			while (n > 0 && !stack.isEmpty() && i > stack.peek()) {
				stack.pop();
				n--;
			}
			stack.push(i);
		}

		while (n > 0) {
			stack.pop();
			n--;
		}
		int i = 0;
		while (!stack.isEmpty()) {
			ans[i++] = stack.pop();
		}
		reverse(ans);
		return ans;
	}

	private static void reverse(int a[]) {
		int l = 0, r = a.length - 1;
		while (l < r) {
			CommonUtil.swap(a, l, r);
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		int a[] = { 9, 1, 2, 5, 8, 3 };
		int k = 3;
		int res[];
		res = maxNumberWithKDigits(a, k);
		System.out.println(Arrays.toString(res));
	}

}
