/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.raj.nodes.NestedInteger;
import com.raj.nodes.NestedIntegerImpl;

/**
 * @author Raj
 *
 *         Given a nested list of integers, return the sum of all integers in
 *         the list weighted by their depth.
 * 
 *         Each element is either an integer, or a list -- whose elements may
 *         also be integers or other lists.
 * 
 *         Different from the previous question where weight is increasing from
 *         root to leaf, now the weight is defined from bottom up. i.e., the
 *         leaf level integers have weight 1, and the root level integers have
 *         the largest weight.
 * 
 *         Example 1: Given the list [[1,1],2,[1,1]], return 8. (four 1's at
 *         depth 1, one 2 at depth 2)
 * 
 *         Example 2: Given the list [1,[4,[6]]], return 17. (one 1 at depth 3,
 *         one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */
public class NestedListWeightSum2 {

	public int depthSum(List<NestedInteger> nestedList) {
		if (null == nestedList || nestedList.size() == 0)
			return 0;
		Queue<NestedInteger> queue = new LinkedList<>();

		for (NestedInteger i : nestedList) {
			queue.offer(i);
		}
		int levelSum = 0, prev = 0, total = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger cur = queue.poll();
				if (cur.isInteger()) {
					levelSum += cur.getInteger();
				} else {
					for (NestedInteger item : cur.getList()) {
						queue.offer(item);
					}
				}
			}
			prev += levelSum;
			total += prev;
			levelSum = 0;
		}
		return total;
	}

	public int depthSumUtil(List<NestedInteger> nestedList, int level) {
		int sum = 0;
		for (NestedInteger item : nestedList) {
			if (item.isInteger()) {
				sum += (level * item.getInteger());
			} else {
				sum += depthSumUtil(item.getList(), level + 1);
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NestedListWeightSum2 obj = new NestedListWeightSum2();
		List<NestedInteger> l1 = new ArrayList<>();
		List<NestedInteger> l2 = new ArrayList<>();
		List<NestedInteger> l3 = new ArrayList<>();
		l1.add(new NestedIntegerImpl(1));
		l2.add(new NestedIntegerImpl(4));
		l3.add(new NestedIntegerImpl(6));
		NestedInteger n2 = new NestedIntegerImpl(l2);
		NestedInteger n3 = new NestedIntegerImpl(l3);
		l2.add(n3);
		l1.add(n2);

		int result = obj.depthSum(l1);
		System.out.println(result);
	}

}
