/**
 * 
 */
package com.raj.trees.binary;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */

public class BinaryTreeVerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(BinaryTreeNode<Integer> root) {
		List<List<Integer>> result = new ArrayList<>();
		if (null == root) {
			return result;
		}
		class Node {
			BinaryTreeNode<Integer> node;
			int level;

			public Node(BinaryTreeNode<Integer> node, int level) {
				this.node = node;
				this.level = level;
			}

		}
		Map<Integer, LinkedList<Integer>> map = new HashMap<>();
		Deque<Node> q = new LinkedList<>();
		q.addLast(new Node(root, 0));
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			Node node = q.removeFirst();

			map.compute(node.level, (k, v) -> {
				if (null == v) {
					v = new LinkedList<>();
				}
				v.add(node.node.data);
				return v;
			});

			min = Math.min(min, node.level);
			max = Math.max(max, node.level);

			if (node.node.left != null) {
				q.addLast(new Node(node.node.left, node.level - 1));
			}
			if (node.node.right != null) {
				q.addLast(new Node(node.node.right, node.level + 1));
			}

		}
		
		for(int i=min;i<=max;i++){
			result.add(new ArrayList<>(map.get(i)));
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		List<List<Integer>> result = null;
		result = obj.verticalOrder(ob.root);
		System.out.println(result);

	}

}
