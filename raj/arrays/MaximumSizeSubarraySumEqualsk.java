/**
 * 
 */
package com.raj.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/
public class MaximumSizeSubarraySumEqualsk {

    /*
     * The HashMap stores the sum of all elements before index i as key, and i as value. For each i, check not only the current sum but also (currentSum - previousSum) to see if there is any that equals k, and update max length.
     */
    // Time : O(n), Space : O(n)
    public int maxSubArrayLen(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0,maxLen=0;
        map.put(0, -1);
        for(int i=0;i<a.length;i++){
            sum = sum+a[i];
             if(map.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;
    }
    
    
    /*
     * The subarray sum similar to the range sum problem. Preprocess the input array such that you get the range sum in
     * constant time.sum[i] means the sum from 0 to i inclusively the sum from i to j is sum[j] - sum[i - 1] except that
     * from 0 to j is sum[j].
     * 
     */
    public int maxSubArrayLen2(int[] a, int k) {
        int sum[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                sum[i] = a[i];
            } else {
                sum[i] = a[i] + sum[i - 1];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        /*
         * add this to cover scenario where sum of 0 to j elements is 'k' for example, k=3, 0 the element is 3 then size
         * j-i, nothing 0-(-1) = 1
         */
        map.put(0, -1);
        int maxLen = 0;

        // sum[j]-sum[i] = k ;sum[i] =sum[j]-k

        for (int j = 0; j < sum.length; j++) {

            if(sum[j] == k){
                maxLen = j+1;
            }
            else if (map.containsKey(sum[j] - k)) {
                maxLen = Math.max(maxLen, j - map.get(sum[j] - k));
            }
            if(!map.containsKey(sum[j])){
                map.put(sum[j], j);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

        MaximumSizeSubarraySumEqualsk obj = new MaximumSizeSubarraySumEqualsk();
        int a[] = {1, -1, 5, -2, 3 };
        int result = -1;
        result = obj.maxSubArrayLen(a, 3);
        System.out.println(result);

        int b[] = {-2, -1, 2, 1 };
        result = obj.maxSubArrayLen(b, 1);
        System.out.println(result);
    }

}
