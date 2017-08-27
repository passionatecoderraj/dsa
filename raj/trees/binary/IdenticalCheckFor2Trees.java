/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class IdenticalCheckFor2Trees {

	public boolean isStructurallyIdentical(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;
		return isStructurallyIdentical(root1.left, root2.left) && isStructurallyIdentical(root1.right, root2.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IdenticalCheckFor2Trees obj = new IdenticalCheckFor2Trees();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);

		BinaryTree ob2 = new BinaryTree();
		ob2.insert(1);
		ob2.insert(2);
		ob2.insert(3);
		ob2.insert(4);
		ob2.insert(54);

		boolean result = false;
		result = obj.isStructurallyIdentical(ob.root, ob2.root);
		System.out.println(result);

	}

}
