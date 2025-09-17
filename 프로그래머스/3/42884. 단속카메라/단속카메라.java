import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int now = routes[0][1];
        int answer = 1;

        for(int[] route : routes){
            if(route[0] <= now && route[1] >= now){
                continue;
            }
            now = route[1];
            answer++;
        }
        
        return answer;
    }
}