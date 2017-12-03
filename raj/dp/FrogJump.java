/**
 * 
 */
package com.raj.dp;

import java.util.HashSet;
import java.util.LinkedHashMap;
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
	public boolean canFrogJumpToEnd(int[] stones) {
		Map<Integer, HashSet<Integer>> map = new LinkedHashMap<>();
		for (int num : stones) {
			map.put(num, new HashSet<>());
		}
		map.get(0).add(1);

		for (int i = 0; i < stones.length - 1; i++) {
			int stone = stones[i];
			for (int step : map.get(stone)) {
				int reach = step + stone;
				if (reach == stones[stones.length - 1])
					return true;
				if (map.containsKey(reach)) {
					map.get(reach).add(step);
					map.get(reach).add(step + 1);
					if (step > 1) {
						map.get(reach).add(step - 1);
					}
				}
			}
		}

		return false;
	}

	public boolean canJump(boolean[] a) {
		return util(a, 0, 1, a.length);
	}

	boolean util(boolean[] a, int cur, int step, int target) {
		if (cur >= target)
			return true;
		if (!a[cur] || step <= 0)
			return false;
		return util(a, cur + step - 1, step - 1, target) || util(a, cur + step, step, target)
				|| util(a, cur + step + 1, step + 1, target);
	}

	public static void main(String[] args) {
		int a[] = { 0, 1, 3, 5, 6, 8, 12, 17 };
		boolean result = false;
		FrogJump obj = new FrogJump();
		result = obj.canFrogJumpToEnd(a);
		System.out.println(result);

		int b[] = { 0, 1, 2, 3, 4, 8, 9, 11 };
		result = obj.canFrogJumpToEnd(b);
		System.out.println(result);

		int c[] = { 0, 2 };
		result = obj.canFrogJumpToEnd(c);
		System.out.println(result);

		boolean t[] = { true, false, true, false, false };
		result = obj.canJump(t);
		System.out.println(result);

	}

}
