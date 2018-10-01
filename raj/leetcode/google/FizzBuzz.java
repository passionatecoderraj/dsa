package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Raj
 * 
 * Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
 *
 */

public class FizzBuzz {

	// without using %
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1, fizz = 1, buzz = 1; i <= n; i++, fizz++, buzz++) {
			if (fizz == 3 && buzz == 5) {
				res.add("FizzBuzz");
				fizz = buzz = 0;
			} else if (fizz == 3) {
				res.add("Fizz");
				fizz = 0;
			} else if (buzz == 5) {
				res.add("Buzz");
				buzz = 0;
			} else {
				res.add(Integer.toString(i));
			}
		}
		return res;
	}

	public List<String> fizzBuzz2(int n) {
		List<String> res = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				res.add("FizzBuzz");
			else if (i % 3 == 0)
				res.add("Fizz");
			else if (i % 5 == 0)
				res.add("Buzz");
			else
				res.add(Integer.toString(i));
		}
		return res;
	}

	public static void main(String... args) {
		FizzBuzz obj = new FizzBuzz();
		List<String> res = null;
		res = obj.fizzBuzz(15);
		System.out.println(res);
	}
}
