import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
           return this.cost - o.cost;
        }
    }
        
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        ArrayList<List<Node>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares){
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }
        
        int[] distA= dijkstra(a, graph); // a혼자 타는 경우
        int[] distB = dijkstra(b, graph); // b혼자 타는 경우
        int[] distS = dijkstra(s, graph); // 같이 타는 경우
        
        for(int i = 1; i <= n; i++){
            int cost = distA[i] + distB[i] + distS[i];
            if(answer > cost){
                answer = cost;
            }
        }
        return answer;
    }
    
    private int[] dijkstra(int start, ArrayList<List<Node>> graph){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.cost < dist[now.to]){
                continue;
            }
            
            for(Node next : graph.get(now.to)){
                int newCost = next.cost + now.cost;
                if(newCost < dist[next.to]){
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
        return dist;
    }
}