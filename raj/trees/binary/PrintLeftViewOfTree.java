/**
 *
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.bst.BinarySearchTree;

/**
 * @author Raj
 */

public class PrintLeftViewOfTree {

    int max_level = 0;

    public void printLeftViewRecursively(BinaryTreeNode<Integer> root, int level) {
        if (null == root) {
            return;
        }
        if (max_level < level) {
            System.out.print(root.data + " ");
            max_level = level;
        }
        printLeftViewRecursively(root.left, level + 1);
        printLeftViewRecursively(root.right, level + 1);

    }

    public static void main(String[] args) {
        PrintLeftViewOfTree obj = new PrintLeftViewOfTree();

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

        obj.printLeftViewRecursively(tree.root, 1);
    }

}
