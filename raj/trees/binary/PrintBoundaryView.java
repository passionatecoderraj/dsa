/**
 *
 */
package com.raj.trees.binary;

import static com.raj.trees.binary.BinaryTree.isLeaf;

import java.util.ArrayList;
import java.util.List;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.bst.BinarySearchTree;

/**
 * @author Raj
 */

public class PrintBoundaryView {

    public List<Integer> boundaryOfBinaryTree(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        result.add(root.data);
        leftBoundary(root.left, result);
        /*
         * / leaves(root,result) can be used when root is not a leaf.
         *
         * Just to cover root is leaf scenario we are getting root.left leaves and root.right leaves separately
         */
        leaves(root.left, result);
        leaves(root.right, result);
        rightBoundary(root.right, result);
        return result;
    }

    // left boundary, left leaves, right leaves, right boundary
    public List<Integer> boundaryOfBinaryTree2(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        result.add(root.data);
        leftBoundary(root.left, result);
        leaves(root.left, result);
        leaves(root.right, result);
        rightBoundary(root.right, result);
        return result;
    }

    /*
     * prints only left children
     */
    public void leftBoundary(BinaryTreeNode<Integer> root, List<Integer> result) {
        if (root == null || isLeaf(root)) {
            return;
        }
        result.add(root.data);
        if (root.left == null) {
            leftBoundary(root.right, result);
        } else {
            leftBoundary(root.left, result);
        }
    }

    /*
     * prints only right children
     */
    public void rightBoundary(BinaryTreeNode<Integer> root, List<Integer> result) {
        if (root == null || isLeaf(root)) {
            return;
        }
        if (root.right == null) {
            rightBoundary(root.left, result);
        } else {
            rightBoundary(root.right, result);
        }
        result.add(root.data);
    }

    public void leaves(BinaryTreeNode<Integer> root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            result.add(root.data);
            return;
        }
        leaves(root.left, result);
        leaves(root.right, result);
    }

    public static void main(String[] args) {
        PrintBoundaryView obj = new PrintBoundaryView();

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 3);

        List<Integer> res = null;
        res = obj.boundaryOfBinaryTree(tree.root);
        System.out.println(res);
    }
}
