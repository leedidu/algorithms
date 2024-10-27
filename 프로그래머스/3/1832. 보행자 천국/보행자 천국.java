class Solution {
    static int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m + 1][n + 1][2]; // 마지막은 오는 방향 저장 -> 0 : 왼 / 1 : 위

        dp[0][0][0] = 1;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(cityMap[i][j] == 0) {
                    dp[i + 1][j][0] += (dp[i][j][0] + dp[i][j][1]) % MOD; // 가로
                    dp[i][j+1][1] +=  (dp[i][j][0] + dp[i][j][1]) % MOD;// 세로
                } else if(cityMap[i][j] == 1) {
                    continue;
                } else if (cityMap[i][j] == 2) {
                    // 가로
                    dp[i + 1][j][0] += (dp[i][j][0]) % MOD;
                    // 세로
                    dp[i][j+1][1] +=  (dp[i][j][1]) % MOD;
                }
            }
        }

        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
}