package leetcode.medium;

public class IntegerToRoman {
    //https://leetcode.com/problems/integer-to-roman/discuss/6310/My-java-solution-easy-to-understand
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] notation = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num != 0; i++) {
            while (num >= values[i]) {
                sb.append(notation[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
