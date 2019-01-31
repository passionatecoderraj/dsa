/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 * 
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.

Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.

Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:

Given the 8 x 8 grid below, we want to construct the corresponding quad tree:



It can be divided according to the definition above:



 

The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.

For the non-leaf nodes, val can be arbitrary, so it is represented as *.



Note:

N is less than 1000 and guaranteened to be a power of 2.
If you want to know more about the quad tree, you can refer to its wiki.
 * 
 */
public class ConstructQuadTree {

	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
		}

		public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
			val = _val;
			isLeaf = _isLeaf;
			topLeft = _topLeft;
			topRight = _topRight;
			bottomLeft = _bottomLeft;
			bottomRight = _bottomRight;
		}
	}
	// https://leetcode.com/problems/construct-quad-tree/discuss/151684/Recursive-Java-Solution
	public Node construct(int[][] grid) {
		return util(grid, 0, grid.length - 1, 0, grid[0].length - 1);
	}

    Node util(int[][] g,int r1, int r2, int c1, int c2) {
        if (r1 > r2 || c1 > c2) return null;
        boolean isLeaf = true;
        int val = g[r1][c1];
        for (int i = r1; i <= r2; i++)
            for (int j = c1; j <= c2; j++)
                if (g[i][j] != val) {
                    isLeaf = false;
                    break;
                }
        if (isLeaf)
            return new Node(val == 1, true, null, null, null, null);
        int rowMid = (r1 + r2) / 2, colMid = (c1 + c2) / 2;
        return new Node(false, false,
            util(g, r1, rowMid, c1, colMid),//top left 
            util(g, r1, rowMid, colMid + 1,  c2),//top right
            util(g, rowMid + 1, r2, c1, colMid),//bottom left 
            util(g, rowMid + 1, r2, colMid + 1, c2));//bottom right
    }
    
	public static void main(String[] args) {
		ConstructQuadTree obj = new ConstructQuadTree();
		Node res = null;
		res = obj.construct(new int[][] { {} });
		System.out.println(res);

	}
}
