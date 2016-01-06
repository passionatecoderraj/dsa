/**
 * 
 */
package com.raj.trees.bst;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.BinaryTreeNode;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class SortedListToBalancedBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(11);
		obj.insert(12);
		obj.insert(13);
		obj.insert(14);
		obj.insert(15);
		obj.insert(16);

		obj.print();
		SortedListToBalancedBST ob = new SortedListToBalancedBST();

		// Time : O(n), Space : O(n)
		ob.head = obj.root;
		BinaryTreeNode<Integer> root = ob.listToBST(0, obj.length() - 1);
		new BinarySearchTree().preOrder(root);
		System.out.println();
		new BinarySearchTree().inOrder(root);
		System.out.println();
		new BinarySearchTree().levelOrder(root);
		System.out.println();
	}

	ListNode<Integer> head = null;

	public BinaryTreeNode<Integer> listToBST(int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		BinaryTreeNode<Integer> left = listToBST(start, mid - 1);

		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(head.data);
		head = head.next;
		BinaryTreeNode<Integer> right = listToBST(mid + 1, end);

		node.left = left;
		node.right = right;
		return node;
	}
}
