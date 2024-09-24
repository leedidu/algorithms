import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> allRoute;
    static int end;
    static int[] distance;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        // 강철부대가 위치한 지역을 포함한 총지역의 수 n, 두 지역을 왕복할 수 있는 길 정보를 담은 2차원 정수배열, 각 부대원이 위치한 서로 다른 지역들, 강철부대지역
        allRoute = new ArrayList<>();
        end = destination;
        distance = new int[n + 1];

        for(int i = 0; i <= n; i++){
            allRoute.add(new ArrayList<>());
        }

        for(int[] road : roads){ // 양방향 연결
            allRoute.get(road[0]).add(road[1]);
            allRoute.get(road[1]).add(road[0]);
        }

        bfs(n);

        for(int i = 0; i < sources.length; i++){
            if(distance[sources[i]] != -1){
                answer[i] = distance[sources[i]];
            } else{
                answer[i] = -1;
            }
        }
        return answer;
    }
    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1]; // 방문 배열도 매번 초기화

        Arrays.fill(distance, -1);
        queue.add(end);
        distance[end] = 0;
        visited[end] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : allRoute.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}