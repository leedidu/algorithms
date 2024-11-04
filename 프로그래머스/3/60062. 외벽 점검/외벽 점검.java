import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;

    public static int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        int[] extendedWeak = new int[len * 2];

        // 취약 지점을 확장하여 선형 배열로 만듦
        for (int i = 0; i < len; i++) {
            extendedWeak[i] = weak[i];
            extendedWeak[i + len] = weak[i] + n;
        }

        Arrays.sort(dist);

        // 모든 가능한 친구 순열을 구해 하나씩 탐색
        for (int i = 1; i <= dist.length; i++) {
            int[] selected = Arrays.copyOfRange(dist, dist.length - i, dist.length);
            do {
                if (checkCoverage(extendedWeak, selected, len)) {
                    answer = Math.min(answer, i);
                }
            } while (nextPermutation(selected));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // 주어진 친구 순서로 취약 지점을 모두 커버할 수 있는지 확인
    private static boolean checkCoverage(int[] extendedWeak, int[] dist, int len) {
        for (int start = 0; start < len; start++) {
            int count = 0;
            int position = extendedWeak[start] + dist[count];

            for (int j = start; j < start + len; j++) {
                if (extendedWeak[j] > position) {
                    count++;
                    if (count >= dist.length) break;
                    position = extendedWeak[j] + dist[count];
                }
            }

            if (count < dist.length) return true;
        }
        return false;
    }

    // 순열 생성
    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if (i <= 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) j--;

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}