import java.util.ArrayList;

class Solution {
    public static ArrayList<Long> solution(long[] numbers) {
        ArrayList<Long> answer = new ArrayList<>();
        for (long num : numbers) {
            if(num % 2 == 0) { // 짝수일경우는 바로 다음수가 정답
                answer.add(num + 1);
            } else {
                // 홀수일 경우 가장 오른쪽에있는 0을 1로 변경한후 그다음비트를 0으로 변경
                long bit = 1;
                while ((num & bit) != 0) {
                    bit <<= 1; // 오른쪽부터 첫 번째 0을 찾기 위해 비트 이동
                }
                // 가장 낮은 0을 1로 바꾸고 바로뒤의 비트를 0으로 변경
                answer.add(num + bit - (bit >> 1));
            }
        }
        return answer;
    }
}