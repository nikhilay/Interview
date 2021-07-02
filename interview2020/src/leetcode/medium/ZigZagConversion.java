package leetcode.medium;


public class ZigZagConversion {
    public String convert(String s, int numRows) {

        StringBuilder result = new StringBuilder();
        StringBuilder[] map = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            map[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {

            for (int index = 0; index < numRows && i < s.length(); index++) {
                map[index] = map[index].append(s.charAt(i++));
            }

            for (int index = numRows - 2; index >= 1 && i < s.length() ; index--) {
                map[index] = map[index].append(s.charAt(i++));
            }

        }
        for (StringBuilder sb : map) {
            result.append(sb.toString());
        }
        return result.toString();

    }
}
