import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int[] t = new int[times.length];
        for(int i = 0; i < times.length; i++){
            t[i] = times[i];
        }
        Arrays.sort(t);
        long left = 1;
        long right = (long)t[t.length - 1] * n;

        while(true){
            if(left > right) break;
            
            long mid = (left + right) / 2;
            long num = 0;
            for(int i = 0; i < times.length; i++){
                num += (mid/times[i]);
            }
            if(num >= n){
                answer = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return answer;
    }
}