/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */

/*
 * http://algorithms.tutorialhorizon.com/given-two-binary-trees-check-if-one-
 * binary-tree-is-a-subtree-of-another/
 */
public class CheckIfTreeIsSubsetOfAnotherTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIfTreeIsSubsetOfAnotherTree obj = new CheckIfTreeIsSubsetOfAnotherTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);

		BinaryTree ob2 = new BinaryTree();
		ob2.insert(3);
		ob2.insert(6);
		ob2.insert(7);

		ob.inOrder(ob.root);
		System.out.println();
		ob2.inOrder(ob2.root);
		System.out.println();

		boolean result = obj.checkIfTreeIsSubTreeOfAnother(ob.root, ob2.root);
		System.out.println(result);

	}

	public String storeInOrder(BinaryTreeNode<Integer> root) {
		if (null == root)
			return "";
		return storeInOrder(root.left) + root.data + storeInOrder(root.right);
	}

	public String storePreOrder(BinaryTreeNode<Integer> root) {
		if (null == root)
			return "";
		return root.data + storePreOrder(root.left) + storePreOrder(root.right);
	}

	// Time : O(n)
	public boolean checkIfTreeIsSubTreeOfAnother(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> root2) {
		String inA = storeInOrder(root);
		String inB = storeInOrder(root2);

		String preA = storePreOrder(root);
		String preB = storePreOrder(root2);

		return inA.contains(inB) && preA.contains(preB);
	}

}
