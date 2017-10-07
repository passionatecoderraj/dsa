package com.raj.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num.isEmpty()) {
            return result;
        }
        if (num.length() == 1) {
            if (num.charAt(0) - '0' == target) {
                result.add(num);
            }
            return result;

        }
        addOperatorsUtil(num, 1, num.charAt(0) - '0', num.charAt(0) + "", target, result);
        return result;
    }

    private void addOperatorsUtil(String num, int i, int cur, String st, int target, List<String> result) {
        if (i == num.length()) {
            if (cur == target) {
                result.add(st);
            }
            return;
        }
        int digit = num.charAt(i) - '0';
        addOperatorsUtil(num, i + 1, cur + digit, st + "+" + num.charAt(i), target, result);
        addOperatorsUtil(num, i + 1, cur - digit, st + "-" + num.charAt(i), target, result);
        addOperatorsUtil(num, i + 1, cur * digit, st + "*" + num.charAt(i), target, result);

    }

    public static void main(String[] args) {
        ExpressionAddOperators obj = new ExpressionAddOperators();
        List<String> res = null;
        res = obj.addOperators("123", 6);
        System.out.println(res);

        res = obj.addOperators("232", 8);
        System.out.println(res);

        res = obj.addOperators("105", 5);
        System.out.println(res);

        res = obj.addOperators("00", 0);
        System.out.println(res);

        res = obj.addOperators("3456237490", 9191);
        System.out.println(res);

    }

}
