/**
 *
 */
package com.raj.trees.binary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *         //@formatter:off
 *
 *         Given a binary tree with n nodes, your task is to check if it's
 *         possible to partition the tree to two trees which have the equal sum
 *         of values after removing exactly one edge on the original tree.
 * 
 *         Example 1: Input: 5 / \ 10 10 / \ 2 3
 * 
 *         Output: True Explanation: 5 / 10
 * 
 *         Sum: 15
 * 
 *         10 / \ 2 3
 * 
 *         Sum: 15 Example 2: Input: 1 / \ 2 10 / \ 2 20
 * 
 *         Output: False Explanation: You can't split the tree into two trees
 *         with equal sum after removing exactly one edge on the tree.
 * 
 *         //@formatter:on
 */
public class EqualTreePartition {

	/*
	 * that if the total root.val = 0 and it's leftchild sum = -k, right child
	 * sum = k, we will always return true cuz root node has sum/2=0...
	 * 
	 * So I think we should not add the root-sum into HashMap, that will solve
	 * the problem. In fact under any circumstances, we do not expect to cut the
	 * root node:)
	 * 
	 * We cannot cut the root node by removing only one edge	
	 * 
	 * https://discuss.leetcode.com/topic/100179/java-c-simple-solution-with-
	 * only-one-hashmap/11
	 */
	public boolean checkEqualTree(BinaryTreeNode<Integer> root) {
		Set<Integer> set = new HashSet<>();
		int sum = treeSum(root, root, set);
		return sum % 2 == 0 && set.contains(sum / 2);
	}

	private int treeSum(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> root, Set<Integer> set) {
		if (null == node) {
			return 0;
		}
		int sum = node.data + treeSum(node.left, root, set) + treeSum(node.right, root, set);
		if (node != root) {
			set.add(sum);
		}
		return sum;
	}

	/*
	 * The idea is to use a hash table to record all the different sums of each
	 * subtree in the tree. If the total sum of the tree is sum, we just need to
	 * check if the hash table constains sum/2.
	 * 
	 * The following code has the correct result at a special case when the tree
	 * is [0,-1,1], which many solutions dismiss. I think this test case should
	 * be added.
	 * 
	 */
	public boolean checkEqualTree2(BinaryTreeNode<Integer> root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = getSum(root, map);
		if (sum == 0)
			return map.getOrDefault(sum, 0) > 1;
		return sum % 2 == 0 && map.containsKey(sum / 2);
	}

	public int getSum(BinaryTreeNode<Integer> root, Map<Integer, Integer> map) {
		if (root == null)
			return 0;
		int cur = root.data + getSum(root.left, map) + getSum(root.right, map);
		map.put(cur, map.getOrDefault(cur, 0) + 1);
		return cur;
	}

	public static void main(String[] args) {
		EqualTreePartition obj = new EqualTreePartition();

		BinaryTree ob = new BinaryTree();
		ob.insert(5);
		ob.insert(10);
		ob.insert(10);
		ob.insert(2);
		ob.insert(3);

		boolean res = false;
		res = obj.checkEqualTree(ob.root);
		System.out.println(res);
	}

}
