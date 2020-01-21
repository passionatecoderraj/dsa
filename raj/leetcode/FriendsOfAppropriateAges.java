package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Raj
 *
 *Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output: 
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 

Notes:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.

 */
public class FriendsOfAppropriateAges {

	/*
	 * Three conditions could be merged to one:
	   The Person with age A can request person with age B if B is in range ( 0.5 * A + 7, A ]
	 */
	// https://leetcode.com/problems/friends-of-appropriate-ages/discuss/127341/10ms-concise-Java-solution-O(n)-time-and-O(1)-space
	// Time : O(n), Space : O(1)
	public int numFriendRequests(int[] ages) {
		int res = 0;
		// sum array for range sum
		int sum[] = new int[121];
		int count[] = new int[121];
		for (int n : ages)
			count[n]++;
		for (int i = 1; i <= sum.length; i++)
			sum[i] = count[i] + sum[i - 1];
		for (int i = 1; i <= sum.length; i++) {
			if (count[i] == 0)
				continue;
			int p = sum[i] - sum[i / 2 + 7];
			// //people will not friend request themselves, so  - numInAge[i]
			res += p * count[i] - count[i];
		}
		return res;
	}
	
	public int numFriendRequests2(int[] ages) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : ages) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int res = 0;
		for (Integer k1 : map.keySet()) {
			for (Integer k2 : map.keySet()) {
				if (k1 * 0.5 + 7 >= k2)
					continue;
				if (k1 < k2)
					continue;
				if (k1 < 100 && 100 < k2)
					continue;
				/*
				 * (k1,v1) = (16,2), (k2,v2) = (17,3);
				 * age 16 people do not send friend req to 17
				 * all age 17 people send friend req to age 16. so, 3 * 2 = 6 ways
				 * when k1 == k2, 
				 * they still send friend req in m * n ways.
				 * But, they do not send req themselves, so deduct
				 * 
				 */
				if (k1 == k2)
					//res += map.get(k1) * (map.get(k2) - 1);
					res += (map.get(k1) * map.get(k2)) - map.get(k1);
				else
					res += map.get(k1) * map.get(k2);
			}
		}
		return res;
	}

	public static void main(String[] args) {

		FriendsOfAppropriateAges obj = new FriendsOfAppropriateAges();
		int res = -1;
		int a[] = { 16, 16, 16, 16 };

		res = obj.numFriendRequests(a);
		System.out.println(res);

		int b[] = { 16, 17, 18 };
		res = obj.numFriendRequests(b);
		System.out.println(res);
	}

}
