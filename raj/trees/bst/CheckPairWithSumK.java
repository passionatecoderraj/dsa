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
public class CheckPairWithSumK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.insert(tree.root, 15);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 16);
		tree.root = tree.insert(tree.root, 25);
		tree.inOrder(tree.root);
		System.out.println();
		CheckPairWithSumK obj = new CheckPairWithSumK();

		int k = 26;
		obj.checkPairWithSumK(tree.root, k);
		System.out.println();
	}

	public void checkPairWithSumK(BinaryTreeNode<Integer> root, int k) {
		if (null == root) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<BinaryTreeNode<Integer>>();

		BinaryTreeNode<Integer> temp1 = root, temp2 = root;
		BinaryTreeNode<Integer> pop1 = null, pop2 = null;
		boolean isPairFound = false;
		while (true) {
			if (temp1 != null || temp2 != null) {
				if (temp1 != null) {
					stack1.push(temp1);
					temp1 = temp1.left;
				}
				if (temp2 != null) {
					stack2.push(temp2);
					temp2 = temp2.right;
				}
			} else {
				if (stack1.isEmpty() || stack2.isEmpty())
					break;

				pop1 = stack1.pop();
				pop2 = stack2.pop();
				if (pop1.data + pop2.data > k) {
					temp2 = pop2.left;
					stack1.push(pop1);
				} else if (pop1.data + pop2.data < k) {
					temp1 = pop1.right;
					stack2.push(pop2);
				} else {
					isPairFound = true;
					break;
				}
			}
		}
		if (isPairFound)
			System.out.println("1st=" + pop1.data + ", 2nd=" + pop2.data + ", Sum=" + k);
		else
			System.out.println("Pair Not found");
	}

}
