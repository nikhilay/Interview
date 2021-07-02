package leetcode.medium;

public class Pow {
    public double myPow(double x, int n) {

        if (n < 0) {
            if(n==Integer.MIN_VALUE){
              n+=2;
            }
            n = -n;
            x = 1 / x;
        }

        double ans = 1.0;

        while (n > 0) {

            if (n % 2 == 1) {
                ans *= x;
            }
            x = x * x;
            n = n / 2;
        }
        return ans;
    }
}
