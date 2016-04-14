/**
 * 
 */
package com.raj.trees.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.raj.nodes.BinaryTreeNode;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class CreateListForEveryLevelOfATree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateListForEveryLevelOfATree obj = new CreateListForEveryLevelOfATree();

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
		List<ListNode<Integer>> list = new ArrayList<>();
		obj.createListForEveryLevel(root, list);
		for (ListNode<Integer> r : list) {
			System.out.print("List : ");
			while (r != null) {
				System.out.print(r.data + ", ");
				r = r.next;
			}
			System.out.println();
		}

	}

	// Time : O(n), Space : O(n)
	public void createListForEveryLevel(BinaryTreeNode<Integer> root, List<ListNode<Integer>> list) {
		if (null == root)
			return;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		ListNode<Integer> cur = null, nn = null;
		BinaryTreeNode<Integer> temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp == null) {
				if (q.isEmpty())
					break;
				cur = null;
				q.add(null);
				continue;
			}
			nn = new ListNode<Integer>(temp.data);
			if (cur == null) {
				cur = nn;
				list.add(cur);
			} else {
				cur.next = nn;
				cur = cur.next;
			}
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);

		}
	}

}
