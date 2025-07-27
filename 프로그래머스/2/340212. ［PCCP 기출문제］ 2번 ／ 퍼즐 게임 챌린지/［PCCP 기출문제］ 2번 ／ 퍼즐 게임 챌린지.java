class Solution {
    public static int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = -1;
        for (int i = 0; i < times.length; i++) {
            if (diffs[i] > right) {
                right = diffs[i];
            }
        }
        int mid = 0;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            mid = (left + right) / 2; // 찾고자 하는 레벨
            long total = times[0];
            for (int i = 1; i < times.length; i++) {
                if (diffs[i] <= mid) {
                    total += times[i];
                } else {
                    total += (long) (times[i] + times[i - 1]) * (diffs[i] - mid) + times[i];
                }
            }
            if (total <= limit) { // 레벨을 찾았을 경우
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else { // 레벨 못찾음
                left = mid + 1;
            }
        }
        return ans;
    }
}