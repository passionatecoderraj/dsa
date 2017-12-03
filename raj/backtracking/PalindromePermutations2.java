package com.raj.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raj 
 * 
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].
 */
public class PalindromePermutations2 {

    public List<String> generatePalindromes(String s) {
        int[] c = new int[256];
        List<String> res = new ArrayList<>();

        // step 1. build character count map and count odds
        for (char ch : s.toCharArray()) {
            c[ch]++;
        }

        StringBuilder sb = new StringBuilder();
        Character odd = null;
        // step 2. add half count of each character to list
        for (int i = 0; i < c.length; i++) {
            if (c[i] % 2 != 0) {
                // more than one odd is not possible
                if (odd != null) {
                    return res;
                }
                odd = (char) i;
            }
            for (int j = 0; j < c[i] / 2; j++) {
                sb.append((char) i);
            }
        }

        // permute half of the string
        permute(sb.toString().toCharArray(), odd, 0, res);

        return res;
    }

    private void permute(char[] a, Character odd, int start, List<String> res) {
        if (start == a.length) {
            StringBuilder sb = new StringBuilder();
            StringBuilder first_half = new StringBuilder(String.valueOf(a));
            sb.append(first_half.toString());
            if (null != odd) {
                sb.append(odd);
            }
            sb.append(first_half.reverse().toString());
            res.add(sb.toString());
        }

        for (int i = start; i < a.length; i++) {
            if (!containsDuplicate(a, start, i)) {
                swap(a, i, start);
                permute(a, odd, start + 1, res);
                swap(a, i, start);
            }
        }
    }

    private boolean containsDuplicate(char a[], int start, int end) {
        for (int i = start; i < end; i++) {
            if (a[i] == a[end]) {
                return true;
            }
        }
        return false;
    }

    private void swap(char a[], int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void generateSomePalindrome(char a[]) {

        int[] c = new int[256];

        // step 1. build character count map and count odds
        for (char ch : a) {
            c[ch]++;
        }

        Character odd = null;
        int k = 0;
        // step 2. add half count of each character to list
        for (int i = 0; i < c.length; i++) {
            if (c[i] % 2 != 0) {
                // more than one odd is not possible
                if (odd != null) {
                    return;
                }
                odd = (char) i;
            }
            for (int j = 0; j < c[i] / 2; j++) {
                a[k++] = (char) i;
            }
        }

        if (odd != null) {
            a[k] = odd;
        }
        int l = 0, r = a.length - 1;
        while (l < r) {
            a[r--] = a[l++];
        }
    }

    public static void main(String args[]) {
        PalindromePermutations2 obj = new PalindromePermutations2();
        List<String> result = null;
        result = obj.generatePalindromes("aabbcc");
        System.out.println(result);

        char[] a = {'a', 'b', 'a', 'b', 'c', 'c', 'c' };

        obj.generateSomePalindrome(a);
        System.out.println(Arrays.toString(a));
    }
}