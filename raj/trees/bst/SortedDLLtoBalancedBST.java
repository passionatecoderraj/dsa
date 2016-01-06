/**
 * 
 */
package com.raj.trees.bst;

import com.raj.linkedlist.DoubleLinkedList;
import com.raj.nodes.DLLNode;

/**
 * @author Raj
 *
 */
public class SortedDLLtoBalancedBST {

	public void inOrder(DLLNode<Integer> node) {
		if (node != null) {
			inOrder(node.prev);
			System.out.print(node.data + " ");
			inOrder(node.next);
		}
	}

	public void preOrder(DLLNode<Integer> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.prev);
			preOrder(node.next);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleLinkedList<Integer> obj = new DoubleLinkedList<Integer>();
		obj.insert(11);
		obj.insert(12);
		obj.insert(13);
		obj.insert(14);
		obj.insert(15);
		obj.insert(16);

		DoubleLinkedList<Integer> obj2 = new DoubleLinkedList<Integer>();
		obj2.insert(11);
		obj2.insert(12);
		obj2.insert(13);
		obj2.insert(14);
		obj2.insert(15);
		obj2.insert(16);
		obj.print();

		SortedDLLtoBalancedBST ob = new SortedDLLtoBalancedBST();

		// Tree construction is top down here
		// Time : O(nlogn), Space : O(1)
		DLLNode<Integer> root1 = ob.dllToBST(obj.root);
		ob.inOrder(root1);
		System.out.println();
		ob.preOrder(root1);
		System.out.println();

		// Tree construction is bottom up here
		// Time : O(n), Space : O(1)
		ob.head = obj2.root;
		DLLNode<Integer> root2 = ob.dllToBSTBottomup(obj2.length());
		ob.inOrder(root2);
		System.out.println();
		ob.preOrder(root2);
		System.out.println();

	}

	DLLNode<Integer> head = null;

	public DLLNode<Integer> dllToBSTBottomup(int n) {
		if (n <= 0)
			return null;
		DLLNode<Integer> left = dllToBSTBottomup(n / 2);
		DLLNode<Integer> node = head;
		head = head.next;
		DLLNode<Integer> right = dllToBSTBottomup(n - n / 2 - 1);
		node.prev = left;
		node.next = right;
		return node;
	}

	public DLLNode<Integer> dllToBST(DLLNode<Integer> root) {
		if (root == null || root.next == null) {
			return root;
		}
		DLLNode<Integer> mid = middle(root);
		if (mid.prev != null)
			mid.prev.next = null;

		mid.prev = dllToBST(root);
		if (mid.next != null)
			mid.next.prev = null;
		mid.next = dllToBST(mid.next);
		return mid;
	}

	public DLLNode<Integer> middle(DLLNode<Integer> root) {
		DLLNode<Integer> slow, fast;
		slow = fast = root;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
