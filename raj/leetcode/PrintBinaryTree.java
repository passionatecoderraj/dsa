package com.raj.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.bst.BinarySearchTree;

/**
 * @author Raj
 *
 *Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].


 */

public class PrintBinaryTree {

	//https://leetcode.com/problems/print-binary-tree/discuss/106239/Java-Recursive-Solution
	public List<List<String>> printTree(BinaryTreeNode<Integer> root) {
		List<List<String>> res = new ArrayList<>();
		int rows = getHeight(root);
		if (rows == 0)
			return res;
		int cols = ((int) Math.pow(2, rows)) - 1;

		List<String> row = new ArrayList<>();
		for (int i = 0; i < cols; i++) {
			row.add("");
		}
		for (int i = 0; i < rows; i++) {
			res.add(new ArrayList<>(row));
		}
		printNodes(root, res, 0, rows, 0, cols - 1);
		return res;
	}

	private void printNodes(BinaryTreeNode<Integer> root, List<List<String>> res, int cur_row, int rows,
			int left_of_col, int right_of_col) {
		if (cur_row == rows || null == root)
			return;
		int pos = (left_of_col + right_of_col) / 2;
		res.get(cur_row).set(pos, String.valueOf(root.data));
		printNodes(root.left, res, cur_row + 1, rows, left_of_col, pos - 1);
		printNodes(root.right, res, cur_row + 1, rows, pos + 1, right_of_col);
	}

	private int getHeight(BinaryTreeNode<Integer> root) {
		return null == root ? 0 : 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 3);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 1);

		PrintBinaryTree obj = new PrintBinaryTree();
		List<List<String>> res = null;
		res = obj.printTree(tree.root);
		System.out.println(res);
	}

}
