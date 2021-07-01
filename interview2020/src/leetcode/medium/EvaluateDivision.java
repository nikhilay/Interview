package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    //https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build Graph
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);

        // Go through the queries
        double[] result = new double[queries.size()];
        for (int q = 0; q < queries.size(); q++) {
            result[q] = findPathValue(graph, queries.get(q).get(0), queries.get(q).get(1), new HashSet<>());
        }
        //return result
        return result;
    }

    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String node1 = equations.get(i).get(0);
            String node2 = equations.get(i).get(1);
            double weight = values[i];
            if (!graph.containsKey(node1)) graph.put(node1, new HashMap<>());
            graph.get(node1).put(node2, weight);
            graph.get(node1).put(node1, 1.0);
            if (!graph.containsKey(node2)) graph.put(node2, new HashMap<>());
            graph.get(node2).put(node2, 1.0);
            graph.get(node2).put(node1, 1.0 / weight);


        }
        return graph;
    }

    private double findPathValue(HashMap<String, HashMap<String, Double>> graph, String start, String end,
                                 HashSet<String> visited) {

        if (!graph.containsKey(start)) return -1.0;

        if (graph.get(start).containsKey(end)) return graph.get(start).get(end);

        visited.add(start);

        for (String node : graph.get(start).keySet()) {
            if (!visited.contains(node)) {
                double val = findPathValue(graph, node, end, visited);
                if (val != -1.0) {
                    return graph.get(start).get(node) * val;
                }
            }
        }
        return -1.0;

    }
}
