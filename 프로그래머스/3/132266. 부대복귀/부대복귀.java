import java.util.*;

class Node{
    int to;
    
    Node(int to){
        this.to = to;
    }
}

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            graph.get(road[0]).add(new Node(road[1]));
            graph.get(road[1]).add(new Node(road[0]));
        }
        
        int[] dist = bfs(graph, n, destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = (dist[sources[i]] == Integer.MAX_VALUE) ? -1 : dist[sources[i]];
        }
        return answer;
    }
    
    private int[] bfs(List<List<Node>> graph, int n, int dest){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[dest] = 0;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(dest));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            for (Node next : graph.get(cur.to)) {
                if (dist[next.to] == Integer.MAX_VALUE) {
                    dist[next.to] = dist[cur.to] + 1;
                    q.offer(next);
                }
            }
        }
        return dist;
    }
}