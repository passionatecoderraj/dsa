/**
 *
 */
package com.raj.trees.binary;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj Given a non-empty binary tree, return the average value of the nodes on each level in the form of an
 *         array. Example 1: Input: 3 / \ 9 20 / \ 15 7 Output: [3, 14.5, 11] Explanation: The average value of nodes on
 *         level 0 is 3, on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11]. Note: The range of node's
 *         value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(BinaryTreeNode<Integer> root) {
        List<Double> result = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

        if (root == null) {
            return result;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                BinaryTreeNode<Integer> node = q.poll();
                sum += node.data;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(sum / n);
        }
        return result;
    }

    public List<Double> averageOfLevels2(BinaryTreeNode<Integer> root) {
        class Level {
            long sum;
            int count;
        }
        Deque<BinaryTreeNode<Integer>> q = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        q.add(root);
        q.add(null);
        Level level = new Level();
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> temp = q.poll();
            if (null == temp) {
                double d = (1.0) * level.sum / level.count;
                list.add(d);
                if (q.isEmpty()) {
                    break;
                }
                level = new Level();
                q.add(null);
            } else {
                level.count++;
                level.sum += temp.data;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree obj = new AverageOfLevelsInBinaryTree();

        BinaryTree ob = new BinaryTree();
        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);
        ob.insert(5);
        ob.insert(6);
        ob.insert(7);
        ob.insert(8);

        BinaryTreeNode<Integer> root = ob.root;

        List<Double> res = new ArrayList<>();
        res = obj.averageOfLevels(root);
        System.out.println(res);
    }

}
