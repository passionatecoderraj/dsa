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
public class PrintRightViewOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintRightViewOfTree obj = new PrintRightViewOfTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		obj.printRighViewOfTree(ob.root);
	}

	// Time : O(n)
	public void printRighViewOfTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

		q.add(root);
		q.add(null);
		BinaryTreeNode<Integer> tmp2 = null, temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp == null) {
				System.out.print(tmp2.data + " ");
				if (q.isEmpty())
					break;
				q.add(null);
				continue;
			}
			tmp2 = temp;
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}

}
