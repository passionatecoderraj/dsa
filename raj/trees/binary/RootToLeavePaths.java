/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class RootToLeavePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RootToLeavePaths obj = new RootToLeavePaths();

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

		int a[] = new int[200];
		obj.printRootToLeavePaths(root, 0, a);
	}

	public void printRootToLeavePaths(BinaryTreeNode<Integer> root, int level, int[] a) {
		if (root == null) {
			return;
		}
		a[level] = root.data;

		if (isLeaf(root)) {
			for (int i = 0; i <= level; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}

		printRootToLeavePaths(root.left, level + 1, a);
		printRootToLeavePaths(root.right, level + 1, a);

	}

	private boolean isLeaf(BinaryTreeNode<Integer> root) {
		return root.left == null && root.right == null;
	}

}
