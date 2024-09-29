import java.util.*;
class Solution {
    static Map<String, String> referralMap = new HashMap<>();
    static Map<String, Integer> profitMap = new HashMap<>();
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        // 조직원 8명
        // 칫솔의 판매에 의하여 발생하는 이익에서 10% 계산 -> 자신을 조직에 참여시킨 추천인에게 배분, 나머지는 자신이 가짐
        // 자신이 조직에 추천하여 가입시킨 판매어ㅜㄴ에게서 발생하는 이익의 10%까지 자신의 이익
        // 자신에게 발생하는 이익또한 마찬가지의 규칙으로 자신의 추천인에게 분배
        // 원 단위에서 절사, 1원 미만인경우 이득을 분배하지 않고 모두 가짐

        for(int i = 0; i < enroll.length; i++){
            profitMap.put(enroll[i], 0); // 자기자신과 금액 (초기금액은 0원)
            referralMap.put(enroll[i], referral[i]); // 자신과 추천인
        }

        for(int i = 0; i < seller.length; i++){
            distributeProfit(seller[i], amount[i]*100);
        }
                for(int i = 0; i < enroll.length; i++){
            answer[i] = profitMap.get(enroll[i]);
        }
        return answer;
    }

    public static void distributeProfit(String seller, int amount) {
        if(seller.equals("-") || amount == 0) return;

        int commission = amount / 10; //추천인에게 넘길
        int my = amount - commission; // 자신이 가질것

        profitMap.put(seller, profitMap.getOrDefault(seller, 0) + my);
        distributeProfit(referralMap.get(seller), commission); // 추천인에게 수익 10%전달
    }
}