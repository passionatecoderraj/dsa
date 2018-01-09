/**
 *
 */
package com.raj.trees.binary;

import static com.raj.trees.binary.BinaryTree.levelOrder;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *  //@formatter:off
 *
 Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input:
    Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
         3
        / \
       4   5
      / \   \
     5   4   7
 *   //@formatter:on
 */
public class MergeTwoBinaryTrees {

    public BinaryTreeNode<Integer> mergeTrees(BinaryTreeNode<Integer> r1, BinaryTreeNode<Integer> r2) {
        if (null == r1) {
            return r2;
        }
        if (null == r2) {
            return r1;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(r1.data + r2.data);
        root.left = mergeTrees(r1.left, r2.left);
        root.right = mergeTrees(r1.right, r2.right);
        return root;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MergeTwoBinaryTrees obj = new MergeTwoBinaryTrees();

        BinaryTree ob = new BinaryTree();
        ob.insert(1);
        ob.insert(3);
        ob.insert(2);
        ob.insert(5);

        BinaryTreeNode<Integer> l1 = obj.createTestTree1();
        levelOrder(ob.root);
        levelOrder(l1);

        BinaryTreeNode<Integer> res = null;
        res = obj.mergeTrees(ob.root, l1);
        levelOrder(res);
    }

    public BinaryTreeNode<Integer> createTestTree1() {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(7);

        n2.left = n1;
        n2.right = n3;
        n1.right = n4;
        n3.right = n7;
        return n2;
    }

}
