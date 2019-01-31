/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj
 *
 */
public class SerializeAndDeserializeBinaryTree {

	public String serialize(BinaryTreeNode<Integer> root) {
		List<String> list = new ArrayList<>();
		serializeBinaryTree(root, list);
		return String.join(",", list);
	}

	// use List<String> to capture tree. If negative numbers or two digit
	// numbers are there string concatenation may not work
	public void serializeBinaryTree(BinaryTreeNode<Integer> root, List<String> preOrder) {
		if (null == root) {
			preOrder.add("#");
			return;
		}
		preOrder.add(Integer.toString(root.data));
		serializeBinaryTree(root.left, preOrder);
		serializeBinaryTree(root.right, preOrder);
	}

	public BinaryTreeNode<Integer> deserialize(String sb) {
		String arr[] = sb.split(",");
		Queue<String> q = new LinkedList<>(Arrays.asList(arr));
		return deSerializeBinaryTree(q);
	}

	public BinaryTreeNode<Integer> deSerializeBinaryTree(Queue<String> q) {
		String val = q.poll();
		if (val.equals("#")) {
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(Integer.parseInt(val));
		root.left = deSerializeBinaryTree(q);
		root.right = deSerializeBinaryTree(q);
		return root;
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTree.inOrder(ob.root);
		System.out.println();
		String ser="";
		ser = obj.serialize(ob.root);
		System.out.println(ser);
		BinaryTreeNode<Integer> root = null;
		root = obj.deserialize(ser);
		BinaryTree.inOrder(root);
	}

	int index = 0;

	public BinaryTreeNode<Integer> deSerializeBinaryTree2(StringBuilder preOrder) {
		char ch = preOrder.charAt(index++);
		if (ch == '#') {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(Character.getNumericValue(ch));
		root.left = deSerializeBinaryTree2(preOrder);
		root.right = deSerializeBinaryTree2(preOrder);
		return root;
	}

	// use List<String> to capture tree. If negative numbers or two digit
	// numbers are there string concatenation may not work
	public void serializeBinaryTree2(BinaryTreeNode<Integer> root, StringBuilder preOrder) {
		if (null == root) {
			preOrder.append("#");
			return;
		}
		preOrder.append(root.data);
		serializeBinaryTree2(root.left, preOrder);
		serializeBinaryTree2(root.right, preOrder);
	}

}
