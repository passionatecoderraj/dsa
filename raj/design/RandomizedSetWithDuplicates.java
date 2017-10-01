package com.raj.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 */
public class RandomizedSetWithDuplicates {
	ArrayList<Integer> locations;
	HashMap<Integer, Set<Integer>> nums;
	Random rand = new Random();

	/** Initialize your data structure here. */
	public RandomizedSetWithDuplicates() {
		locations = new ArrayList<>();
		nums = new HashMap<>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean contains = nums.containsKey(val);
		if (!contains) {
			nums.put(val, new LinkedHashSet<Integer>());
		}
		nums.get(val).add(locations.size());
		locations.add(val);
		return !contains;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		boolean contain = nums.containsKey(val);
		if (!contain)
			return false;
		int cur_val_idx = nums.get(val).iterator().next();
		nums.get(val).remove(cur_val_idx);
		if (cur_val_idx < locations.size() - 1) {
			int last_val = locations.get(locations.size() - 1);
			locations.set(cur_val_idx, last_val);
			nums.get(last_val).remove(locations.size() - 1);
			nums.get(last_val).add(cur_val_idx);
		}
		locations.remove(locations.size() - 1);

		if (nums.get(val).isEmpty()) {
			nums.remove(val);
		}
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return locations.get(rand.nextInt(locations.size()));
	}

	public static void main(String... args) {
		// Init an empty set.
		RandomizedSetWithDuplicates randomSet = new RandomizedSetWithDuplicates();
		boolean res = false;
		int result = -1;
		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		res = randomSet.insert(1);
		System.out.println(res);

		// Inserts another 1 to the collection. Returns false as the collection
		// contained 1. Collection now contains [1,1]
		res = randomSet.insert(1);
		System.out.println(res);

		// Inserts 2 to the collection, returns true. Collection now contains
		// [1,1,2].
		res = randomSet.insert(2);
		System.out.println(res);

		result = randomSet.getRandom();
		System.out.println(result);

		// Removes 1 from the set, returns true. Set now contains [2].
		res = randomSet.remove(1);
		System.out.println(res);

		result = randomSet.getRandom();
		System.out.println(result);
	}
}
