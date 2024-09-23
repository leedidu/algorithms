import java.util.Arrays;

class Solution {
    public static long solution(int n, int[] times) {
        long answer = 0;
        // n = 입국심사를 기다리는 사람 수, times = 각 심사관이 한명을 심사하는데 걸리는 시간
        Arrays.sort(times);
        long start = 1;
        long end = (long) times[times.length - 1] * n; // 최악의 경우
        // 비어있는 심사대보다 비지않은 곳에서 받는 것이 더빠르다면 거기로 가야함
        while(start <= end) {
            long mid = (start+end)/2;
            long sum = 0;
            // 전체 심사위원의 수 > 인원이면 줄일수있음
            for(int i : times){
                sum += mid/i; // 심사관이 mid 시간 동안 처리할 수 있는 사람의 수
            }

            if(sum >= n) { // mid시간 동안 모두 심사 가능
                answer = mid;
                end = mid - 1; // 더 짧은 시간에서 탐색
            } else {
                start = mid + 1; // mid가 짧다는 말 -> 더 긴시간에서 탐색
            }
        }

        return answer;
    }
}