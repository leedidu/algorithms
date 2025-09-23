import java.util.*;

class Node {
    int to;
    int cost;

    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    static int ans = 0;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {   // 1번부터 N번까지
            graph.add(new ArrayList<>());
        }
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c)); // 양방향
        }
        
        int[] dist = dijkstra(graph, N);
        
        for(int i : dist){
            if(i <=K){
                answer ++;
            }
        }
        return answer;
    }
    
    private int[] dijkstra(List<List<Node>> towns, int N){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost > dist[cur.to]){
                continue;
            }
            
            for(Node next : towns.get(cur.to)){
                int cost = next.cost + cur.cost;
                
                if(cost < dist[next.to]){
                    dist[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
            }
        }
        return dist;
    }
}