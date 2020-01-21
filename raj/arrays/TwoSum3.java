/**
 * 
 */
package com.raj.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj
 * 
 *         Design and implement a TwoSum class. It should support the following
 *         operations: add and find.
 * 
 *         add - Add the number to an internal data structure. find - Find if
 *         there exists any pair of numbers which sum is equal to the value.
 * 
 *         For example, add(1); add(3); add(5); find(4) -> true find(7) -> false
 */

public class TwoSum3 {

	class TwoSumUsingSet {
		Set<Integer> numbers;
		Set<Integer> sum;
		int count = 0;

		TwoSumUsingSet() {
			numbers = new HashSet<>();
			sum = new HashSet<>();
		}

		// Time : O(n), Space : O(n)
		void add(int n) {
			count++;
			if (sum.contains(n)) {
				sum.add(2 * n);
			} else {
				for (int i : numbers) {
					sum.add(i + n);
				}
				numbers.add(n);
			}
		}

		// Time : O(1)
		boolean find(int value) {
			return count >= 2 && sum.contains(value);
		}

	}

	class TwoSumUsingMap {
		Map<Integer, Integer> map = new HashMap<>();

		// Time : O(1), Space : O(n)
		void add(int n) {
			map.compute(n, (key, value) -> {
				if (null == value)
					return 1;
				return value + 1;
			});
		}

		// Time : O(n)
		boolean find(int sum) {
			for (int i : map.keySet()) {
				int target = sum - i;
				if (map.containsKey(target)) {
					if (target != i || map.get(target) >= 2)
						return true;
				}
			}
			return false;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TwoSum3 obj = new TwoSum3();
		
	}

}
