package leetcode.hard;

public class MinimumWindowSubstring {
    //https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
    //https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems/25816
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count[c]++;
        }

        int start = 0;
        int end = 0;
        int minStart = 0;
        int len = t.length();
        int minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            count[c]--;
            if(count[c]>=0) len -- ;
            end++;

            while(len == 0){
                if(minLen > end - start){
                    minLen = end - start;
                    minStart = start;
                }
                char cStart  = s.charAt(start);
                count[cStart]++;
                if(count[cStart]>0)len++;
                start++;


            }
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(minStart, minStart + minLen);

    }
}
