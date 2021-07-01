package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    //https://leetcode.com/problems/restore-ip-addresses/discuss/504942/Java-Clean-code-with-Choose-Explore-Unchoose-template-of-backtracking
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        dfs(s, result, new LinkedList<>(), 0);
        return result;
    }

    private void dfs(String s, List<String> result, List<String> ip, int start) {

        if (ip.size() == 4 && start == s.length()) {
            result.add(String.join(".", ip));
            return;
        }
        if (ip.size() > 4 || start >= s.length()) return;

        for (int i = start; i < s.length(); i++) {
            String part = s.substring(start, i + 1);
            if (part.length() == 0 || Integer.valueOf(part) > 255 || (part.charAt(0) == '0' && part.length() != 1)) {
                break;
            }
            ip.add(part);
            dfs(s, result, ip, i + 1);
            ip.remove(ip.size() - 1);
        }
    }
    
}
