/**
 *
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * @author Raj
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.


 */
public class FlattenBinaryTreeToLinkedList {

    private BinaryTreeNode<Integer> prev = null;

    public void flatten(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);

        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
        BinaryTree.levelOrder(tree.root);
        obj.flatten(tree.root);

        BinaryTree.levelOrder(tree.root);

    }

}
