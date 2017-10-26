/**
 * 
 */
package com.raj.trees.binary;

import java.util.ArrayList;
import java.util.List;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class RootToLeavePaths {

	//https://discuss.leetcode.com/topic/21474/accepted-java-simple-solution-in-8-lines
	public List<String> binaryTreePaths(BinaryTreeNode<Integer> root) {
		List<String> res = new ArrayList<>();
		if (null == root) {
			return res;
		}
		binaryTreePathsUtil(root, "", res);
		return res;
	}

	public void binaryTreePathsUtil(BinaryTreeNode<Integer> root, String path, List<String> res) {
		if(null == root){
		    return;
		}
	    if (BinaryTree.isLeaf(root)) {
			res.add(path + root.data);
			return;
		}
			binaryTreePathsUtil(root.left, path + root.data + "->", res);
			binaryTreePathsUtil(root.right, path + root.data + "->", res);
	}

	public static void main(String[] args) {
		RootToLeavePaths obj = new RootToLeavePaths();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTreeNode<Integer> root = ob.root;

		int a[] = new int[200];
		obj.printRootToLeavePaths(root, 0, a);
		List<String> res = obj.binaryTreePaths(root);
		System.out.println(res);
	}

	public void printRootToLeavePaths(BinaryTreeNode<Integer> root, int level, int[] a) {
		if (root == null) {
			return;
		}
		a[level] = root.data;

		if (isLeaf(root)) {
			for (int i = 0; i <= level; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}

		printRootToLeavePaths(root.left, level + 1, a);
		printRootToLeavePaths(root.right, level + 1, a);

	}

	private boolean isLeaf(BinaryTreeNode<Integer> root) {
		return root.left == null && root.right == null;
	}

}
