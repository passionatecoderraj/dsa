/**
 * 
 */
package com.raj.mathamatical;

import java.util.HashMap;

/**
 * @author Raj
 *
 *         Suppose we abstract our file system by a string in the following
 *         manner:
 * 
 *         The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * 
 *         dir subdir1 subdir2 file.ext The directory dir contains an empty
 *         sub-directory subdir1 and a sub-directory subdir2 containing a file
 *         file.ext.
 * 
 *         The string "dir\n
 * 
 *         \tsubdir1\n
 * 
 *         \t\tfile1.ext\n
 * 
 *         \t\tsubsubdir1\n
 * 
 *         \tsubdir2\n
 * 
 *         \t\tsubsubdir2\n
 * 
 *         \t\t\tfile2.ext"
 * 
 *         represents:
 * 
 *         dir subdir1 file1.ext subsubdir1 subdir2 subsubdir2 file2.ext The
 *         directory dir contains two sub-directories subdir1 and subdir2.
 *         subdir1 contains a file file1.ext and an empty second-level
 *         sub-directory subsubdir1. subdir2 contains a second-level
 *         sub-directory subsubdir2 containing a file file2.ext.
 * 
 *         We are interested in finding the longest (number of characters)
 *         absolute path to a file within our file system. For example, in the
 *         second example above, the longest absolute path is
 *         "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not
 *         including the double quotes).
 * 
 *         Given a string representing the file system in the above format,
 *         return the length of the longest absolute path to file in the
 *         abstracted file system. If there is no file in the system, return 0.
 * 
 *         Note: The name of a file contains at least a . and an extension. The
 *         name of a directory or sub-directory will not contain a .. Time
 *         complexity required: O(n) where n is the size of the input string.
 * 
 *         Notice that a/aa/aaa/file1.txt is not the longest file path, if there
 *         is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 * 
 *         look here for problem description :
 *         https://leetcode.com/problems/longest-absolute-file-path/
 */
public class LongestAbsoluteFilePath {

	// at each
	// Time :O(n),Space :O(n)
	public static int lengthLongestPath(String input) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(-1, 0);
		int result = 0;
		for (String s : input.split("\n")) {
			int level = s.lastIndexOf("\t");
			int len = s.substring(level + 1).length();
			// if it's a file check for max size
			if (s.contains(".")) {
				result = Math.max(result, hashMap.get(level) + len);
			}
			// if it's a level create a new level with length so far
			else {
				// hashMap.get(level) + len + 1 -> here '1' represents the '\'
				// in output
				hashMap.put(level + 1, hashMap.get(level) + len + 1);
			}
		}
		return result;
	}

	public static int lengthLongestPath2(String input) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, 0);
		int result = 0;
		for (String s : input.split("\n")) {
			int level = s.lastIndexOf("\t") + 1;
			int len = s.substring(level).length();
			if (s.contains(".")) {
				result = Math.max(result, hashMap.get(level) + len);
			} else {
				// hashMap.get(level) + len + 1 -> here '1' represents the '\'
				// in output
				hashMap.put(level + 1, hashMap.get(level) + len + 1);
			}
		}
		System.out.println(hashMap);
		return result;
	}

	public static void main(String[] args) {
		int res = -1;
		res = lengthLongestPath(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
		System.out.println(res);
		res = lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
		System.out.println(res);
	}

}
