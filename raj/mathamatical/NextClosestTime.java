/**
 *
 */
package com.raj.mathamatical;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj 
 * 
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

 */
public class NextClosestTime {

    /*
     * if you have time 12:00(noon) : 720, 12:05 means 725 i.e. (725 - 720) % (24 * 60) = 5 secs
     *
     * 00:10 means (10 - 720) % (24 * 60) = -710 nothing but -> 24*60-710 = 730;
     *
     * (if result is negative add to 24*60 because max time we get next closest is same time which is 24 hours away
     */
    public String nextClosestTime(String time) {

        int start = Integer.parseInt(time.substring(0, 2)) * 60;
        start += Integer.parseInt(time.substring(3));

        List<Integer> digits = new ArrayList<>();
        for (Character ch : time.toCharArray()) {
            if (ch != ':') {
                digits.add(ch - '0');
            }
        }

        String res = time;
        int min = 24 * 60;
        for (int h1 : digits) {
            for (int h2 : digits) {
                if (h1 * 10 + h2 >= 24) {
                    continue;
                }
                for (int m1 : digits) {
                    for (int m2 : digits) {

                        if (m1 * 10 + m2 >= 60) {
                            continue;
                        }
                        int cur = ((h1 * 10 + h2) * 60) + (m1 * 10 + m2);

                        int val = (cur - start) % (24 * 60);
                        val = val > 0 ? val : ((24 * 60) + val);
                        if (val == start) {
                            continue;
                        }
                        if (val < min) {
                            min = val;
                            res = Integer.toString(h1) + "" + Integer.toString(h2) + ":" + Integer.toString(m1) + ""
                                    + Integer.toString(m2);
                        }
                    }
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        // new Date(year, month, day), month: 0 index

        String result = "";
        NextClosestTime obj = new NextClosestTime();
        result = obj.nextClosestTime("19:34");
        System.out.println(result);

        result = obj.nextClosestTime("00:00");
        System.out.println(result);

    }

}
