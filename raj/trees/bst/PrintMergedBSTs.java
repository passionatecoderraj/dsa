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
public class PrintMergedBSTs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.insert(tree.root, 100);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 300);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 70);
		tree.inOrder(tree.root);
		System.out.println();

		BinarySearchTree tree2 = new BinarySearchTree();
		tree2.root = tree.insert(tree2.root, 80);
		tree2.root = tree.insert(tree2.root, 40);
		tree2.root = tree.insert(tree2.root, 120);
		tree2.inOrder(tree2.root);
		System.out.println();

		PrintMergedBSTs obj = new PrintMergedBSTs();

		// google interview quesiont
		// Time : O(m+n), Space : O(m+n)
		obj.printMergedBSTS(tree, tree2);

	}

	public void printMergedBSTS(BinarySearchTree tree1, BinarySearchTree tree2) {
		if (null == tree1.root && null == tree2.root)
			return;
		else if (null == tree1.root) {
			tree2.inOrder(tree2.root);
			return;
		} else if (null == tree2.root) {
			tree1.inOrder(tree1.root);
			return;
		}

		BinaryTreeNode<Integer> temp1 = null, temp2 = null, pop1, pop2;
		Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<BinaryTreeNode<Integer>>();
		temp1 = tree1.root;
		temp2 = tree2.root;

		while (true) {
			if (temp1 != null || temp2 != null) {
				if (temp1 != null) {
					stack1.addFirst(temp1);
					temp1 = temp1.left;
				}
				if (temp2 != null) {
					stack2.addFirst(temp2);
					temp2 = temp2.left;
				}
			} else {

				// TODO: here program is not right, when one of the stacks is
				// empty it should print rest of the keys in other stack. That
				// logic needs to be fixed.
				if (stack1.isEmpty() && stack2.isEmpty())
					break;
				else if (stack1.isEmpty()) {
					tree2.inOrder(stack1.removeFirst());
					break;
				} else if (stack2.isEmpty()) {
					tree1.inOrder(stack1.removeFirst());
					break;
				}
				pop1 = stack1.removeFirst();
				pop2 = stack2.removeFirst();
				if (pop1.data < pop2.data) {
					System.out.print(pop1.data + " ");
					temp1 = pop1.right;
					stack2.addFirst(pop2);
					pop2 = null;
				} else {
					System.out.print(pop2.data + " ");
					temp2 = pop2.right;
					stack1.addFirst(pop1);
					pop1 = null;
				}

			}
		}
	}

}
