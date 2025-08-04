import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n]; // i번째로 시작했을 때 가장 긴 수열 길이를 담은 배열
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) { // 현재 수
            for (int j = 0; j < i; j++) { // 앞의 수
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
            }
        }
        System.out.println(ans);
    }
}