package com.raj.string;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * @author Raj
 *
 *
 *Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }

    // same solution but easier to read
    public String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.equals(".") && !dir.equals("")) {
                stack.push(dir);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        SimplifyPath obj = new SimplifyPath();
        String input = "";
        String result = "";
        input = "/home/";
        result = obj.simplifyPath(input);
        System.out.println(result);

        input = "/a/./b/../../c/";
        result = obj.simplifyPath(input);
        System.out.println(result);

        input = "/../";
        result = obj.simplifyPath(input);
        System.out.println(result);

        input = "/home//foo/";
        result = obj.simplifyPath(input);
        System.out.println(result);

        input = "/abc/.../";
        result = obj.simplifyPath(input);
        System.out.println(result);
    }

}
