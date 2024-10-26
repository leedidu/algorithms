class Solution {
    public static int answer;

    public static int solution(int[] info, int[][] edges) {
        answer = 0;
        dfs(0, new boolean[info.length], 0, 0, edges, info);
        return answer;
    }

    public static void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt, int[][] edges, int[] info){
        visited[idx] = true;

        if(info[idx] == 0){ // 양일 경우
            sheepCnt ++;
            answer = Math.max(answer, sheepCnt);
        } else { // 늑대일 경우
            wolfCnt ++;
        }

        if(sheepCnt <= wolfCnt) return; // 늑대가 더많아지면 탐색X

        for(int[] edge : edges){ // 다음 노드
            if(visited[edge[0]] && !visited[edge[1]]){
                boolean[] newVisited = visited.clone();
                dfs(edge[1], newVisited, sheepCnt, wolfCnt , edges, info);
            }
        }
    }
}