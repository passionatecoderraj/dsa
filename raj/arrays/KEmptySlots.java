/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 *
 *There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.
Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1
Note:
The given array will be in the range [1, 20000].
 */
public class KEmptySlots {

	// problem description :
	// https://stackoverflow.com/questions/46393470/find-earliest-time-for-k-empty-group
	public int kEmptySlots(int[] flowers, int k) {
	    int[] days = new int[flowers.length];
	    for (int i = 0; i < days.length; i++) {
	        days[flowers[i] - 1] = i + 1;
	    }
	    System.out.println(Arrays.toString(flowers));
		System.out.println(Arrays.toString(days));
		
	    int left = 0;
	    int right = k + 1;
	    int res = Integer.MAX_VALUE;
	    for (int i = 1; right < days.length; i++) {
	    	
	        // current days[i] is valid, continue scanning
	        if (days[i] > days[left] && days[i] > days[right]) {
	        	System.out.println("continue : - i="+i+"("+days[i]+"),l="+left+"("+days[left]+"),r="+right+"("+days[right]+")");
	            continue;
	        }
	        
	        System.out.println("i="+i+"("+days[i]+"),l="+left+"("+days[left]+"),r="+right+"("+days[right]+")");
	       // reach boundary of sliding window, since previous number are all valid, record result  
	        if (i == right) {
	            res = Math.min(res, Math.max(days[left],days[right]));
	        }
	        // not valid, move the sliding window
	        left = i;
	        right = left + k + 1;
	    }
	    return res == Integer.MAX_VALUE ? -1 : res;
	}
	
	public int kEmptySlots2(int[] flowers, int k) {
		int[] days = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++)
			days[flowers[i] - 1] = i + 1;
		int left = 0, right = k + 1, res = Integer.MAX_VALUE;
		System.out.println(Arrays.toString(flowers));
		System.out.println(Arrays.toString(days));
		for (int i = 0; right < days.length; i++) {
			System.out.println("i="+i+"("+days[i]+"),l="+left+"("+days[left]+"),r="+right+"("+days[right]+")");
			if (days[i] < days[left] || days[i] <= days[right]) {
				if (i == right)
					res = Math.min(res, Math.max(days[left], days[right])); // we get a valid subarray
				left = i;
				right = k + 1 + i;
			}
		}
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KEmptySlots obj = new KEmptySlots();
		int res = -1;
		
		int flowers[] = { 5, 1, 2, 4, 3 };
		res = obj.kEmptySlots(flowers, 2);
		System.out.println(res);

//		int flowers2[] = { 2, 5, 1, 4, 3 };
//		res = obj.kEmptySlots(flowers, 2);
//		System.out.println(res);

	}

}
