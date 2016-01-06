/**
 * 
 */
package com.raj.trees.binary;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class LevelThatHasMaxSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LevelThatHasMaxSum obj = new LevelThatHasMaxSum();

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
		int result = -1;
		result = obj.levelThatHasMaxSum(root);
		System.out.println(result);
	}

	public int levelThatHasMaxSum(BinaryTreeNode<Integer> node) {
		int level = 0;
		int maxLevel = 0;
		int maxSumLevel = Integer.MIN_VALUE;
		int curLevelSum = 0;
		if (null == node) {
			return -1;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();

		queue.addLast(node);
		queue.addLast(null);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			if (cur == null) {
				level++;

				if (curLevelSum > maxSumLevel) {
					maxSumLevel = curLevelSum;
					maxLevel = level;
				}
				curLevelSum = 0;
				if (!queue.isEmpty())
					queue.addLast(null);
			} else {
				curLevelSum += cur.data;
				if (cur.right != null) {
					queue.addLast(cur.right);
				}
				if (cur.left != null) {
					queue.addLast(cur.left);
				}
			}

		}
		System.out.println("maxLevel=" + maxLevel + ", maxSum=" + maxSumLevel);
		return maxLevel;
	}

}
