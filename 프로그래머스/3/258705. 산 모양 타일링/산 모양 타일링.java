class Solution {
    public static int solution(int n, int[] tops) {
        int answer = 0;
        int MOD = 10007;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // 0 상태 >> 밑에 삼각형 총 세개 초기상태는 tops에 따라 나뉨
        dp1[0] = 1;
        dp2[0] = 2 + tops[0];

        // 점화식
        // dp1[i] = dp1[i-1] + dp2[i-1]
        // dp2[i] = dp1[i-1] * (1 + tops[i]) + dp2[i-1] * (2 + tops[i])

        for(int i = 1; i < n; i++){
            dp1[i] += (dp1[i-1] + dp2[i-1]) % MOD;
            dp2[i] += (dp1[i-1] * (1 + tops[i]) % MOD) + (dp2[i-1] * (2 + tops[i]) % MOD);
        }

        return (dp1[n-1] + dp2[n-1]) % MOD;
    }

}