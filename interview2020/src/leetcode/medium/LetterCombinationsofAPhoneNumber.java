package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofAPhoneNumber {
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
    public List<String> letterCombinations(String digits) {
        LinkedList<String> combinations = new LinkedList<>();
        if (digits.length() == 0) return combinations;
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combinations.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Integer.valueOf(digits.charAt(i));
            while (combinations.peek().length() == i) {
                String ans = combinations.remove();
                for (char c : letters[num - '0'].toCharArray()) {
                    combinations.add(ans + c);
                }
            }

        }
        return combinations;
    }
}
