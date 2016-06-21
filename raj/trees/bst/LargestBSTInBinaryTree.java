/**
 * 
 */
package com.raj.trees.bst;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj
 *
 */
public class LargestBSTInBinaryTree {

	private static BinaryTreeNode<Integer> makeTree() {
		BinaryTreeNode<Integer> r25 = new BinaryTreeNode<Integer>(25);
		BinaryTreeNode<Integer> r18 = new BinaryTreeNode<Integer>(18);
		BinaryTreeNode<Integer> r50 = new BinaryTreeNode<Integer>(50);
		BinaryTreeNode<Integer> r19 = new BinaryTreeNode<Integer>(19);
		BinaryTreeNode<Integer> r20 = new BinaryTreeNode<Integer>(20);

		BinaryTreeNode<Integer> r35 = new BinaryTreeNode<Integer>(35);
		BinaryTreeNode<Integer> r60 = new BinaryTreeNode<Integer>(60);
		BinaryTreeNode<Integer> r15 = new BinaryTreeNode<Integer>(15);
		BinaryTreeNode<Integer> r_18 = new BinaryTreeNode<Integer>(18);
		BinaryTreeNode<Integer> r_25 = new BinaryTreeNode<Integer>(25);

		BinaryTreeNode<Integer> r_20 = new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> r40 = new BinaryTreeNode<Integer>(40);
		BinaryTreeNode<Integer> r55 = new BinaryTreeNode<Integer>(55);
		BinaryTreeNode<Integer> r70 = new BinaryTreeNode<Integer>(70);
		BinaryTreeNode<Integer> r__25 = new BinaryTreeNode<Integer>(25);
		r25.left = r18;
		r25.right = r50;
		r18.left = r19;
		r18.right = r20;
		r19.right = r15;
		r20.left = r_18;
		r20.right = r_25;

		r50.left = r35;
		r50.right = r60;
		r35.left = r_20;
		r35.right = r40;
		r_20.right = r__25;

		r60.left = r55;
		r60.right = r70;
		return r25;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LargestBSTInBinaryTree obj = new LargestBSTInBinaryTree();
		Result result = null;
		BinaryTreeNode<Integer> node = makeTree();
		BinaryTree.postOrder(node);
		System.out.println();
		result = obj.largestBSTInBinaryTree(node);
		System.out.println(result);
	}

	class Result {
		boolean isBst;
		int count;
		int min;
		int max;

		public Result(boolean isBst, int count, int min, int max) {
			this.isBst = isBst;
			this.count = count;
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Result [isBst=" + isBst + ", count=" + count + ", min=" + min + ", max=" + max + "]";
		}
	}

	public Result largestBSTInBinaryTree(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return new Result(true, 0, 0, 0);
		}
		Result left = largestBSTInBinaryTree(node.left);
		Result right = largestBSTInBinaryTree(node.right);

		if (BinaryTree.isLeaf(node)) {
			return new Result(true, 1, node.data, node.data);
		}
		if (left.isBst && right.isBst) {
			if (node.data > left.max && node.data < right.min)
				return new Result(true, 1 + left.count + right.count, left.min, right.max);
		}
		return new Result(false, Math.max(left.count, right.count), 0, 0);
	}

}
