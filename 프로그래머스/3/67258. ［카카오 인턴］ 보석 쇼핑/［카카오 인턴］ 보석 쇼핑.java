import java.util.*;

class Solution {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> gemSet = new HashSet<>(Arrays.asList(gems)); // 모든 보석 종류
        HashMap<String, Integer> gemMap = new HashMap<>(); // 현재 구간의 보석 개수
        int left = 0, right = 0;
        int minLength = gems.length + 1; // 최소 구간 길이를 추적

        while (true) {
            // 현재 구간이 모든 보석을 포함하고 있는 경우
            if (gemMap.size() == gemSet.size()) {
                if (right - left < minLength) { // 더 짧은 구간을 찾은 경우
                    minLength = right - left;
                    answer[0] = left + 1; // 1-based 인덱스로 변환
                    answer[1] = right;    // right는 exclusive이므로 그대로 저장
                }

                // 왼쪽 포인터 이동
                String leftGem = gems[left];
                gemMap.put(leftGem, gemMap.get(leftGem) - 1);
                if (gemMap.get(leftGem) == 0) {
                    gemMap.remove(leftGem);
                }
                left++;
            }
            // 보석 종류가 부족한 경우, 오른쪽 포인터 이동
            else if (right == gems.length) {
                break; // 모든 보석을 다 탐색한 경우
            } else {
                String rightGem = gems[right];
                gemMap.put(rightGem, gemMap.getOrDefault(rightGem, 0) + 1);
                right++;
            }
        }

        return answer;
    }
}