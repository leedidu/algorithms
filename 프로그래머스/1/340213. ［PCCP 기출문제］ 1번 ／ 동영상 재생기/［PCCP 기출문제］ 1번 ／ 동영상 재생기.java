class Solution {
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int totalTime = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int opStart = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int opEnd = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        int now = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);

        if(now >= opStart && now <= opEnd){
            now = opEnd;
        }
        
        for (String command : commands) {
            if(command.equals("next")){
                if(totalTime - now >= 10){
                    now += 10;
                } else {
                    now = totalTime;
                }
            }
            if(command.equals("prev")){
                if(now - 10 >= 0){
                    now -= 10;
                } else {
                    now = 0;
                }
            }
            if(now >= opStart && now <= opEnd){
                now = opEnd;
            }
        }

        String min = String.format("%02d", now / 60);
        String sec = String.format("%02d", now % 60);

        answer = min + ":" + sec;
        return answer;
    }
}