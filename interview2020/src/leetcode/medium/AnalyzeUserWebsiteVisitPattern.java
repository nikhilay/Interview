package leetcode.medium;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    class Node {
        String username;
        int timestamp;
        String website;

        Node(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> result = new LinkedList<>();
        if (username == null || timestamp == null || website == null) return result;
        List<Node> traffic = new LinkedList<>();
        for (int i = 0; i < username.length; i++) {
            traffic.add(new Node(username[i], timestamp[i], website[i]));
        }

        Collections.sort(traffic, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.timestamp - o2.timestamp;
            }
        });
        HashMap<String, List<String>> memo = new HashMap<>();
        for (int i = 0; i < traffic.size(); i++) {
            String user = traffic.get(i).username;
            if (!memo.containsKey(user)) memo.put(user, new LinkedList<>());
            memo.get(user).add(traffic.get(i).website);
        }
        HashMap<String, Integer> freq = new HashMap<>();
        //form 3 sequences
        for (String user : memo.keySet()) {
            HashMap<String, Integer> map = new HashMap<>();
            generateSequence(map, memo.get(user), 0, new LinkedList<String>());
            for(String site: map.keySet()){
                freq.put(site, freq.getOrDefault(site, 0)  + 1);
            }
        }
        String res = "";
        int max = Integer.MIN_VALUE;
        for (String pattern : freq.keySet()) {
            if (freq.get(pattern) > max) {
                res = pattern;
                max = Math.max(max, freq.get(pattern));
            } else if (freq.get(pattern) == max && res.compareTo(pattern) > 0) {
                res = pattern;

            }

        }
        for (String site : res.split(",")) {
            result.add(site);
        }
        return result;
    }

    //home,about, rei, career
    private void generateSequence(HashMap<String, Integer> freq, List<String> websites, int index, List<String> list) {
        if (list.size() == 3) {
            StringBuilder pattern = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                pattern.append(list.get(i));
                if (i != 2) pattern.append(",");
            }
            if (!freq.containsKey(pattern.toString())) {
                freq.put(pattern.toString(), freq.getOrDefault(pattern.toString(), 0) + 1);
            }
            return;
        }

        for (int i = index; i < websites.size(); i++) {
            list.add(websites.get(i));
            generateSequence(freq, websites, i + 1, list);
            list.remove(list.size() - 1);

        }
    }
    /*
    ["joe","joe","joe","james","james","james","james","mary","mary","mary","joe"]
[1,2,3,4,5,6,7,8,9,10,11]
["home","about","rei","home","cart","maps","home","home","about","career", "career"]
     */
}
