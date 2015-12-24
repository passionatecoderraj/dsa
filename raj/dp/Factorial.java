package com.raj.dp;

public class Factorial {

	public static void main(String[] args) {
		Factorial obj = new Factorial();
		int result = -1, n =5;
		
		result = obj.factorial(n);
		System.out.println(result);
	}

	public int factorial(int n) {
		if(n < 0) return -1;
		else if(n ==0 || n == 1) return 1;
		else{
			return n*factorial(n-1);
		}
	}
	

}
