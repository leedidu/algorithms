import java.util.Stack;

class Solution {
    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int currentBox = 1;  // 현재 오름차순으로 도착하는 박스 번호

        for (int o : order) {
            // 현재 박스 번호가 배송순서보다 작거나 같을 때까지 컨테이너에 넣기
            while (currentBox <= o) {
                stack.push(currentBox);
                currentBox++;
            }

            // 스택의 맨 위가 배달해야 하는 순서와 일치하면 배달
            if (!stack.isEmpty() && stack.peek() == o) {
                stack.pop();
                answer++;
            } else {
                // 배달할 수 없으면 더 이상 진행 불가
                break;
            }
        }

        return answer;
    }
}