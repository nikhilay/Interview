package leetcode.medium;

import java.util.*;

public class AccountsMerge {
    //https://leetcode.com/problems/accounts-merge/discuss/109158/Java-Solution-(Build-graph-%2B-DFS-search)
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> adjList = new HashMap<>();
        Map<String, String> emailToNameMap = new HashMap<>();

        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                emailToNameMap.put(list.get(i), name);
                if (!adjList.containsKey(list.get(i))) {
                    adjList.put(list.get(i), new HashSet<>());
                }
                if (i == 1) continue;
                adjList.get(list.get(i - 1)).add(list.get(i));
                adjList.get(list.get(i)).add(list.get(i - 1));
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>>  result = new LinkedList<>();
        for (String node : emailToNameMap.keySet()) {
            if (visited.add(node)) {
                Set<String> neighbors = adjList.get(node);
                List<String> list = new LinkedList<>();
                list.add(node);
                for (String neighbor : neighbors) {
                    dfs(neighbor, visited, adjList, list);
                }
                Collections.sort(list);
                list.add(0,emailToNameMap.get(node));
                result.add(list);
            }
        }
   return result;
    }

    private void dfs(String neighbor, Set<String> visited, Map<String, Set<String>> adjList, List<String> list){

        if(visited.add(neighbor)){
            list.add(neighbor);
            for(String node: adjList.get(neighbor)){
                dfs(node,visited,adjList,list);
            }
        }

    }
}
