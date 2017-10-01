package com.raj.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author Raj
 *
 *Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.

Example:
Input: 
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
Output:
[null,[],null,null,["a"],"hello"]
Explanation:
filesystem
Note:
You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.
 */
public class FileSystem {

	class File {
		boolean isFile;
		StringBuilder content = new StringBuilder();
		Map<String, File> children = new HashMap<>();
	}

	File root;

	public FileSystem() {
		root = new File();
	}

	public List<String> ls(String path) {
		List<String> result = new ArrayList<>();
		String dirs[] = path.split("/");
		File temp = root;
		String name = "";
		for (String dir : dirs) {
			if (dir.isEmpty())
				continue;
			if (!temp.children.containsKey(dir))
				return result;
			temp = temp.children.get(dir);
			name = dir;
		}
		if (temp.isFile) {
			result.add(name);
		} else {
			for (String key : temp.children.keySet()) {
				result.add(key);
			}
		}
		Collections.sort(result);
		return result;
	}

	public void mkdir(String path) {
		String dirs[] = path.split("/");
		File temp = root;
		for (String dir : dirs) {
			if (dir.isEmpty())
				continue;
			if (!temp.children.containsKey(dir)) {
				temp.children.put(dir, new File());
			}
			temp = temp.children.get(dir);
		}
	}

	public void addContentToFile(String filePath, String content) {
		String dirs[] = filePath.split("/");
		File temp = root;
		for (String dir : dirs) {
			if (dir.isEmpty())
				continue;
			if (!temp.children.containsKey(dir)) {
				temp.children.put(dir, new File());
			}
			temp = temp.children.get(dir);
		}
		temp.isFile = true;
		temp.content.append(content);
	}

	public String readContentFromFile(String filePath) {
		String dirs[] = filePath.split("/");
		File temp = root;
		for (String dir : dirs) {
			if (dir.isEmpty())
				continue;
			if (!temp.children.containsKey(dir)) {
				temp.children.put(dir, new File());
			}
			temp = temp.children.get(dir);
		}
		temp.isFile = true;
		return temp.content.toString();
	}

	public static void main(String... args) {
		FileSystem fs = new FileSystem();
		List<String> files = null;
		String content = null;
		files = fs.ls("/");
		System.out.println(files);
		fs.mkdir("/a/b/c");
		fs.addContentToFile("/a/b/c/d", "Hello Raj");
		files = fs.ls("/");
		System.out.println(files);
		content = fs.readContentFromFile("/a/b/c/d");
		System.out.println(content);
	}
}