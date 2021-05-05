package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    //https://leetcode.com/problems/subdomain-visit-count/discuss/121738/C%2B%2BJavaPython-Easy-Understood-Solution
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> cpDomainMap = new HashMap<>();
        for (String s : cpdomains) {
            int pos = s.indexOf(" ");
            int count = Integer.valueOf(s.substring(0, pos));
            String domain = s.substring(pos + 1);
            cpDomainMap.put(domain, cpDomainMap.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String superDomain = domain.substring(i + 1);
                    cpDomainMap.put(superDomain, cpDomainMap.getOrDefault(superDomain, 0) + count);
                }

            }
        }
        List<String> result = new ArrayList<>();
        for (String s : cpDomainMap.keySet()) {
            result.add(cpDomainMap.get(s) + " " + s);
        }
        return result;
    }
}
