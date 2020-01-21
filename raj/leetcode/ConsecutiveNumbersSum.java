/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 *
 *
 Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

Example 1:

Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3
Example 2:

Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
Note: 1 <= N <= 10 ^ 9.
 */
public class ConsecutiveNumbersSum {

	/*
	 *
	 * 1) can we just decide with 'k' numbers starting with 'x', whether these numbers can contribute to sum N
	 *	
	 * 
The thought process goes like this- Given a number N, we can possibly write it as a sum of 2 numbers, 3 numbers, 4 numbers and so on. Let's assume the fist number in this series be x. Hence, we should have
x + (x+1) + (x+2)+...+ k terms = N
kx + k*(k-1)/2 = N implies
kx = N - k*(k-1)/2 

This is how we got above equation : sum of 11,12,13 is 3 terms so. ((3*(3+1))/2) + (11-1)*3 = 36
similarly, k*(k+1)/2 + (x-1) *k = N ===> k(k+1)/2 + kx-k = N ===> kx+k( (k+1)/2 - 1) = N ===> kx + k (k+1-2)/2 = N ====> kx + k(k-1)/2 = N 
So, we can calculate the RHS for every value of k and if it is a multiple of k then we can construct a sum of N using k terms starting from x.
Now, the question arises, till what value of k should we loop for? That's easy. In the worst case, RHS should be greater than 0. That is

N - k*(k-1)/2 > 0 which implies
k*(k-1) < 2N which can be approximated to
k*k < 2N ==> k < sqrt(2N)
	 */
	
	
	// https://leetcode.com/problems/consecutive-numbers-sum/discuss/129015/5-lines-C++-solution-with-detailed-mathematical-explanation.
	// Time : O(sqrt(N), Space : O(1)
	/*
	 * https://leetcode.com/problems/consecutive-numbers-sum/discuss/129015/5-lines-C++-solution-with-detailed-mathematical-explanation.
	 * https://www.youtube.com/watch?v=oKOCYZd4m7E&feature=youtu.be
	 *  sum of consecutive first 'k' numbers 
	 *  1+2+3+... +k ==> k*(k+1)/2
	 *  
	 *  sum of consecutive next 'k' numbers
	 *  2+3+4+....+k+k+1 => 1+2+3+...+k+k ==> k*(k+1)/2 + k
	 *  
	 *  sum of consecutive next 'k' numbers
	 *  3+4+5+....+k+k+1+k+2 => 1+2+3+...+k+k+k ==> k*(k+1)/2 + 2k
	 *  
	 *  If sum of 'k' consecutive numbers is 'N' then "N' must be divisible by 'k'.
	 *  
	 *   N = k*(k+1)/2 + (i-1)*k
	 * 
	 *  consider example N = 9
	 *  
	 */
	// Time : O(sqrt(N), Space : O(1)
	public int consecutiveNumbersSum(int N) {
		int count = 1;
		// k starts from 2 goes until k*(k+1)/2<=N.
		for (int k = 2; (k*(k+1))/2 <=N; k++) {
			if ((N - (k * (k + 1) / 2)) % k == 0) {
				count++;
			}
		}
		return count;
	}

	// Brute force not passed OJ
	// Time : O(n2)
	public int consecutiveNumbersSum2(int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			int sum = i;
			int cur = i;
			while (sum < N) {
				sum += ++cur;
			}
			if (sum == N)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		ConsecutiveNumbersSum obj = new ConsecutiveNumbersSum();
		int res = -1;
		res = obj.consecutiveNumbersSum(15);
		System.out.println(res);
	}

}
