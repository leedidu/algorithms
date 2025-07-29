import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vNum = Integer.parseInt(st.nextToken());
        int eNum = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int INF = Integer.MAX_VALUE;

        List<Node>[] graph = new ArrayList[vNum + 1];
        for (int i = 1; i <= vNum; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < eNum; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[now].add(new Node(next, weight));
        }

        int[] dist = new int[vNum + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int cur = now.to;
            int curDist = now.weight;

            if (dist[cur] < curDist) {
                continue;
            }

            for (Node next : graph[cur]) {
                int cost = dist[cur] + next.weight;
                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    q.add(new Node(next.to, cost));
                }
            }
        }
        for (int i = 1; i <= vNum; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}

