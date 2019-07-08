/**
 * 
 */
package com.raj.leetcode;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.

A subsequence of a string S is obtained by deleting 0 or more characters from S.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

Example 1:
Input: 
S = 'bccb'
Output: 6
Explanation: 
The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.
Example 2:
Input: 
S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
Output: 104860361
Explanation: 
There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
Note:

The length of S will be in the range [1, 1000].
Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.

 */
public class CountDifferentPalindromicSubsequences {

	// Time : O(n2), Space : O(n2)
	/*
	 * same solution with explanation is below
	 */
	public int countPalindromicSubsequences(String str) {
		int n = str.length();
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			t[i][i] = 1;
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (str.charAt(i) == str.charAt(j)) {
					int low = i + 1, high = j - 1;
					while (low <= high && str.charAt(i) != str.charAt(low)) {
						low++;
					}
					while (low <= high && str.charAt(i) != str.charAt(high)) {
						high--;
					}
					if (low > high) {
						t[i][j] = t[i + 1][j - 1] * 2 + 2;
					} else if (low == high) {
						t[i][j] = t[i + 1][j - 1] * 2 + 1;
					} else {
						t[i][j] = t[i + 1][j - 1] * 2 - t[low + 1][high - 1];
					}

				} else {
					t[i][j] = t[i][j - 1] + t[i + 1][j] - t[i + 1][j - 1];
				}
				t[i][j] = t[i][j] < 0 ? t[i][j] + 1000000007 : t[i][j] % 1000000007;
			}
		}
		CommonUtil.print2DArray(t, n, n);
		// return total palindromic subsequence
		return t[0][n - 1];
	}

	// https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109507/Java-96ms-DP-Solution-with-Detailed-Explanation
	// Time : O(n2), Space : O(n2)
	/*
	 * if a[i] != a[j], it's t[i+1][j] + t[i][j-1] - t[i+1][j-1]
	 * example : f(pqr)
	 * 				 p!=r => so f(qr) + f(pq) - f(q) = >  {q,r} + {p, q} - q (because q is common)  => 2 + 2 - 1 = 3
	 * 
	 *   if a[i] == a[j], it means we always make 2 times the no. of palindromes one without (i,j) and one with (i,j)
	 *   for example, for string f(pqrsp) -> f(i,j) -> since both ends are equals -> then no. of palindromes are without including p -> {q,r,s} with including p -> {pqp,prp,psp}
	 *   but we need to address the cases in case if a[i] repeats inside substring f(i+1,j-1)
	 *  case 1) if there is not match of characters between with new ends of (i,j), then total is additional 2
	 *    This is because in the above example, f(pqrsp) -> we get 6 by including p and excluding p {q,r,s, pqp,prp,psp}, we also need to cover cases of {p, pp}
	 *    so, answer is +2 for this -> final :  2*f(i+1,j-1) + 2
	 *    
	 *   case 2) if there is exact one match of character then we just need to do +1 for 2*f(i+1,j-1)
	 *   consider, f(pprsp) -> {p,r,s} without considering ends, by considering ends -> {ppp, prp,psp} 
	 *   now since p is already there we just need to add {p}
	 *   final : 2*f(i+1,j-1) + 1
	 *   case 3) if there is more than one match with ends from both sides at (x,y), then consider removing f(x+1,j-1) from final results
	 *   example : f(pprpp) -> without ends {r, prp, p, pp} by considering ends {prp, pprpp, pp, pppp} 
	 *   but we have sub string where f(prp) => f(x,y) ->  where sub-ends match the value with p. So, we need to deduce this from previsous value
	 *    final : 2 * f(i+1, j-1) - f(x+1,y-1)
	 * 
	 */
	 public int countPalindromicSubsequences2(String str) {
	        int n = str.length();
	        int[][] t = new int[n][n];

	        for(int i = 0; i < n; i++){
	            t[i][i] = 1;   // Consider the test case "a", "b" "c"...
	        }

	        for(int l = 2; l <= n; l++){
	            for(int i = 0; i < n - l + 1; i++){
	                int j = i + l - 1;
	                if (str.charAt(i) == str.charAt(j)) {
	                    int low = i + 1;
	                    int high = j - 1;

	              /* Variable low and high here are used to get rid of the duplicate*/

	                    while (low <= high && str.charAt(i) != str.charAt(low)) {
	                        low++;
	                    }
	                    while (low <= high && str.charAt(i) != str.charAt(high)) {
	                        high--;
	                    }
	                    if(low > high){
	                        // consider the string from i to j is "a...a" "a...a"... where there is no character 'a' inside the leftmost and rightmost 'a'
	                       /* eg:  "aba" while i = 0 and j = 2:  dp[1][1] = 1 records the palindrome{"b"}, 
	                         the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"b"}, 
	                         and additional time as {"aba"}. The reason why 2 counted is that we also count {"a", "aa"}. 
	                         So totally dp[i][j] record the palindrome: {"a", "b", "aa", "aba"}. 
	                         */ 

	                        t[i][j] = t[i + 1][j - 1] * 2 + 2;  
	                    } 
	                    else if(low == high){
	                        // consider the string from i to j is "a...a...a" where there is only one character 'a' inside the leftmost and rightmost 'a'
	                       /* eg:  "aaa" while i = 0 and j = 2: the dp[i + 1][j - 1] records the palindrome {"a"}.  
	                         the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"a"}, 
	                         and additional time as {"aaa"}. the reason why 1 counted is that 
	                         we also count {"aa"} that the first 'a' come from index i and the second come from index j. So totally dp[i][j] records {"a", "aa", "aaa"}
	                        */
	                        t[i][j] = t[i + 1][j - 1] * 2 + 1;  
	                    }
	                    else{
	                        // consider the string from i to j is "a...a...a... a" where there are at least two character 'a' close to leftmost and rightmost 'a'
	                       /* eg: "aacaa" while i = 0 and j = 4: the dp[i + 1][j - 1] records the palindrome {"a",  "c", "aa", "aca"}. 
	                          the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"a",  "c", "aa", "aca"}, 
	                          and additional time as {"aaa",  "aca", "aaaa", "aacaa"}.  Now there is duplicate :  {"aca"}, 
	                          which is removed by deduce dp[low + 1][high - 1]. So totally dp[i][j] record {"a",  "c", "aa", "aca", "aaa", "aaaa", "aacaa"}
	                          */
	                        t[i][j] = t[i + 1][j - 1] * 2 - t[low + 1][high - 1]; 
	                    }
	                }
	                else{
	                    t[i][j] = t[i][j - 1] + t[i + 1][j] - t[i + 1][j - 1];  //s.charAt(i) != s.charAt(j)
	                }
	                t[i][j] = t[i][j] < 0 ? t[i][j] + 1000000007 : t[i][j] % 1000000007;
	            }
	        }

	        return t[0][n - 1];
	    }
	 
	 
	public static void main(String[] args) {
		int result = -1;

		CountDifferentPalindromicSubsequences obj = new CountDifferentPalindromicSubsequences();
		result = obj.countPalindromicSubsequences("bccb");
		System.out.println(result);
		result = obj.countPalindromicSubsequences("kacak");
		System.out.println(result);
	}

}
