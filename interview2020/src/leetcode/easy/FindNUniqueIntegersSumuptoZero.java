package leetcode.easy;

public class FindNUniqueIntegersSumuptoZero {
    //https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/discuss/464344/Trivial-PythonRubyJavaC%2B%2B
    //https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/discuss/463890/Simple-Java-%3A-Fill-from-both-sides
    public int[] sumZero(int n) {
        int[] result = new int[n];

        for (int i = 1; i < n; i++) {
            result[i] = i;
            result[0] -= i;
        }
        return result;
    }
}
