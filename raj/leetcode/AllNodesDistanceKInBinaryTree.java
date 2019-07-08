/**
 *
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj Given a non-empty binary tree, return the average value of the
 *         nodes on each level in the form of an array. Example 1: Input: 3 / \
 *         9 20 / \ 15 7 Output: [3, 14.5, 11] Explanation: The average value of
 *         nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 *         Hence return [3, 14.5, 11]. Note: The range of node's value is in the
 *         range of 32-bit signed integer.
 */
public class AllNodesDistanceKInBinaryTree {

	BinaryTreeNode<Integer> found = null;

	public List<Integer> distanceK(BinaryTreeNode<Integer> root, int target, int K) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, BinaryTreeNode<Integer>> map = new HashMap<>();
		dfs(root, map, target);
		if (null == found) {
			return res;
		}
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(found);
		Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
		while (!q.isEmpty() && K-- > 0) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				BinaryTreeNode<Integer> temp = q.poll();
				visited.add(temp);
				if (temp.left != null && !visited.contains(temp.left)) {
					q.offer(temp.left);
				}
				if (temp.right != null && !visited.contains(temp.right)) {
					q.offer(temp.right);
				}
				if (map.containsKey(temp.data) &&  temp.data !=root.data && !visited.contains(map.get(temp.data))) {
					q.offer(map.get(temp.data));
				}
			}

		}
		while (!q.isEmpty())
			res.add(q.poll().data);
		return res;
	}
	
	public List<Integer> distanceK2(BinaryTreeNode<Integer> root, int target, int K) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, BinaryTreeNode<Integer>> map = new HashMap<>();
		dfs(root, map, target);
		if (null == found) {
			return res;
		}
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(found);
		Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
		while (!q.isEmpty() && K-- > 0) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				BinaryTreeNode<Integer> temp = q.poll();
				visited.add(temp);
				if (temp.left != null && !visited.contains(temp.left)) {
					q.offer(temp.left);
				}
				if (temp.right != null && !visited.contains(temp.right)) {
					q.offer(temp.right);
				}
				if (map.containsKey(temp.data) && !visited.contains(map.get(temp.data))) {
					q.offer(map.get(temp.data));
				}
			}

		}
		while (!q.isEmpty())
			res.add(q.poll().data);
		return res;
	}

	public void dfs(BinaryTreeNode<Integer> root, Map<Integer, BinaryTreeNode<Integer>> map, int target) {
		if (null == root)
			return;

		if (root.left != null) {
			map.put(root.left.data, root);
			dfs(root.left, map, target);
		}

		if (root.right != null) {
			map.put(root.right.data, root);
			dfs(root.right, map, target);
		}

		if (root.data == target) {
			found = root;
		}
	}

	public static void main(String[] args) {
		AllNodesDistanceKInBinaryTree obj = new AllNodesDistanceKInBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(3);
		ob.insert(5);
		ob.insert(1);
		ob.insert(6);
		ob.insert(2);
		ob.insert(0);
		ob.insert(8);
		ob.insert(7);
		ob.insert(4);

		int target = 5, K = 2;
		List<Integer> res = new ArrayList<>();
		res = obj.distanceK(ob.root, target, K);
		System.out.println(res);

	}

}
