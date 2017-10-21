package com.raj.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int wordLadder(String beginWord, String endWord, Set<String> dictionary) {

        class WordNode {
            String word;
            int numSteps;

            public WordNode(String word, int numSteps) {
                this.word = word;
                this.numSteps = numSteps;
            }

        }
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));

        dictionary.add(endWord);

        while (!queue.isEmpty()) {
            WordNode cur = queue.poll();
            if (cur.word.equals(endWord)) {
                return cur.numSteps;
            }
            char a[] = cur.word.toCharArray();
            for (int i = 0; i < a.length; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char temp = a[i];
                    if (a[i] != ch) {
                        a[i] = ch;
                    }
                    String str = new String(a);
                    if (dictionary.contains(str)) {
                        queue.add(new WordNode(str, cur.numSteps + 1));
                    }
                    a[i] = temp;
                }
            }
        }
        return Integer.MAX_VALUE;

    }

    public List<List<String>> wordLadder2(String beginWord, String endWord, Set<String> dictionary) {

        class WordNode {
            String word;
            int numSteps;
            WordNode parent;

            public WordNode(String word, int numSteps, WordNode parent) {
                this.word = word;
                this.numSteps = numSteps;
                this.parent = parent;
            }

        }
        List<List<String>> result = new ArrayList<>();
        List<WordNode> list = new ArrayList<>();
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1, null));

        dictionary.add(endWord);

        while (!queue.isEmpty()) {
            WordNode cur = queue.poll();
            if (cur.word.equals(endWord)) {
                if (list.isEmpty() || cur.numSteps == list.get(0).numSteps) {
                    list.add(cur);
                } else if (cur.numSteps > list.get(0).numSteps) {
                    break;
                }

            }
            char a[] = cur.word.toCharArray();
            for (int i = 0; i < a.length; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char temp = a[i];
                    if (a[i] != ch) {
                        a[i] = ch;
                    }
                    String str = new String(a);
                    if (dictionary.contains(str)) {
                        queue.add(new WordNode(str, cur.numSteps + 1, cur));
                    }
                    a[i] = temp;
                }
            }
        }

        for (WordNode node : list) {
            List<String> res = new ArrayList<>();
            while (node != null) {
                res.add(0, node.word);
                node = node.parent;
            }
            result.add(res);
        }
        return result;

    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        class WordNode {
            String word;
            int numSteps;
            WordNode pre;

            public WordNode(String word, int numSteps, WordNode pre) {
                this.word = word;
                this.numSteps = numSteps;
                this.pre = pre;
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();

        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1, null));

        dict.add(end);

        int minStep = 0;

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(dict);

        int preNumSteps = 0;

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;

            if (word.equals(end)) {
                if (minStep == 0) {
                    minStep = top.numSteps;
                }

                if (top.numSteps == minStep && minStep != 0) {
                    // nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while (top.pre != null) {
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }

            }

            if (preNumSteps < currNumSteps) {
                unvisited.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (unvisited.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }

                    arr[i] = temp;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {

        byte a = 4;
        String b = Byte.toString(a);
        System.out.println(b);
        System.out.println(b.length());
        Set<String> dictionary = new HashSet<>();
        dictionary.add("hot");
        dictionary.add("dot");
        dictionary.add("dog");
        dictionary.add("lot");
        dictionary.add("log");
        int res = -1;
        WordLadder obj = new WordLadder();
        res = obj.wordLadder("hit", "cog", dictionary);
        System.out.println(res);
        List<List<String>> result = obj.wordLadder2("hit", "cog", dictionary);
        System.out.println(result);
    }

}
