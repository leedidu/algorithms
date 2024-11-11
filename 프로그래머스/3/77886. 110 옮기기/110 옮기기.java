import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            answer[i] = move110(s[i]);
        }

        return answer;
    }

    public static String move110(String s) {
        Stack<Character> stack = new Stack<>();
        int count110 = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (stack.size() >= 2 && stack.get(stack.size() - 2) == '1' && stack.get(stack.size() - 1) == '1' && c == '0') {
                stack.pop();
                stack.pop();
                count110++;
            } else {
                stack.push(c);
            }
        }

        // stack을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        // 110을 넣을 위치 찾기
        int index = sb.lastIndexOf("0") + 1;
        StringBuilder result = new StringBuilder(sb);
        
        for (int j = 0; j < count110; j++) {
            result.insert(index, "110");
        }

        return result.toString();
    }
}
