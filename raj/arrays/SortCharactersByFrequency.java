/**
 *
 */
package com.raj.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {

    // Without using sorting : Time : O(n)
    // https://discuss.leetcode.com/topic/66045/c-o-n-solution-without-sort/19
    public String frequencySort3(String s) {
        int count[] = new int[256];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        StringBuilder t[] = new StringBuilder[s.length() + 1];
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (t[count[i]] == null) {
                    t[count[i]] = new StringBuilder();
                }
                t[count[i]].append((char) i);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = t.length - 1; i > 0; i--) {
            if (t[i] != null) {
                for (char ch : t[i].toString().toCharArray()) {
                    for (int k = 0; k < i; k++) {
                        res.append(ch);
                    }
                }
            }
        }
        return res.toString();
    }

    // Without using sorting, with map : Time : O(n)
    // https://discuss.leetcode.com/topic/66045/c-o-n-solution-without-sort/19
    public String frequencySort2(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            countMap.compute(ch, (k, v) -> {
                if (null == v) {
                    v = 0;
                }
                return v + 1;
            });
        }

        StringBuilder t[] = new StringBuilder[s.length() + 1];
        countMap.forEach((ch, count) -> {
            if (t[count] == null) {
                t[count] = new StringBuilder();
            }
            t[count].append(ch);
        });

        StringBuilder res = new StringBuilder();
        for (int i = t.length - 1; i > 0; i--) {
            if (t[i] != null) {
                for (char ch : t[i].toString().toCharArray()) {
                    for (int k = 0; k < i; k++) {
                        res.append(ch);
                    }
                }
            }
        }
        return res.toString();
    }

    // using sorting, with map : Time : O(n)
    public String frequencySort(String s) {
        class Node {
            int count;
            char ch;

            public Node(char ch, int count) {
                this.ch = ch;
                this.count = count;
            }

        }
        Node t[] = new Node[256];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Node((char) i, 0);
        }
        for (char ch : s.toCharArray()) {
            t[ch].count++;
        }

        Arrays.sort(t, (n1, n2) -> n2.count - n1.count);

        StringBuilder res = new StringBuilder();
        for (Node element : t) {
            if (element.count == 0) {
                break;
            }
            for (int k = 0; k < element.count; k++) {
                res.append(element.ch);
            }

        }
        return res.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency obj = new SortCharactersByFrequency();
        String res = "";
        String a = "";

        a = "cccaaa";
        res = obj.frequencySort(a);
        System.out.println(res);

        a = "Aabb";
        res = obj.frequencySort(a);
        System.out.println(res);

    }

}
