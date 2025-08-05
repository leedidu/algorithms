import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10]; // i자리 수인 계단 수에서 정수로 끝나는 수의 개수
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dp[i], 1);
        }

        dp[1][0] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1]) % 1000000000;
            dp[i][9] = (dp[i - 1][8]) % 1000000000;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i];
        }
        System.out.println(ans % 1000000000);
    }
}