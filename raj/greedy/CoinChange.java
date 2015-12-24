package com.raj.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

	public static void main(String[] args) {
		
	//	int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int coins[] = {1, 5, 6, 9};
		int n = 11;
		List<Integer> denominiations = new ArrayList<Integer>();
		
		CoinChange obj = new CoinChange();
		obj.findMinCoins(n,coins,denominiations);
		if(denominiations.size() == 0)
			System.out.println("No denominations to form given :"+n);
		else
			System.out.println(denominiations);
		
		denominiations.clear();
		
		obj.findMinCoinsGeeksForGeeks(n,coins,denominiations);
		if(denominiations.size() == 0)
			System.out.println("No denominations to form given :"+n);
		else
			System.out.println(denominiations);
		
	}

	public void findMinCoins(int n, int[] coins, List<Integer> denominiations) {
		Arrays.sort(coins);
		
		for(int i=0;i<coins.length-1;i++){
			if(coins[i+1] > n){
				denominiations.add(coins[i]);
				n = n-coins[i];
				if(n <= 0) break;
				i=-1;
			}
			else if(i+1 == coins.length-1){
				denominiations.add(coins[i+1]);
				n = n-coins[i+1];
				if(n <= 0) break;
				i=-1;
			}
			
		}
	
		if(n<0) denominiations.clear();
	}

	public void findMinCoinsGeeksForGeeks(int n, int[] coins, List<Integer> denominiations) {
		Arrays.sort(coins);
		
		for(int i=coins.length-1;i>=0;i--){
			while(n >= coins[i]){
				n = n-coins[i];
				denominiations.add(coins[i]);
			}
		}
	
		if(n<0) denominiations.clear();
	}

}
