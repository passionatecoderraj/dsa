package com.raj.bit;

public class TestStuff {

	public static void main(String[] args) {
		int a,b;
		a = 4;
		b = ~a;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(a&b);
	}

}
