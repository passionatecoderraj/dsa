/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.AVLTreeNode;
import com.raj.sorting.MergeSort;

/**
 * @author Raj
 *
 */
public class MergeTwoBalancedBSTs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.root = tree.insert(tree.root, 100);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 300);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 70);
		tree.inOrder(tree.root);
		System.out.println();
		AVLTree tree2 = new AVLTree();
		tree2.root = tree.insert(tree2.root, 80);
		tree2.root = tree.insert(tree2.root, 40);
		tree2.root = tree.insert(tree2.root, 120);
		tree2.inOrder(tree2.root);
		System.out.println();
		MergeTwoBalancedBSTs obj = new MergeTwoBalancedBSTs();

		AVLTreeNode<Integer> result = null;
		// Time : O(m+n), Space : O(m+n)
		result = obj.mergeUsingInorder(tree, tree2);
		tree.inOrder(result);
		System.out.println();
		// it uses inplace conversions to change from dll to bst and vice versa
		// Time : O(m+n) if balanced bst, Space : O(log(m+n))
		result = obj.mergeUsingDLL(tree, tree2);
		tree.inOrder(result);
		System.out.println();
		tree.preOrder(result);
		System.out.println();

	}

	public AVLTreeNode<Integer> mergeUsingDLL(AVLTree tree, AVLTree tree2) {
		AVLTreeNode<Integer> head1, head2, mergedHead;

		int m = tree.size(tree.root);
		int n = tree.size(tree2.root);
		bstToDll(tree.root);
		head1 = this.head;
		this.head = null;
		bstToDll(tree2.root);
		head2 = this.head;

		mergedHead = merge(head1, head2);
		// printDLL(mergedHead);
		this.mergeHead = mergedHead;
		return sortedDLLToBST(m + n);
	}

	AVLTreeNode<Integer> mergeHead;

	public AVLTreeNode<Integer> sortedDLLToBST(int n) {
		if (n <= 0)
			return null;
		AVLTreeNode<Integer> left = sortedDLLToBST(n / 2);
		AVLTreeNode<Integer> node = mergeHead;
		mergeHead = mergeHead.right;
		node.left = left;
		node.right = sortedDLLToBST(n - n / 2 - 1);
		return node;
	}

	public AVLTreeNode<Integer> merge(AVLTreeNode<Integer> head1, AVLTreeNode<Integer> head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if (head1.data <= head2.data) {
			head1.right = merge(head1.right, head2);
			head1.right.left = head1;
			head1.left = null;
			return head1;
		} else {
			head2.right = merge(head1, head2.right);
			head2.right.left = head2;
			head2.left = null;
			return head2;
		}
	}

	AVLTreeNode<Integer> head = null;
	AVLTreeNode<Integer> prev = null;

	public void bstToDll(AVLTreeNode<Integer> root) {
		if (root == null)
			return;
		bstToDll(root.left);
		if (head == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		bstToDll(root.right);
	}

	// method1
	public AVLTreeNode<Integer> mergeUsingInorder(AVLTree tree, AVLTree tree2) {
		int m = tree.size(tree.root);
		int n = tree.size(tree2.root);

		int a[] = new int[m + n];
		this.index = 0;
		inOrder(tree.root, a);
		inOrder(tree2.root, a);
		// CommonUtil.printArray(a);
		new MergeSort().merge(a, 0, m - 1, m + n - 1);

		return sortedArrayToAvl(a, 0, m + n - 1);
	}

	public AVLTreeNode<Integer> sortedArrayToAvl(int[] a, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		AVLTreeNode<Integer> node = new AVLTreeNode<Integer>(a[mid]);
		node.left = sortedArrayToAvl(a, start, mid - 1);
		node.right = sortedArrayToAvl(a, mid + 1, end);
		return node;
	}

	int index = 0;

	public void inOrder(AVLTreeNode<Integer> root, int[] a) {
		if (root != null) {
			inOrder(root.left, a);
			a[index++] = root.data;
			inOrder(root.right, a);
		}
	}

	
}
