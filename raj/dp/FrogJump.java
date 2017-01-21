/**
 * 
 */
package com.raj.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Raj
 *
 *         A frog is crossing a river. The river is divided into x units and at
 *         each unit there may or may not exist a stone. The frog can jump on a
 *         stone, but it must not jump into the water.
 * 
 *         Given a list of stones' positions (in units) in sorted ascending
 *         order, determine if the frog is able to cross the river by landing on
 *         the last stone. Initially, the frog is on the first stone and assume
 *         the first jump must be 1 unit.
 * 
 *         If the frog's last jump was k units, then its next jump must be
 *         either k - 1, k, or k + 1 units. Note that the frog can only jump in
 *         the forward direction.
 * 
 *         [0,1,3,5,6,8,12,17]
 * 
 *         There are a total of 8 stones. The first stone at the 0th unit,
 *         second stone at the 1st unit, third stone at the 3rd unit, and so
 *         on... The last stone at the 17th unit.
 * 
 *         Return true. The frog can jump to the last stone by jumping 1 unit to
 *         the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th
 *         stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5
 *         units to the 8th stone.
 */
public class FrogJump {

	// Time : O(n), Space : O(n)
	public static boolean canFrogJumpToEnd(int[] stones) {
		Map<Integer, HashSet<Integer>> map = new LinkedHashMap<>();
		for (int num : stones) {
			map.put(num, new HashSet<>());
		}
		map.get(0).add(1);
		for (Integer num : map.keySet()) {
			for (Integer val : map.get(num)) {
				List<Integer> reach = new ArrayList<Integer>();
				if (val > 1)
					reach.add(val - 1);
				reach.add(val);
				if (num != 0)
					reach.add(val + 1);
				for (int step : reach) {
					int key = num + step;
					if (map.containsKey(key)) {
						if (key == stones[stones.length - 1])
							return true;
						map.get(key).add(step);
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 0, 1, 3, 5, 6, 8, 12, 17 };
		boolean result = false;
		result = canFrogJumpToEnd(a);
		System.out.println(result);

		int b[] = { 0, 1, 2, 3, 4, 8, 9, 11 };
		result = canFrogJumpToEnd(b);
		System.out.println(result);

		int c[] = { 0, 2 };
		result = canFrogJumpToEnd(c);
		System.out.println(result);

	}

}
