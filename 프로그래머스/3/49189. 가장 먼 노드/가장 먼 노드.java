import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        return bfs(1);
    }

    public static int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        int cnt = 0;

        while(true){
            Queue<Integer> temp = new LinkedList<>();

            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int i : graph.get(cur)){
                    if(!visited[i]){
                        temp.add(i);
                        visited[i] = true;
                    }
                }
            }

            if(temp.isEmpty()){
                break;
            }
            queue.addAll(temp);
            cnt = temp.size();
        }
        return cnt;
    }
}