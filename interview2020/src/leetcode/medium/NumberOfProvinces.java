package leetcode.medium;

public class NumberOfProvinces {
    //https://leetcode.com/problems/number-of-provinces/discuss/101338/Neat-DFS-java-solution
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int city = 0; city < isConnected.length; city++) {
            if (visited[city] == 0) {
                dfs(isConnected, visited, city);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int[] visited, int origin) {
        for (int dest = 0; dest < isConnected.length; dest++) {
            if(isConnected[origin][dest]==1 && visited[dest]==0){
                visited[dest] = 1;
                dfs(isConnected, visited,dest);
            }
        }
    }
}
