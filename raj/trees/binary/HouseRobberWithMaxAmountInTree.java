/**
 *
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj 
 * 
 *          The houses form a binary tree. If the root is robbed, its left and right can not be robbed.
 *        
 *         http://buttercola.blogspot.com/2016/06/leetcode-house-robber-iii.html
 */
public class HouseRobberWithMaxAmountInTree {

    public int maxAmountRobbedByHouseRobber(BinaryTreeNode<Integer> root) {
        if (null == root) {
            return 0;
        }
        Result obj = maxAmountRobbedByHouseRobberUtil(root);
        return Math.max(obj.amtIncludingRoot, obj.amtExcludingRoot);
    }

    private Result maxAmountRobbedByHouseRobberUtil(BinaryTreeNode<Integer> root) {
        if (null == root) {
            return new Result(0, 0);
        }
        Result left = maxAmountRobbedByHouseRobberUtil(root.left);
        Result right = maxAmountRobbedByHouseRobberUtil(root.right);
        // when root is included, sum of (root, left amount when it's excluded
        // and right amount when it's excluded)
        int incl = root.data + left.amtExcludingRoot + right.amtExcludingRoot;

        // when root is excluded, sum of (max of left's amt including and left
        // amt excluding, and max of right amt including and right's amt
        // excluding)
        // When excluded, we are going to include it's children. It means we need to get the max value at their
        // nodes. To do so, we need to calculate max(including,excluding) similar to the way we are doing for root
        int excl = Math.max(left.amtIncludingRoot, left.amtExcludingRoot)
                + Math.max(right.amtIncludingRoot, right.amtExcludingRoot);

        return new Result(incl, excl);
    }

    class Result {
        int amtIncludingRoot;
        int amtExcludingRoot;

        public Result(int amtIncludingRoot, int amtExcludingRoot) {
            this.amtIncludingRoot = amtIncludingRoot;
            this.amtExcludingRoot = amtExcludingRoot;
        }

        @Override
        public String toString() {
            return "Result [amtIncludingRoot=" + amtIncludingRoot + ", amtExcludingRoot=" + amtExcludingRoot + "]";
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HouseRobberWithMaxAmountInTree obj = new HouseRobberWithMaxAmountInTree();

        BinaryTree ob1 = new BinaryTree();
        ob1.insert(3);
        ob1.insert(2);
        ob1.insert(0);
        ob1.insert(3);
        ob1.insert(1);

        BinaryTree ob2 = new BinaryTree();
        ob2.insert(3);
        ob2.insert(4);
        ob2.insert(5);
        ob2.insert(1);
        ob2.insert(3);
        ob2.insert(0);
        ob2.insert(1);

        int result = 0;
        result = obj.maxAmountRobbedByHouseRobber(ob1.root);
        System.out.println(result);

        result = obj.maxAmountRobbedByHouseRobber(ob2.root);
        System.out.println(result);

    }
}
