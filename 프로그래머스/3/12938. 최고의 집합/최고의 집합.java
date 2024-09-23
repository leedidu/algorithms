import java.util.Arrays;

class Solution {
    public static int[] solution(int n, int s) {
        // 합이 s면서 n개의 수의 곱은 최대를 구함
        // 각 수의 차가 최소가 되어야함
        // 최고의 집합이 없을 경우 -1
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            answer[i] = s / n;
        }

        for(int i = 0; i < s % n; i++) {
            answer[i]++;
        }

        Arrays.sort(answer);
        return answer;
    }
}