package leetcode.easy;

public class Sqrt {
    //69. Sqrt(x)
    //
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
