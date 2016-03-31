/**
 * 
 */
package com.raj.trees.binary;

import java.util.Map;
import java.util.TreeMap;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */

/*
 * Given a binary tree, print it in ver­ti­cal order sum
 * 
 * http://algorithms.tutorialhorizon.com/print-the-vertical-sum-in-binary-tree/
 */
public class VerticalSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VerticalSum obj = new VerticalSum();

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

		Map<Integer, Integer> result = null;
		result = obj.verticalSumOfNodes(root, result);
		System.out.println(result);

		Map<Integer, Integer> res = new TreeMap<Integer, Integer>();
		obj.bottomView(root, 0, res);
		System.out.println(res);
	}

	public Map<Integer, Integer> verticalSumOfNodes(BinaryTreeNode<Integer> root, Map<Integer, Integer> result) {
		result = new TreeMap<Integer, Integer>();
		verticalSum(root, 0, result);
		return result;
	}

	public void verticalSum(BinaryTreeNode<Integer> root, int level, Map<Integer, Integer> map) {
		if (null == root)
			return;
		verticalSum(root.left, level - 1, map);
		if (map.containsKey(level)) {
			map.put(level, map.get(level) + root.data);
		} else {
			map.put(level, root.data);
		}
		verticalSum(root.right, level + 1, map);
	}

	public void bottomView(BinaryTreeNode<Integer> root, int level, Map<Integer, Integer> map) {
		if (null == root)
			return;
		map.put(level, root.data);
		bottomView(root.right, level + 1, map);
		bottomView(root.left, level - 1, map);
	}

}
