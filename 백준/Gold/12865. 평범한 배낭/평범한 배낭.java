import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] weights = new int[n];
        int[] values = new int[n];
        
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        
        int[] dp = new int[k + 1];
        
        for (int i = 0; i < n; i++) {
            for (int w = k; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
        
        System.out.println(dp[k]);
        
        sc.close();
    }
}
