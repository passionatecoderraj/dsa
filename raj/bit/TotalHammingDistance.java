/**
 *
 */
package com.raj.bit;

/**
 * @author Raj 
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.
 */
public class TotalHammingDistance {

    // https://discuss.leetcode.com/topic/72092/java-o-n-time-o-1-space
    public int totalHammingDistance(int a[]) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int n : a) {
                bitCount += (n >>> i) & 1;
            }
            /*
             * we will only care how many combinations of 1 and 0 in the current bit among all numbers. 
             * n - bitCount will tell us the number of zeroes. So that the
             *  bitCount(number of ones) * (n - bitCount) will give us the number of bits differences for current bit. 
             */
            total += (bitCount) * (a.length - bitCount);
        }
        return total;
    }

    public static void main(String[] args) {
        TotalHammingDistance obj = new TotalHammingDistance();
        int result = -1;
        int a[] = {4, 14, 2 };
        result = obj.totalHammingDistance(a);
        System.out.println(result);
    }

}
