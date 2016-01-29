/**
 * 
 */
package com.raj.trees.binary;

import java.util.Deque;
import java.util.LinkedList;

import com.interivew.graph.CommonUtil;
import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class MirrorOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MirrorOfBinaryTree obj = new MirrorOfBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);

		BinaryTree ob2 = new BinaryTree();
		ob2.insert(1);
		ob2.insert(3);
		ob2.insert(2);
		ob2.insert(7);
		ob2.insert(6);
		ob2.insert(5);
		ob2.insert(4);

		ob.inOrder(ob.root);
		System.out.println();
		ob2.inOrder(ob2.root);
		System.out.println();

		obj.mirrorWithoutRecursion(ob.root);
		ob.inOrder(ob.root);
		System.out.println();
	
		obj.mirror(ob.root);
		ob.inOrder(ob.root);
		System.out.println();

		boolean result = obj.areMirrors(ob.root, ob2.root);
		System.out.println(result);

	}

	
	public boolean areMirrors(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		} else {
			if (root1.data == root2.data) {
				return areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left);
			}
		}

		return false;
	}

	public void mirror(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		mirror(root.left);
		mirror(root.right);
		root = CommonUtil.swapLeftRight(root);
	}

	public void mirrorWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> cur;
		queue.addLast(root);

		while (!queue.isEmpty()) {
			cur = queue.removeFirst();
			if (cur.left != null)
				queue.addLast(cur.left);
			if (cur.right != null)
				queue.addLast(cur.right);
			cur = CommonUtil.swapLeftRight(cur);
		}
	}


}
