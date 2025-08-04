import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        if (n == 1) {
            System.out.println(wines[1]);
        } else if (n == 2) {
            System.out.println(wines[1] + wines[2]);
        } else {
            dp[1] = wines[1];
            dp[2] = wines[1] + wines[2];

            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
            }

            int max = dp[0];
            for (int i = 1; i <= n; i++) {
                if (max < dp[i]) {
                    max = dp[i];
                }
            }
            System.out.println(max);
        }
    }
}