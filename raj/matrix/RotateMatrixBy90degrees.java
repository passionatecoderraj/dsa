/**
 * 
 */
package com.raj.matrix;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *         You are given an n x n 2D matrix representing an image.
 * 
 *         Rotate the image by 90 degrees (clockwise).
 * 
 *         Follow up: Could you do this in-place?
 * 
 *         https://discuss.leetcode.com/topic/9744/ac-java-in-place-solution-
 *         with-explanation-easy-to-understand
 */
public class RotateMatrixBy90degrees {

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry 
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
    */
    public void rotateImageBy90degrees(int[][] a, int m, int n) {
      
        // swap rows
        int l = 0, r = m - 1;
        while (l < r) {
            for (int i = 0; i < n; i++) {
                CommonUtil.swap(a, l,i,r,i);
            }
            l++;
            r--;
        }
        
        // transpose
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                CommonUtil.swap(a, i, j, j, i);
            }
        }

    }
    
    public void rotateImageBy90degrees2(int[][] a, int m, int n) {
		// transpose
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < n; j++) {
				CommonUtil.swap(a, i, j, j, i);
			}
		}
		// swap columns
		int l = 0, r = n - 1;
		while (l < r) {
			for (int i = 0; i < m; i++) {
				CommonUtil.swap(a, i, l, i, r);
			}
			l++;
			r--;
		}

	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int m = a.length, n = a[0].length;
		RotateMatrixBy90degrees obj = new RotateMatrixBy90degrees();
		obj.rotateImageBy90degrees(a, m, n);
		CommonUtil.print2DArray(a, m, n);

	}

	// Time : O(m*n), Space : O(mn)
	public void rotateImageBy90degreesExtraSpace(int[][] a, int m, int n) {
		int t[][] = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				t[j][m - i - 1] = a[i][j];
			}
		}
		CommonUtil.print2DArray(t, n, m);
	}

	// TODO : inplace algorithm -
	// https://www.shiftedup.com/2015/05/10/programming-challenge-rotating-a-matrix-90-degrees-in-place

}
