package leetcode.hard;

import java.util.*;

public class AlienDictionary {
    //https://leetcode.com/problems/alien-dictionary/solution/
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        HashMap<Character, List<Character>> adjList = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        //Lets create in-degree matrix
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c,0);
                adjList.put(c, new LinkedList<>());
            }

        }


        // Forming all the edges and in-degree list
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) return "";
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j),
                            indegree.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        //Let's loop through indegree matrix to find out which indegree is 0

        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty()){
            char c = queue.poll();
            result.append(c);
            for(Character next:adjList.get(c) ){
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next)==0) queue.offer(next);
            }
        }
        //["z","x","a","zb","zx"]
        if(result.length() < indegree.size()) return "";

    return result.toString();
    }
}
