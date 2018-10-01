package com.raj.leetcode.google;

import java.util.Arrays;

/**
 * 
 * @author Raj
 * Write a program to implement fenwick or binary indexed tree
 * 
 * A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 * 
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)

 * 
 */

public class BinaryIndexTree {

	/*
	 * The idea is based on the fact that all positive integers can be represented as sum of powers of 2. For example 19 can be represented as 16 + 2 + 1.
	 * root has 0 bits, next level nodes has 1 bits, following nodes have 2 bits , then 3 bits so on.
	 * 
	 * The purpose of next is that, it tells which all nodes cur value should be part of
	 * for example, for array of size 8, when updating value 3, it tells 3,4,8 should be updated.
	 * 
	 * getting Parent() is 2^2 + 2^0 
	 * 
	 * it will be good if it is mentioned why 5 is expressed as 2^2 + 2^0 and not 2^0 + 2^2. 
	 * The idea here is to go to the parent and then next x number of elements. I got confused when i saw the video. 
	 * Then later i figured it out that it is expressed as parent index + some power of 2.﻿
	 *
	 */
	int[] binaryIndexedTree;
	int[] nums;
	// Time : O(nlogn)
	public void create(int a[]) {
		this.nums=new int[a.length];
		binaryIndexedTree = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			update(i, a[i]);
		}
	}

	// Time :O(logn)
	public void update(int index, int val) {
		int delta = val-nums[index];
		nums[index]=val;
		for(int i=index+1;i<binaryIndexedTree.length;i=getNext(i)) {
			binaryIndexedTree[i]+=delta;
		}
	}

	// Time :O(logn)
	public int rangeSumQuery(int qlow, int qhigh) {
		return getSum(qhigh + 1) - getSum(qlow)  ;
	}

	private int getSum(int index) {
		int sum = 0;
		for (int i=index;i > 0;i=getParent(i)) {
			sum += binaryIndexedTree[i];
		}
		return sum;
	}

	/**
	 * To get parent 
	 * 1) 2's complement to get minus of index 
	 * 2) AND this with index
	 * 3) Subtract that from index
	 */
	private int getParent(int index) {
		return index - (index & -index);
	}

	/*
	
	/**
	 * To get next 
	 * 1) 2's complement of get minus of index 
	 * 2) AND this with index 
	 * 3) Add it to index
	 */
	private int getNext(int index) {
		return index + (index & -index);
	}

	public static void main(String[] args) {
		BinaryIndexTree obj = new BinaryIndexTree();
		
		int[] a = { -1, 3, 8, 6 };
		obj.create(a);
		System.out.println(Arrays.toString(obj.binaryIndexedTree));
		int result = -1;
		result = obj.rangeSumQuery(0, 2);
		System.out.println(result);

		result = obj.rangeSumQuery(2, 3);
		System.out.println(result);

		obj.update(2, -4);
		System.out.println(Arrays.toString(obj.binaryIndexedTree));

		result = obj.rangeSumQuery(0, 2);
		System.out.println(result);
		
		int a2[] = {3,2,-1, 6,5,4,-3,3,7,2,3};
		obj.create(a2);
		System.out.println(Arrays.toString(obj.binaryIndexedTree));

	}

}
