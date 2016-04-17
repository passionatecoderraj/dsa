/**
 * 
 */
package com.raj.trees.binary;

import java.util.LinkedList;
import java.util.Queue;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */

/*
 * http://algorithms.tutorialhorizon.com/print-right-view-of-a-given-binary-
 * tree/
 */
public class PrintLeftViewOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintLeftViewOfTree obj = new PrintLeftViewOfTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		obj.printLeftViewOfTree(ob.root);
	}

	// Time : O(n)
	public void printLeftViewOfTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

		q.add(root);
		q.add(null);
		BinaryTreeNode<Integer> tmp2 = null, temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp == null) {
				if (q.isEmpty())
					break;
				tmp2 = null;
				q.add(null);
				continue;
			}
			if (null == tmp2) {
				tmp2 = temp;
				System.out.print(tmp2.data + " ");
			}
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}

}
