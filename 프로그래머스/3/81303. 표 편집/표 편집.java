import java.util.*;

class Solution {
    public static StringBuilder solution(int n, int k, String[] cmd) {
        Stack<Integer> delete = new Stack<>();
        int size = n;
        int now = k;

        for (String s : cmd) {
            String[] st = s.split(" ");
            switch (st[0]) {
                case "U":  // 위
                    now -= Integer.parseInt(st[1]);
                    break;
                case "D":  // 아래
                    now += Integer.parseInt(st[1]);
                    break;
                case "C":  // 행 삭제
                    delete.push(now);
//                    answer.setCharAt(now, 'X');
                    size--;
                    if (now == size) {
                        now--;  // 마지막 행을 삭제한 경우 커서를 위로 이동
                    }
                    break;
                case "Z":  // 삭제 복구
                    int restored = delete.pop();
//                    answer.setCharAt(restored, 'O');  // 복구 표시
                    size++;  // 복구된 행 추가
                    if (now >= restored) {
                        now++;  // 복구된 행보다 커서가 아래에 있으면 한 칸 이동
                    }
                    break;
            }
        }

        StringBuilder answer = new StringBuilder("O".repeat(size));  // 처음 O로 초기화
        while(!delete.isEmpty()) {
            int i = delete.pop();
            answer.insert(i, 'X');
        }
        return answer;
    }
}