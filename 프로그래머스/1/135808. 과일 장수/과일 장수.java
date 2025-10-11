import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // 1 1 1 2 2 3 3 : 7개
        
        
        Arrays.sort(score);
        int total = score.length / m;
        for(int i = 1; i <= total; i++){
            answer += score[score.length - (m * i)] * m;
        }
        return answer;
    }
}