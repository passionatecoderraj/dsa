
package com.raj.leetcode;

/**
 * @author Raj
 *Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */


public class ValidAnagram {

    // Time : O(n), Space : O(1)
    public boolean isAnagram(String s, String t) {
        int a[] = new int[26];
        for(char ch:s.toCharArray()){
            a[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            a[ch-'a']--;
        }
        for(int num:a){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		ValidAnagram obj = new ValidAnagram();

		boolean result = false;

		// Time : O(n) Space :O(1)
		result = obj.isAnagram("anagram", "nagaram");
		System.out.println(result);

		result = obj.isAnagram("rat", "car");
		        System.out.println(result);

	}

	
}
