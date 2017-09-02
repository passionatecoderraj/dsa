/**
 *
 */
package com.raj.trees.binary;

import static com.raj.trees.binary.BinaryTree.levelOrder;
import static java.lang.Integer.parseInt;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 * //@formatter:off
 *You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   /
  3   1 5
 * //@formatter:on
 */
public class ConstructBinaryTreeFromString {

    public BinaryTreeNode<Integer> constructBinaryTreeFromString(String s) {
        if (null == s || s.length() == 0) {
            return null;
        }
        int firstLeftparan = s.indexOf("(");
        if (-1 == firstLeftparan) {
            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(parseInt(s));
            return root;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(parseInt(s.substring(0, firstLeftparan)));
        int start = firstLeftparan, paranCount = 0;
        for (int i = firstLeftparan; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                paranCount++;
            } else if (s.charAt(i) == ')') {
                paranCount--;
            }

            if (0 == paranCount) {
                if (start == firstLeftparan) {
                    root.left = constructBinaryTreeFromString(s.substring(start + 1, i));
                    start = i + 1;
                } else {
                    root.right = constructBinaryTreeFromString(s.substring(start + 1, i));
                }
            }

        }
        return root;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ConstructBinaryTreeFromString obj = new ConstructBinaryTreeFromString();

        BinaryTree ob = new BinaryTree();
        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);

        BinaryTreeNode<Integer> res = null;
        String input = "4(2(3)(1))(6(5))";
        res = obj.constructBinaryTreeFromString(input);
        levelOrder(res);
    }

}
