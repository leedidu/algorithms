import java.util.HashMap;

class Solution {
    public static boolean solution(String[] phone_book) {
        // 어떤 번호가 다른 번호의 접두어인 경우 - false
        HashMap<String, Boolean> map = new HashMap<>();

        for(String num : phone_book){
            map.put(num, true);
        }

        for(String num : phone_book){
            for(int len = 1; len < num.length(); len++){
                if(map.containsKey(num.substring(0, len))){
                    return false;
                }
            }
        }
        return true;
    }
}