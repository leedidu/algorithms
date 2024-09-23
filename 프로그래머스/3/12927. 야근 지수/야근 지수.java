import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static long solution(int n, int[] works) {
        // 야근 지수 = 야근을 시작한 지점에서 남은 일의 작업량을 제곱하여 더한 값
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works) {
            pq.offer(work);
        }


        for(int i = 0; i < n; i++) {
            int work = pq.poll(); // 최대값을 찾고 제거
            if(work <= 0) break;
            pq.offer(work - 1); // 1을 줄인만큼 추가 
        }

        for(int a : pq){
            if(a < 0) return 0;
            else answer += a * a;
        }

        return answer;
    }
}