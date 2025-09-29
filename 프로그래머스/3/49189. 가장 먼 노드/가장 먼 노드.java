import java.util.*;

class Node {
    int now;
    ArrayList<Integer> to;
    
    Node(int now, ArrayList<Integer> to){
        this.now = now;
        this.to = to;
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, new ArrayList<>());
        }
        
        for(int[] e: edge){
            nodes[e[0]].to.add(e[1]);
            nodes[e[1]].to.add(e[0]);
        }
        
        Queue<Integer> q= new LinkedList();
        q.offer(1);
        boolean[]visited = new boolean[n+1];
        visited[1] = true;
        int[] dist = new int[n + 1];
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i = 0; i < nodes[now].to.size(); i++){
                int next = nodes[now].to.get(i);
                
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
        int max = 0;
        for(int i : dist){
            if(max < i){
                max = i;
            }
        }
        for(int i= 0; i < dist.length; i++){
            if(dist[i] == max){
                answer++;
            }
        }
        return answer;
    }
}