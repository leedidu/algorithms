import java.util.*;

class Solution {
    static int[][] routes;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        routes = new int[n][m];
        routes[0][0] = 1;
                
        for(int[] puddle : puddles){
            routes[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        for(int i = 0; i < m; i++){
            if(routes[0][i] == -1){
                break;
            }
            routes[0][i] = 1;
        }
        for(int i = 0; i < n; i++){
            if(routes[i][0] == -1){
                break;
            }
            routes[i][0] = 1;
        }
        dp(m, n);
        answer = routes[n - 1][m - 1] % 1000000007;
        return answer;
    }
    
    private void dp(int m, int n){
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(routes[i][j] == -1){
                    continue;
                }
                
                int up = routes[i - 1][j] == -1 ? 0 : routes[i - 1][j];
                int left = routes[i][j - 1] == -1 ? 0 : routes[i][j - 1];
                routes[i][j] = (up + left) % 1000000007;
            }
        }
    }
}