/**
 *
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 * 
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class SecondMinimumNodeInaBinaryTree {

	public int findSecondMinimumValue(BinaryTreeNode<Integer> root) {
		if (null == root)
			return -1;
		int res = util(root);
		return res;
	}

	private int util(BinaryTreeNode<Integer> root) {
		if (null == root)
			return -1;
		/*
		 * by problem definition there are not half-nodes. Only full nodes or leaf nodes
		 */
		int left = util(root.left);
		int right = util(root.right);
		
       if(root.left!=null && root.left.data!=root.data){
            left = root.left.data;
        }
       
        if(root.right!=null && root.right.data!=root.data){
            right = root.right.data;
        }
       
		if (left != -1 && right != -1) {
			return Math.min(left, right);
		}
		return left != -1 ? left : right;
	}
  
	private int utilMethod2(BinaryTreeNode<Integer> root) {
		if (null == root || BinaryTree.isLeaf(root))
			return -1;
		/*
		 * by problem definition there are not half-nodes. Only full nodes or leaf nodes
		 */
		int left = root.left.data == root.data?utilMethod2(root.left):root.left.data;
		int right = root.right.data == root.data?utilMethod2(root.right):root.right.data;
		
		if (left != -1 && right != -1) {
			return Math.min(left, right);
		}
		return left != -1 ? left : right;
	}

	public static void main(String[] args) {
		SecondMinimumNodeInaBinaryTree obj = new SecondMinimumNodeInaBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(2);
		ob.insert(2);
		ob.insert(5);
		ob.insert(5);
		ob.insert(7);

		BinaryTree ob2 = new BinaryTree();
		ob2.insert(2);
		ob2.insert(2);
		ob2.insert(2);

		int res = -1;
		res = obj.findSecondMinimumValue(ob.root);
		System.out.println(res);

		res = obj.findSecondMinimumValue(ob2.root);
		System.out.println(res);
	}

}
