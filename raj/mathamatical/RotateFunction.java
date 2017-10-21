/**
 *
 */
package com.raj.mathamatical;

/**
 * @author Raj Given an array of integers A and let n to be its length. Assume Bk to be an array obtained by rotating
 *         the array A k positions clock-wise, we define a "rotation function" F on A as follow: F(k) = 0 * Bk[0] + 1 *
 *         Bk[1] + ... + (n-1) * Bk[n-1]. Calculate the maximum value of F(0), F(1), ..., F(n-1). Note: n is guaranteed
 *         to be less than 105. 
 *         
 *         Example: A = [4, 3, 2, 6] 
 *         
 *         F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18= 25
 *         F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16 
 *         F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23 
 *         F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26 
 *         
 *         So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 *         https://discuss.leetcode.com/topic/58459/java-o-n-solution-with- explanation
 */
public class RotateFunction {

    /*
     * Clockwise rotation
     *
     * f(0)=0*a+1*b+2*c+3*d
     *
     * f(1)=0*d+1*a+2*b+3*c
     *
     * f(1)-f(0) = a+b+c-3d = a+b+c+d-4d = sum(arr)-4d(d=rotated element)
     *
     * f(1) = f(0)+sum(arr)-4d 
     * 
     * f(2) = f(1) + sum(arr)-4c 
     * 
     * f(3) = f(2) + sum(arr)-4b
     *
     */

    public static int maxRotateFunction(int a[]) {
        int preFun = 0;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            preFun += (i * a[i]);
        }
       
        int maxFun = preFun;
        for (int i = 1; i <a.length;i++) {
             int curFun = sum + preFun - (a.length * a[a.length-i]);
            maxFun = Math.max(curFun, maxFun);
            preFun = curFun;
        }
        return maxFun;
    }

    /*
     * This is for anti clockwise rotation arr[] = {a,b,c,d}
     *
     * f(0)=0*a+1*b+2*c+3*d
     *
     * f(1)=3*a+0*b+1*c+2*d
     *
     * f(1)-f(0) = 3a-b-c-d = 4a-a-b-c-d = 4a-sum(arr)
     *
     * f(1) = f(0) + 4a-sum(arr)
     *
     * f(2) = f(1) + 4b-sum(arr)
     *
     */
    public static int maxRotateFunctionAntiClockwise(int a[]) {
        int preFun = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            preFun += (i * a[i]);
        }
        int maxFun = preFun;
        for (int i = 1; i < a.length; i++) {
            int curFun = preFun + (a.length * a[i - 1]) - sum;
            maxFun = Math.max(maxFun, curFun);
            preFun = curFun;
        }
        return maxFun;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {4, 3, 2, 6 };
        int result = -1;

        result = maxRotateFunction(a);
        System.out.println(result);
    }

}
