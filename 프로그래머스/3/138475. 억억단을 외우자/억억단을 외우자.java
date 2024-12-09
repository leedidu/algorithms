import java.util.*;
class Solution {
    static int end;
    static int[] arr;
    static int[] cntArr;
    static int[] divisorArr;
    public static int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];

        end = e;
        arr = starts;
        cntArr = new int[end + 1];

        divisorArr = countDivisor();
        saveMaxCnt();

        for(int i = 0; i < starts.length; i++) {
            answer[i] = cntArr[starts[i]];
        }
        return answer;
    }

    // 해당 숫자까지부터 e까지 최대 개수 cntArr에 저장
    public static void saveMaxCnt() {
        int maxIdx = end; // 시간복잡도를 줄이기 위해서 뒤에서부터 확인 >> i에서 최댓값인덱스를 구했다면 i-1에서는 divisorArr[i-1]만 비교하면됨
        for (int i = end; i >= 1; i--) {
            if (divisorArr[i] >= divisorArr[maxIdx]) {
                maxIdx = i;
            }
            cntArr[i] = maxIdx;
        }
    }


    // 1~e까지의 약수 개수를 담은 리스트 반환
    public static int[] countDivisor() {
        int[] divisors = new int[end + 1];

        for (int i = 1; i <= end; i++) {
            for (int j = i; j <= end; j += i) {
                divisors[j]++; // i = 2라면 2씩 증가하는 모든 j의 약수가 됨
            }
        }
        return divisors;
    }
}