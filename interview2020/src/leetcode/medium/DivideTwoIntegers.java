package leetcode.medium;

public class DivideTwoIntegers {
    //https://leetcode.com/problems/divide-two-integers/solution/
    public int divide(int dividend, int divisor) {
        int HALF_MIN_VALUE = Integer.MIN_VALUE >> 1;

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negatives = 2;
        if (dividend > 0) {
            dividend = -dividend;
            negatives--;
        }

        if (divisor > 0) {
            divisor = -divisor;
            negatives--;
        }
        //-10/-3
        int quotient = 0;
        while (divisor >= dividend) {
            int value = divisor;
            int productOfTwo = 1;

            while (value>= HALF_MIN_VALUE && value + value >= dividend) {
                value+=value;
                productOfTwo+=productOfTwo;
            }
            dividend -=value;
            quotient +=productOfTwo;
        }

        if (negatives == 1) {
            quotient = -quotient;
        }
        return quotient;
    }
}
