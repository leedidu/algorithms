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

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        int[] startToV1 = dijkstra(1, n, graph);
        int[] v1ToV2 = dijkstra(v1, n, graph);
        int[] v2ToEnd = dijkstra(v2,n, graph);

        long INF = Long.MAX_VALUE;
        long path1 = (long)startToV1[v1] + v1ToV2[v2] + v2ToEnd[n];
        long path2 = (long)startToV1[v2] + v1ToV2[n] + v2ToEnd[v1];

        if (startToV1[v1] == Integer.MAX_VALUE || v1ToV2[v2] == Integer.MAX_VALUE || v2ToEnd[n] == Integer.MAX_VALUE || startToV1[v2] == Integer.MAX_VALUE || v2ToEnd[v1] == Integer.MAX_VALUE || v1ToV2[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(path1, path2));
        }
    }

    static int[] dijkstra(int start, int n, List<Node>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.weight) continue;
            for (Node next : graph[cur.to]) {
                int cost = dist[cur.to] + next.weight;
                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }
        return dist;
    }

}

