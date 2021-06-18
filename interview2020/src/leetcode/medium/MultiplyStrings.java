package leetcode.medium;

public class MultiplyStrings {
    //https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = prod + result[p2];
                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (digit != 0) sb.append(digit);
            if (sb.length() != 0 && digit == 0) sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
