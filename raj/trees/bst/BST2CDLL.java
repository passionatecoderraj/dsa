/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;
import com.raj.nodes.DLLNode;

/**
 * @author Raj
 *
 */
public class BST2CDLL {
	public void printDLL(DLLNode<Integer> head) {
		if (null == head) {
			System.out.println("Empty");
			return;
		}
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public void printDLL(BinaryTreeNode<Integer> head) {
		if (null == head) {
			System.out.println("Empty");
			return;
		}
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
		System.out.println();
	}

	public void printCDLL(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> head = root;
		if (null == head) {
			System.out.println("Empty");
			return;
		}
		while (true) {
			System.out.print(head.data + " ");
			head = head.right;
			if (root == head)
				break;
		}
		System.out.println();
	}

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

		BinarySearchTree tree2 = new BinarySearchTree();
		tree2.root = tree2.insert(tree2.root, 8);
		tree2.root = tree2.insert(tree2.root, 3);
		tree2.root = tree2.insert(tree2.root, 10);
		tree2.root = tree2.insert(tree2.root, 1);
		tree2.root = tree2.insert(tree2.root, 6);
		tree2.root = tree2.insert(tree2.root, 14);
		tree2.root = tree2.insert(tree2.root, 4);
		tree2.root = tree2.insert(tree2.root, 7);
		tree2.root = tree2.insert(tree2.root, 13);

		BST2CDLL obj = new BST2CDLL();
		tree.inOrder(tree.root);
		System.out.println();
		// Time : O(n), Space : O(n)
		obj.bstToDLL(tree.root);
		obj.printDLL(obj.head);

		// Time : O(n), Space : O(1)
		// double linked list
		obj.bstToDLLWithoutExtraSpace(tree.root);
		obj.printDLL(obj.headOfDLL);

		// circular double linked list
		// double linked list
		obj.bstToCDLLWithoutExtraSpace(tree2.root);
		obj.printCDLL(obj.headOfCDLL);
	}

	DLLNode<Integer> prev = null;
	DLLNode<Integer> head = null;

	public void bstToDLL(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		bstToDLL(root.left);

		DLLNode<Integer> node = new DLLNode<Integer>(root.data);
		if (null == head) {
			head = node;
		} else {
			node.prev = prev;
			prev.next = node;
		}
		prev = node;
		bstToDLL(root.right);
	}

	BinaryTreeNode<Integer> headOfDLL = null;
	BinaryTreeNode<Integer> prevOfDLL = null;

	public void bstToDLLWithoutExtraSpace(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		bstToDLLWithoutExtraSpace(root.left);

		BinaryTreeNode<Integer> right = root.right;
		if (null == headOfDLL) {
			headOfDLL = root;
		} else {
			prevOfDLL.right = root;
		}
		root.left = prevOfDLL;

		prevOfDLL = root;
		bstToDLLWithoutExtraSpace(right);
	}

	BinaryTreeNode<Integer> headOfCDLL = null;
	BinaryTreeNode<Integer> prevOfCDLL = null;

	public void bstToCDLLWithoutExtraSpace(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		bstToCDLLWithoutExtraSpace(root.left);

		BinaryTreeNode<Integer> right = root.right;
		if (null == headOfCDLL) {
			headOfCDLL = root;
		} else {
			prevOfCDLL.right = root;
		}
		root.left = prevOfCDLL;
		root.right = headOfCDLL;
		prevOfCDLL = root;
		bstToCDLLWithoutExtraSpace(right);
	}

}
