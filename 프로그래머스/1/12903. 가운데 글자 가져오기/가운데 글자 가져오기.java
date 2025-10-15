import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int len = s.length();
        String[] str = s.split("");
        if(len % 2 == 0){
            answer.append(str[len / 2 - 1]);
            answer.append(str[len / 2]);
        } else {
            answer.append(str[len/2]);
        }
        return answer.toString();
    }
}