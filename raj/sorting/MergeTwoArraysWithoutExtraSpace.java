/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
/*
 * We have two sorted array. Without using additional memory we need to merge
 * these two arrays(longer array is having more space for merging). Output
 * should return through second arra
 */
public class MergeTwoArraysWithoutExtraSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MergeTwoArraysWithoutExtraSpace obj = new MergeTwoArraysWithoutExtraSpace();
		int longArray[] = { 2, 4, 5, 6, 7, 0, 0, 0, 0, 0 };
		int shortArray[] = { 1, 3, 8, 9 };
		int longUsed = 5;

		obj.merge(longArray, shortArray, longUsed);
		CommonUtil.printArray(longArray);
	}

	public void merge(int[] longArray, int[] shortArray, int longUsed) {
		int longArrTail = longUsed - 1;
		int shortArrTail = shortArray.length - 1;
		while (longArrTail >= 0 && shortArrTail >= 0) {
			if (longArray[longArrTail] > shortArray[shortArrTail]) {
				longArray[longArrTail + shortArrTail + 1] = longArray[longArrTail];
				longArrTail--;
			} else {
				longArray[longArrTail + shortArrTail + 1] = shortArray[shortArrTail];
				shortArrTail--;
			}
		}

		// if there are more elements left in long array, we don't need do
		// anything because final merge is into longer array
		// if there are more elements left in short array, we need to merge(or
		// copy) these into longer array
		while (shortArrTail >= 0) {
			longArray[shortArrTail] = shortArray[shortArrTail];
			shortArrTail--;
		}
	}

}
