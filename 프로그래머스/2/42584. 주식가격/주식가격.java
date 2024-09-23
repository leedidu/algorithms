import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
            while(!stack.empty() && prices[i] < prices[stack.peek()]) { // 스택이 비어있지 않고 가격이 줄어든 경우
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}