import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n + 1];
        System.out.println(dp(arr));
    }

    public static int dp(int[] arr) {
        int max = arr[0];
        dp[0] = arr[0];
        for(int i = 1; i<arr.length; i++){
            dp[i] = Math.max((arr[i] + dp[i - 1]), arr[i]);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}