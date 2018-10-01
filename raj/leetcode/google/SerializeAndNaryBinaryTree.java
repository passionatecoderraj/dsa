/**
 * 
 */
package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Raj
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following 3-ary tree

 



 

 

as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Note:

N is in the range of [1, 1000]
Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 


 *
 */
public class SerializeAndNaryBinaryTree {

	// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/discuss/151421/Java-preorder-recursive-solution-using-queue
		
	// Encodes a tree to a single string.
	public String serialize(Node root) {
		List<String> list = new ArrayList<>();
		preOrder(root, list);
		return String.join("#", list);
	}

	private void preOrder(Node root, List<String> list) {
		if (null == root)
			return;
		list.add(Integer.toString(root.val));
		list.add(Integer.toString(root.children.size()));
		for (Node child : root.children) {
			preOrder(child, list);
		}
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		if (data.isEmpty())
			return null;
		String arr[] = data.split("#");
		Queue<String> q = new LinkedList<>(Arrays.asList(arr));
		return util(q);
	}

	private Node util(Queue<String> q) {
		int node_val = Integer.parseInt(q.poll());
		int no_of_children = Integer.parseInt(q.poll());
		Node root = new Node();
		root.val = node_val;
		root.children = new ArrayList<>(no_of_children);
		for (int i = 0; i < no_of_children; i++) {
			root.children.add(util(q));
		}
		return root;
	}

	public static void main(String[] args) {
		SerializeAndNaryBinaryTree obj = new SerializeAndNaryBinaryTree();
		Node n2 = new Node(2, new ArrayList<>());
		Node n4 = new Node(4, new ArrayList<>());
		Node n5 = new Node(5, new ArrayList<>());
		Node n6 = new Node(6, new ArrayList<>());
		Node n3 = new Node(3, new ArrayList<>(Arrays.asList(n5,n6)));
		Node n1 = new Node(1, new ArrayList<>(Arrays.asList(n3,n2,n4)));
		
		String res = obj.serialize(n1);
		System.out.println(res);
		Node n = obj.deserialize(res);
		System.out.println(n);
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", children=" + children + "]";
		}
		
	}
}
