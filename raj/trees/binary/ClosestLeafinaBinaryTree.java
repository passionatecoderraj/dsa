/**
 *
 */
package com.raj.trees.binary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
Examples:

              A
            /    \    
           B       C
                 /   \  
                E     F   
               /       \
              G         H
             / \       /
            I   J     K

Closest leaf to 'H' is 'K', so distance is 1 for 'H'
Closest leaf to 'C' is 'B', so distance is 2 for 'C'
Closest leaf to 'E' is either 'I' or 'J', so distance is 2 for 'E' 
Closest leaf to 'B' is 'B' itself, so distance is 0 for 'B' 
 * 
 */
public class ClosestLeafinaBinaryTree {

	/*
	 * to understand problem definition :
	 * https://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
	 * 
	 * Solution: https://discuss.leetcode.com/topic/113482/java-dfs-bfs-27ms
	 */

	public int findClosestLeaf(BinaryTreeNode<Integer> root, int k) {
		// store all edges that trace node back to its parent
		Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> backMap = new HashMap<>();
		BinaryTreeNode<Integer> search = dfs(root, k, backMap);
		if (null == search)
			return -1;

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
		q.offer(search);
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> cur = q.poll();
			if (cur.left == null && cur.right == null)
				return cur.data;
			visited.add(cur);

			if (cur.left != null && !visited.contains(cur.left))
				q.offer(cur.left);
			if (cur.right != null && !visited.contains(cur.right))
				q.offer(cur.right);
			if (backMap.containsKey(cur) && !visited.contains(backMap.get(cur))) {
				q.offer(backMap.get(cur));
			}
		}
		return -1;
	}

	private BinaryTreeNode<Integer> dfs(BinaryTreeNode<Integer> root, int k,
			Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> backMap) {
		if (null == root || root.data == k) {
			return root;
		}
		if (root.left != null) {
			backMap.put(root.left, root);
			BinaryTreeNode<Integer> left = dfs(root.left, k, backMap);
			if (left != null)
				return left;
		}

		if (root.right != null) {
			backMap.put(root.right, root);
			BinaryTreeNode<Integer> right = dfs(root.right, k, backMap);
			if (right != null)
				return right;
		}
		return null;
	}

	public static void main(String[] args) {
		ClosestLeafinaBinaryTree obj = new ClosestLeafinaBinaryTree();

		BinaryTreeNode<Integer> root = obj.createTestAlmostCompleteBinaryTree();
		int res = -1;

		res = obj.findClosestLeaf(root, 3);
		System.out.println(res);

		res = obj.findClosestLeaf(root, 4);
		System.out.println(res);

		res = obj.findClosestLeaf(root, 8);
		System.out.println(res);

		res = obj.findClosestLeaf(root, 2);
		System.out.println(res);

	}

	public BinaryTreeNode<Integer> createTestAlmostCompleteBinaryTree() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> n9 = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> n10 = new BinaryTreeNode<Integer>(8);

		n1.left = n2;
		n1.right = n3;

		n3.left = n4;
		n3.right = n5;

		n4.left = n6;
		n5.right = n7;

		n6.left = n8;
		n6.right = n9;

		n7.left = n10;

		return n1;
	}

}
