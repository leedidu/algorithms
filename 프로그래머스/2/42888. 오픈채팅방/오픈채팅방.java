import java.util.*;

class Solution {
    public static ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for(String str : record) {
            if(str.split(" ")[0].equals("Enter") || str.split(" ")[0].equals("Change")) {
                map.put(str.split(" ")[1], str.split(" ")[2]); // uid : 닉네임
            }
        }

        for(int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if(split[0].equals("Enter")) {
                answer.add(map.get(split[1]) + "님이 들어왔습니다." );
            } else if(split[0].equals("Leave")) {
                answer.add(map.get(split[1]) + "님이 나갔습니다.");
            }
        }
        return answer;
    }
}