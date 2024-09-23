import java.util.*;

class Solution {
    public static int solution(int[] A, int[] B) {
        // 숫자가 큰 쪽이 +1 점
        int answer = 0;

        PriorityQueue<Integer> aq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> bq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < A.length; i++){
            aq.offer(A[i]);
            bq.offer(B[i]);
        }

        while (!aq.isEmpty()) {
            int a = aq.poll();
            int b = bq.peek();
            if(a < b){
                bq.poll();
                answer++;
            }
        }
        return answer;
    }
}