/**
 * 
 */
package com.raj.trees.bst;

import java.util.List;

import com.raj.nodes.IntervalTreeNode;

/**
 * @author Raj
 *
 */
/*
 * 
 * 
 */
public class IntervalTree {

	IntervalTreeNode root;

	public IntervalTreeNode insert(IntervalTreeNode root, IntervalTreeNode node) {
		if (null == root) {
			node.max = node.end;
			return node;
		}
		if (root.start > node.start) {
			root.left = insert(root.left, node);
			root.max = Math.max(root.max, node.max);
		} else {
			root.right = insert(root.right, node);
			root.max = Math.max(root.max, node.max);
		}
		return root;
	}

	public void printRootToLeafPaths(IntervalTreeNode root, int index, IntervalTreeNode a[]) {
		if (null == root) {
			return;
		}
		a[index++] = root;

		if (root.left == null && root.right == null) {
			for (int i = 0; i < index; i++) {
				System.out.print(a[i] + "-");
			}
			System.out.println();
			return;
		}
		printRootToLeafPaths(root.left, index, a);
		printRootToLeafPaths(root.right, index, a);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<IntervalTreeNode> result = null;

		IntervalTree obj = new IntervalTree();

		IntervalTreeNode root = null;
		root = obj.insert(root, new IntervalTreeNode(6, 8));
		root = obj.insert(root, new IntervalTreeNode(1, 9));
		root = obj.insert(root, new IntervalTreeNode(10, 14));
		root = obj.insert(root, new IntervalTreeNode(2, 4));
		root = obj.insert(root, new IntervalTreeNode(4, 7));

		IntervalTreeNode a[] = new IntervalTreeNode[1000];
		obj.printRootToLeafPaths(root, 0, a);

	}

}
