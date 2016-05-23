package com.interivew.practice;

import com.interivew.graph.CommonUtil;

public class JustPractice {

	public void permute(char[] word, int cur) {
		if (word.length == cur) {
			System.out.println(word);
			return;
		}
		for (int i = cur; i < word.length; i++) {
			CommonUtil.swap(word, i, cur);
			permute(word, cur + 1);
			CommonUtil.swap(word, i, cur);
		}
	}

	public void permuteLengthK(char[] word, int cur, int k) {
		if (k == cur) {
			System.out.println(word);
			return;
		}
		for (int i = cur; i < word.length; i++) {
			CommonUtil.swap(word, i, cur);
			permuteLengthK(word, cur + 1, k);
			CommonUtil.swap(word, i, cur);
		}
	}

	public void permuteUnique(char[] word, int cur) {
		if (word.length == cur) {
			System.out.println(word);
			return;
		}
		for (int i = cur; i < word.length; i++) {
			if (!containsDuplicate(word, cur, i - 1, word[i])) {
				CommonUtil.swap(word, i, cur);
				permuteUnique(word, cur + 1);
				CommonUtil.swap(word, i, cur);
			}
		}
	}

	private boolean containsDuplicate(char[] a, int start, int end, int k) {
		for (int i = start; i <= end; i++) {
			if (a[i] == k)
				return true;
		}
		return false;
	}

	public void combinations(char word[], int curPosition, StringBuilder sb) {
		if (curPosition == word.length)
			return;
		for (int i = curPosition; i < word.length; i++) {
			sb.append(word[i]);
			System.out.println(sb);
			combinations(word, i + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public void combinationsOfSizeK(char word[], int curPosition, int k, char[] res, int resIndex) {
		if (resIndex == k) {
			CommonUtil.printArray(res);
			return;
		}
		for (int i = curPosition; i < word.length; i++) {
			res[resIndex] = word[i];
			combinationsOfSizeK(word, i + 1, k, res, resIndex + 1);
		}
	}
	
	

}

class TernarySearchTree {
	class TSTNode {
		char data;
		boolean end_of_word;
		TSTNode left, right, eq;

		public TSTNode(char data) {
			super();
			this.data = data;
			left = null;
			right = null;
			eq = null;
		}
	}

	TSTNode root = null;

	public TSTNode insert(TSTNode root, String word, int pos) {
		if (null == root) {
			root = new TSTNode(word.charAt(pos));

			if (pos == word.length() - 1) {
				root.end_of_word = true;
			} else {
				root.eq = insert(root.eq, word, pos + 1);
			}
		}
		if (root.data > word.charAt(pos)) {
			root.left = insert(root.left, word, pos);
		} else if (root.data < word.charAt(pos)) {
			root.right = insert(root.right, word, pos);
		} else {
			if (pos == word.length() - 1) {
				root.end_of_word = true;
			} else {
				root.eq = insert(root.eq, word, pos + 1);
			}
		}
		return root;
	}
}
