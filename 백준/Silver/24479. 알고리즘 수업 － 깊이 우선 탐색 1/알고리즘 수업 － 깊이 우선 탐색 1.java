import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점
        List<Integer> nodes = new ArrayList<>();

        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            graph[now].add(next);
            graph[next].add(now);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(visited, r, nodes, graph);
        int[] order = new int[n + 1];
        for (int i = 0; i < nodes.size(); i++) {
            order[nodes.get(i)] = i + 1;
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(order[i]);
        }

    }

    static void dfs(boolean[] visited, int start, List<Integer> nodes, List<Integer>[] graph) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;
        nodes.add(start);
        Collections.sort(graph[start]);

        List<Integer> next = graph[start];
        if (!next.isEmpty()) {
            for (int j = 0; j < next.size(); j++) {
                dfs(visited, next.get(j), nodes, graph);
            }
        }
    }
}