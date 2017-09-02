/**
 *
 */
package com.raj.trees.binary;

import java.util.HashMap;
import java.util.Map;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 * 
 *         Given a binary tree, write a function to get the maximum width of the
 *         given tree. The width of a tree is the maximum width among all
 *         levels. The binary tree has the same structure as a full binary tree,
 *         but some nodes are null. The width of one level is defined as the
 *         length between the end-nodes (the leftmost and right most non-null
 *         nodes in the level, where the null nodes between the end-nodes are
 *         also counted into the length calculation.
 */
public class MaxWidthOfaBinaryTree {

	public int maxWidthOfaBinaryTree(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return 0;
		}
		Map<Integer, int[]> map = new HashMap<>();
		findMax(map, root, 0, 1);
		int max = 1;
		for (int[] res : map.values()) {
			max = Math.max(max, res[1] - res[0] + 1);
		}
		return max;
	}

	private void findMax(Map<Integer, int[]> map, BinaryTreeNode<Integer> root, int level, int position) {
		if (null == root) {
			return;
		}
		int res[] = map.get(level);
		if (null == res) {
			res = new int[2];
			res[0] = Integer.MAX_VALUE;
			res[1] = Integer.MIN_VALUE;
			map.put(level, res);
		}

		res[0] = Math.min(res[0], position);
		res[1] = Math.max(res[1], position);
		findMax(map, root.left, level + 1, 2 * position);
		findMax(map, root.right, level + 1, 2 * position + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxWidthOfaBinaryTree obj = new MaxWidthOfaBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTreeNode<Integer> l1 = obj.createTestTree1();
		BinaryTreeNode<Integer> l2 = obj.createTestTree2();

		int res = -1;
		res = obj.maxWidthOfaBinaryTree(l1);
		System.out.println(res);

		res = obj.maxWidthOfaBinaryTree(l2);
		System.out.println(res);
	}

	public BinaryTreeNode<Integer> createTestTree1() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> n9 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> n10 = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> n11 = new BinaryTreeNode<Integer>(11);
		BinaryTreeNode<Integer> n12 = new BinaryTreeNode<Integer>(12);
		BinaryTreeNode<Integer> n13 = new BinaryTreeNode<Integer>(13);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n5.right = n7;
		n3.right = n8;
		n8.right = n9;
		n9.left = n10;
		n9.right = n11;
		n10.left = n12;
		n10.right = n13;

		return n1;
	}

	public BinaryTreeNode<Integer> createTestTree2() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> n9 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> n10 = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> n11 = new BinaryTreeNode<Integer>(11);
		BinaryTreeNode<Integer> n12 = new BinaryTreeNode<Integer>(12);
		BinaryTreeNode<Integer> n13 = new BinaryTreeNode<Integer>(13);
		BinaryTreeNode<Integer> n14 = new BinaryTreeNode<Integer>(14);
		BinaryTreeNode<Integer> n15 = new BinaryTreeNode<Integer>(15);

		n1.left = n2;
		n1.right = n3;
		n3.right = n4;
		n2.left = n5;
		n2.right = n6;

		n5.left = n7;
		n5.right = n8;
		n8.left = n9;
		n9.left = n10;
		n9.right = n11;
		n6.right = n12;
		n12.left = n13;
		n12.right = n14;
		n14.right = n15;
		return n1;
	}

}
