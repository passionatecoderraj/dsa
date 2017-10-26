/**
 *
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj 
 * 
 *Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(BinaryTreeNode<Integer> root) {
        return sumOfLeftLeavesUtil(root,false);
    }
    private int sumOfLeftLeavesUtil(BinaryTreeNode<Integer> root, boolean isLeft) {
        if(null == root) 
            return 0;
        if(BinaryTree.isLeaf(root) && isLeft) {
            return root.data;
        }
        return sumOfLeftLeavesUtil(root.left, true)+sumOfLeftLeavesUtil(root.right, false);
    }
    public static void main(String[] args) {
        SumOfLeftLeaves obj = new SumOfLeftLeaves();

        BinaryTree ob = new BinaryTree();
        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);
        ob.insert(5);
        ob.insert(6);
        ob.insert(7);

      
        int result = -1;
        result = obj.sumOfLeftLeaves(ob.root);
        System.out.println(result);

    }

}
