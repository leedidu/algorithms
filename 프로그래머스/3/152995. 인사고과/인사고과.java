import java.util.*;

class Solution {
    public static int solution(int[][] scores) {
        int answer = 1;
        // 근무태도 + 동료평가
        // 동석차일 경우 뛰어넘음
        int[] wanho = scores[0]; // 완호 점수 저장

        Arrays.sort(scores, (o1, o2) -> { // 동료펑가 내림차순, 동점일 경우 근무태도 오름차순
            int second = Integer.compare(o2[0], o1[0]);
            if(second != 0) return second;
            return Integer.compare(o1[1], o2[1]);
        });


        int max = -1;

        for (int i = 0; i < scores.length; i++) {
            // 완호가 탈락하는 경우 체크
            if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1] && max > scores[i][1]) {
                return -1;
            }
            if (scores[i][1] >= max) {
                max = scores[i][1];  // 동료평가점수가 크면 갱신
            } else {
                // 인센티브 못받는 사람 확인
                scores[i][0] = -1;
                scores[i][1] = -1;
            }
        }

        int wanhoScore = wanho[0] + wanho[1];

        // 인센티브 못받는지 확인 + 등수 체크

        for (int[] score : scores) {
            if (score[0] == -1 && score[1] == -1) {
                continue; // 무효화된 점수는 건너뜀
            }

            int sum = score[0] + score[1];
            if (sum > wanhoScore) {  // 완호보다 점수 합이 큰 사람만 카운팅
                answer++;
            }
        }
        return answer;
    }
}