/**
 *
 */
package com.raj.arrays;

/**
 * @author Raj
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class FindTheDuplicateNumber {

    // https://discuss.leetcode.com/topic/25913/my-easy-understood-solution-with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanation
    public int findDuplicate(int[] a) {
        if (a.length == 0) {
            return -1;
        }
        int slow = a[0], fast = a[a[0]];
        while (slow != fast) {
            slow = a[slow];
            fast = a[a[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        int a[] = {1, 3, 4, 5, 5, 6, 2 };
        int res = obj.findDuplicate(a);
        System.out.println(res);
    }

}
