import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int index, int n, int[][] computers){
        if(visited[index]){
            return;
        }
        
        visited[index] = true;
        
        for(int i = 0; i < n; i++){
            if(computers[index][i] == 1){
                dfs(i, n, computers);
            }
        }
    }
}