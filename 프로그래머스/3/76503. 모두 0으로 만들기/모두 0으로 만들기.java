import java.util.*;

public class Solution {
    static long totalOperations;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static long[] weight;

    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        for (int value : a) sum += value;
        if (sum != 0) return -1;

        int n = a.length;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        visited = new boolean[n];
        weight = new long[n];
        for (int i = 0; i < n; i++) weight[i] = a[i];

        totalOperations = 0;
        dfs(0);
        return totalOperations;
    }

    static long dfs(int node) {
        visited[node] = true;
        long sum = weight[node];

        for (int i = 0; i < graph.get(node).size(); i++) {
            int neighbor = graph.get(node).get(i);
            if (!visited[neighbor]) {
                sum += dfs(neighbor);
            }
        }

        totalOperations += Math.abs(sum);
        return sum;
    }
}
