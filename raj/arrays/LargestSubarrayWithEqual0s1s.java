package com.raj.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEqual0s1s {

	public int largestSubarrayWithEqual0s1s(int a[]) {
		 for (int i = 0; i < a.length; i++) {
				if (a[i] == 0)
					a[i] = -1;
			}
	        Map<Integer, Integer> map = new HashMap<>();
	        int sum=0,maxLen=0;
	        map.put(0, -1);
	        for(int i=0;i<a.length;i++){
	            sum = sum+a[i];
	             if(map.containsKey(sum)){
	                maxLen = Math.max(maxLen, i-map.get(sum));
	            }
	            if(!map.containsKey(sum)){
	                map.put(sum, i);
	            }
	        }
	        return maxLen;
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
