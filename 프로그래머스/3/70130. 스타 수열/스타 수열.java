import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(int[] a) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxLength = 0;

        // 빈도수를 계산
        for (int num : a) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int target : countMap.keySet()) {
            if (countMap.get(target) * 2 <= maxLength) {
                continue;
            }
            
            int length = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if ((a[i] == target || a[i + 1] == target) && a[i] != a[i + 1]) {
                    length += 2;
                    i++; // 두 칸 건너뜀
                }
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
