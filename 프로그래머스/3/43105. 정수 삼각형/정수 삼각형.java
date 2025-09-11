import java.util.*;

class Solution {
    static int[][] ans;
    public int solution(int[][] triangle) {
        int answer = 0;
        ans = new int[triangle.length][];
        for(int i = 0; i < triangle.length; i++){
            ans[i] = new int[triangle[i].length];
        }
        ans[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0){
                    ans[i][j] = triangle[i][j] + ans[i - 1][j];
                } 
            }
        }
        dp(triangle);
        for(int i = 0; i < ans[ans.length - 1].length; i++){
            if(answer < ans[ans.length - 1][i]){
                answer = ans[ans.length - 1][i];
            }
        }
        return answer;
    }
    
    private void dp(int[][] triangle){
        for(int i = 1; i < triangle.length; i++){
            for(int j = 1; j < triangle[i].length; j++){
                if(j == triangle[i].length - 1){
                    ans[i][j] = ans[i-1][j-1] + triangle[i][j];
                } else {
                    ans[i][j] = Math.max(ans[i-1][j-1], ans[i-1][j]) + triangle[i][j];
            }            }
        }
    }
}