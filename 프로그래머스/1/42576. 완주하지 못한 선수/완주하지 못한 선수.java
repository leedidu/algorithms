import java.util.HashMap;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> name = new HashMap<>();

        for(String par : participant){
            name.put(par, name.getOrDefault(par, 0) + 1);
        }

        for(String com : completion){
            name.put(com, name.getOrDefault(com, 0) - 1);
        }

        for(String st : name.keySet()){
            if(name.get(st) != 0){
                return st;
            }
        }
        return answer;
    }
}