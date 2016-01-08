/**
 * 
 */
package com.raj.trees.bst;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class InorderReverse {

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
		InorderReverse obj = new InorderReverse();

		obj.inorderReverse(tree.root);
		System.out.println();
	}

	public void inorderReverse(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp = root;
		while (true) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.right;
			} else {
				if (stack.isEmpty())
					break;
				BinaryTreeNode<Integer> pop = stack.pop();
				System.out.print(pop.data + " ");
				temp = pop.left;
			}
		}
		System.out.println();
	}

}
