package com.raj.backtracking;
/**							
* 							
*/							
							
import java.util.ArrayList;							
import java.util.HashSet;							
import java.util.List;							
import java.util.Set;							
							
/**							
* @author Raj							
* 							
* 							
*         http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/							
* 							
*         Given a string s, partition s such that every substring of the							
*         partition is a palindrome.							
* 							
*         For example, given s = "aab", Return							
* 							
*         [ ["aa","b"], ["a","a","b"] ]							
* 							
*/							
public class PrintAllPalindromePartitions {							
							
	private List<String> printAllPalindromePartitions(String s) {						
							
		List<String> result = new ArrayList<String>();					
							
		if (s == null)					
			return result;				
							
		if (s.length() <= 1) {					
			result.add(s);				
			return result;				
		}					
							
		int length = s.length();					
							
		int[][] table = new int[length][length];					
							
		// l is length, i is index of left boundary, j is index of right					
		// boundary					
		for (int l = 1; l <= length; l++) {					
			for (int i = 0; i <= length - l; i++) {				
				int j = i + l - 1;			
				if (s.charAt(i) == s.charAt(j)) {			
					if (l == 1 || l == 2) {		
						table[i][j] = 1;	
					} else {		
						table[i][j] = table[i + 1][j - 1];	
					}		
					if (table[i][j] == 1) {		
						result.add(s.substring(i, j + 1));	
					}		
				} else {			
					table[i][j] = 0;		
				}			
			}				
		}					
							
		return result;					
	}						
							
	public static void main(String[] args) {						
		String str = "abcbb";					
							
		List<String> result = null;					
		PrintAllPalindromePartitions obj = new PrintAllPalindromePartitions();					
		result = obj.printAllPalindromePartitions(str);					
		System.out.println(result);					
	}						
							
}	