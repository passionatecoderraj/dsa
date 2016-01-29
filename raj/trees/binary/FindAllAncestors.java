/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class FindAllAncestors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindAllAncestors obj = new FindAllAncestors();

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
		int k = 7;
		result = obj.printAllAncestors(root, k);
		System.out.println(result);
	}

	public boolean printAllAncestors(BinaryTreeNode<Integer> root, int k) {
		if (null == root) {
			return false;
		}
		if (root.data == k) {
			System.out.println(root.data);
			return true;
		}
		if (printAllAncestors(root.left, k) || printAllAncestors(root.right, k)) {
			System.out.println(root.data);
			return true;
		}
		return false;
	}

}
