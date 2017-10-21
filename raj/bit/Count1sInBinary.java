/**
 *
 */
package com.raj.bit;

/**
 * @author Raj
 */
public class Count1sInBinary {

    /*
     * In Java we need to put attention on the fact that the maximum integer is 2147483647. Integer type in Java is
     * signed and there is no unsigned int. So the input 2147483648 is represented in Java as -2147483648 (in java int
     * type has a cyclic representation, that means Integer.MAX_VALUE+1==Integer.MIN_VALUE). This force us to use
     *
     * n!=0 in the while condition and we cannot use
     *
     * n>0
     */
    // https://discuss.leetcode.com/topic/11385/simple-java-solution-bit-shifting
    public int count1sInBinary(int n) {
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Count1sInBinary obj = new Count1sInBinary();
        int result = -1, n = 30;
        result = obj.count1sInBinary(n);
        System.out.println(result);

        System.out.println(Integer.toBinaryString(-2));
    }

}
