/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class CheckIfTwoNodesAreSiblings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIfTwoNodesAreSiblings obj = new CheckIfTwoNodesAreSiblings();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTreeNode<Integer> root = ob.root;

		boolean result = false;
		result = obj.checkIfTwoNodesAreSiblings(root, 6, 7);
		System.out.println(result);

		result = obj.checkIfTwoNodesAreSiblings(root, 6, 8);
		System.out.println(result);

	}

	// Time : O(n)
	public boolean checkIfTwoNodesAreSiblings(BinaryTreeNode<Integer> root, int a, int b) {
		if (root == null)
			return false;
		if (root.left != null && (root.left.data == a || root.left.data == b)) {
			if (root.left.data == a) {
				if (root.right != null && root.right.data == b)
					return true;
			}
			if (root.left.data == b) {
				if (root.right != null && root.right.data == a)
					return true;
			}
		}

		return checkIfTwoNodesAreSiblings(root.left, a, b) || checkIfTwoNodesAreSiblings(root.right, a, b);
	}

}
