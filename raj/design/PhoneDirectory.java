package com.raj.design;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Raj
 *
 *Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
 */
public class PhoneDirectory {

	Set<Integer> set = new HashSet<>();

	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers
	 *            - The maximum numbers that can be stored in the phone
	 *            directory.
	 */
	public PhoneDirectory(int n) {
		for (int i = 0; i < n; i++) {
			set.add(i);
		}
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {
		if (set.isEmpty()) {
			return -1;
		}
		int num = set.iterator().next();
		set.remove(num);
		return num;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return set.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		set.add(number);
	}

	public static void main(String... args) {
		// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
		PhoneDirectory directory = new PhoneDirectory(3);
		int result = -1;
		boolean res = false;
		// It can return any available phone number. Here we assume it returns
		// 0.
		result = directory.get();
		System.out.println(result);

		// Assume it returns 1.
		result = directory.get();
		System.out.println(result);

		// The number 2 is available, so return true.
		res = directory.check(2);
		System.out.println(res);

		// It returns 2, the only number that is left.
		result = directory.get();
		System.out.println(result);

		// The number 2 is no longer available, so return false.
		res = directory.check(2);
		System.out.println(res);

		// Release number 2 back to the pool.
		directory.release(2);

		// Number 2 is available again, return true.
		res = directory.check(2);
		System.out.println(res);
	}
}
