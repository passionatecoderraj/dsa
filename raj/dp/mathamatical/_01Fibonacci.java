package com.raj.dp.mathamatical;

public class _01Fibonacci {

	public static void main(String[] args) {
		_01Fibonacci obj = new _01Fibonacci();
		int n = 20;
		int result =-1;
		result = obj.fibBruteForce(n);
		System.out.println(result);
		result = obj.fibBottomUpBigOn(n);
		System.out.println(result);
		obj.init(n);
		result = obj.fibTopDown(n);
		System.out.println(result);
		result = obj.fibWithoutStoring(n);
		System.out.println(result);
		
	}

	public int fibWithoutStoring(int n) {
		int a=0, b=1, sum=1;
		for(int i=2;i<=n;i++){
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}

	int f[];
	public void init(int n){
		f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		for(int i=2;i<=n;i++)
			f[i] = -1;
	}
	public int fibTopDown(int n) {
		if(f[n] == -1){
			f[n] = fibTopDown(n-1) + fibTopDown(n-2);
		}
		
		return f[n];
	}

	public int fibBottomUpBigOn(int n) {
		int[] fib = new int[n+1];
		if(n < 0) return -1;
		
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2;i<=n;i++){
			fib[i] = fib[i-1]+fib[i-2];
		}
		return fib[n];
	}

	public int fibBruteForce(int n) {
		if(n < 0) return -1;
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		else 
			return fibBruteForce(n-1)+fibBruteForce(n-2);
	}
	

}
