import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<int[]> deque = new ArrayDeque<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int balloon = sc.nextInt();
            deque.add(new int[]{i + 1, balloon});
        }

        StringBuilder answer = new StringBuilder();
        int[] current = deque.pollFirst();
        answer.append(current[0]).append(" ");
        int move = current[1];

        while (!deque.isEmpty()) {
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
                current = deque.pollFirst();
            } else {
                for (int i = 0; i < -move - 1; i++) {
                    deque.addFirst(deque.pollLast());
                }
                current = deque.pollLast();
            }

            answer.append(current[0]).append(" ");
            move = current[1];
        }
        System.out.println(answer.toString().trim());
    }
}
