/**
 *
 */
package com.raj.trees.binary;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Raj
 * 
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulateNextRightPointer {

    // Time :O(n), Space :O(1)
    public void updateNextSiblingInConstantSpace(BinaryTreeNodeWithSibling<Integer> root) {
        BinaryTreeNodeWithSibling<Integer> level_start, cur;
        level_start = root;
        while (level_start != null) {
            cur = level_start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            level_start = level_start.left;
        }
    }

    // Time :O(n), Space :O(n)
    public void updateNextSiblingRecur(BinaryTreeNodeWithSibling<Integer> node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            node.left.next = node.right;
        }
        if (node.next != null) {
            if (node.right != null) {
                node.right.next = node.next.left;
            }
        }

        updateNextSiblingRecur(node.left);
        updateNextSiblingRecur(node.right);
    }

    public static void main(String[] args) {
        PopulateNextRightPointer obj = new PopulateNextRightPointer();

        BinaryTreeNodeWithSibling<Integer> completebinarytree_root = obj.createTestAlmostCompleteBinaryTree();

        obj.updateNextSiblingInConstantSpace(completebinarytree_root);
        obj.levelOrderUsingNextSibling(completebinarytree_root);

    }

    public BinaryTreeNodeWithSibling<Integer> createTestAlmostCompleteBinaryTree() {
        BinaryTreeNodeWithSibling<Integer> n1 = new BinaryTreeNodeWithSibling<Integer>(1);
        BinaryTreeNodeWithSibling<Integer> n2 = new BinaryTreeNodeWithSibling<Integer>(2);
        BinaryTreeNodeWithSibling<Integer> n3 = new BinaryTreeNodeWithSibling<Integer>(3);
        BinaryTreeNodeWithSibling<Integer> n4 = new BinaryTreeNodeWithSibling<Integer>(4);
        BinaryTreeNodeWithSibling<Integer> n5 = new BinaryTreeNodeWithSibling<Integer>(5);
        BinaryTreeNodeWithSibling<Integer> n6 = new BinaryTreeNodeWithSibling<Integer>(6);
        BinaryTreeNodeWithSibling<Integer> n7 = new BinaryTreeNodeWithSibling<Integer>(7);
        BinaryTreeNodeWithSibling<Integer> n8 = new BinaryTreeNodeWithSibling<Integer>(8);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        return n1;
    }

    public int height(BinaryTreeNodeWithSibling<Integer> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void levelOrderUsingNextSibling(BinaryTreeNodeWithSibling<Integer> root) {
        int size = height(root);
        for (int i = 1; i <= size; i++) {
            printNodesAtGivenLevel(root, i);
            System.out.print("| ");
        }
        System.out.println();
    }

    public boolean printNodesAtGivenLevel(BinaryTreeNodeWithSibling<Integer> root, int level) {
        if (root == null) {
            return false;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
            BinaryTreeNodeWithSibling<Integer> temp = root.next;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            return true;
        } else if (level > 1) {
            if (printNodesAtGivenLevel(root.left, level - 1) || printNodesAtGivenLevel(root.right, level - 1)) {
                return true;
            }
        }

        return false;
    }

    public void levelOrderTraversal(BinaryTreeNodeWithSibling<Integer> node) {
        if (null == node) {
            System.out.println("Empty");
            return;
        }

        Deque<BinaryTreeNodeWithSibling<Integer>> queue = new LinkedList<BinaryTreeNodeWithSibling<Integer>>();
        queue.addLast(node);

        while (!queue.isEmpty()) {
            BinaryTreeNodeWithSibling<Integer> cur = queue.removeFirst();
            System.out.print(cur.data + " ");

            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
        }
        System.out.println();
    }

}

class BinaryTreeNodeWithSibling<T> {
    public T data;
    public BinaryTreeNodeWithSibling<T> left;
    public BinaryTreeNodeWithSibling<T> right;
    public BinaryTreeNodeWithSibling<T> next;

    public BinaryTreeNodeWithSibling() {

    }

    public BinaryTreeNodeWithSibling(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode [data=" + data + "]";
    }

}
