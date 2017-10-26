/**
 *
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj 
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(BinaryTreeNode<Integer> s, BinaryTreeNode<Integer> t) {
        if (null == s || null == t) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    private boolean isSame(BinaryTreeNode<Integer> s, BinaryTreeNode<Integer> t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }
        return s.data == t.data && isSame(s.left, t.left) && isSame(s.right, t.right);

    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree obj = new SubtreeOfAnotherTree();

        BinaryTree ob = new BinaryTree();
        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);
        ob.insert(5);
        ob.insert(6);
        ob.insert(7);

        BinaryTree ob2 = new BinaryTree();
        ob2.insert(2);
        ob2.insert(4);
        ob2.insert(5);

        boolean result = false;
        result = obj.isSubtree(ob.root, ob2.root);
        System.out.println(result);

    }

}
