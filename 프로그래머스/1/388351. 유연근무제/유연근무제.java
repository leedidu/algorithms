class Solution {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int people = schedules.length;
        int[] num = new int[people];

        for (int i = 0; i < people; i++) {
            int now = startday;
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100 + 10;
            if(minute >= 60){
                minute -= 60;
                hour += 1;
            }
            int endTime = hour * 100 + minute;

            for (int j = 0; j < 7; j++) { // 날짜
                if (now == 6 || now == 7) {
                    now++;
                    continue;
                }
                if (timelogs[i][j] <= endTime) {
                    num[i]++;
                }
                now++;
                if(now > 7) now = now - 7;
            }
        }

        for (int i = 0; i < people; i++) {
            if (num[i] == 5) {
                answer++;
            }
        }
        return answer;
    }
}