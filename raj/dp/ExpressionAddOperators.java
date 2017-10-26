package com.raj.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return rst;
        }
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    // a little trick is that we should save the value(prevResult) that is to be multiplied in the next recursion.

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long prevNum) {
        if (pos == num.length()) {
            if (target == eval) {
                rst.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // 0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it
            // too.
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }

            // overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                /*@formatter:off
                 * suppose num = 234 and target=  14 , result is : 2+3*4
                 *  Step1 : 2
                 *  Step2 : 2+3(5), 2-3(-1),2*3(6)
                 *  Step3 : evalution should be : 2+3"+4", 2+3"-4", 2+3"*4". For + and -, doing operation on previous result(i.e. 5) is fine.
                 *          However, for multiplication it also tries to 5*4. Which is wrong. Instead, it should multiply wit prevNum(i.e.3).
                 *          For that case, we do cur*prevNum and also deduct prevNum from 'eval' since we are considering 'prevNum' for multiplication.
                 *
                 *
                 *@formatter:on
                 */
                helper(rst, path + "*" + cur, num, target, i + 1, eval - prevNum + prevNum * cur, prevNum * cur);
            }
        }
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
