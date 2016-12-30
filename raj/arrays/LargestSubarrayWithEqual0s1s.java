package com.raj.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEqual0s1s {

	public int largestSubarrayWithEqual0s1s(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				a[i] = -1;
		}
		int maxLength = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int lsum = 0;
		for (int i = 0; i < a.length; i++) {
			lsum += a[i];
			if (lsum == 0) {
				maxLength = i + 1;
			} else {
				if (!map.containsKey(lsum)) {
					map.put(lsum, i);
				} else {
					int left = map.get(lsum);
					int right = i;
					maxLength = Integer.max(right - left, maxLength);
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LargestSubarrayWithEqual0s1s obj = new LargestSubarrayWithEqual0s1s();
		int a[] = { 1, 0, 0, 1, 0, 1, 1 };
		int result = -1;
		result = obj.largestSubarrayWithEqual0s1s(a);
		System.out.println(result);
		int b[] = { 1, 1, 1, 1 };
		result = obj.largestSubarrayWithEqual0s1s(b);
		System.out.println(result);
		int c[] = { 0, 0, 1, 1, 0 };
		result = obj.largestSubarrayWithEqual0s1s(c);
		System.out.println(result);

		int d[] = { 1, 1, 1, 0, 1, 0, 0 };
		result = obj.largestSubarrayWithEqual0s1s(d);
		System.out.println(result);

	}

}
