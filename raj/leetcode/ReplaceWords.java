package com.raj.leetcode;

import java.util.Arrays;
import java.util.List;

import com.raj.nodes.TrieNode;
import com.raj.patternmatching.Trie;

/**
 * 
 * @author Raj
 * 
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
 */

public class ReplaceWords {

	// https://leetcode.com/problems/replace-words/discuss/105767/Java-SimpleClassical-Trie-questionsolution-(Beat-96)
	// Time : O(W), W = no. of words in sentence, Space : O(D) D = size of dictionary
	public String replaceWords(List<String> dict, String sentence) {
		Trie trie = new Trie();
		for (String w : dict) {
			trie.insert(w);
		}
		String tokens[] = sentence.split(" ");
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < tokens.length; i++) {
			res.append(getShortestRepalcement(tokens[i], trie.root));
			if (i != tokens.length - 1) {
				res.append(" ");
			}

		}
		return res.toString();
	}

	private String getShortestRepalcement(String str, TrieNode root) {
		TrieNode cur = root;
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
            // no more match so break and return
            if(!cur.children.containsKey(ch))
                break;
			cur = cur.children.get(ch);
			sb.append(ch);
			// found root
			if (cur.endOfWord) {
				return sb.toString();
			}
		}
		return str;
	}

	public static void main(String[] args) {
		ReplaceWords obj = new ReplaceWords();

		String result = null;

		String words[] = { "cat", "bat", "rat" };
		String sentence = "the cattle was rattled by the battery";

		result = obj.replaceWords(Arrays.asList(words), sentence);
		System.out.println(result);

	}

}
