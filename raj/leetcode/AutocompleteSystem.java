package com.raj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * 
 * @author Raj
 *
 *
 *Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.


Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
The system have already tracked down the following sentences and their corresponding times: 
"i love you" : 5 times 
"island" : 3 times 
"ironman" : 2 times 
"i love leetcode" : 2 times 
Now, the user begins another search: 

Operation: input('i') 
Output: ["i love you", "island","i love leetcode"] 
Explanation: 
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 

Operation: input(' ') 
Output: ["i love you","i love leetcode"] 
Explanation: 
There are only two sentences that have prefix "i ". 

Operation: input('a') 
Output: [] 
Explanation: 
There are no sentences that have prefix "i a". 

Operation: input('#') 
Output: [] 
Explanation: 
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search. 

Note:
The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class AutocompleteSystem {

    TrieNode root;
    StringBuilder search_string;
    TrieNode search_node;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode(' ');
        search_node = root;

        search_string = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    private void insert(String sentence, int times) {
        TrieNode temp = this.root;
        for (char ch : sentence.toCharArray()) {
            if (!temp.children.containsKey(ch)) {
                temp.children.put(ch, new TrieNode(ch));
            }
            temp = temp.children.get(ch);
        }
        temp.endWord = true;
        temp.times = times;
    }

    public List<String> input(char ch) {
    	 List<String> res = new ArrayList<>();
         PriorityQueue<Node> pq = new PriorityQueue<>(
                 (n1, n2) -> n1.times == n2.times ? n2.string.compareTo(n1.string) : n1.times - n2.times);
         search_string.append(ch);
         if ('#' == ch) {
             // when end of the string is reached, increment the count
             // to increment count, if node doesn't exist , create a new node
            
             search_node.endWord = true;
             search_node.times++;
            
             search_string.setLength(0);
             search_node = this.root;
         } else if(!search_node.children.containsKey(ch)){
               search_node.children.put(ch, new TrieNode(ch));
               search_node = search_node.children.get(ch);
         }else {
        	 search_node = search_node.children.get(ch); 
        	 collect(search_node, new StringBuilder(search_string), pq);	 
         }
         
         while (!pq.isEmpty()) {
             Node n = pq.poll();
             res.add(0, n.string);
         }
         return res;
    }

    private void collect(TrieNode temp, StringBuilder sb, PriorityQueue<Node> pq) {
        if (temp.endWord) {
            pq.offer(new Node(sb.toString(), temp.times));
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        for (char ch : temp.children.keySet()) {
            sb.append(ch);
            collect(temp.children.get(ch), sb, pq);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode" };
        int times[] = {5, 3, 2, 2 };
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        // obj.print();
        List<String> res = null;
        // res = obj.hasPrefix("i lov");
        // System.out.println(res);
        res = obj.input('i');
        System.out.println(res);
        res = obj.input(' ');
        System.out.println(res);
        res = obj.input('a');
        System.out.println(res);
        res = obj.input('#');
        System.out.println(res);

        res = obj.input('i');
        System.out.println(res);
        res = obj.input(' ');
        System.out.println(res);
        res = obj.input('a');
        System.out.println(res);
        res = obj.input('#');
        System.out.println(res);

        res = obj.input('i');
        System.out.println(res);
        res = obj.input(' ');
        System.out.println(res);
        res = obj.input('a');
        System.out.println(res);
        res = obj.input('#');
        System.out.println(res);

        res = obj.input('i');
        System.out.println(res);
        res = obj.input(' ');
        System.out.println(res);
        res = obj.input('a');
        System.out.println(res);
        res = obj.input('#');
        System.out.println(res);
        // String[] sentences2 = {"abc", "abbc", "a" };
        // int times2[] = {3, 3, 3 };
        // AutocompleteSystem obj2 = new AutocompleteSystem(sentences, times);
        // res = obj2.input('b');
        // System.out.println(res);
        // res = obj2.input('c');
        // System.out.println(res);
        // res = obj2.input('#');
        // System.out.println(res);
        // res = obj2.input('b');
        // System.out.println(res);

    }

    public void print() {
        print(this.root, new StringBuilder());
    }

    private void print(TrieNode root, StringBuilder sb) {

        if (root.endWord) {
            System.out.println(sb + "(" + root.times + ")");
        }
        for (char ch : root.children.keySet()) {
            sb.append(ch);
            print(root.children.get(ch), sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public List<String> hasPrefix(String str) {
        List<String> res = new ArrayList<>();
        TrieNode temp = this.root;
        for (char ch : str.toCharArray()) {
            if (temp.children.containsKey(ch)) {
                temp = temp.children.get(ch);
            } else {
                return res;
            }
        }
        StringBuilder sb = new StringBuilder(str);
        hasPrefixStrings(temp, sb, res);
        return res;
    }

    private void hasPrefixStrings(TrieNode root, StringBuilder sb, List<String> res) {
        if (root.endWord) {
            res.add(sb.toString());
        }
        for (char ch : root.children.keySet()) {
            sb.append(ch);
            hasPrefixStrings(root.children.get(ch), sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

class TrieNode {
    char data;
    boolean endWord;
    int times;
    Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(char data) {
        this.data = data;
    }
}

class Node {
    String string;
    int times;

    public Node(String string, int times) {
        this.string = string;
        this.times = times;
    }

}
