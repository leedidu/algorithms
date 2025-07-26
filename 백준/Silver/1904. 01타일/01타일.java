import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        dp = new int[a + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp(a);
        System.out.println(dp[a]);
    }

    public static void dp(int a) {
        for (int i = 2; i <= a; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
    }
}