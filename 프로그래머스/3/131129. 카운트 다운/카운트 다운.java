import java.util.*;

public class Solution {
    public int[] solution(int target) {
        int[] dp = new int[target + 1];
        int[] singleCount = new int[target + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(singleCount, 0);

        dp[0] = 0;
        singleCount[0] = 0;

        for (int score = 1; score <= 20; score++) {
            for (int multiplier = 1; multiplier <= 3; multiplier++) {
                int points = score * multiplier;
                for (int t = points; t <= target; t++) {
                    if (dp[t - points] + 1 < dp[t]) {
                        dp[t] = dp[t - points] + 1;
                        singleCount[t] = singleCount[t - points] + (multiplier == 1 ? 1 : 0);
                    } else if (dp[t - points] + 1 == dp[t]) {
                        singleCount[t] = Math.max(singleCount[t], singleCount[t - points] + (multiplier == 1 ? 1 : 0));
                    }
                }
            }
        }

        for (int t = 50; t <= target; t++) {
            if (dp[t - 50] + 1 < dp[t]) {
                dp[t] = dp[t - 50] + 1;
                singleCount[t] = singleCount[t - 50] + 1;
            } else if (dp[t - 50] + 1 == dp[t]) {
                singleCount[t] = Math.max(singleCount[t], singleCount[t - 50] + 1);
            }
        }

        return new int[]{dp[target], singleCount[target]};
    }
}
