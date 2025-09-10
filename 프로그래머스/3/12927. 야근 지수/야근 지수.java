import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int work : works){
            q.offer(work);
        }
        
        for(int i = 0; i < n; i++){
            if(q.isEmpty()){
                break;
            }
            int num = q.poll();
            if(num <= 0){
                continue;
            }
            num--;
            q.offer(num);
        }
        
        for(int i : q){
            answer += (i * i);
        }
        return answer;
    }
}