import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        // 최대합 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 왼쪽 가장자리
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    // 오른쪽 가장자리
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    // 내부
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        // 최대 값 찾기 >> 마지막행
        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, dp[n-1][j]);
        }
        
        System.out.println(maxSum);
        sc.close();
    }
}
