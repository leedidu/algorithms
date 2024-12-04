class Solution {
    public static int solution(String[] lines) {
        int answer = 1;
        int[] end = new int[lines.length];
        int[] start = new int[lines.length];

        for(int i = 0; i < lines.length; i++) {
            String[] arr = lines[i].split(" "); // 1 : 종료시간 / 2 : 지속 시간
            end[i] = timeToInteger(arr[1]); // 종료시간
            start[i] = getStartTime(end[i], arr[2]); // 시작시간
        }

        for(int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int curEndTime = end[i] + 1000;
            if(curEndTime > start[i]) {
                for(int j = 0; j < lines.length; j++) {
                    if(curEndTime > start[j] && end[j] >= end[i]) {
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    // 스트링 타입 시간 > 정수
    public static int timeToInteger(String time) {
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);

        String[] seconds = arr[2].split("\\.");
        int second = Integer.parseInt(seconds[0]);
        int millisecond = Integer.parseInt(seconds[1]);
        return (hour * 3600 + minute * 60 + second) * 1000 + millisecond;
    }

    // 시작 시간 구하는 메서드
    public static int getStartTime(int end, String seconds) {
        seconds = seconds.substring(0, seconds.length() - 1);
        double duration = Double.parseDouble(seconds) * 1000;
        return (int)(end - duration + 1);
    }
}