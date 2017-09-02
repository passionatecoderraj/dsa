/**
 * 
 */
package com.interview.practice;

import java.io.File;

/**
 * @author Raj
 *
 */
public class ShowStats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "C:\\Users\\Raj\\workspace\\prac\\src\\com\\raj\\";
		int result = -1;
		result = showStats(path, 0);
		System.out.println(result );
	}

	public static String getSpaces(int level) {
		String space = "      ";
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < level; i++) {
			str.append(space);
		}
		return str.toString();
	}

	public static int getCount(File[] files) {
		int count = 0;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile())
				count++;
		}
		return count;
	}

	public static int showStats(String path, int level) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		String spaces = getSpaces(level);
		int count = 0, cur_dir_count = 0;
		for (int i = 0; i < folder.listFiles().length; i++) {
			if (listOfFiles[i].isFile()) {
				String name = listOfFiles[i].getName();
				System.out.println(spaces + name.substring(0, name.length() - 5));
				cur_dir_count++;
			}
		}
		for (int i = 0; i < folder.listFiles().length; i++) {
			if (listOfFiles[i].isDirectory()) {
				int c = getCount(listOfFiles[i].listFiles());
				System.out.println(spaces + listOfFiles[i].getName() + "(Count-" + c + ")");
				int r = showStats(path + listOfFiles[i].getName() + "\\", level + 1);
				count += r;
			}
		}
		return count + cur_dir_count;
	}

}