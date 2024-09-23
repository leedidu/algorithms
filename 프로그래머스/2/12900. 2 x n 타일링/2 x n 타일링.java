class Solution {
    public static int solution(int n) {
        // 세로가 2 가로가 n
        // 이전까지의 타일 배치 방법을 더하는 것
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}