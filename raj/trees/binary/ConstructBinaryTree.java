/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class ConstructBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConstructBinaryTree obj = new ConstructBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);

		ob.inOrder(ob.root);
		System.out.println();
		ob.preOrder(ob.root);
		System.out.println();
		ob.postOrder(ob.root);
		System.out.println();

		int inOrder[] = { 4, 2, 5, 1, 6, 3 };
		int preOrder[] = { 1, 2, 4, 5, 3, 6 };
		int postOrder[] = { 4, 5, 2, 6, 3, 1 };

		// Time : O(n2) (Worse case occurs when the tree is skewed)
		BinaryTreeNode<Integer> node = obj.buildFromInorderPreOrder(inOrder, preOrder, 0, inOrder.length - 1);
		new BinaryTree().inOrder(node);
		System.out.println();
		obj.postOrderIndex = postOrder.length - 1;
		BinaryTreeNode<Integer> node2 = obj.buildFromInorderPostOrder(inOrder, postOrder, 0, inOrder.length - 1);
		new BinaryTree().inOrder(node2);

	}

	public BinaryTreeNode<Integer> buildFromInorderPostOrder(int[] inOrder, int[] postOrder, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(postOrder[postOrderIndex]);
		postOrderIndex--;

		if (inStart == inEnd) {
			return node;
		}
		int inIndex = search(inOrder, inStart, inEnd, node.data);

		node.right = buildFromInorderPostOrder(inOrder, postOrder, inIndex + 1, inEnd);
		node.left = buildFromInorderPostOrder(inOrder, postOrder, inStart, inIndex - 1);
		return node;
	}

	int postOrderIndex = 0;
	int preOrderIndex = 0;

	public BinaryTreeNode<Integer> buildFromInorderPreOrder(int[] inOrder, int[] preOrder, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}

		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(preOrder[preOrderIndex]);
		preOrderIndex++;

		if (inStart == inEnd)
			return node;

		int inIndex = search(inOrder, inStart, inEnd, node.data);

		node.left = buildFromInorderPreOrder(inOrder, preOrder, inStart, inIndex - 1);
		node.right = buildFromInorderPreOrder(inOrder, preOrder, inIndex + 1, inEnd);

		return node;
	}

	public int search(int[] inOrder, int inStart, int inEnd, int data) {
		for (int i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == data) {
				return i;
			}
		}
		return -1;
	}

}
