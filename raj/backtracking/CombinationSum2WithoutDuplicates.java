package com.raj.backtracking;
import java.util.ArrayList;							
import java.util.Arrays;							
import java.util.List;							
							
/**							
* Given a collection of candidate numbers (C) and a target number (T), find all							
* unique combinations in C where the candidate numbers sums to T.							
* 							
* 							
* * Input : [10, 1, 2, 7, 6, 1, 5] , Sum : 8							
* 							
* 							
* Output :[ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]							
* 							
* @author Raj							
*							
*/							
public class CombinationSum2WithoutDuplicates {							
							
	public List<List<Integer>> combinationSumWithoutDuplicates(int a[], int sum) {						
		List<List<Integer>> result = new ArrayList<>();					
		Arrays.sort(a);					
		combinationSumUtilWithoutDuplicates(a, 0, sum, new ArrayList<>(), result);					
		return result;					
	}						
							
	private void combinationSumUtilWithoutDuplicates(int[] a, int i, int sum, ArrayList<Integer> cur,						
			List<List<Integer>> result) {				
		if (sum == 0) {					
			List<Integer> temp = new ArrayList<>(cur);				
			result.add(temp);				
			return;				
		}					
		for (int j = i; j < a.length; j++) {					
			if (a[j] > sum)				
				break;			
			if (j > i && a[j] == a[j - 1])				
				continue;			
			cur.add(a[j]);				
			combinationSumUtilWithoutDuplicates(a, j + 1, sum - a[j], cur, result);				
			cur.remove(cur.size() - 1);				
		}					
	}						
							
	public static void main(String args[]) {						
		CombinationSum2WithoutDuplicates obj = new CombinationSum2WithoutDuplicates();					
							
		List<List<Integer>> result = null;					
							
		int b[] = { 10, 1, 2, 7, 6, 1, 5 };					
		result = obj.combinationSumWithoutDuplicates(b, 8);					
		System.out.println(result);					
							
	}						
							
}	