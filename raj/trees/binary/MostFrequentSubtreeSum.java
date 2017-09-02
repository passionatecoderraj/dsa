package com.raj.trees.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

/**
 * 
 * 
 Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2	
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(BinaryTreeNode<Integer> root) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        dfs(root, map);
        int frequent = 0;
        for (int val : map.values()) {
            frequent = Math.max(val, frequent);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == frequent) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int dfs(BinaryTreeNode<Integer> root, Map<Integer, Integer> map) {
        if (null == root) {
            return 0;
        }
        int lsum = dfs(root.left, map);
        int rsum = dfs(root.right, map);
        int nsum = root.data + lsum + rsum;
        map.compute(nsum, (k, v) -> {
            if (null == v) {
                v = 0;
            }
            return v + 1;
        });
        return nsum;
    }
    
    public static void main(String args[]) {
        MostFrequentSubtreeSum obj = new MostFrequentSubtreeSum();
        BinaryTree ob = new BinaryTree();
        ob.insert(5);
        ob.insert(2);
        ob.insert(-3);
        int res[] = null;
        res = obj.findFrequentTreeSum(ob.root);
        System.out.println(Arrays.toString(res));
        ob = new BinaryTree();
        ob.insert(5);
        ob.insert(2);
        ob.insert(-5);
        res = obj.findFrequentTreeSum(ob.root);
        System.out.println(Arrays.toString(res));

    }

}
