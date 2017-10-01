/**
 *
 */
package com.raj.mathamatical;

/**
 * @author Raj
 */
public class XPowerN {

    public double myPow(double x, int n) {
        if (0 == n) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        return x * temp * temp;
    }

    public double pow(double x, int n) {
        if (0 == n) {
            return 1;
        }
        if (n < 0) {
            return (1.0 / powOptimized(x, n));
        }
        return powOptimized(x, n);
    }

    public double powOptimized(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = powOptimized(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        return x * temp * temp;
    }

    public static void main(String[] args) {
        XPowerN obj = new XPowerN();
        int result = -1, x = 2, n = 10;

        // Time :O(logn)
        double res = 0;
        res = obj.powOptimized(x, n);
        System.out.println(result);

        // Time :O(logn)
        // for negative values also
        res = obj.pow(2, -3);
        System.out.println(res);

        res = obj.myPow(2, -3);
        System.out.println(res);
    }

}