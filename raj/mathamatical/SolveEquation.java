package com.raj.mathamatical;

/**
 * @author Raj
 * @formatter : off
 *Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:
Input: "x=x"
Output: "Infinite solutions"
Example 3:
Input: "2x=x"
Output: "x=0"
Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"
Example 5:
Input: "x=x+2"
Output: "No solution"
 *
 * @formatter : on
 */
import java.util.ArrayList;
import java.util.List;

public class SolveEquation {

    // Time : O(n), Space : O(n)
    public String solveEquation(String eq) {
        String arr[] = eq.split("=");
        int a1, b1, a2, b2;
        a1 = b1 = a2 = b2 = 0;
        for (String str : breakIt(arr[0])) {
            if (str.indexOf("x") >= 0) {
                a1 += Integer.parseInt(coeff(str));
            } else {
                b1 += Integer.parseInt(str);
            }
        }

        for (String str : breakIt(arr[1])) {
            if (str.indexOf("x") >= 0) {
                a2 += Integer.parseInt(coeff(str));
            } else {
                b2 += Integer.parseInt(str);
            }
        }
        if (a1 == a2) {
            if (b1 == b2) {
                return "Infinite solutions";
            }
            return "No solution";
        }

        return "x=" + (b2 - b1) / (a1 - a2);
    }

    public List<String> breakIt(String str) {
        List<String> res = new ArrayList<>();
        int l = 0;
        for (int r = 1; r < str.length(); r++) {
            char ch = str.charAt(r);
            if (ch == '+' || ch == '-') {
                res.add(str.substring(l, r));
                l = r;
            }
        }
        res.add(str.substring(l));
        return res;
    }

    public String coeff(String x) {
        if (x.length() == 1) {
            return "1";
        }
        if (x.length() == 2 && (x.charAt(0) == '+' || x.charAt(0) == '-')) {
            return x.replace("x", "1");
        }
        return x.replace("x", "");
    }

    public List<String> breakIt2(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '+' || ch == '-') {
                if (sb.length() > 0) {
                    res.add(sb.toString());
                    sb.setLength(0);
                }
            }
            sb.append(ch);
        }
        res.add(sb.toString());

        return res;
    }

    public static void main(String[] args) {
        SolveEquation obj = new SolveEquation();
        String input = null;
        input = "4x+5-3+x=61+2x-2";

        String result = null;
        result = obj.solveEquation(input);
        System.out.println(result);

    }

}
