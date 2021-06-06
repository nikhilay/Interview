package leetcode.medium;

public class StringCompression {
    //https://leetcode.com/problems/string-compression/discuss/92559/Simple-Easy-to-Understand-Java-solution
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int index = 0;
        int finalIndex = 0;
        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while (index<chars.length && currentChar == chars[index]) {
                count++;
                index++;
            }
            System.out.println(index);
            chars[finalIndex++] = currentChar;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[finalIndex++] = c;
                }
            }

        }
        return finalIndex;
    }
}
