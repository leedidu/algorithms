import java.util.*;

class Solution {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String element : operations) {
            String command = element.split(" ")[0];
            int num = Integer.parseInt(element.split(" ")[1]);
            if (command.equals("I")) { // I일 경우는 ans, reverse_ans에 모두 추가해야함
                minQueue.add(num);
                maxQueue.add(num);
            } else if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
                if (num == -1) {
                    int a= minQueue.poll();
                    maxQueue.remove(a);
                } else {
                    minQueue.remove(maxQueue.poll());
                }
            }
        }
        answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.poll();
        answer[1] = minQueue.isEmpty() ? 0 : minQueue.poll();
        return answer;
    }
}