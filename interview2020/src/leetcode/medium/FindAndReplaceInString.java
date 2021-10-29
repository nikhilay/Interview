package leetcode.medium;

import java.util.HashMap;

public class FindAndReplaceInString {
    //https://leetcode.com/problems/find-and-replace-in-string/discuss/134758/Java-O(n)-solution
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        if (indices == null || sources == null || targets == null) return "";
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                map.put(indices[i], i);
            }
        }

        for (int i = 0; i < s.length();) {
            if(map.containsKey(i)){
                sb.append(targets[map.get(i)]);
                i+=sources[map.get(i)].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
