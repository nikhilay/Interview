package leetcode.medium;

public class ReverseWordsInAString {
    //https://leetcode.com/problems/reverse-words-in-a-string/solution/
    public String reverseWords(String s) {
        //clear spaces
        String stringWithoutSpaces = trimSpaces(s);
        // reverse word
        String reverseWord = reverse(stringWithoutSpaces, 0, stringWithoutSpaces.length());
        //reverse each word
        return reverseEachWord(reverseWord);

    }

    private String trimSpaces(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;

        while (s.charAt(start) == ' ') ++start;
        while (s.charAt(end) == ' ') --end;

        while (start <= end) {
            char c = s.charAt(start);

            if (c != ' ') {
                sb.append(c);
            } else if (s.charAt(start - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb.toString();
    }

    private String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        while (start < end) {
            sb.append(s.charAt(end - 1));
            end--;

        }
        return sb.toString();
    }

    private String reverseEachWord(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < s.length() && j < s.length()) {
            while (j < s.length() && s.charAt(j) != ' ') ++j;
            sb.append(reverse(s, i, j));
            if (j != s.length()) sb.append(' ');
            i = j + 1;
            j++;

        }
        return sb.toString();
    }
}
