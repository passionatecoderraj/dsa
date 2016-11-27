/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *         Given a binary tree, write a program to count the number of Single
 *         Valued Subtrees. A Single Valued Subtree is one in which all the
 *         nodes have same value.
 */
public class CountSingleValuedSubtrees {

	public int countSingleValuedSubtrees(BinaryTreeNode<Integer> root) {
		Result res = countSingleValuedSubtreesUtil(root);
		return res.count;
	}

	private Result countSingleValuedSubtreesUtil(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return new Result(0, -1);
		}
		if (BinaryTree.isLeaf(root)) {
			return new Result(1, root.data);
		}
		Result left = countSingleValuedSubtreesUtil(root.left);
		Result right = countSingleValuedSubtreesUtil(root.right);

		int count = 0;

		if (left.data != -1 && right.data != -1) {
			if (root.data == left.data && root.data == right.data) {
				count = 1 + left.count + right.count;
			} else {
				count = left.count + right.count;
			}
		} else if (left.data == -1) {
			if (root.data == right.data) {
				count = 1 + left.count + right.count;
			} else {
				count = left.count + right.count;
			}
		} else if (right.data == -1) {
			if (root.data == left.data) {
				count = 1 + left.count + right.count;
			} else {
				count = left.count + right.count;
			}
		}
		return new Result(count, root.data);
	}

	private Result countSingleValuedSubtreesUtil2(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return new Result(0, -1);
		}
		if (BinaryTree.isLeaf(root)) {
			return new Result(1, root.data);
		}
		Result left = countSingleValuedSubtreesUtil(root.left);
		Result right = countSingleValuedSubtreesUtil(root.right);

		int count = 0;

		if (left.data != -1 && right.data != -1) {
			if (root.data == left.data && root.data == right.data) {
				count = 1 + left.count + right.count;
			} else {
				count = left.count + right.count;
			}
		} else if (left.data == -1) {
			if (root.data == right.data) {
				count = 1 + left.count + right.count;
			} else {
				count = left.count + right.count;
			}
		} else if (right.data == -1) {
			if (root.data == left.data) {
				count = 1 + left.count + right.count;
			} else {
				count = left.count + right.count;
			}
		}
		return new Result(count, root.data);
	}

	class Result {
		int count;
		int data;

		public Result(int count, int data) {
			super();
			this.count = count;
			this.data = data;
		}

		@Override
		public String toString() {
			return "Result [data=" + data + ", count=" + count + "]";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountSingleValuedSubtrees obj = new CountSingleValuedSubtrees();

		BinaryTree ob = new BinaryTree();
		ob.insert(5);
		ob.insert(4);
		ob.insert(5);
		ob.insert(4);
		ob.insert(4);
		ob.insert(5);

		int result = -1;
		result = obj.countSingleValuedSubtrees(ob.root);
		System.out.println(result);

		ob = new BinaryTree();
		ob.insert(5);
		ob.insert(4);
		ob.insert(5);
		ob.insert(4);
		ob.insert(5);
		ob.insert(5);
		result = obj.countSingleValuedSubtrees(ob.root);
		System.out.println(result);

	}

}
