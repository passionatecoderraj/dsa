/**
 * 
 */
package com.raj.string;

import com.raj.nodes.TSTNode;

/**
 * @author Raj
 *
 */
public class TernarySearchTree {

	TSTNode root = null;

	public TSTNode insert(TSTNode node, String str, int pos) {

		if (node == null) {
			if (pos >= str.length())
				return node;

			node = new TSTNode(str.charAt(pos));
			node.left = null;
			node.right = null;

			if (pos == str.length() - 1) {
				node.is_end_of_string = true;
				return node;
			} else {
				node.eq = insert(node.eq, str, pos + 1);
				return node;
			}

		} else if (node.data > str.charAt(pos)) {
			node.left = insert(node.left, str, pos);
		} else if (node.data < str.charAt(pos)) {
			node.right = insert(node.right, str, pos);

		} else if (node.data == str.charAt(pos)) {
			if (pos == str.length() - 1) {
				node.is_end_of_string = true;
			} else
				node.eq = insert(node.eq, str, pos + 1);
		}

		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TernarySearchTree obj = new TernarySearchTree();
		obj.root = obj.insert(obj.root, "raj", 0);
		obj.root = obj.insert(obj.root, "raja", 0);
		obj.root = obj.insert(obj.root, "kumar", 0);
		obj.root = obj.insert(obj.root, "ra", 0);
		obj.root = obj.insert(obj.root, "dasari", 0);
		System.out.println(obj.root);
		char c[] = new char[100];
		obj.printRootToLeavePaths(0, obj.root, c);

	}

	public void printRootToLeavePaths(int level, TSTNode node, char[] ch) {
		if (node == null)
			return;
		if (isLeaf(node)) {
			ch[level] = node.data;
			for (int i = 0; i <= level; i++) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}
		ch[level] = node.data;
		printRootToLeavePaths(level + 1, node.left, ch);
		printRootToLeavePaths(level + 1, node.eq, ch);
		printRootToLeavePaths(level + 1, node.right, ch);

	}

	private boolean isLeaf(TSTNode node) {
		return node.left == null && node.right == null && node.eq == null;
	}

}
