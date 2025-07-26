import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[101];
    static int max = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n > max){
                dp(n);
                max = n;
            }
            System.out.println(dp[n]);
        }
    }

    public static void dp(int a) {
        for (int i = 4; i <= a; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
    }
}