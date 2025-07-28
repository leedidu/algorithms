import java.util.*;
class Solution {
    public static int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        int server = 1;
        for (int i = 0; i < 24; i++) {
            while (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
                server--;
            }

            while (players[i] >= server * m) {
                queue.add(i);
                answer++;
                server++;
            }
        }
        return answer;
    }
}