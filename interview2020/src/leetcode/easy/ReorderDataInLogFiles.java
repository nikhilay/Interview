package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> logComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                int s1logIndex = s1SpaceIndex + 1;
                int s2logIndex = s2SpaceIndex + 1;

                char s1FirstChar = s1.charAt(s1logIndex);
                char s2FirstChar = s2.charAt(s2logIndex);
                //Both are digits
                if (s1FirstChar <= '9' && s2FirstChar <= '9') return 0;
                //s1 digit and s2 log
                if (s1FirstChar <= '9') return 1;
                //s1 log and s1 digit
                if (s2FirstChar <= '9') return -1;

                int compareletters = s1.substring(s1logIndex).compareTo(s2.substring(s2logIndex));

                if (compareletters != 0) return compareletters;

                int compareIdentifier = s1.substring(0, s1logIndex).compareTo(s2.substring(0,s2logIndex));

                return compareIdentifier;
            }
        };
        Arrays.sort(logs,logComparator);
        return logs;
    }

}
