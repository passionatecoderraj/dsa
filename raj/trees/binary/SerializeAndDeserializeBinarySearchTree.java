/**
 * 
 */
package com.raj.trees.binary;

import java.util.ArrayList;
import java.util.List;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.bst.BinarySearchTree;

/**
 * @author Raj
 *
 */
public class SerializeAndDeserializeBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SerializeAndDeserializeBinarySearchTree obj = new SerializeAndDeserializeBinarySearchTree();

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

		BinaryTree.inOrder(tree.root);
		System.out.println();
		List<Integer> preOrder = new ArrayList<>();
		obj.serializeBinarySearchTree(tree.root, preOrder);
		System.out.println(preOrder);
		BinaryTreeNode<Integer> root = null;
		root = obj.deSerializeBinarySearchTree(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		BinaryTree.inOrder(root);
	}

	int index = 0;

	public BinaryTreeNode<Integer> deSerializeBinarySearchTree(List<Integer> preOrder, int min, int max) {
		if (index == preOrder.size())
			return null;
		int val = preOrder.get(index);
		if (val > min && val < max) {
			index++;
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(val);
			root.left = deSerializeBinarySearchTree(preOrder, min, val);
			root.right = deSerializeBinarySearchTree(preOrder, val, max);
			return root;
		}
		return null;
	}

	public void serializeBinarySearchTree(BinaryTreeNode<Integer> root, List<Integer> preOrder) {
		if (null == root)
			return;
		preOrder.add(root.data);
		serializeBinarySearchTree(root.left, preOrder);
		serializeBinarySearchTree(root.right, preOrder);
	}

}
