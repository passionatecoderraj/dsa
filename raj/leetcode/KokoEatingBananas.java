package com.raj.leetcode;

/**
 * 
 * @author Raj
 *
 *Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer K such that she can eat all the bananas within H hours.

 

Example 1:

Input: piles = [3,6,7,11], H = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], H = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], H = 6
Output: 23
 

Note:

1 <= piles.length <= 10^4
piles.length <= H <= 10^9
1 <= piles[i] <= 10^9
 */
public class KokoEatingBananas {

	/*
	 * Each hour, Koko chooses some pile of bananas, and eats K bananas from that pile.
		There is a limited range of K's to enable her to eat all the bananas within H hours.
		We ought to reduce the searching space and to return the minimum valid K.
		Binary Search is born for that.
		Initially, we know that K belongs to [1, the largest element in piles[]]. And we follow the pattern of lower-bound Binary Search except that if (K == target) is replaced with if (canEatAll(piles, K, H)).
	 */
	// Time : O(nlogn), Space : O(1)
	public int minEatingSpeed(int[] a, int H) {
		int l = 1, r = Integer.MIN_VALUE;
		for (int n : a) {
			r = Math.max(r, n);
		}
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (isValid(a, H, m)) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

	private boolean isValid(int[] a, int H, int m) {
		int count = 0;
		for (int n : a) {
			count += (n % m == 0) ? (n / m) : (n / m) + 1;
		}
		return count <= H;
	}

	public static void main(String... args) {
		KokoEatingBananas obj = new KokoEatingBananas();
		int res = -1;
		res = obj.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8);
		System.out.println("res=" + res);
		res = obj.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5);
		System.out.println("res=" + res);
		res = obj.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6);
		System.out.println("res=" + res);

	}
}
