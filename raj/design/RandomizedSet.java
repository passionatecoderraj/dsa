package com.raj.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author Raj
 *
 *Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */
public class RandomizedSet {
	Map<Integer, Integer> nums;
	ArrayList<Integer> locations;
	Random rand = new Random();

	/** Initialize your data structure here. */
	public RandomizedSet() {
		nums = new HashMap<>();
		locations = new ArrayList<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (!nums.containsKey(val)) {
			nums.put(val, locations.size());
			locations.add(val);
			return true;
		}
		return false;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (nums.containsKey(val)) {
			if (nums.size() > 1) {
				int last_val = locations.get(locations.size() - 1);
				int cur_val_idx = nums.get(val);
				locations.set(cur_val_idx, last_val);
				nums.put(last_val, cur_val_idx);
			}

			nums.remove(val);
			locations.remove(locations.size() - 1);

			return true;
		}
		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return locations.get(rand.nextInt(locations.size()));
	}

	public static void main(String... args) {
		// Init an empty set.
		RandomizedSet randomSet = new RandomizedSet();
		boolean res = false;
		int result = -1;
		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		res = randomSet.insert(1);
		System.out.println(res);
		// Returns false as 2 does not exist in the set.
		res = randomSet.remove(2);
		System.out.println(res);

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		res = randomSet.insert(2);
		System.out.println(res);

		// getRandom should return either 1 or 2 randomly.
		result = randomSet.getRandom();
		System.out.println(result);

		// Removes 1 from the set, returns true. Set now contains [2].
		res = randomSet.remove(1);
		System.out.println(res);

		// 2 was already in the set, so return false.
		res = randomSet.insert(2);
		System.out.println(res);

		// Since 2 is the only number in the set, getRandom always return 2.
		result = randomSet.getRandom();
		System.out.println(result);
	}
}
