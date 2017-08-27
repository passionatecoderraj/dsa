/**
 * 
 */
package com.raj.trees.binary;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class Diameter {

	int diameter = Integer.MIN_VALUE;
	int diameterRoot = Integer.MIN_VALUE;

	public int diameter(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int lh = diameter(root.left);
		int rh = diameter(root.right);
		int curDiameter = lh + rh + 1;
		if (curDiameter > diameter) {
			diameter = curDiameter;
			diameterRoot = root.data;
		}
		return 1 + Math.max(lh, rh);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Diameter obj = new Diameter();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTreeNode<Integer> l1 = obj.createTestTree1();
		BinaryTreeNode<Integer> l2 = obj.createTestTree2();

		obj.diameter(l1);
		System.out.println(obj.diameter);
		System.out.println(obj.diameterRoot);

		obj.diameter = Integer.MIN_VALUE;
		obj.diameterRoot = Integer.MIN_VALUE;

		obj.diameter(l2);
		System.out.println(obj.diameter);
		System.out.println(obj.diameterRoot);
	}

	public BinaryTreeNode<Integer> createTestTree1() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> n9 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> n10 = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> n11 = new BinaryTreeNode<Integer>(11);
		BinaryTreeNode<Integer> n12 = new BinaryTreeNode<Integer>(12);
		BinaryTreeNode<Integer> n13 = new BinaryTreeNode<Integer>(13);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n5.right = n7;
		n3.right = n8;
		n8.right = n9;
		n9.left = n10;
		n9.right = n11;
		n10.left = n12;
		n10.right = n13;

		return n1;
	}

	public BinaryTreeNode<Integer> createTestTree2() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> n9 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> n10 = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> n11 = new BinaryTreeNode<Integer>(11);
		BinaryTreeNode<Integer> n12 = new BinaryTreeNode<Integer>(12);
		BinaryTreeNode<Integer> n13 = new BinaryTreeNode<Integer>(13);
		BinaryTreeNode<Integer> n14 = new BinaryTreeNode<Integer>(14);
		BinaryTreeNode<Integer> n15 = new BinaryTreeNode<Integer>(15);

		n1.left = n2;
		n1.right = n3;
		n3.right = n4;
		n2.left = n5;
		n2.right = n6;

		n5.left = n7;
		n5.right = n8;
		n8.left = n9;
		n9.left = n10;
		n9.right = n11;
		n6.right = n12;
		n12.left = n13;
		n12.right = n14;
		n14.right = n15;
		return n1;
	}

}
