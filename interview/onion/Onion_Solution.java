package com.interview.onion;


import java.util.ArrayList;
import java.util.HashSet;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
import java.util.List;
import java.util.Set;

// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Onion_Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsLessKDist(String str, int k) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= str.length() - k; i++) {
            String st = str.substring(i, i + k);
            if (util(st)) {
                set.add(st);
            }
        }
        for (String st : set) {
            res.add(st);
        }
        return res;
    }

    public boolean util(String str) {
        int[] c = new int[256];
        int count = 0;
        for (char ch : str.toCharArray()) {
            c[ch]++;
            if (c[ch] > 1) {
                count++;
            }
        }
        System.out.println();
        return count == 1;
    }
    // METHOD SIGNATURE ENDS
}