/**
 * 
 */
package com.raj.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Raj
 * 
 */

/*
 * This problem we are not actually finding duplicates.
 * 
 * Rather finding numbers with max difference of t and with in the distance of k
 * 
 * Contains Duplicate in java
 * 
 * difference between nums[i] and nums[j] is at most t and the difference
 * between i and j is at most k
 *
 */

/*
 * http://blog.welkinlan.com/2015/09/11/contains-duplicate-i-ii-iii-leetcode-
 * java/
 */
public class ContainsDuplicate3 {

	// Time : O(n) , Space : O(k)
	/*
	 * {4, 8, 1, 6} t=2, k =2 assume no negatives, and t >0, then bucket = a[i]/t 
	 * then we can place 4 in bucket 2
	 * 					, 8, in bucket 4
	 * 					, 1, in bucket 0 
	 * 					and 6 in bucket 3
	 * for each number, identify the bucket it should go to ,
	 * 	if this bucket is already present, it means a[i]+t or a[i]-t is already exist
	 * or duplicate may presnet in previous bucket or current bucket
	 * 
	 * in the above example
	 *  bucket to val map : {}, 
	 *  cur -> 4  -> buckets empty -> place {{2, 4}}
	 *  cur -> 8 ->  bucket 4, bucket 5 or bucket 3 doesn't exist -> so place {{2, 4}, {4, 8}} 
	 *  cur -> 1 ->  bucket 0, bucket2 doesn't exist -> so place { 0,1} and remove {2,4} since distance of k=2 is reached { {4,8},{0,1}}
	 *  cur -> 6 -> bucket 3 , bucket 3 doens't exist. bucket 4 exist and diff(8-6) <= 2 so, return true
	 *    
	 *    
	 *    
	 *    
	 * Note1 : Another complication is that negative ints are allowed. A simple num / t just shrinks everything towards 0. Therefore, we can just reposition every element to start from Integer.MIN_VALUE
	 * Note2 : Actually, we can use t + 1 as the bucket size to get rid of the case when t == 0. It simplifies the code. The above code is therefore the updated version.
	 */
	public boolean containsNearbyAlmostDuplicate3(int[] a, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			long remappedNum = (long) a[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);
			if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) a[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}

	// Time : O(n) , Space : O(k)
	public boolean containsNearbyAlmostDuplicate(int[] a, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		if(t==0) {
			Set<Integer> set = new HashSet<>();
			for(int i=0;i<a.length;i++) {
				if(!set.add(a[i])) {
					return true;
				}
				if(i>=k) {
					set.remove(a[i-k]);
				}
			}
		}
		else {
			Map<Long, Long> map = new HashMap<>();
			for (int i = 0; i < a.length; i++) {
				long remappedNum = (long) a[i] - Integer.MIN_VALUE;
				long bucket = remappedNum / ((long) t);
				if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
						|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
					return true;
				if (map.entrySet().size() >= k) {
					long lastBucket = ((long) a[i - k] - Integer.MIN_VALUE) / ((long)t);
					map.remove(lastBucket);
				}
				map.put(bucket, remappedNum);
			}
		}
		return false;
	}
	
	// Time : O(n*log(k)) , Space : O(k)
	public boolean containsNearbyAlmostDuplicate2(int[] a, int k, int t) {
		TreeSet<Long> treeSet = new TreeSet<>();
		for (int i = 0; i < a.length; i++) {
			/*
			 * change a little ，for the last case ： （new int[]{-2147483648,-2147483647} , 3,
			 * 3)
			 */
			long cur = a[i];
			Long floor = treeSet.floor(cur + t);
			Long ceil = treeSet.ceiling(cur - t);
			if ((floor != null && floor >= cur) || (ceil != null && ceil <= cur)) {
				return true;
			}
			treeSet.add(cur);
			if (i >= k)
				treeSet.remove((long) a[i - k]);
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate3 obj = new ContainsDuplicate3();
		int a[] = { 3, 6, 0, 4 };
		int k = 2, t = 2;

		boolean result = false;
		// Time : O(n*log(k)) , Space : O(k)
		result = obj.containsNearbyAlmostDuplicate(a, k, t);
		System.out.println(result);

	}

}
