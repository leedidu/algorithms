import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수
        // + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : scoville) { pq.add(a); }

        while (pq.size() >= 2 && pq.peek() < K) {             
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + 2 * b);
            answer++;
        }

        if(pq.peek() >= K){
            return answer;
        } else{
            return -1;
        }
    }
}