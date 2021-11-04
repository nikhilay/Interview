package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) return true;
        HashMap<Character, HashSet<Character>> adjacencyList = new HashMap<>();
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char var1 = equation.charAt(0);
                char var2 = equation.charAt(3);

                if (!adjacencyList.containsKey(var1)) adjacencyList.put(var1, new HashSet<>());
                if (!adjacencyList.containsKey(var2)) adjacencyList.put(var2, new HashSet<>());

                adjacencyList.get(var1).add(var2);
                adjacencyList.get(var2).add(var1);

            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char var1 = equation.charAt(0);
                char var2 = equation.charAt(3);

                if (var1 == var2) return false;
                if (!adjacencyList.containsKey(var1) || !adjacencyList.containsKey(var2)) continue;

                if (hasConflict(adjacencyList, var1, var2, new HashSet<>())) return false;

            }
        }
        return true;
    }

    private boolean hasConflict(HashMap<Character, HashSet<Character>> adjacencyList,
                                char var1, char var2, HashSet<Character> visited){
        if(var1==var2) return true;

        visited.add(var1);
        for(char next : adjacencyList.get(var1)){
            if(!visited.contains(next)){
                if(hasConflict(adjacencyList, next, var2, visited)) return true;
            }
        }
       return false;
    }
}
