package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();

        while (left <= right) {
            if (isValidSelfDividingNumber(left)) {
                result.add(left);
            }
            left++;
        }

        return result;
    }

    private boolean isValidSelfDividingNumber(int n) {
        int number = n;
        while (number != 0) {
            int digit = number % 10;
            if (digit == 0 || (n % digit != 0)) return false;
            number = number / 10;
        }
        return true;
    }
}
