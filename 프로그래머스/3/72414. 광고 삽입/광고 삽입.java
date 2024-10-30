class Solution {
    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        long[] arr = new long[360001];

        for(String log : logs) { // 초단위 변환
            String[] section = log.split("-");
            int start = convertTimeToInt(section[0]);
            int end = convertTimeToInt(section[1]);

            arr[start]++; // 시청자수 증가
            arr[end]--; // 시청자수 감소
        }

        for (int i = 1; i < 360001; i++) { // 누적합을 이용해서 실제 시청자수 구함
            arr[i] += arr[i - 1];
        }

        for (int i = 1; i < 360001; i++) { // 누적 시청시간구함
            arr[i] += arr[i - 1];
        }

        int play = convertTimeToInt(play_time);
        int adv = convertTimeToInt(adv_time);

        long max = arr[adv - 1];
        long point = 0;

        // 광고 삽입 지점 찾기 >> 광고시간 기준으로 누적시청시간 비교
        for (int i = adv; i <= play; i++) {
            long cur = arr[i] - arr[i - adv]; // 광고가 삽입된 구간의 시청시간 합
            if (cur > max) { // 광고시간갱신
                max = cur;
                point = i - adv + 1;
            }
        }

        answer = convertTimeToStr(point);
        return answer;
    }

    public static int convertTimeToInt(String time) {
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        int sec = Integer.parseInt(arr[2]);

        return hour * 3600 + min * 60 + sec;
    }

    public static String convertTimeToStr(long time) {
        long hour = time / 3600;
        time -= hour * 3600;
        long min = time / 60;
        time -= min * 60;
        long sec = time;

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}