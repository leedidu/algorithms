import java.util.*;

class Solution {
    public int[] solution(int n, int s) {        
        if(n > s){
            return new int[]{-1};
        } 
        int[] answer = new int[n];
        
        int q = s / n;
        int r = s % n;

        Arrays.fill(answer, q);

        for (int i = n - r; i < n; i++) { // 뒤에서부터 분배
            answer[i]++;
        }
        
        return answer;
    }
}