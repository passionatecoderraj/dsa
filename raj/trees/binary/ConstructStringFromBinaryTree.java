/**
 *
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *  //@formatter:off
 *
 *You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 *   //@formatter:on
 */
public class ConstructStringFromBinaryTree {

    public String constructStringFromBinaryTree(BinaryTreeNode<Integer> root) {
        if (null == root) {
            return "";
        }
        String left = constructStringFromBinaryTree(root.left);
        String right = constructStringFromBinaryTree(root.right);
        String node = Integer.toString(root.data);
        if (left.isEmpty() && right.isEmpty()) {
            return node;
        } else if (right.isEmpty()) {
            return node + "(" + left + ")";
        } else if (left.isEmpty()) {
            return node + "()" + "(" + right + ")";
        } else {
            return node + "(" + left + ")" + "(" + right + ")";
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ConstructStringFromBinaryTree obj = new ConstructStringFromBinaryTree();

        BinaryTree ob = new BinaryTree();
        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);

        BinaryTreeNode<Integer> l1 = obj.createTestTree1();

        String res = null;
        res = obj.constructStringFromBinaryTree(ob.root);
        System.out.println(res);
        res = obj.constructStringFromBinaryTree(l1);
        System.out.println(res);
    }

    public BinaryTreeNode<Integer> createTestTree1() {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n4;

        return n1;
    }

}
