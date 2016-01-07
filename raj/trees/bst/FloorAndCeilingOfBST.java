/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class FloorAndCeilingOfBST {

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
		tree.inOrder(tree.root);
		System.out.println();
		FloorAndCeilingOfBST obj = new FloorAndCeilingOfBST();

		int key = 25;

		obj.floorAndCeilingOfBST(tree.root, key);
		System.out.println("floor=" + obj.floor + ", ceil=" + obj.ceiling);

	}

	int floor = Integer.MIN_VALUE;
	int ceiling = Integer.MAX_VALUE;

	public void floorAndCeilingOfBST(BinaryTreeNode<Integer> root, int key) {
		if (root == null)
			return;
		if (root.data > key) {
			ceiling = root.data;
			floorAndCeilingOfBST(root.left, key);
		} else if (root.data < key) {
			floor = root.data;
			floorAndCeilingOfBST(root.right, key);
		} else {
			ceiling = key;
			floor = key;
		}
	}
}
