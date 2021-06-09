package leetcode.medium;

public class ReorganizeString {
    //https://leetcode.com/problems/reorganize-string/discuss/232469/Java-No-Sort-O(N)-0ms-beat-100
    public String reorganizeString(String s) {

        char[] result = new char[s.length()];
        int index = 0;
        int[] frequencies = new int[26];
        int maxFreq = 0;
        int maxFreqChar = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencies[c - 'a']++;
            if (maxFreq < frequencies[c - 'a']) {
                maxFreq = frequencies[c - 'a'];
                maxFreqChar = c - 'a';
            }
        }

        if (maxFreq > (s.length() + 1) / 2) return "";
        while (frequencies[maxFreqChar] != 0) {
            result[index] = (char) (maxFreqChar + 'a');
            frequencies[maxFreqChar]--;
            index += 2;
        }

        for (int i = 0; i < frequencies.length; i++) {
            while (frequencies[i] != 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                frequencies[i]--;
                index += 2;
            }
        }

        return String.valueOf(result);
    }
}
