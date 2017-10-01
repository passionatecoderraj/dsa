/**
 *
 */
package com.raj.trees.bst;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj
 */
public class LargestBSTInBinaryTree {

	public Result largestBSTInBinaryTree(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return new Result(true, 0, MAX_VALUE, MIN_VALUE);
		}

		Result left = largestBSTInBinaryTree(root.left);
		Result right = largestBSTInBinaryTree(root.right);

		// if either of left or right subtree says its not BST or the data
		// of this node is not greater/equal than max of left and less than min
		// of right
		// then subtree with this node as root will not be BST.
		// Return false and max size of left and right subtree to parent
		if (!left.isBst || !right.isBst || root.data < left.max || root.data > right.min) {
			return new Result(false, max(left.count, right.count), 0, 0);
		}

		int count = 1 + left.count + right.count;
		// if root.left is null then set root.data as min else
		// take min of left side as min
		int min = root.left != null ? left.min : root.data;
		// if root.right is null then set root.data as max else
		// take max of right side as max.
		int max = root.right != null ? right.max : root.data;

		return new Result(true, count, min, max);
	}

	public static void main(String[] args) {

		LargestBSTInBinaryTree obj = new LargestBSTInBinaryTree();
		Result result = null;
		BinaryTreeNode<Integer> node = makeTree();
		BinaryTree.postOrder(node);
		System.out.println();
		result = obj.largestBSTInBinaryTree(node);
		System.out.println(result);

		BinaryTree tree = new BinaryTree();
		tree.insert(8);
		tree.insert(7);
		result = obj.largestBSTInBinaryTree(tree.root);
		BinaryTree.postOrder(tree.root);
		System.out.println(result);
	}

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

}
