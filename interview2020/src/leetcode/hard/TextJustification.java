package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    //https://leetcode.com/problems/text-justification/discuss/24902/Java-easy-to-understand-broken-into-several-functions
    //https://leetcode.com/problems/text-justification/discuss/24902/Java-easy-to-understand-broken-into-several-functions/339909
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        int start = 0;
        while (start < words.length) {
            int end = findtheEndWord(start, words, maxWidth);
            justify(start, end, words, maxWidth, result);
            start = end + 1;
        }
        return result;
    }

    private int findtheEndWord(int start, String[] words, int maxWidth) {
        int count = words[start++].length();
        while (start < words.length && words[start].length() + 1 + count <= maxWidth) {
            count += words[start].length() + 1;
            start++;
        }
        return start - 1;
    }

    private void justify(int start, int end, String[] words, int maxWidth, List<String> result) {
        if (start == end) {
            result.add(lastLinePadding(words[start], maxWidth));
            return;
        }
        boolean isLastLine = end == words.length - 1;
        int wordsLen = wordLength(start, end, words);
        int totalSpaces = maxWidth - wordsLen;
        int numSpaces = end - start;
        String space = isLastLine ? " " : blank(totalSpaces / numSpaces);
        int remainder = isLastLine ? 0 : totalSpaces % numSpaces;

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(words[i])
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");
        }

        if (isLastLine) {
            result.add(lastLinePadding(sb.toString().trim(), maxWidth));
            return;
        }
        result.add(sb.toString().trim());
    }

    private String lastLinePadding(String s, int maxWidth) {
        int n = maxWidth - s.length();
        StringBuilder sb = new StringBuilder(s);
        while (n-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String blank(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(" ");
            n--;
        }
        return sb.toString();
    }

    private int wordLength(int start, int end, String[] words) {
        int len = 0;
        for (int i = start; i <= end; i++) {
            len += words[i].length();
        }
        return len;
    }
}

