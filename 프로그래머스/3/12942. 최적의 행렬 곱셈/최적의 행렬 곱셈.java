class Solution {
    static int[][] dp;
    public static int solution(int[][] matrix_sizes) {
        /*
        * dp[i][j] = min(dp[i][k] + dp[k+1][j] + 앞행렬의 행 수 * k번째 행렬의 열 수 * j번째 행렬의 열 수)
        * k : 분할 지점
        * */

        int n = matrix_sizes.length; // 행렬의 개수
        dp = new int[n + 1][n + 1];

        // 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < n; i++) {
            dp[i][i] = 0; // 자기자신 >> 0
        }

        dynamicProgramming(matrix_sizes, n);
        return dp[0][n - 1];
    }

    static void dynamicProgramming(int[][] matrix_sizes, int n){
        for (int len = 1; len < n; len++) { // 길이만큼 반복
            for (int i = 0; i < n - len; i++) {
                int j = i + len; // 끝 인덱스

                for (int k = i; k < j; k++) { // 분할지점
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1]);
                }
            }
        }
    }
}