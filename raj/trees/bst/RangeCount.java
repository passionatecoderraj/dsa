/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class RangeCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 3);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 14);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 7);
		tree.root = tree.insert(tree.root, 13);
		tree.postOrder(tree.root);
		System.out.println();
		RangeCount obj = new RangeCount();

		int result = -1, k1 = 1, k2 = 7;
		result = obj.rangeCount(tree.root, k1, k2);
		System.out.println(result);
		// obj.printRangeWithoutRecursion(tree.root, k1, k2);

	}

	// k1 < k2
	public int rangeCount(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (null == root)
			return 0;
		if (root.data >= k1 && root.data <= k2) {
			return 1 + rangeCount(root.left, k1, k2) + rangeCount(root.right, k1, k2);
		} else if (root.data > k2) {
			return rangeCount(root.left, k1, k2);
		} else if (root.data < k1) {
			return rangeCount(root.right, k1, k2);
		}
		return 0;

	}

}
